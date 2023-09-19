package JAVA.HW_10.Basic_Mathematical_Operations;
// DESCRIPTION:
// our task is to create a function that does four basic mathematical operations.

// The function should take three arguments - operation(string/char), value1(number), value2(number).
// The function should return result of numbers after applying the chosen operation.

// Examples(Operator, value1, value2) --> output
// ('+', 4, 7) --> 11
// ('-', 15, 18) --> -3
// ('*', 5, 5) --> 25
// ('/', 49, 7) --> 7
// SOLUTION:
public class Main {
  public static Integer basicMath(String op, int v1, int v2)
  {
    if (op.equals("+")) {
      return v1 + v2;
    }
    else if (op.equals("-")) {
      return v1 - v2;
    }
    else if (op.equals("*")) {
      return v1 * v2;
    }
    else {
      return v1 / v2;
    }
  }
  public static void main(String[] args) {
    String op = "+";
    int v1 = 4;
    int v2 = 7;
    System.out.println(basicMath(op, v1, v2));
  }
}
