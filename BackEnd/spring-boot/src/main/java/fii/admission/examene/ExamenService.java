package fii.admission.examene;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class ExamenService {

	static public List<Examen> getAllExamen() {
		ArrayList<Examen> result = new ArrayList<Examen>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Examen";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Examen p = new Examen();
				p.setId(rs.getString("id"));
				p.setStartDate(rs.getString("START_DATE"));
                                p.setEndDate(rs.getString("END_DATE"));
                                p.setTip(rs.getString("tip"));
                                p.setNrProba(rs.getInt("NR_PROBA"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if (result.isEmpty())
				return null;
			else
				return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAllExamen] %s\n", exc.getMessage());
		}
		return null;
	}

	public static Examen getExamen(String id) {
		Examen result = new Examen();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM Examen WHERE id = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setId(rs.getString("id"));
				result.setStartDate(rs.getString("START_DATE"));
				result.setEndDate(rs.getString("END_DATE"));
				result.setTip(rs.getString("tip"));
				result.setNrProba(rs.getInt("NR_PROBA"));
			} else
				return null;
			pstmt.close();
			rs.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][getExamen] %s\n", exc.getMessage());
		}
		return null;
	}

	public static int updateExamen(String id, Examen examen) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE Examen SET id=?, start_date = ?, end_date = ?, nr_proba = ?, tip = ? where id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, examen.getId());
			pstmt.setString(2, examen.getStartDate());
			pstmt.setString(3, examen.getEndDate());
			pstmt.setInt(4, examen.getNrProba());
			pstmt.setString(5, examen.getTip());
			pstmt.setString(6, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateExamen] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int deleteExamen(String id) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM Examen WHERE id = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][deleteExamen] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int insertExamen(Examen examen) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO Examen"
				+ " (ID, START_DATE, END_DATE,NR_PROBA,TIP)"
				+ " VALUES ( ?, ?, ?, ?, ?)";		
		
		try{
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, examen.getId());
			pstmt.setString(2, examen.getStartDate());
			pstmt.setString(3, examen.getEndDate());
			pstmt.setInt(4, examen.getNrProba());
			pstmt.setString(5, examen.getTip());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch(Exception exc) {
			System.out.printf("[error][updateExamen] %s\n", exc.getMessage());
		}
		return 0;
	}
}
