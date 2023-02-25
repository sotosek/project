import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_test_connect {

    public static void main(String[] args) {
        Initialization init = new Initialization(".\\src\\config.ini");
        String url = init.getUrl();
        String username = init.getUsername();
        String password = init.getPassword();

        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.close();
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
