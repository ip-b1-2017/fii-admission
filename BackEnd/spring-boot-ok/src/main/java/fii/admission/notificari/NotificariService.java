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
		String query = "SELECT * FROM NOTIFICARI";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Notificari p = new Notificari();
				p.setText(rs.getString("TEXT"));
				p.setSeen(rs.getString("SEEN"));
				p.setUserEmail(rs.getString("USEREMAIL"));
				p.setUserid(rs.getInt("USERID"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if (result.isEmpty())
				return null;
			else
				return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAllNotificari] %s\n", exc.getMessage());
		}
		return null;
	}

	public static Notificari getNotificari(int userid) {
		Notificari result = new Notificari();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM NOTIFICARI WHERE USERID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result.setText(rs.getString("TEXT"));
				result.setSeen(rs.getString("SEEN"));
				result.setUserEmail(rs.getString("USEREMAIL"));
				result.setUserid(rs.getInt("USERID"));
			} else
				return null;
			pstmt.close();
			rs.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][getNotificari] %s\n", exc.getMessage());
		}
		return null;
	}

	public static int updateNotificari(int userid, Notificari notificari) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE NOTIFICARI SET useremail = ?, text = ?, seen = ?, userid =?  where userid = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1,notificari.getUserEmail());
			pstmt.setString(2, notificari.getText());
			pstmt.setString(3, notificari.getSeen());
			pstmt.setInt(4, notificari.getUserid());
			pstmt.setInt(5, userid);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int deleteNotificari(int userid) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM NOTIFICARI WHERE userid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, userid);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][deleteNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int insertNotificari(Notificari notificari) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO NOTIFICARI " + "(userid,text, seen, useremail)" + "VALUES ( ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1,notificari.getUserid());
			pstmt.setString(2, notificari.getText());
			pstmt.setString(3, notificari.getSeen());
			pstmt.setString(4, notificari.getUserEmail());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
		}
		return 0;
	}
}
