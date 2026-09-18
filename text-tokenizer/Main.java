import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static String tokenizeText(String text, String delimiter) {
        // 1. Wenn text null ist
        if (text == null) {
            return "Invalid text";
        }

        // 2. Wenn delimiter null ist, Leerzeichen benutzen
        if (delimiter == null) {
            delimiter = " ";
        }

        // 3. StringTokenizer erstellen
        StringTokenizer st = new StringTokenizer(text, delimiter);

        // 4. Anzahl speichern, bevor nextToken() benutzt wird
        int count = st.countTokens();

        // 5. Ergebnis-String aufbauen
        String result = "Token count: " + count;

        // 6. Alle Tokens anhängen
        while (st.hasMoreTokens()) {
            result += "\nToken: " + st.nextToken();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String delimiter = scanner.nextLine();

        if (text.equals("null")) text = null;
        if (delimiter.equals("null")) delimiter = null;

        System.out.println(tokenizeText(text, delimiter));

        scanner.close();
    }
}
