package fii.admission.candidati;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatService {

    static public List<Candidat> getAllCandidat() {
        ArrayList<Candidat> result = new ArrayList<Candidat>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM CANDIDAT";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Candidat candidat = new Candidat();
                candidat.setLastname(rs.getString("NUME"));
                candidat.setFirstname(rs.getString("PRENUME"));
                candidat.setCnp(rs.getString("CNP"));
                candidat.setEmail(rs.getString("USEREMAIL"));
                candidat.setPhone(rs.getString("TELEFON"));
                result.add(candidat);
            }
            stmt.close();
            rs.close();
            if (result.isEmpty())
                return null;
            else
                return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllCandidat] %s\n", exc.getMessage());
        }
        return null;
    }

    public static Candidat getCandidat(String cnp) {
        Candidat result = new Candidat();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM CANDIDAT WHERE CNP = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, cnp);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setLastname(rs.getString("NUME"));
                result.setFirstname(rs.getString("PRENUME"));
                result.setCnp(rs.getString("CNP"));
                result.setEmail(rs.getString("USEREMAIL"));
                result.setPhone(rs.getString("TELEFON"));
            } else
                return null;
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getCandidat] %s\n", exc.getMessage());
        }
        return null;
    }

    public static Candidat getCandidatByEmail(String email) {
        Candidat result = new Candidat();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM CANDIDAT WHERE USEREMAIL = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setLastname(rs.getString("NUME"));
                result.setFirstname(rs.getString("PRENUME"));
                result.setCnp(rs.getString("CNP"));
                result.setEmail(rs.getString("USEREMAIL"));
                result.setPhone(rs.getString("TELEFON"));
            } else
                return null;
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getCandidatByEmail] %s\n", exc.getMessage());
        }
        return null;
    }

    public static int updateCandidat(String cnp, Candidat candidat) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE CANDIDAT SET nume = ?, prenume = ?, cnp = ?, "
                + "useremail = ?, telefon = ? " +
                "where cnp = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, candidat.getLastname());
            pstmt.setString(2, candidat.getFirstname());
            pstmt.setString(3, candidat.getCnp());
            pstmt.setString(4, candidat.getEmail());
            pstmt.setString(5, candidat.getPhone());
            pstmt.setString(6, cnp);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateCandidat] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int deleteCandidat(String cnp) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM CANDIDAT WHERE cnp = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, cnp);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][deleteCandidat] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int insertCandidat(Candidat candidat) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO CANDIDAT " + "(NUME, PRENUME, CNP, USEREMAIL,TELEFON)"
                + " VALUES ( ?, ?, ?, ?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, candidat.getLastname());
            pstmt.setString(2, candidat.getFirstname());
            pstmt.setString(3, candidat.getCnp());
            pstmt.setString(4, candidat.getEmail());
            pstmt.setString(5, candidat.getPhone());
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateCandidat] %s\n", exc.getMessage());
        }
        return 0;
    }
}
