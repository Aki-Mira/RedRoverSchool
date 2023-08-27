package JAVA.HW5;
// DECRIPTION:
// Дана строка:
// String s = “Перевыборы выбранного президента”;
// необходимо подсчитать количество букв “е” в строке.
// Для указанной строки ответ будет 4.
// SOLUTION:
public class Task2 {
  public static void main(String[] args) {
    String s = "Перевыборы выбранного президента";
    char symbol = 'е';
    int count = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) ==  symbol) {
            count++;
        }
      }
      System.out.print(count + "\n");
  }
}
