
import java.io.*;

public class FileCopier {

    public void copyTextFile(String sourceFilePath, String destinationFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text file copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying text file: " + e.getMessage());
        }
    }

    public void copyImageFile(String sourceFilePath, String destinationFilePath) {
        try (FileInputStream inputStream = new FileInputStream(sourceFilePath);
             FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Image file copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying image file: " + e.getMessage());
        }
    }
}
