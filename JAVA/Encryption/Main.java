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
    System.out.println("Введите текст для шифровки:");
       String text = sc.nextLine();
       char[] str = text.toCharArray();
       Calendar c = Calendar.getInstance();
       int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
       for (int i = 0; i < str.length; i++)  {
        str[i] += dayOfWeek;
       }
       System.out.println("===========");
       System.out.println("Ваш шифр:");
       System.out.println(str);
       System.out.println("===========");
    System.out.println("Введите текст для дешифровки:");
    System.out.println("(скопируйте и вставьте шифр)");
       String text1 = sc.nextLine();
       char[] str1 = text1.toCharArray();
       for (int i = 0; i < str1.length; i++)  {
        str1[i] -= dayOfWeek;
       }
       System.out.println("===========");
       System.out.println("Ваше сообщение:");
       System.out.println(str1);
  }
}