/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fii.admission.anunturi;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class AnunturiService {

	static public List<Anunturi> getAllAnunturi() {
		ArrayList<Anunturi> result = new ArrayList<Anunturi>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Anunturi";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Anunturi anunt = new Anunturi();
				anunt.setId(rs.getInt("ID"));
				anunt.setAnunt(rs.getString("ANUNT"));
				result.add(anunt);
			}
			stmt.close();
			rs.close();
			if (result.isEmpty())
				return null;
			else
				return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAllAnunturi] %s\n", exc.getMessage());
		}
		return null;
	}

	public static Anunturi getAnunturi(int id) {
		Anunturi result = new Anunturi();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Anunturi WHERE ID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result.setId(rs.getInt("ID"));
				result.setAnunt(rs.getString("ANUNT"));
			} else
				return null;
			pstmt.close();
			rs.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAnunturi] %s\n", exc.getMessage());
		}
		return null;
	}

	public static int updateAnunturi(int id, Anunturi anunt) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE Anunturi SET id = ?, anunt = ? "+ 
				"where id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, anunt.getId());
			pstmt.setString(2, anunt.getAnunt());
			pstmt.setInt(3, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateAnunturi] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int deleteAnunturi(int id) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM Anunturi WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][deleteAnunturi] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int insertAnunturi(Anunturi anunt) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO Anunturi " + "(ID, ANUNT)" + "VALUES (?,?)";

		try {
			String deleteOld = "DELETE FROM Anunturi WHERE id = " +
					"(SELECT CASE WHEN COUNT(*) >9 THEN MIN(ID) ELSE -1 END FROM ANUNTURI );";
			PreparedStatement deleteStmt = con.prepareStatement(deleteOld);
			deleteStmt.executeUpdate();
			deleteStmt.close();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, anunt.getId());
			pstmt.setString(2, anunt.getAnunt());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateAnunturi] %s\n", exc.getMessage());
		}
		return 0;
	}
}
