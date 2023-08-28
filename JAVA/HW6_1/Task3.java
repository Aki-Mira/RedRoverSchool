package JAVA.HW6_1;

import java.util.Arrays;

// DECRIPTION:
// Дан массив: 
// int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
// необходимо вывести минимальное значение массива.
// SOLUTION:
public class Task3 {
  public static void main(String[] args) {
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
    int [] arr = new int [array.length];
    for (int i = 0; i < array.length; i++) {
      Arrays.sort(array[i]);
      arr[i] = array[i][0];
    }
    Arrays.sort(arr);
    System.out.println(arr[0]);
  }
}
