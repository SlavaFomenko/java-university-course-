
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

    private static void createInitialFile(String filePath) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.writeBytes("1. Milk\n");
            raf.writeBytes("2. Bread\n");
            raf.writeBytes("3. Eggs\n");
            raf.writeBytes("4. Butter\n");
            raf.writeBytes("5. Cheese\n");
            System.out.println("Initial file created.");
        } catch (IOException e) {
            System.out.println("Error creating initial file: " + e.getMessage());
        }
    }

    private static void appendItems(String filePath) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(20);
            raf.writeBytes("2.5. Juice\n");

            raf.seek(54);
            raf.writeBytes("4.5. Yogurt\n");

            raf.seek(0);
            raf.seek(raf.length());
            raf.writeBytes("6. Fruits\n");

            System.out.println("Items appended to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error appending items to file: " + e.getMessage());
        }
    }

    private static void readFile(String filePath) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            String line;
            System.out.println("Contents of the file:");
            while ((line = raf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "directory_for_files/products.txt";

        createInitialFile(filePath);

        appendItems(filePath);

        readFile(filePath);
    }
}
