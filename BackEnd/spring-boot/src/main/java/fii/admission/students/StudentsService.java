package fii.admission.students;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class StudentsService {

	public static List<Student> getAllStudents() {
		ArrayList<Student> result = new ArrayList<>();
		Connection conn = MainApp.getDBConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from studenti");
			while (rs.next()) {
				Student student = new Student();
				student.setCnp ( rs.getString("cnp"));
				student.setUsername(rs.getString("username"));
				student.setNume_nastere(rs.getString("nume_nastere"));
				student.setTelefon(rs.getString("telefon"));
				student.setPrenume(rs.getString("prenume"));
				student.setAdresa(rs.getString("adresa"));
				student.setNationalitate(rs.getString("nationalitate"));
				student.setAdresa_documente(rs.getString("adresa_documente"));
				student.setNume_actual(rs.getString("nume_actual"));
				student.setPrenume_tata(rs.getString("prenume_tata"));
				student.setPrenume_mama(rs.getString("prenume_mama"));
				student.setSexul(rs.getString("sexul"));
				student.setData_nastere(rs.getString("data_nastere"));
				student.setTara_nastere(rs.getString("tara_nastere"));
				student.setJudet_nastere(rs.getString("judet_nastere"));
				student.setLocalitate_nastere(rs.getString("localitate_nastere"));
				student.setCetatenie(rs.getString("cetatenie"));
				student.setLimba_materna(rs.getString("limba_materna"));
				student.setEtnie(rs.getString("etnie"));
				student.setStare_civila(rs.getString("stare_civila"));
				student.setDate_CI(rs.getString("date_ci"));
				student.setDate_pasaport(rs.getString("date_pasaport"));
				student.setCazare_studii(rs.getString("cazare_studii"));
				student.setCazare_admitere(rs.getString("cazare_admitere"));
				student.setStare_sociala(rs.getString("stare_sociala"));
				student.setDizabilitati(rs.getString("dizabilitati"));
				byte[] byteArr = rs.getBytes("login_token");
				student.setLogin_token(byteArr.toString());
				result.add(student);
			}
			stmt.close();
			rs.close();
		} catch (Exception exc) {
			System.out.printf("[error][getAllStudents] %s\n", exc.getMessage());
		}
		return result;
	}

	public static Student getStudent(String cnp) {
		Connection conn = MainApp.getDBConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement("Select * from studenti where cnp = ?");
			psmt.setString(1, cnp);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setCnp(rs.getString("cnp"));
				student.setUsername(rs.getString("username"));
				student.setNume_nastere(rs.getString("nume_nastere"));
				student.setTelefon(rs.getString("telefon"));
				student.setPrenume(rs.getString("prenume"));
				student.setAdresa(rs.getString("adresa"));
				student.setNationalitate(rs.getString("nationalitate"));
				student.setAdresa_documente(rs.getString("adresa_documente"));
				student.setNume_actual(rs.getString("nume_actual"));
				student.setPrenume_tata(rs.getString("prenume_tata"));
				student.setPrenume_mama(rs.getString("prenume_mama"));
				student.setSexul(rs.getString("sexul"));
				student.setData_nastere (rs.getString("data_nastere"));
				student.setTara_nastere(rs.getString("tara_nastere"));
				student.setJudet_nastere(rs.getString("judet_nastere"));
				student.setLocalitate_nastere(rs.getString("localitate_nastere"));
				student.setCetatenie(rs.getString("cetatenie"));
				student.setLimba_materna(rs.getString("limba_materna"));
				student.setEtnie(rs.getString("etnie"));
				student.setStare_civila(rs.getString("stare_civila"));
				student.setDate_CI(rs.getString("date_ci"));
				student.setDate_pasaport(rs.getString("date_pasaport"));
				student.setCazare_studii(rs.getString("cazare_studii"));
				student.setCazare_admitere(rs.getString("cazare_admitere"));
				student.setStare_sociala(rs.getString("stare_sociala"));
				student.setDizabilitati(rs.getString("dizabilitati"));
				byte[] byteArr = rs.getBytes("login_token");
				student.setLogin_token(byteArr.toString());
				psmt.close();
				rs.close();
				return student;
			}
		} catch (Exception exc) {
			System.out.printf("[error][getAllStudents] %s\n", exc.getMessage());
		}
		return null;
	}
	
	public static boolean addStudent(Student student) {
		return true;
	}
}
