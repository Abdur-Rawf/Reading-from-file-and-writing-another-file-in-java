import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumTo {

    public static void main(String[] args) {
        // File names
        String inputFileName = "Input.txt";
        String outputFileName = "Output.txt";

        try {
            // Read the numbers from the input file
            List<Integer> numbers = new ArrayList<>();
            Scanner scanner = new Scanner(new File(inputFileName));
            
            // Read each number and add it to the list
            scanner.useDelimiter(",\\s*"); // use comma as delimiter
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            scanner.close();

            // Open the output file for writing
            PrintWriter writer = new PrintWriter(new File(outputFileName));

            // Calculate and write the sum for each number in the list
            for (int num : numbers) {
                int sumToNum = (num * (num + 1)) / 2; // Sum from 1 to num
                writer.print(sumToNum + ", "); // Write the calculated sum
            }

            writer.close();
            System.out.println("Output written to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}