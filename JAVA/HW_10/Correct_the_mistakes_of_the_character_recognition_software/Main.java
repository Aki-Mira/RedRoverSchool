package JAVA.HW_10.Correct_the_mistakes_of_the_character_recognition_software;
// DESCRIPTION:
// Character recognition software is widely used to digitise printed texts. Thus the texts can be edited, searched and stored on a computer.

import java.util.Scanner;

// When documents (especially pretty old ones written with a typewriter), are digitised character recognition softwares often make mistakes.

// Your task is correct the errors in the digitised text. You only have to handle the following mistakes:

// S is misinterpreted as 5
// O is misinterpreted as 0
// I is misinterpreted as 1
// The test cases contain numbers only by mistake.
// SOLUTION:
public class Main {
  public static String correct(String string) {
    string = string.replace("5", "S");
    string = string.replace("0", "O");
    string = string.replace("1", "I");
    return string;
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner (System.in)) {
      String string = scanner.nextLine();
      System.out.println(correct(string));
    }
  }
}
