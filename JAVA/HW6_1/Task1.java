package JAVA.HW6_1;
// DECRIPTION:
// Дан массив: 
// int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
// необходимо вывести сумму элементов массива.
// SOLUTION:
public class Task1 {
  public static void main(String[] args) {
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
            sum += array[i][j];
      }
    }
    System.out.println(sum);
  }
}
