/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fii.admission.candidat;

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
public class CandidatService {
	
	static public List<Candidat> getAllCandidat() {
		ArrayList<Candidat> result = new ArrayList<Candidat>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM CANDIDAT";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Candidat candidat = new Candidat();
				candidat.setNume(rs.getString("NUME"));
				candidat.setPrenume(rs.getString("PRENUME"));
				candidat.setCNP(rs.getString("CNP"));
				candidat.setUserEmail(rs.getString("USEREMAIL"));
				result.add(candidat);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllCandidat] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Candidat getCandidat(String cnp) {
		Candidat result = new Candidat();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM CANDIDAT WHERE CNP = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cnp);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setNume(rs.getString("NUME"));
				result.setPrenume(rs.getString("PRENUME"));
				result.setCNP(rs.getString("CNP"));
				result.setUserEmail(rs.getString("USEREMAIL"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getCandidat] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateCandidat(String cnp, Candidat candidat) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE CANDIDAT SET nume = ?, prenume = ?, pcnp = ?, " + 
					   "useremail = ? where cnp = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidat.getNume());
			pstmt.setString(2, candidat.getPrenume());
			pstmt.setString(3, candidat.getCNP());
			pstmt.setString(4, candidat.getUserEmail());
			pstmt.setString(5, cnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateCandidat] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteCandidat(String cnp) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM CANDIDAT WHERE cnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, cnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteCandidat] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertCandidat(Candidat candidat) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO CANDIDAT "
				+ "(NUME, PRENUME, CNP, USEREMAIL)"
				+ "VALUES ( ?, ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidat.getNume());
			pstmt.setString(2, candidat.getPrenume());
			pstmt.setString(3, candidat.getCNP());
			pstmt.setString(4, candidat.getUserEmail());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateCandidat] %s\n", exc.getMessage());
		}
		return 0;
	}
}
