package fii.admission.medie;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class MedieService {
	
	static public List<Medie> getAllMedie() {
		ArrayList<Medie> result = new ArrayList<Medie>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM MEDIE";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Medie p = new Medie();
				p.setCandidatCNP(rs.getString("CANDIDATCNP"));
				p.setValoare(rs.getFloat("VALOARE"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllMedie] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Medie getMedie(String candidatCNP) {
		Medie result = new Medie();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM MEDIE WHERE CANDIDATCNP = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, candidatCNP);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setCandidatCNP(rs.getString("CANDIDATCNP"));
				result.setValoare(rs.getFloat("VALOARE"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getMedie] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateMedie(String candidatCNP, Medie medie) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE MEDIE SET CANDIDATCNP = ?, VALOARE = ? WHERE CANDIDATCNP = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, medie.getCandidatCNP());
			pstmt.setFloat(2, medie.getValoare());
			pstmt.setString(3, candidatCNP);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateMedie] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteMedie(String candidatCNP) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM MEDIE WHERE CANDIDATCNP = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidatCNP);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteMedie] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertMedie(Medie medie) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO MEDIE "
				+ "(CANDIDATCNP,VALOARE)"
				+ "VALUES ( ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, medie.getCandidatCNP());
			pstmt.setFloat(2, medie.getValoare());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateMedie] %s\n", exc.getMessage());
		}
		return 0;
	}
}
