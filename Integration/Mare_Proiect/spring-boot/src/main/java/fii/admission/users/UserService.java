package fii.admission.users;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public static List<User> getAllUser() {
        ArrayList<User> result = new ArrayList<User>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM USER";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setRol(rs.getString("ROL"));
                user.setEmail(rs.getString("EMAIL"));
                user.setParola(rs.getString("PAROLA"));
                user.setToken(rs.getString("TOKEN"));
                result.add(user);
            }
            stmt.close();
            rs.close();
            if (result.isEmpty())
                return null;
            else
                return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllUser] %s\n", exc.getMessage());
        }
        return null;
    }

    public static User getUser(String email) {
        User result = new User();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM USER WHERE email = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setRol(rs.getString("ROL"));
                result.setEmail(rs.getString("EMAIL"));
                result.setParola(rs.getString("PAROLA"));
                result.setToken(rs.getString("TOKEN"));
            } else
                return null;
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getUser] %s\n", exc.getMessage());
        }
        return null;
    }

    public static boolean isLogged(UserIn user) {
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM USER WHERE email = ? and parola = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            pstmt.close();
            rs.close();
        } catch (Exception exc) {
            System.out.printf("[error][getUser] %s\n", exc.getMessage());
        }
        return false;
    }

    public static int updateUser(String email, User user) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE USER SET ROL = ?, email = ?, parola = ?, "
                + "token = ? where email = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, user.getRol());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getParola());
            pstmt.setString(4, user.getToken());
            pstmt.setString(7, email);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateUser] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int deleteUser(String email) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM USER WHERE email = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, email);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][deleteUser] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int insertUser(User user) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO USER " + "(ROL, EMAIL, PAROLA, TOKEN)"
                + " VALUES ( ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, user.getRol());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getParola());
            pstmt.setString(4, user.getToken());
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateUser] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static boolean updateToken(SetTokenEntity ust) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE USER SET "
                + "token = ? where email = ?";

        try

        {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, ust.getToken());
            pstmt.setString(2, ust.getEmail());
            result = pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (
                Exception exc)

        {
            System.out.printf("[error][updateUser] %s\n", exc.getMessage());
        }
        return false;
    }

    public static RoleEntity getRole(String token) {
        Connection con = MainApp.getDBConnection();
        RoleEntity role = new RoleEntity();
        String query = "SELECT ROl FROM USER WHERE token = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, token);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                role.setRole(rs.getString("ROL"));
                return role;
            }
            pstmt.close();
            rs.close();
        } catch (Exception exc) {
            System.out.printf("[error][getUser] %s\n", exc.getMessage());
        }
        return null;
    }

}
