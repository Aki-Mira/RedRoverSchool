package JAVA.HW_10.Convert_a_string_to_an_array;
// DESCRIPTION:
// Write a function to split a string and convert it into an array of words.

import java.util.Arrays;
import java.util.Scanner;

// Examples (Input ==> Output):
// "Robin Singh" ==> ["Robin", "Singh"]

// "I love arrays they are my favorite" ==> ["I", "love", "arrays", "they", "are", "my", "favorite"]
// SOLUTION:
public class Main {
  public static String[] stringToArray(String s) {
    return s.split(" ");
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String string = scanner.nextLine();
      System.out.println(Arrays.toString(stringToArray(string)));
    }
    }
}
