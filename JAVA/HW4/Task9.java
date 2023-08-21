// DECRIPTION:
// Дан массив произвольных целых чисел.

// проверить, отсортирован ли он, т.е. все ли числа в массиве стоят так, что каждое следующее число больше предыдущего.
// SOLUTION:

package JAVA.HW4;

import java.util.Arrays;

public class Task9 {
  public static void main(String[] args) {
    int [] Array = {2, 15, 9};
    // Arrays.sort(Array);
    int res = 0;
    for (int i = 0; i < Array.length - 1; i++) {
      if (Array[i] <= Array[i+1]) {
        res++;
        // System.out.println(res);
      }
      else {
        System.out.println("Массив не отсортирован");
        break;
      }
    }
    if (res == Array.length - 1) {
      System.out.println("Массив отсортирован");
    }
    }
    }  
  
