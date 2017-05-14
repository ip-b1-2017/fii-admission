/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fii.admission.forms;

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
public class FormService {
	
	static public List<Form> getAllForm() {
		ArrayList<Form> result = new ArrayList<Form>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM FORM";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Form form = new Form();
				form.setInformatii(rs.getString("INFORMATII"));
				form.setStatus(rs.getString("STATUS"));
				form.setCandidatCnp(rs.getString("CANDIDATCNP"));
				result.add(form);
			}
			stmt.close();
			rs.close();
			if(result.isEmpty()) return null;
			else return result;
		} catch(Exception exc) {
			System.out.printf("[error][getAllForm] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static Form getForm(String candidatcnp) {
		Form result = new Form();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM FORM WHERE CANDIDATCNP = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, candidatcnp);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setInformatii(rs.getString("INFORMATII"));
				result.setStatus(rs.getString("STATUS"));
				result.setCandidatCnp(rs.getString("CANDIDATCNP"));
			}
			else return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getForm] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static int updateForm(String candidatcnp, Form form) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE FORM SET informatii = ?, status = ?, candidatcnp = ? where candidatcnp = ?";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, form.getInformatii());
			pstmt.setString(2, form.getStatus());
			pstmt.setString(3, form.getCandidatCnp());
			pstmt.setString(4, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateForm] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int deleteForm(String candidatcnp) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM FORM WHERE candidatcnp = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, candidatcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteForm] %s\n", exc.getMessage());
		}
		return 0;
	}
	
	public static int insertForm(Form form) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO FORM "
				+ "(INFORMATII, STATUS, CANDIDATCNP)"
				+ "VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, form.getInformatii());
			pstmt.setString(2, form.getStatus());
			pstmt.setString(3, form.getCandidatCnp());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateForm] %s\n", exc.getMessage());
		}
		return 0;
	}
}

