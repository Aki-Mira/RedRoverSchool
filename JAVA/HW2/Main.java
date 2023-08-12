package JAVA.HW2;
import java.util.Scanner;
 /*Задача №1
Необходимо создать целочисленные переменные a и b, присвоить произвольные значения переменным на ваш выбор и вывести результаты следующих операций с этими переменными: сложение, умножение, вычитание, деление и остаток от деления. Также сделать проверку на четность этих переменных и вывести результат.
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите число a:");
    int a = sc.nextInt();
    System.out.println("Введите число b:");
    int b = sc.nextInt();
    if (a % 2 ==0) {
    System.out.println ("a - четное число");
    }
    else {
    System.out.println ("a - нечетное число");
    }
    if (b % 2 ==0) {
    System.out.println ("b - четное число");
    }
    else {
    System.out.println ("b - нечетное число");
    }
    System.out.printf("a + b = %d\n", a + b);
    System.out.printf("a - b = %d\n", a - b);
    System.out.printf("a * b = %d\n", a * b);
    System.out.printf("a / b = %d\n", a / b);
    System.out.printf("Остаток от деления a на b равен %d\n", a % b);
}
}