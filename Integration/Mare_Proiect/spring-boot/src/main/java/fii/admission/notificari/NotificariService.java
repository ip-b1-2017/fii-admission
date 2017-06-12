package fii.admission.notificari;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificariService {

    static public List<Notificari> getAllNotificari() {
        ArrayList<Notificari> result = new ArrayList<Notificari>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTIFICARI";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Notificari p = new Notificari();
                p.setMessage(rs.getString("TEXT"));
                p.setSeen(rs.getInt("SEEN") == 1);
                p.setEmail(rs.getString("USEREMAIL"));
                result.add(p);
            }
            stmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllNotificari] %s\n", exc.getMessage());
        }
        return null;
    }

    public static List<Notificari> getNotificari(String useremail) {
        List<Notificari> result = new ArrayList<>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTIFICARI WHERE USEREMAIL = ? order by seen";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, useremail);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Notificari p = new Notificari();
                p.setMessage(rs.getString("TEXT"));
                p.setSeen(rs.getInt("SEEN") == 1);
                p.setEmail(rs.getString("USEREMAIL"));
                result.add(p);
            }
            pstmt.close();
            rs.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getNotificari] %s\n", exc.getMessage());
        }
        return null;
    }

    public static int updateNotificari(String useremail, Notificari notificari) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE NOTIFICARI SET text = ?, seen = ?, useremail =?  where useremail = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, notificari.getMessage());
            pstmt.setInt(2, notificari.isSeen() ? 1 : 0);
            pstmt.setString(3, notificari.getEmail());
            pstmt.setString(4, useremail);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int setSeen(String useremail) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE NOTIFICARI SET seen = 1 where useremail = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, useremail);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int deleteNotificari(String useremail) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM NOTIFICARI WHERE useremail = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, useremail);
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][deleteNotificari] %s\n", exc.getMessage());
        }
        return 0;
    }

    public static int insertNotificari(Notificari notificari) {
        System.out.println(notificari.toString());
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO NOTIFICARI "
                + " (text, seen, useremail)"
                + " VALUES ( ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, notificari.getMessage());
            pstmt.setInt(2, notificari.isSeen() ? 1 : 0);
            pstmt.setString(3, notificari.getEmail());
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][updateNotificari] %s\n", exc.getMessage());
            return 0;
        }
    }
}
