package JAVA.HW5;

import java.util.function.ObjDoubleConsumer;

// DECRIPTION:
// Дана строка: 
// String s = “Перестановочный алгоритм быстрого действия”;
// необходимо вывести все буквы “о” из этой строки.
// Для указанной строки ответ будет “ооооо” (или в столбик)
// SOLUTION:
public class Task1 {

public static void main(String[] args) {
  String s = "Перестановочный алгоритм быстрого действия";
  char symbol = 'о';
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) ==  symbol) {
            System.out.print(symbol);
        }
      }
      System.out.print("\n");
    }
  }