package fii.admission.profesori;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class ProfesoriService {

	static public List<Profesor> getAllProfesori() {
		ArrayList<Profesor> result = new ArrayList<Profesor>();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM PROFESORI";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Profesor p = new Profesor();
				p.setNume(rs.getString("NUME"));
				p.setPrenume(rs.getString("PRENUME"));
				p.setPCNP(rs.getString("PCNP"));
				p.setSaliExamenSaliId(rs.getString("SALI_EXAMENSALIID"));
				p.setSaliExamenExamenId(rs.getString("SALI_EXAMENEXAMENID"));
				result.add(p);
			}
			stmt.close();
			rs.close();
			if (result.isEmpty())
				return null;
			else
				return result;
		} catch (Exception exc) {
			System.out.printf("[error][getAllProfesori] %s\n", exc.getMessage());
		}
		return null;
	}

	public static Profesor getProfesor(String pcnp) {
		Profesor result = new Profesor();
		Connection con = MainApp.getDBConnection();
		String query = "SELECT * FROM PROFESORI WHERE PCNP = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, pcnp);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result.setNume(rs.getString("NUME"));
				result.setPrenume(rs.getString("PRENUME"));
				result.setPCNP(rs.getString("PCNP"));
				result.setSaliExamenSaliId(rs.getString("SALI_EXAMENSALIID"));
				result.setSaliExamenExamenId(rs.getString("SALI_EXAMENEXAMENID"));
			} else
				return null;
			pstmt.close();
			rs.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][getProfesor] %s\n", exc.getMessage());
		}
		return null;
	}

	public static int updateProfesor(String pcnp, Profesor prof) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "UPDATE PROFESORI SET nume = ?, prenume = ?, pcnp = ?, "
				+ "sali_examensaliid = ?, sali_examenexamenid = ? where pcnp = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, prof.getNume());
			pstmt.setString(2, prof.getPrenume());
			pstmt.setString(3, prof.getPCNP());
			pstmt.setString(4, prof.getSaliExamenSaliId());
			pstmt.setString(5, prof.getSaliExamenExamenId());
			pstmt.setString(6, pcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateProfesor] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int deleteProfesor(String pcnp) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "DELETE FROM PROFESORI WHERE pcnp = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, pcnp);
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][deleteProfesor] %s\n", exc.getMessage());
		}
		return 0;
	}

	public static int insertProfesor(Profesor prof) {
		int result;
		Connection con = MainApp.getDBConnection();
		String query = "INSERT INTO PROFESORI " + "(NUME, PRENUME, PCNP, SALI_EXAMENSALIID, SALI_EXAMENEXAMENID)"
				+ "VALUES ( ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, prof.getNume());
			pstmt.setString(2, prof.getPrenume());
			pstmt.setString(3, prof.getPCNP());
			pstmt.setString(4, prof.getSaliExamenSaliId());
			pstmt.setString(5, prof.getSaliExamenExamenId());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception exc) {
			System.out.printf("[error][updateProfesor] %s\n", exc.getMessage());
		}
		return 0;
	}
}
