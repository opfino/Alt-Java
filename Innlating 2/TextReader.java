import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader {
    public static String ReadFile() throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the path to the text file: ");
        String filename = userInput.nextLine();
        
        StringBuilder textBuilder = new StringBuilder();
        try (Scanner fileInput = new Scanner(new File(filename))) {
            while (fileInput.hasNextLine()) {
                textBuilder.append(fileInput.nextLine()).append("\n");
            }
        }
        return textBuilder.toString();
    }
}
