package JAVA.HW_9.Find_the_position;

import java.util.Scanner;

public class Main {
  public static String position(char alphabet)
  {
    String alphabet_string = "abcdefghijklmnopqrstuvwxyz";
    return "Position of alphabet: " + (alphabet_string.indexOf(alphabet) + 1);
    
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      char alphabet = scanner.nextLine().charAt(0);
      System.out.println(position(alphabet));
    }
  }
}
