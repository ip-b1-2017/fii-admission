package fii.admission.notificari;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class NotificariService {
	
	static public List<Notificari> getAllNotificari() {
		ArrayList<Notificari> result = new ArrayList<Notificari>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Notificari";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Notificari p = new Notificari();
				p.setText(rs.getString("text"));
				p.setSeen(rs.getString("seen"));
				p.setUserEmail(rs.getString("useremail"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllNotificari] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Notificari getNotificari(String useremail) {
		Notificari result = new Notificari();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Notificari WHERE useremail = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, useremail);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setText(rs.getString("text"));
				result.setSeen(rs.getString("seen"));
				result.setUserEmail(rs.getString("useremail"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getNotificari] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateNotificari(String useremail, Notificari notificari) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE Notificari SET text = ?, seen = ?, useremail =?  where useremail = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, notificari.getText());
			pstmt.setString(2, notificari.getSeen());
			pstmt.setString(3, notificari.getUserEmail());
			pstmt.setString(4, useremail);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteNotificari(String useremail) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM Notificari WHERE useremail = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, useremail);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertNotificari(Notificari notificari) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO Notificari "
				+ "(text, seen, useremail)"
				+ "VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, notificari.getText());
			pstmt.setString(2, notificari.getSeen());
			pstmt.setString(3, notificari.getUserEmail());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}
}
