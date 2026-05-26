public class WordAnalyzer {
    
    // Count total number of words
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    
    // Count long words (6 letters or more)
    public static int countLongWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        int count = 0;
        for (String word : words) {
            // Remove punctuation for word length check
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() >= 6) {
                count++;
            }
        }
        return count;
    }
    
    // Get average word length
    public static double getAverageWordLength(String text) {
        int totalWords = countWords(text);
        if (totalWords == 0) {
            return 0;
        }
        int totalLetters = 0;
        String[] words = text.trim().split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            totalLetters += cleanWord.length();
        }
        return (double) totalLetters / totalWords;
    }
}
