import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = scanner.nextLong();

        long[] prices = new long[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();
        }

        // Сортируем цены в порядке увеличения
        Arrays.sort(prices);

        long maxPrice = 0;

        for (int i = 0; i < n; i++) {
            if (s >= prices[i]) {
                maxPrice = prices[i];
            } else {
                break;
            }
        }

        if (maxPrice > 0) {
            System.out.println(maxPrice);
        } else {
            System.out.println(0);
        }
    }
}