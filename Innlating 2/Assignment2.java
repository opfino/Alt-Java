
import java.io.FileNotFoundException;

public class Assignment2 {
    public static void main(String[] args) {
        try {
            // Read text file using TextReader
            TextReader reader = new TextReader();
            String text = TextReader.ReadFile();
            
            if (text == null || text.trim().isEmpty()) {
                System.out.println("No text was read from the file.");
                return;
            }
            
            System.out.println("Text loaded successfully.\n");
            
            // Analyze text using TextAnalyzer
            TextAnalyzer analyzer = new TextAnalyzer(text);
            analyzer.analyze();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
