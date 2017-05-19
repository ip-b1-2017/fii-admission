package fii.admission.statistici;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cosmin on 5/16/2017.
 */
@Service
public class StatisticiService {

    public StatisticiAdmin getStatistici(){
        return null;
    }

    public static String getNumarCandidati(String email){
        Connection con = MainApp.getDBConnection();
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String numarCandidati=null;
        String query = "SELECT count(*) FROM CANDIDAT";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            numarCandidati = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return numarCandidati;
    }

    public static String getStatusAplicatie(String email){
        Connection con = MainApp.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet rs  = null;
        String  query = "select status from form f, candidat c where c.useremail=? and c.CNP=f.CANDIDATCNP";
        String statusAplicatie=null;
        try{
             pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
             rs = pstmt.executeQuery();
            if(rs.next()){
                statusAplicatie = rs.getString(1);
                return statusAplicatie;
            }else{
                return "Neinscris";
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
