// DECRIPTION:
// Дан массив:
// int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
// необходимо вывести среднее арифметическое всех значений массива.
// SOLUTION:

package JAVA.HW4;

import java.util.stream.IntStream;

public class Task7 {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(IntStream.of(array).sum()/array.length);
  }
}
