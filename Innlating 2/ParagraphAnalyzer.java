public class ParagraphAnalyzer {
    
    // Count paragraphs (separated by empty lines)
    public static int countParagraphs(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] paragraphs = text.trim().split("\\n\\s*\\n");
        return paragraphs.length;
    }
    
    // Get paragraphs
    public static String[] getParagraphs(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }
        return text.trim().split("\\n\\s*\\n");
    }
    
    // Get average paragraph length (in words)
    public static double getAverageParagraphLength(String text) {
        int paragraphs = countParagraphs(text);
        if (paragraphs == 0) {
            return 0;
        }
        int words = WordAnalyzer.countWords(text);
        return (double) words / paragraphs;
    }
    
    // Get average paragraph length (in sentences)
    public static double getAverageParagraphSentences(String text) {
        int paragraphs = countParagraphs(text);
        if (paragraphs == 0) {
            return 0;
        }
        int sentences = SentenceAnalyzer.countSentences(text);
        return (double) sentences / paragraphs;
    }
}
