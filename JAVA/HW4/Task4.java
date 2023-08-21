// DECRIPTION:
// Дан массив:
// int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
// необходимо вывести сумму всех значений массива.
// SOLUTION:

package JAVA.HW4;

import java.util.stream.IntStream;

public class Task4 {
  public static void main(String[] args) {
    int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
    System.out.println(IntStream.of(array).sum());
  }
}
