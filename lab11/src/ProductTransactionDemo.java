import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/store";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);

            try {
                String addProduct1 = "INSERT INTO products (name, price) VALUES (?, ?)";
                try (PreparedStatement statement1 = connection.prepareStatement(addProduct1)) {
                    statement1.setString(1, "Товар A");
                    statement1.setDouble(2, 250.50);
                    statement1.executeUpdate();
                    System.out.println("Перший товар додано.");
                }

                var savepoint = connection.setSavepoint("AfterFirstProduct");

                String addProduct2 = "INSERT INTO products (name, price VALUES (?, ?)";
                try (PreparedStatement statement2 = connection.prepareStatement(addProduct2)) {
                    statement2.setString(1, "Товар B");
                    statement2.setDouble(2, 350.75);
                    statement2.executeUpdate();
                }

                connection.commit();
            } catch (SQLException e) {
                System.out.println("Помилка під час виконання транзакції: " + e.getMessage());
                connection.rollback(connection.setSavepoint("AfterFirstProduct"));
                System.out.println("Транзакцію відкотили до точки збереження.");
            }

            String selectQuery = "SELECT * FROM products";
            try (PreparedStatement statement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = statement.executeQuery()) {
                System.out.println("Список товарів після транзакції:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    System.out.printf("ID: %d, Назва: %s, Ціна: %.2f%n", id, name, price);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
