package JAVA.Encryption;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Задача ввести произвольный текст, а шифровальщик сдвинет символ на число (равное дню недели)
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("===========");
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите текст для шифровки");
       String text = sc.nextLine();
       char[] str = text.toCharArray();
       Calendar c = Calendar.getInstance();
       int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
       for (int i = 0; i < str.length; i++)  {
        str[i] += dayOfWeek;
       }
       System.out.println("===========");
       System.out.println(str);
  }
}