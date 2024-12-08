import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDatabasePrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/store";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String insertQuery = "INSERT INTO products (name, price) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                addProduct(preparedStatement, "Товар 11", 1100.00);
                addProduct(preparedStatement, "Товар 12", 1200.50);
                addProduct(preparedStatement, "Товар 13", 1300.75);
                addProduct(preparedStatement, "Товар 14", 1400.10);
                addProduct(preparedStatement, "Товар 15", 1500.25);
                System.out.println("Додано ще 5 товарів.");
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setDouble(1, 1000.00);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    System.out.println("Товари з ціною більше 1000:");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        double price = resultSet.getDouble("price");
                        System.out.printf("ID: %d, Назва: %s, Ціна: %.2f%n", id, name, price);
                    }
                }
            }

            String deleteQuery = "DELETE FROM products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                int rowsDeleted = preparedStatement.executeUpdate();
                System.out.println("Усі записи видалено. Кількість видалених записів: " + rowsDeleted);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(PreparedStatement preparedStatement, String name, double price) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, price);
        preparedStatement.executeUpdate();
    }
}
