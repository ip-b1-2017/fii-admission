package fii.admission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class MainApp {
	private static final String DB_FILE = "FiiConcurs.db";
	private static Connection sqliteDBConnection;
	
    public static void createNewDatabase() {
    	 
        String url = "jdbc:sqlite:./" + DB_FILE;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.printf("[debug][createNewDatabase] Database \"%s\" created!\n", DB_FILE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection getDBConnection() {
    	if (sqliteDBConnection == null) {
    		try {
				sqliteDBConnection = DriverManager.getConnection("jdbc:sqlite:./" + DB_FILE);
			} catch (SQLException e) {
				System.out.printf("[error][getDBConnection] %s\n", e.getMessage());
			}
    	}
    	return sqliteDBConnection;
    }
    
    
	public static void main(String[] args) {
		// createNewDatabase();
		SpringApplication.run(MainApp.class, args);
	}
}
