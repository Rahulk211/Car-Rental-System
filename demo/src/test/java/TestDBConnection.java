

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/carrentalsys?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "admin@1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("✅ Database connection successful!");
            } else {
                System.out.println("❌ Database connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

