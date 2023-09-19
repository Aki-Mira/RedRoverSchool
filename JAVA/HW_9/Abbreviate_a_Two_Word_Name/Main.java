package JAVA.HW_9.Abbreviate_a_Two_Word_Name;
// DESCRIPTION:
// Write a function to convert a name into initials. This kata strictly takes two words with one space in between them.

import java.util.Scanner;

// The output should be two capital letters with a dot separating them.

// It should look like this:

// Sam Harris => S.H

// patrick feeney => P.F
// SOLUTION:
public class Main {

  public static String abbrevName(String name) {
    name = name.toUpperCase();
    String[] words = name.split(" ");
    char[] nameFirst = words[0].toCharArray();
    char[] nameLast = words[1].toCharArray();
    
    return nameFirst[0] + "." + nameLast[0];
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String s = scanner.nextLine();
      System.out.println(abbrevName(s));
    }
  }
}
