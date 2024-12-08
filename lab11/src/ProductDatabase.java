import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/store";
        String user = "root";
        String password ="root";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String createTableQuery = """
                    CREATE TABLE IF NOT EXISTS products (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL
                    );
                    """;
            statement.executeUpdate(createTableQuery);
            System.out.println("Таблиця 'products' створена або вже існує.");

            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 1', 100.50)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 2', 200.00)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 3', 300.75)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 4', 400.00)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 5', 500.25)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 6', 600.10)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 7', 700.60)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 8', 800.20)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 9', 900.75)");
            statement.addBatch("INSERT INTO products (name, price) VALUES ('Товар 10', 1000.90)");

            int[] results = statement.executeBatch();
            System.out.println("Дані для 10 товарів додано. Кількість операцій: " + results.length);

            String selectQuery = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("Список товарів:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                System.out.printf("ID: %d, Назва: %s, Ціна: %.2f%n", id, name, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
