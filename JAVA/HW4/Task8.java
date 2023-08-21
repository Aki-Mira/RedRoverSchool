// DECRIPTION:
// Дан массив произвольных целых чисел.

// необходимо подсчитать количество положительных и отрицательных чисел в этом массиве.
// SOLUTION:

package JAVA.HW4;

public class Task8 {
  public static void main(String[] args) {
    int [] array = {1, -1, -2, -2, 3, -3, 0};
    int sumpositive = 0;
    int sumnegative = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > 0) {
        sumpositive += array[i];
        // System.out.println(sumpositive);
      }
      else {
        sumnegative += array[i];
        // System.out.println(sumnegative);
      }
    }
    System.out.println("Сумма положительных чисел массива = " + sumpositive + " Сумма отрицательных чисел массива = " + sumnegative);
  }
}
