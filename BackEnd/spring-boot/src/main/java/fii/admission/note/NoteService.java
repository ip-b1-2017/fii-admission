package fii.admission.note;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class NoteService {
	
	static public List<Note> getAllNote() {
		ArrayList<Note> result = new ArrayList<Note>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Note";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Note p = new Note();
				p.setCandidatCNP(rs.getString("candidatcnp"));
				p.setValoare(rs.getFloat("valoare"));
				p.setExamenId(rs.getString("EXAMENID"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllNote] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Note getNote(String candidatcnp) {
		Note result = new Note();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Note WHERE candidatcnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, candidatcnp);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setCandidatCNP(rs.getString("candidatcnp"));
				result.setValoare(rs.getFloat("valoare"));
				result.setExamenId(rs.getString("EXAMENID"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getNote] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateNote(String candidatcnp, Note note) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE Note SET valoare = ?, " + 
					   "candidatcnp = ?, examenid = ? where candidatcnp = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(2, note.getCandidatCNP());
			pstmt.setFloat(1, note.getValoare());
			pstmt.setString(3, note.getExamenId());
			pstmt.setString(4, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateNote] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteNote(String candidatcnp) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM Note WHERE candidatcnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteNote] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertNote(Note note) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO Note "
				+ "( valoare,candidatcnp,EXAMENID)"
				+ "VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(2, note.getCandidatCNP());
			pstmt.setFloat(1, note.getValoare());
			pstmt.setString(3, note.getExamenId());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateNote] %s\n", exc.getMessage());
		}
		return 0;
	}
}
