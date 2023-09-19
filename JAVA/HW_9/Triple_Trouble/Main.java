package JAVA.HW_9.Triple_Trouble;
// DESCRIPTION:
// Create a function that will return a string that combines all of the letters of the three inputed strings in groups. Taking the first letter of all of the inputs and grouping them next to each other. Do this for every letter, see example below!

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// E.g. Input: "aa", "bb" , "cc" => Output: "abcabc"

// Note: You can expect all of the inputs to be the same length.

// SOLUTION:
public class Main {
  public static String tripleTrouble(String one, String two, String three) {
    String[] one_letters = one.split("");
    String[] two_letters = two.split("");
    String[] three_letters = three.split("");
    List<String> stringList = new ArrayList<>();
    for (int i = 0; i < one.length(); i++) {
      stringList.add(one_letters[i]);
      stringList.add(two_letters[i]);
      stringList.add(three_letters[i]);
    }
    return String.join("", stringList); 
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner (System.in)) {
      String one = scanner.nextLine();
      String two = scanner.nextLine();
      String three = scanner.nextLine();
      System.out.println(tripleTrouble(one, two, three));
    }
  }
}
