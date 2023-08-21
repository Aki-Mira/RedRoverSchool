// DECRIPTION:
// Дан массив:
// int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
// необходимо вывести минимальное значение массива.
// SOLUTION:

package JAVA.HW4;

import java.util.Arrays;

public class Task6 {
   public static void main(String[] args) {
    int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
    Arrays.sort(array);
    System.out.println(array[0]);
  }
}
