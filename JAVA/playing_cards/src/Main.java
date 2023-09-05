import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Необходимая сумма
        int m = scanner.nextInt(); // Количество номиналов купюр

        List<Integer> denominations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            denominations.add(scanner.nextInt());
        }

        List<Integer> result = findRobberyCombination(n, denominations);

        if (result == null) {
            System.out.println(-1);
        } else {
            System.out.println(result.size());
            for (int denomination : result) {
                System.out.print(denomination + " ");
            }
        }
    }

    public static List<Integer> findRobberyCombination(int target, List<Integer> denominations) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = target + 1; // Инициализируем максимальным значением
        }

        for (int denomination : denominations) {
            for (int i = denomination; i <= target; i++) {
                dp[i] = Math.min(dp[i], dp[i - denomination] + 1);
            }
        }

        if (dp[target] == target + 1) {
            return null; // Нет комбинации для достижения цели
        }

        List<Integer> result = new ArrayList<>();
        int remaining = target;
        Map<Integer, Integer> countMap = new HashMap<>();

        while (remaining > 0) {
            boolean found = false;
            for (int denomination : denominations) {
                if (remaining >= denomination && dp[remaining] == dp[remaining - denomination] + 1 &&
                        (countMap.getOrDefault(denomination, 0) < 2)) {
                    result.add(denomination);
                    remaining -= denomination;
                    countMap.put(denomination, countMap.getOrDefault(denomination, 0) + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                return null; // Не удалось найти подходящий номинал без нарушения условия
            }
        }

        // Проверяем наличие 3 или более одинаковых чисел в результате
        for (int denomination : denominations) {
            if (Collections.frequency(result, denomination) >= 3) {
                return null; // В результате есть 3 или более одинаковых чисел
            }
        }

        return result;
    }
}
