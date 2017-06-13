package fii.admission.notificari;

import fii.admission.MainApp;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificariService {

    static public List<NotificationEntity> getAllNotificari() {
        ArrayList<NotificationEntity> result = new ArrayList<NotificationEntity>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTIFICARI";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                NotificationEntity p = new NotificationEntity();
                p.setMessage(rs.getString("TEXT"));
                p.setSeen(rs.getString("SEEN").compareToIgnoreCase("true") == 0);
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

    public static List<NotificationEntity> getNotificari(String useremail) {
        List<NotificationEntity> result = new ArrayList<>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM NOTIFICARI where useremail = '" + useremail + "'";
        try {
            //PreparedStatement pstmt = con.prepareStatement(query);
            //pstmt.setString(1, useremail);
            System.out.println("TEST0");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("TEST1");
           // ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("TEST2");
                NotificationEntity p = new NotificationEntity();
                p.setMessage(rs.getString("TEXT"));
                p.setSeen(rs.getString("SEEN").compareToIgnoreCase("true") == 0);
                p.setEmail(rs.getString("USEREMAIL"));
                result.add(p);
            }
            System.out.println("TEST3");
            stmt.close();
            rs.close();
            System.out.println("TEST4 " + result.size());
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][getNotificari] %s\n", exc.getMessage());
        }
        return null;
    }

    public static int updateNotificari(String useremail, NotificationEntity notificari) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "UPDATE NOTIFICARI SET text = ?, seen = ?, useremail =?  where useremail = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, notificari.getMessage());
            pstmt.setString(2, notificari.isSeen() ? "true" : "false");
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

    public static int insertNotificari(NotificationEntity notificari) {
        int result;
        Connection con = MainApp.getDBConnection();
        String query = "INSERT INTO NOTIFICARI "
                + " (text, seen, useremail)"
                + " VALUES ( ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, notificari.getMessage());
            pstmt.setString(2, notificari.isSeen() ? "true" : "false");
            pstmt.setString(3, notificari.getEmail());
            result = pstmt.executeUpdate();
            pstmt.close();
            return result;
        } catch (Exception exc) {
            System.out.printf("[error][insertNotificari] %s\n", exc.getMessage());
        }
        return 0;
    }
}
