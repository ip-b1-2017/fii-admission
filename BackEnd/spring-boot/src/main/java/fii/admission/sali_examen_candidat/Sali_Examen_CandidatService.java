package fii.admission.sali_examen_candidat;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class Sali_Examen_CandidatService {
	
	static public List<Sali_Examen_Candidat> getAllSali_Examen_Candidat() {
		ArrayList<Sali_Examen_Candidat> result = new ArrayList<Sali_Examen_Candidat>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM SALI_EXAMEN_CANDIDAT";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Sali_Examen_Candidat p = new Sali_Examen_Candidat();
				p.setCandidatCNP(rs.getString("CANDIDATCNP"));
				p.setSaliExamenSaliId(rs.getString("SALI_EXAMENSALIID"));
				p.setSaliExamenExamenId(rs.getString("SALI_EXAMENEXAMENID"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllSali_Examen_Candidat] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Sali_Examen_Candidat getSali_Examen_Candidat(String candidatcnp) {
		Sali_Examen_Candidat result = new Sali_Examen_Candidat();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM SALI_EXAMEN_CANDIDAT WHERE candidatcnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, candidatcnp);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setCandidatCNP(rs.getString("CANDIDATCNP"));
				result.setSaliExamenSaliId(rs.getString("SALI_EXAMENSALIID"));
				result.setSaliExamenExamenId(rs.getString("SALI_EXAMENEXAMENID"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getSali_Examen_Candidat] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateSali_Examen_Candidat(String candidatcnp, Sali_Examen_Candidat prof) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE SALI_EXAMEN_CANDIDAT SET candidatcnp = ?, sali_examensaliid = ?, sali_examenexamenid = ? "
                        + "where candidatcnp = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, prof.getCandidatCNP());
			pstmt.setString(2, prof.getSaliExamenSaliId());
			pstmt.setString(3, prof.getSaliExamenExamenId());
			pstmt.setString(4, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateSali_Examen_Candidat] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteSali_Examen_Candidat(String candidatcnp) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM SALI_EXAMEN_CANDIDAT WHERE candidatcnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteSali_Examen_Candidat] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertSali_Examen_Candidat(Sali_Examen_Candidat prof) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO SALI_EXAMEN_CANDIDAT "
				+ "(candidatcnp, SALI_EXAMENSALIID, SALI_EXAMENEXAMENID)"
				+ "VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, prof.getCandidatCNP());
			pstmt.setString(2, prof.getSaliExamenSaliId());
			pstmt.setString(3, prof.getSaliExamenExamenId());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateSali_Examen_Candidat] %s\n", exc.getMessage());
		}
		return 0;
	}
}
