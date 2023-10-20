import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Flattener {
    public static <T> List<T> flatten(List<T> inputList) {
        List<T> result = new ArrayList<>();

        for (T element : inputList) {
            if (element instanceof String) {
                result.addAll((Collection<? extends T>) flattenStrings((String) element));
            } else if (element instanceof Integer) {
                result.addAll((Collection<? extends T>) flattenInts((Integer) element));
            }
        }

        return result;
    }

    private static List<String> flattenStrings(String inputString) {
        List<String> result = new ArrayList<>();

        char[] charArray = inputString.toCharArray();
        for (char ch : charArray) {
            result.add(String.valueOf(ch));
        }

        return result;
    }

    private static List<Integer> flattenInts(Integer num) {
        List<Integer> result = new ArrayList<>();

        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                result.add(i);
            }
        } else if (num < 0) {
            for (int i = num; i <= -1; i++) {
                result.add(i);
            }
        }

        return result;
    }
}
