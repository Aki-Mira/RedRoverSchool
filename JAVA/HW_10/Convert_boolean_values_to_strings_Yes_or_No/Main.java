package JAVA.HW_10.Convert_boolean_values_to_strings_Yes_or_No;
// DESCRIPTION:
// Complete the method that takes a boolean value and return a "Yes" string for true, or a "No" string for false.
// Solution:
public class Main {
  public static String boolToWord(boolean b)
  {
    if (b) {
      return "Yes";
    }
    else {
      return "No";
    }
  }
  public static void main(String[] args) {
    System.out.println(boolToWord(false));
  }
}
