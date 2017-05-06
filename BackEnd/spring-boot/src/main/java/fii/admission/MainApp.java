package fii.admission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class MainApp {
	private static final String DB_FILE = "FiiConcurs.db";
	public static final String[] SPRING_APP_ARGS = new String[] {
		"--server.port=9999"
	};
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
		String[] mergedArgs = mergeArgs(args);
		SpringApplication.run(MainApp.class, mergedArgs);
	}
	
	public static String[] mergeArgs(String[] args) {
		String[] new_args = new String[args.length + SPRING_APP_ARGS.length];
		short idx = 0;
		
		for(int i = 0; i < SPRING_APP_ARGS.length; ++i)
			new_args[idx++] = SPRING_APP_ARGS[i];
		
		for(int i = 0; i < args.length; ++i)
			new_args[idx++] = args[i];
		
		return new_args;
	}
}
