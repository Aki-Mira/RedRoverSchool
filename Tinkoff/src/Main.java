import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong(); // Считываем количество людей на кофе-брейке

        long divisor = 0;

        // Находим наибольший делитель меньше N
        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                divisor = Math.max(divisor, i);
                divisor = Math.max(divisor, N / i);
            }
        }

        // Минимальное число разрезов равно найденному делителю минус 1
        long minimumCuts = divisor - 1;

        System.out.println(minimumCuts);
    }
}