import java.util.Collections;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        List<String> stringInput = List.of("каждый", "охотник", "желает");
        List<Integer> intInput = List.of(3, 0, -4, 2, 10);

        List<Object> result1 = Collections.singletonList(Flattener.flatten(stringInput));
        List<Object> result2 = Collections.singletonList(Flattener.flatten(intInput));

        System.out.println(result1);
        System.out.println(result2);
    }
}
