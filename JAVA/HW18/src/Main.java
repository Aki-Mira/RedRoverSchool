import java.util.Collections;
import java.util.List;

public class Main {
    private static <T extends Comparable<T>> T findExtreme(List<T> list, boolean findMin) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        if (findMin) {
            return Collections.min(list);
        } else {
            return Collections.max(list);
        }
    }

    public static <T extends Comparable<T>> T findMin(List<T> list) {
        return findExtreme(list, true);
    }

    public static <T extends Comparable<T>> T findMax(List<T> list) {
        return findExtreme(list, false);
    }

    public static void main(String[] args) {
        // Примеры использования
        List<Integer> integers = List.of(1, 2, 4, 0, -49);
        System.out.println("Min: " + findMin(integers));
        System.out.println("Max: " + findMax(integers));

        List<String> strings = List.of("Иван", "родил", "девчонку", "велел", "тащить", "пеленку");
        System.out.println("Min: " + findMin(strings));
        System.out.println("Max: " + findMax(strings));

        List<Double> doubles = List.of(12.0, -14.2, 90990.3224);
        System.out.println("Min: " + findMin(doubles));
        System.out.println("Max: " + findMax(doubles));

        List<java.time.DayOfWeek> daysOfWeek = List.of(java.time.DayOfWeek.MONDAY, java.time.DayOfWeek.WEDNESDAY, java.time.DayOfWeek.TUESDAY);
        System.out.println("Min: " + findMin(daysOfWeek));
        System.out.println("Max: " + findMax(daysOfWeek));

        List<String> yokozunaList = List.of("Hakuho", "Asashoryu", "Kakuryu");
        System.out.println("Min: " + findMin(yokozunaList));
        System.out.println("Max: " + findMax(yokozunaList));
    }
}
