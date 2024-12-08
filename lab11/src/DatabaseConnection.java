import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DatabaseConnection {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        String dbName = "store";
        String dbUrlWithDB = url + dbName;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("База даних створена або вже існує.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(dbUrlWithDB, user, password);
             Statement statement = connection.createStatement()) {

            String createTableQuery = """
                    CREATE TABLE IF NOT EXISTS products (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL
                    );
                    """;
            statement.executeUpdate(createTableQuery);
            System.out.println("Таблиця створена або вже існує.");

            String insertDataQuery = """
                    INSERT INTO products (name, price)
                    VALUES ('Товар 1', 100.00), ('Товар 2', 200.00);
                    """;
            statement.executeUpdate(insertDataQuery);
            System.out.println("Дані додані до таблиці.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
