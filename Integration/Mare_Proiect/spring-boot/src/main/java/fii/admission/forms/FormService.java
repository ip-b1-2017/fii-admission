package fii.admission.forms;

import com.google.gson.Gson;
import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static fii.admission.DebugHelper.printDebugMsg;

@Service
public class FormService {

	static public List<Form> getAllForm() {
		ArrayList<Form> result = new ArrayList<Form>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM FORM";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Form form = new Form();
				form.setFields(rs.getString("FORMULAR"));
				form.setStatus(rs.getString("STATUS"));
				form.setCandidateCnp(rs.getString("CANDIDATCNP"));
				result.add(form);
			}
			stmt.close();
			rs.close();
			if (result.isEmpty())
				return null;
			else
				return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAllForm] %s\n", exc.getMessage());
		}
		return null;
	}

	public static Form getForm(String candidatcnp) {
		Form result = new Form();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM FORM WHERE CANDIDATCNP = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, candidatcnp);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setFields(rs.getString("FORMULAR"));
				result.setStatus(rs.getString("STATUS"));
				result.setCandidateCnp(rs.getString("CANDIDATCNP"));
			} else
				return null;
			pstmt.close();
			rs.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][getForm] %s\n", exc.getMessage());
		}
		return null;
	}

	public static int updateForm(String candidatcnp, Form form) {
		int result;
		Connection con = MainApp.getDBConnection();
		String getFormQuery = "SELECT formular FROM form WHERE candidatcnp = ?";
		String updateQuery = "UPDATE FORM SET formular = ?, status = ?, candidatcnp = ? where candidatcnp = ?";
		String oldForm, finalForm;
		try{
			PreparedStatement pstmt = con.prepareStatement(getFormQuery);
			pstmt.setString(1, form.getCandidateCnp());
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				oldForm = rs.getString(1);
			}else {
				// THERE IS NO CANDIDATE WITH SUCH CNP
				printDebugMsg("@FormService - updateForm", "missing cnp: " + candidatcnp);
				return 0;
			}
			rs.close();
			finalForm = updateOldForm(oldForm, form.getFields());
			System.out.println(finalForm);
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, finalForm);
			pstmt.setString(2, form.getStatus());
			pstmt.setString(3, form.getCandidateCnp());
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
				+ " (FORMULAR, STATUS, CANDIDATCNP)"
				+ " VALUES ( ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, form.getFields());
			pstmt.setString(2, form.getStatus());
			pstmt.setString(3, form.getCandidateCnp());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateForm] %s\n", exc.getMessage());
		}
		return 0;
	}

	/*
		* Created by bogdan
		* @param formToUpdate: form from database(in JSON) to be updated
		* @param formWithUpdates: form (in JSON) which contains updates
		* @return a new form built in this way:
		 * if exists a key in both forms, new form will contain value from formWithUpdates
		 * else key value pair, from formWithUpdates, will be appended to new form
	 */
	public static String updateOldForm(String formToUpdate, String formWithUpdates){
		Gson gson = new Gson();
		Map<String, String> finalForm, updatesForm;

		finalForm = (Map<String, String>)gson.fromJson(formToUpdate, Map.class);
		updatesForm = (Map<String, String>)gson.fromJson(formWithUpdates, Map.class);

		for(Map.Entry<String, String> update : updatesForm.entrySet() ){
			if(update.getValue().equals(""))
				continue;
			finalForm.put(update.getKey(), update.getValue());
		}

		return gson.toJson(finalForm);
	}
}

