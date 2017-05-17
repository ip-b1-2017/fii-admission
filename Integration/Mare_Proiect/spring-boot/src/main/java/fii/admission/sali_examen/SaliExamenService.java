package fii.admission.sali_examen;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaliExamenService {

    static public List<SaliExamen> getAllSaliExamen() {
        ArrayList<SaliExamen> result = new ArrayList<SaliExamen>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM SALI_EXAMEN";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SaliExamen p = new SaliExamen();
                p.setSaliId(rs.getString("SALIID"));
                p.setExamenId(rs.getString("EXAMENID"));
                result.add(p);
            }
            stmt.close();
            rs.close();
            if (result.isEmpty())
                return null;
            else
                return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllSaliExamen] %s\n", exc.getMessage());
        }
        return null;
    }

    public static SaliExamen getSaliExamen(String saliid) {
        SaliExamen result = new SaliExamen();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM SALI_EXAMEN WHERE saliid = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, saliid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setSaliId(rs.getString("SALIID"));
                result.setExamenId(rs.getString("EXAMENID"));
            } else
                return null;
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getSaliExamen] %s\n", exc.getMessage());
        }
        return null;
    }

    public static int updateSaliExamen(String saliid, SaliExamen saliExamen) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE SALI_EXAMEN SET saliid = ?, examenid = ? where saliid = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, saliExamen.getSaliId());
            pstmt.setString(2, saliExamen.getExamenId());
            pstmt.setString(3, saliid);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateSaliExamen] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int deleteSaliExamen(String saliid) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM SALI_EXAMEN WHERE saliid = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, saliid);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][deleteSaliExamen] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int insertSaliExamen(SaliExamen saliExamen) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO SALI_EXAMEN "
                + " (saliid, examenid)"
                + " VALUES ( ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, saliExamen.getSaliId());
            pstmt.setString(2, saliExamen.getExamenId());
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateSaliExamen] %s\n", exc.getMessage());
        }
        return 0;
    }
}
