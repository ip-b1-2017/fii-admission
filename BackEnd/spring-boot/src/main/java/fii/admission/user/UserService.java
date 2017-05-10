/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class UserService {
	
	static public List<User> getAllUser() {
		ArrayList<User> result = new ArrayList<User>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM USER";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				User user = new User();
				user.setRole(rs.getString("ROLE"));
				user.setEmail(rs.getString("EMAIL"));
				user.setParola(rs.getString("PAROLA"));
                user.setToken(rs.getString("TOKEN"));
				result.add(user);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllUser] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static User getUser(String email) {
		User result = new User();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM USER WHERE email = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setRole(rs.getString("ROLE"));
				result.setEmail(rs.getString("EMAIL"));
				result.setParola(rs.getString("PAROLA"));
				result.setToken(rs.getString("TOKEN"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getUser] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateUser(String email, User user) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE USER SET role = ?, email = ?, parola = ?, " + 
					   "token = ? where email = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, user.getRole());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getParola());
			pstmt.setString(4, user.getToken());
			pstmt.setString(5, email);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateUser] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteUser(String email) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM USER WHERE email = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteUser] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertUser(User user) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO USER "
				+ "(ROLE, EMAIL, PAROLA, TOKEN)"
				+ "VALUES ( ?, ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, user.getRole());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getParola());
			pstmt.setString(4, user.getToken());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateUser] %s\n", exc.getMessage());
		}
		return 0;
	}
}

