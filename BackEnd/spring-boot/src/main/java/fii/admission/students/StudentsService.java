package fii.admission.students;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fii.admission.MainApp;

@Service
public class StudentsService {

	@Autowired
	private StudentRepository studentRepository;
	
	public static List<Student> getAllStudents() {
		ArrayList<Student> result = new ArrayList<>();
		Connection conn = MainApp.getDBConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from studenti");
			while (rs.next()) {
				Student student = new Student();
				student.cnp = rs.getString("cnp");
				student.username = rs.getString("username");
				student.nume_nastere = rs.getString("nume_nastere");
				student.telefon = rs.getString("telefon");
				student.prenume = rs.getString("prenume");
				student.adresa = rs.getString("adresa");
				student.nationalitate = rs.getString("nationalitate");
				student.adresa_documente = rs.getString("adresa_documente");
				student.nume_actual = rs.getString("nume_actual");
				student.prenume_tata = rs.getString("prenume_tata");
				student.prenume_mama = rs.getString("prenume_mama");
				student.sexul = rs.getString("sexul");
				student.data_nastere = rs.getString("data_nastere");
				student.tara_nastere = rs.getString("tara_nastere");
				student.judet_nastere = rs.getString("judet_nastere");
				student.localitate_nastere = rs.getString("localitate_nastere");
				student.cetatenie = rs.getString("cetatenie");
				student.limba_materna = rs.getString("limba_materna");
				student.etnie = rs.getString("etnie");
				student.stare_civila = rs.getString("stare_civila");
				student.date_CI = rs.getString("date_CI");
				student.date_pasaport = rs.getString("date_pasaport");
				student.cazare_studii = rs.getString("cazare_studii");
				student.cazare_admitere = rs.getString("cazare_admitere");
				student.stare_sociala = rs.getString("stare_sociala");
				student.dizabilitati = rs.getString("dizabilitati");
				byte[] byteArr = rs.getBytes("login_token");
				student.login_token = byteArr.toString();
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
				student.cnp = rs.getString("cnp");
				student.username = rs.getString("username");
				student.nume_nastere = rs.getString("nume_nastere");
				student.telefon = rs.getString("telefon");
				student.prenume = rs.getString("prenume");
				student.adresa = rs.getString("adresa");
				student.nationalitate = rs.getString("nationalitate");
				student.adresa_documente = rs.getString("adresa_documente");
				student.nume_actual = rs.getString("nume_actual");
				student.prenume_tata = rs.getString("prenume_tata");
				student.prenume_mama = rs.getString("prenume_mama");
				student.sexul = rs.getString("sexul");
				student.data_nastere = rs.getString("data_nastere");
				student.tara_nastere = rs.getString("tara_nastere");
				student.judet_nastere = rs.getString("judet_nastere");
				student.localitate_nastere = rs.getString("localitate_nastere");
				student.cetatenie = rs.getString("cetatenie");
				student.limba_materna = rs.getString("limba_materna");
				student.etnie = rs.getString("etnie");
				student.stare_civila = rs.getString("stare_civila");
				student.date_CI = rs.getString("date_CI");
				student.date_pasaport = rs.getString("date_pasaport");
				student.cazare_studii = rs.getString("cazare_studii");
				student.cazare_admitere = rs.getString("cazare_admitere");
				student.stare_sociala = rs.getString("stare_sociala");
				student.dizabilitati = rs.getString("dizabilitati");
				byte[] byteArr = rs.getBytes("login_token");
				student.login_token = byteArr.toString();
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
