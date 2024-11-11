import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipExample {

    private static void createZip(String sourceDir, String zipFilePath) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            File dir = new File(sourceDir);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            zipOutputStream.putNextEntry(zipEntry);

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) >= 0) {
                                zipOutputStream.write(buffer, 0, length);
                            }
                            zipOutputStream.closeEntry();
                        }
                        System.out.println("Added to zip: " + file.getName());
                    }
                }
            }
            System.out.println("Zip file created: " + zipFilePath);
        } catch (IOException e) {
            System.out.println("Error creating zip file: " + e.getMessage());
        }
    }

    private static void listFilesInZip(String zipFilePath) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry;
            System.out.println("Files in the zip:");
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
                zipInputStream.closeEntry();
            }
        } catch (IOException e) {
            System.out.println("Error reading zip file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceDir = "directory_for_files";
        String zipFilePath = "directory_for_files/archive.zip";

        createZip(sourceDir, zipFilePath);

        listFilesInZip(zipFilePath);
    }
}
