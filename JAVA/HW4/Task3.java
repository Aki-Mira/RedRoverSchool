// DECRIPTION:
// Необходимо вывести все числа кратные 4 между числами 40 и 60 включительно.
// Реализовать 2 варианта: 
// использовать конструкцию if для определения кратности (цикл с шагом 1, i = i + 1);
// без использования конструкции if (шаг цикла на ваше усмотрение).
// SOLUTION:

package JAVA.HW4;

public class Task3 {
  public static void main(String[] args) {
    int number = 40; 
    while (number <= 60) {
      if (number % 4 == 0) {
        System.out.print(number + " ");
      }
      number++;
   }
  }
}


