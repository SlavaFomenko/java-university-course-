import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/store";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ProductDAO productDAO = new ProductDAO(connection);

            productDAO.create(new Product("Товар 1", 500.00));
            productDAO.create(new Product("Товар 2", 600.00));
            System.out.println("Товари створено.");

            List<Product> products = productDAO.readAll();
            System.out.println("Усі товари:");
            products.forEach(System.out::println);

            Product productToUpdate = products.get(0);
            productToUpdate.setPrice(550.00);
            productDAO.update(productToUpdate);
            System.out.println("Товар оновлено: " + productToUpdate);

            Product retrievedProduct = productDAO.read(productToUpdate.getId());
            System.out.println("Отриманий товар: " + retrievedProduct);

            productDAO.delete(products.get(1).getId());
            System.out.println("Товар видалено.");

            products = productDAO.readAll();
            System.out.println("Товари після видалення:");
            products.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
