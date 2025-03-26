import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to write content to a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read content from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nFile Content:");
            System.out.println("----------------------");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to modify content in a file (appending text)
    public static void modifyFile(String filename, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.newLine();
            writer.write(newContent);
            System.out.println("Content appended to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    // Method to delete a file
    public static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "example.txt";
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nFile Handling Utility");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Append to File");
            System.out.println("4. Delete File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter content to write: ");
                    String content = scanner.nextLine();
                    writeToFile(filename, content);
                    break;
                case 2:
                    readFromFile(filename);
                    break;
                case 3:
                    System.out.print("Enter content to append: ");
                    String additionalContent = scanner.nextLine();
                    modifyFile(filename, additionalContent);
                    break;
                case 4:
                    deleteFile(filename);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}
