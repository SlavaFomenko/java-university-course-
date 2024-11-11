import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class ShoppingReport {
    private StringBuilder report = new StringBuilder();
    private double total = 0;
    private int itemCounter = 1;

    public ShoppingReport() {
        Formatter formatter = new Formatter(report);
        String dateTime = "current date :)";

        formatter.format("Дата та час покупки: %s%n", dateTime);
        formatter.format("========================================================%n");
        formatter.format("%-3s %-20s %-15s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("========================================================%n");
        formatter.close();
    }

    public void addItem(String itemName, String category, double price) {
        Formatter formatter = new Formatter();
        formatter.format("%-3d %-20s %-15s %-10.2f ₴%n", itemCounter++, itemName, category, price);
        report.append(formatter);
        total += price;
        formatter.close();
    }

    public void writeReportToFile(String fileName) {
        File directory = new File("directory_for_files");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(new File(directory, fileName))) {
            writer.write(report.toString());
            writer.write(String.format("========================================================%n"));
            writer.write(String.format("Разом: %.2f ₴%n", total));
            writer.write("========================================================\n");

            System.out.println("Report written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readReportFromFile(String fileName) {
        try (FileReader reader = new FileReader("directory_for_files/" + fileName)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
