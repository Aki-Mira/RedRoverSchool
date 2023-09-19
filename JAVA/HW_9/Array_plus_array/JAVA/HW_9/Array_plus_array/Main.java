package JAVA.HW_9.Array_plus_array;
import java.util.Arrays;
// DESCRIPTION:
// I'm new to coding and now I want to get the sum of two arrays... Actually the sum of all their elements. I'll appreciate for your help.

// P.S. Each array includes only integer numbers. Output is a number too.
// SOLUTION:
public class Main {
  public static int arrayPlusArray(int[] arr1, int[] arr2) {
    return Arrays.stream(arr1).sum() + Arrays.stream(arr2).sum();
   }
  public static void main(String[] args) {
    int[] arr1 = new int[] {1, 2, 3};
    int[] arr2 = new int[] {4, 5, 7};
    System.out.println(arrayPlusArray(arr1, arr2));
  }
}
