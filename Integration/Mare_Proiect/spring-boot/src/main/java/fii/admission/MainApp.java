package fii.admission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class MainApp {
    private static final String DB_FILE = "FiiAdmission.db";
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
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
        return (ConfigurableEmbeddedServletContainer container) -> {

            if (container instanceof TomcatEmbeddedServletContainerFactory) {

                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addConnectorCustomizers(
                        (connector) -> {
                            connector.setMaxPostSize(10000000);//10MB
                        }
                );
            }
        };
    }
}
