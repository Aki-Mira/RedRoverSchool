import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // Считываем количество каждой буквы в строке s
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Слово "sheriff"
        String target = "sheriff";

        // Считываем количество каждой буквы в слове "sheriff"
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int maxWords = Integer.MAX_VALUE;

        // Находим минимальное количество букв, которое ограничивает создание слова "sheriff"
        for (char c : target.toCharArray()) {
            int required = targetCount[c - 'a'];
            int available = charCount[c - 'a'];
            maxWords = Math.min(maxWords, available / required);
        }

        System.out.println(maxWords);
    }
}