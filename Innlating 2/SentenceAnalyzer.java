public class SentenceAnalyzer {
    
    // Count sentences (by ., !, ?)
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }
    
    // Get average sentence length (in words)
    public static double getAverageSentenceLength(String text) {
        int sentences = countSentences(text);
        if (sentences == 0) {
            return 0;
        }
        int words = WordAnalyzer.countWords(text);
        return (double) words / sentences;
    }
    
    // Split text into sentences
    public static String[] getSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }
        return text.split("[.!?]+");
    }
}
