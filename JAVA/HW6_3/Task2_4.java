package JAVA.HW6_3;
// DECRIPTION:
// Given an array of integers your solution should find the smallest integer.

import java.util.Arrays;

// For example:

// Given [34, 15, 88, 2] your solution will return 2
// Given [34, -345, -1, 100] your solution will return -345
// You can assume, for the purpose of this kata, that the supplied array will not be empty.
// SOLUTION:
public class Task2_4 {
  public static int findSmallestInt(int[] args) {
      Arrays.sort(args);
      return args[0];
    }
  public static void main(String[] args) {
    
  }
}
