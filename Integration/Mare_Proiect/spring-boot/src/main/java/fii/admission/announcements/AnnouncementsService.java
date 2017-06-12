package fii.admission.announcements;

import fii.admission.MainApp;
import org.springframework.http.HttpStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosmin on 6/12/2017.
 */
public class AnnouncementsService {

    public static List<Announcement> getAnnouncements(int limit){
        ArrayList<Announcement> ads = new ArrayList<>();
        Connection con = MainApp.getDBConnection();
        String querry = "select * from announcements order by announcement_date";
        Statement stmt = null;
        ResultSet rs;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(querry);

            while(rs.next()){
                Announcement ad = new Announcement();
                ad.setId(rs.getInt(1));
                ad.setTitle(rs.getString(2));
                ad.setText(rs.getString(3));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Announcement> page = new ArrayList<>();
                for(int i=0; i<limit; i++){
                    page.add(ads.get(i));
                }
        return page;
    }

    public static List<Announcement> getAnnouncements(int seek, int limit){
        ArrayList<Announcement> ads = new ArrayList<>();
        Connection con = MainApp.getDBConnection();
        String querry = "select * from announcements order by announcement_date";
        Statement stmt = null;
        ResultSet rs;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(querry);

            while(rs.next()){
                Announcement ad = new Announcement();
                ad.setId(rs.getInt(1));
                ad.setTitle(rs.getString(2));
                ad.setText(rs.getString(3));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Announcement> page = new ArrayList<>();

        for(int i=0, n=ads.size(); i<n; i++){
            if(ads.get(i).getId()==seek){
                for(int j=i+1; j<i+1+limit && j<ads.size(); j++){
                    page.add(ads.get(j));
                }
                break;
            }
        }
        return page;
    }

    public static HttpStatus save(String title, String text){
        Connection con = MainApp.getDBConnection();
        PreparedStatement pstmt=null;
        String query = "INSERT INTO ANNOUNCEMENTS (TITLE,TEXT) VALUES(?,?)";
        try {
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1,title);
            pstmt.setString(2,text);
            pstmt.executeUpdate();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return HttpStatus.CREATED;
    }

    public static HttpStatus delete(int id){
        Connection con = MainApp.getDBConnection();
        String query = "DELETE FROM ANNOUNCEMENTS WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(query.toString());
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception exc) {
            System.out.printf("[error][deleteUser] %s\n", exc.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return HttpStatus.NO_CONTENT;
    }

    public static HttpStatus update(int id, String title, String text){
        Connection con = MainApp.getDBConnection();
        PreparedStatement pstmt=null;
        String query = "UPDATE ANNOUNCEMENTS SET TITLE =?, TEXT=? WHERE ID=?";
        try {
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1,title);
            pstmt.setString(2,text);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return HttpStatus.OK;
    }

}
