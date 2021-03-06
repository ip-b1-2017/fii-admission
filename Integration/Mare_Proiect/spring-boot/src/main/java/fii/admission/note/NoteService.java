package fii.admission.note;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    static public List<Note> getAllNote() {
        ArrayList<Note> result = new ArrayList<Note>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTE";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Note p = new Note();
                p.setCandidatCNP(rs.getString("CANDIDATCNP"));
                p.setValoare(rs.getFloat("VALOARE"));
                p.setExamenid(rs.getString("EXAMENID"));
                result.add(p);
            }
            stmt.close();
            rs.close();
            if (result.isEmpty())
                return null;
            else
                return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllNote] %s\n", exc.getMessage());
        }
        return null;
    }

    public static Note getNote(String candidatcnp, String criteria) {
        Note result = new Note();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTE WHERE CANDIDATCNP = ?";
        if(criteria != null)
            query += " AND EXAMENID = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, candidatcnp);
            if(criteria != null)
                pstmt.setString(2, criteria);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setCandidatCNP(rs.getString("CANDIDATCNP"));
                result.setValoare(rs.getFloat("VALOARE"));
                result.setExamenid(rs.getString("EXAMENID"));
            } else
                return null;
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getNote] %s\n", exc.getMessage());
        }
        return null;
    }

    public static int updateNote(Note note) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE NOTE SET valoare = ? " +
                       "WHERE candidatcnp = ? AND examenid = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setFloat(1, note.getValoare());
            pstmt.setString(2, note.getCandidatCNP());
            pstmt.setString(3, note.getExamenid());

            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateNote] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int deleteNote(String candidatcnp) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM NOTE WHERE CANDIDATCNP = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, candidatcnp);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][deleteNote] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int insertNote(Note note) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO NOTE "
                + "(CANDIDATCNP, VALOARE,EXAMENID)"
                + " VALUES ( ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, note.getCandidatCNP());
            pstmt.setFloat(2, note.getValoare());
            pstmt.setString(3, note.getExamenid());
            result = pstmt.executeUpdate();
            pstmt.close();
            return 0;
        } catch (Exception exc) {
            System.out.printf("[error][updateNote] %s\n", exc.getMessage());
            return 1;
        }
    }
}
