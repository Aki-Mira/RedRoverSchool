package JAVA.HW6_3;
// DECRIPTION:
// Необходимо написать 4 метода:
//     • сложение 2х чисел
//     • вычитание 2х чисел
//     • умножение 2х чисел
//     • деление 2х чисел
// SOLUTION:
public class Task1 {
  public static int sum (int a, int b) {
    int sum = a + b;
    return sum;
  }
  public static int sub  (int a, int b) {
    int sub = a - b;
    return sub;
  }
  public static int mult (int a, int b) {
    int mult = a * b;
    return mult;
  }
  public static double div (double a, double b) {
    double div = a / b;
    return div;
  }
  public static void main(String[] args) {
    int a = 5;
    int b = 7;
    System.out.println(sum(a, b));
    System.out.println(sub(a, b));
    System.out.println(mult(a, b));
    System.out.println(div(a, b));
}
}
