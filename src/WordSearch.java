import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("This program requires 2 parameters.");
            System.exit(1);
        }

        String pattern = args[0];
        String fileName = args[1];

        try {
            searchLines(pattern, fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void searchLines(String pattern, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.contains(pattern)) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
        }
    }
}