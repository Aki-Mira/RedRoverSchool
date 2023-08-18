package JAVA.HW3.L4;

import java.util.Scanner;


public class Engineering {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Sould it move? y/n");
    String answer = sc.nextLine();
    // System.out.println(answer);
    System.out.println("Do it move? y/n");
    String answer2 = sc.nextLine();
    // System.out.println(answer2);
    // System.out.println(answer == answer2);
    if (answer.equalsIgnoreCase(answer2)) {
      System.out.println("No problem");
    }
    else if (answer.equalsIgnoreCase("n")) {
      System.out.println("Use duck tape");
    }
    else {
      System.out.println("Use WD-40");
    }
    
  }
}
