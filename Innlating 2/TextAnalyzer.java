public class TextAnalyzer {
    private String text;
    private int wordCount;
    private int sentenceCount;
    private int longWordCount;
    private int paragraphCount;
    
    public TextAnalyzer(String text) {
        this.text = text;
    }
    
    // Main analysis method
    public void analyze() {
        wordCount = WordAnalyzer.countWords(text);
        sentenceCount = SentenceAnalyzer.countSentences(text);
        longWordCount = WordAnalyzer.countLongWords(text);
        paragraphCount = ParagraphAnalyzer.countParagraphs(text);
        
        displayResults();
    }
    
    // Calculate Lix score: A/B + 100*C/A
    // A = Number of words
    // B = Number of sentences
    // C = Number of long words (6+ letters)
    public double calculateLixScore() {
        if (wordCount == 0 || sentenceCount == 0) {
            return 0;
        }
        return (double) wordCount / sentenceCount + 100.0 * longWordCount / wordCount;
    }
    
    // Display all analysis results
    private void displayResults() {
        System.out.println("===== TEXT ANALYSIS RESULTS =====\n");
        
        System.out.println("--- WORD STATISTICS ---");
        System.out.println("Total Words: " + wordCount);
        System.out.println("Long Words (6+ letters): " + longWordCount);
        System.out.println("Average Word Length: " + String.format("%.2f", WordAnalyzer.getAverageWordLength(text)));
        
        System.out.println("\n--- SENTENCE STATISTICS ---");
        System.out.println("Total Sentences: " + sentenceCount);
        System.out.println("Average Sentence Length: " + String.format("%.2f", SentenceAnalyzer.getAverageSentenceLength(text)) + " words");
        
        System.out.println("\n--- PARAGRAPH STATISTICS ---");
        System.out.println("Total Paragraphs: " + paragraphCount);
        System.out.println("Average Paragraph Length: " + String.format("%.2f", ParagraphAnalyzer.getAverageParagraphLength(text)) + " words");
        System.out.println("Average Paragraph Sentences: " + String.format("%.2f", ParagraphAnalyzer.getAverageParagraphSentences(text)));
        
        System.out.println("\n--- READABILITY SCORE ---");
        System.out.println("Lix Score: " + String.format("%.2f", calculateLixScore()));
        System.out.println("\n================================\n");
    }
}
