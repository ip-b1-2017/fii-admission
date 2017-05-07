/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import java.security.MessageDigest;
import java.sql.*;

/**
 *
 * @author andy
 */
public class IP {

    /**
     * @param args the command line arguments
     */
    public static String saltedHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static boolean checkPassword(String username, String password) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:IP.db");
            statement = connection.createStatement();
            String hashedPassword;
            hashedPassword = saltedHash(password);
            String sql = "Select parola from user where username like '"+hashedPassword+"' ;";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String parola = rs.getString("parola");
                if(!parola.equals(hashedPassword))
                    return false;
            }
            statement.close();
            connection.close();
            return true;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }finally{
            if(statement  !=null)
                statement .close();
            if(connection!=null)
                connection.close();
        }
        return false;
    };
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:IP.db");
            statement = connection.createStatement();
            String hashedPassword;
            
            hashedPassword = saltedHash("1234");
            String sql = "insert into user (rol,email,parola,token) values ("
                    + "'admin','admin@gmail.com', '"+hashedPassword+"','smth');";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
           
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

}
