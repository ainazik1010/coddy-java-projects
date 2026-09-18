import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] sentences = text.split("\\.");
        String[][] textArray = new String[sentences.length][];
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < sentences.length; i++) {
            textArray[i] = sentences[i].trim().split(" ");
        }

        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < textArray[i].length; j++) {
               /* System.out.println("Original" + "[" + i + "," + j + "]: " + textArray[i][j]);

                System.out.println("Processed[" + i + "," + j + "]: " + processed);*/
String processed = textArray[i][j].replaceAll("[^a-zA-Z ]", "").toLowerCase();
                if (!processed.isEmpty()) {
                    wordCount.put(processed, wordCount.getOrDefault(processed, 0) + 1);
                }
            }
        }

        System.out.println("Word counts:");
        for (String key : wordCount.keySet()) {
            System.out.println(key + ": " + wordCount.get(key));
        }
    }
}
