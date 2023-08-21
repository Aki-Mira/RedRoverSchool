// DECRIPTION:
// Дано положительное целое число n.

// создать ряд из n чисел так, чтобы:
// первые два элемента ряда равнялись 1
// любой другой элемент ряда был суммой двух предыдущих.
// Пример:
// 1, 1, 2, 3, 5, 8, …

// Вывести получившийся ряд на экран.
// SOLUTION:

package JAVA.HW4;

import java.util.ArrayList;

public class Task10 {
  public static void main(String[] args) {
    int n = 10;
    int num1 = 1;
    int num2 = 1;
    ArrayList<Integer> list = new ArrayList<>();
    list.add (num1);
    list.add (num2);
    //  System.out.println(list.toString());
    for (int i = 3; i <= n; i++) {
      int num3 = num1 + num2;
      list.add(num3);
      num1 = num2;
      num2 = num3;
    }
    System.out.println(list.toString());
  }
}
