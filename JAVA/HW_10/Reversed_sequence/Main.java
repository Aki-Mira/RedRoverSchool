package JAVA.HW_10.Reversed_sequence;
// DESCRIPTION:
// Build a function that returns an array of integers from n to 1 where n>0.

import java.util.Arrays;
import java.util.Scanner;

// Example : n=5 --> [5,4,3,2,1]
// SOLUTION:
  
public class Main {
  public static int[] reverse(int n){
    int[] array = new int[n];
    for (int i = n; i >= 1; i--) {
      array[n-i] = i;
    }
    return array;
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner (System.in)) {
      int a = scanner.nextInt();
      System.out.println(Arrays.toString(reverse(a)));
    }
  }
}
