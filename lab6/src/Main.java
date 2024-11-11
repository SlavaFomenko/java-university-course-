import java.io.*;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {

//        task2();
        task3();
//        task4();
//        task6();
    }


    public static void task2(){
        System.out.println(checkCredentials("user_login", "password123", "password123"));
        System.out.println(checkCredentials("user_login@", "password123", "password123"));
        System.out.println(checkCredentials("user_login", "password", "Password"));
    };
    public static void task3(){
        ShoppingReport report = new ShoppingReport();

        report.addItem("Джинси", "Жіночий одяг", 1500.78);
        report.addItem("Спідниця", "Жіночий одяг", 1000.56);
        report.addItem("Краватка", "Чоловічий одяг", 500.78);
        report.addItem("Сорочка", "Чоловічий одяг", 800.00);
        report.addItem("Футболка", "Жіночий одяг", 400.50);
        report.addItem("Куртка", "Чоловічий одяг", 1200.00);
        report.addItem("Шорти", "Чоловічий одяг", 600.00);
        report.addItem("Сукня", "Жіночий одяг", 900.00);
        report.addItem("Шарф", "Жіночий одяг", 300.00);
        report.addItem("Чоботи", "Чоловічий одяг", 1000.00);

        report.writeReportToFile("shopping_report.txt");

        report.readReportFromFile("shopping_report.txt");
    };
    public static void task4(){
        FileCopier fileCopier = new FileCopier();

        String textFilePath = "directory_for_files/source.txt";
        try {
            FileWriter writer = new FileWriter(textFilePath);
            writer.write("This is a test text file.\n");
            writer.write("It contains multiple lines of text.\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating text file: " + e.getMessage());
        }

        String imageFilePath = "directory_for_files/source_image.jpg";
        try {
            FileOutputStream fos = new FileOutputStream(imageFilePath);
            fos.write(new byte[0]);
            fos.close();
        } catch (IOException e) {
            System.out.println("Error creating image file: " + e.getMessage());
        }

        fileCopier.copyTextFile(textFilePath, "directory_for_files/destination.txt");

        fileCopier.copyImageFile(imageFilePath, "directory_for_files/destination_image.jpg");
    };
    public static void task6(){
        String baseDirectoryPath = "directory_for_files";

        File innerDirectory = new File(baseDirectoryPath, "inner_directory");
        if (innerDirectory.mkdir()) {
            System.out.println("Directory created: " + innerDirectory.getAbsolutePath());
        } else {
            System.out.println("Directory already exists or failed to create.");
        }

        System.out.println("Absolute path of the directory: " + innerDirectory.getAbsolutePath());

        System.out.println("Parent directory name: " + innerDirectory.getParent());

        try {
            File file1 = new File(innerDirectory, "file1.txt");
            File file2 = new File(innerDirectory, "file2.txt");

            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getAbsolutePath());
            }

            if (file2.createNewFile()) {
                System.out.println("File created: " + file2.getAbsolutePath());
            }

            if (file1.delete()) {
                System.out.println("Deleted file: " + file1.getAbsolutePath());
            } else {
                System.out.println("Failed to delete file: " + file1.getAbsolutePath());
            }

            File renamedDirectory = new File(baseDirectoryPath, "renamed_inner_directory");
            if (innerDirectory.renameTo(renamedDirectory)) {
                System.out.println("Directory renamed to: " + renamedDirectory.getAbsolutePath());
            } else {
                System.out.println("Failed to rename directory.");
            }

            File baseDirectory = new File(baseDirectoryPath);
            File[] files = baseDirectory.listFiles();

            if (files != null) {
                System.out.println("Files and directories in " + baseDirectoryPath + ":");
                for (File file : files) {
                    String type = file.isDirectory() ? "Directory" : "File";
                    System.out.println(type + ": " + file.getName() + " (Size: " + file.length() + " bytes)");
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating files: " + e.getMessage());
        }
    }


    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login must contain only Latin letters, digits, underscores, and be shorter than 20 characters.");
            }

            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password must contain only Latin letters, digits, underscores, and be shorter than 20 characters, and match confirmPassword.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void format() {
        Formatter formatter = new Formatter();

        String dateTime = "28.03.2019 13:25:12";
        String[] products = {
                "Джинси", "Спідниця", "Краватка",
                "Сорочка", "Футболка", "Куртка",
                "Шорти", "Сукня", "Шарф", "Чоботи"
        };
        String[] categories = {
                "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг"
        };
        double[] prices = {1500.78, 1000.56, 500.78, 800.00, 400.50, 1200.00, 600.00, 900.00, 300.00, 1000.00};

        double total = 0;

        formatter.format("Дата та час покупки: %s%n", dateTime);
        formatter.format("========================================================%n");
        formatter.format("%-3s %-20s %-15s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("========================================================%n");

        for (int i = 0; i < products.length; i++) {
            formatter.format("%-3d %-20s %-15s %-10.2f ₴%n", i + 1, products[i], categories[i], prices[i]);
            total += prices[i];
        }

        formatter.format("Разом: %.2f ₴%n", total);
        formatter.format("========================================================%n");

        System.out.println(formatter);
        formatter.close();
    }

}