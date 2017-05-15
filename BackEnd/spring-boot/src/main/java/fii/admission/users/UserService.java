package fii.admission.users;

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
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setRol(rs.getString("ROL"));
				user.setEmail(rs.getString("EMAIL"));
				user.setParola(rs.getString("PAROLA"));
				user.setToken(rs.getString("TOKEN"));
<<<<<<< HEAD
=======
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setId(rs.getInt("ID"));
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
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

	public static User getUser(int id) {
		User result = new User();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM USER WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result.setRol(rs.getString("ROL"));
				result.setEmail(rs.getString("EMAIL"));
				result.setParola(rs.getString("PAROLA"));
				result.setToken(rs.getString("TOKEN"));
<<<<<<< HEAD
=======
				result.setFirstName(rs.getString("FIRSTNAME"));
				result.setLastName(rs.getString("LASTNAME"));
				result.setId(rs.getInt("ID"));
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
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

<<<<<<< HEAD
	public static boolean isLogged(UserIn user){
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM USER WHERE email = ? and parola = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2,user.getPassword());
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
=======
	public static int updateUser(int id, User user) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE USER SET id = ?, rol = ?, email = ?, parola = ?, "
				+ "token = ?, firstname = ?, lastname =? where id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getRole());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getParola());
			pstmt.setString(5, user.getToken());
			pstmt.setString(6, user.getFirstName());
			pstmt.setString(7, user.getLastName());
			pstmt.setInt(8, id);
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateUser] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int deleteUser(int id) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM USER WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, id);
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
<<<<<<< HEAD
		String query = "INSERT INTO USER " + "(ROL, EMAIL, PAROLA, TOKEN)" 
			     + " VALUES ( ?, ?, ?, ?)";
=======
		String query = "INSERT INTO USER " + "(ROL, EMAIL, PAROLA, TOKEN,FIRSTNAME,LASTNAME,ID)"
				+ "VALUES ( ?, ?, ?, ?,?,?,?)";
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, user.getRol());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getParola());
			pstmt.setString(4, user.getToken());
<<<<<<< HEAD
=======
			pstmt.setString(5, user.getFirstName());
			pstmt.setString(6, user.getLastName());
			pstmt.setInt(7,user.getId());
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateUser] %s\n", exc.getMessage());
		}
		return 0;
	}
	public static boolean updateToken(SetTokenEntity ust){
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE USER SET "
			     + "token = ? where email = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, ust.getToken());
			pstmt.setString(2, ust.getEmail());
			result = pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception exc) {
			System.out.printf("[error][updateUser] %s\n", exc.getMessage());
		}
		return false;
	}
}
