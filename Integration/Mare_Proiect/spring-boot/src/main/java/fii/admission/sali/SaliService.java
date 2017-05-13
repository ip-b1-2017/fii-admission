package fii.admission.sali;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class SaliService {
	
	static public List<Sali> getAllSali() {
		ArrayList<Sali> result = new ArrayList<Sali>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM SALI";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Sali p = new Sali();
				p.setId(rs.getString("ID"));
				p.setLocatie(rs.getString("LOCATIE"));
				p.setNrLocuri(rs.getInt("LOCURI"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllSali] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Sali getSali(String id) {
		Sali result = new Sali();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM SALI WHERE id = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setId(rs.getString("ID"));
				result.setLocatie(rs.getString("LOCATIE"));
				result.setNrLocuri(rs.getInt("LOCURI"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getSali] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateSali(String id, Sali sali) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE SALI SET id = ? , locatie = ?, locuri = ? where id = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, sali.getId());
			pstmt.setString(2, sali.getLocatie());
			pstmt.setInt(3, sali.getNrLocuri());
			pstmt.setString(4, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateSali] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteSali(String id) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM SALI WHERE id = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteSali] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertSali(Sali sali) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO SALI "
				+ "(id, locatie, locuri)"
				+ "VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, sali.getId());
			pstmt.setString(2, sali.getLocatie());
			pstmt.setInt(3, sali.getNrLocuri());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateSali] %s\n", exc.getMessage());
		}
		return 0;
	}
}
