// DECRIPNION:
// Необходимо вывести все положительные степени числа 5 которые меньше 10000, вывести результат возведения в степень.
// SOLUTION:

package JAVA.HW4;

public class Task2 {

  public static void main(String[] args) {
    int number = 5;
    int res = 0;
    int i = 1;  
    while  (res < 10000) {
      res = (int)Math.pow(number, i);
      if (res < 10000) {
      System.out.print((int)Math.pow(number, i) + " ");
      }
      i++;
    }
  }
}