package JAVA.HW6_3;
// DECRIPTION:
// If you can't sleep, just count sheep!!

// Task:
// Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...". Input will always be valid, i.e. no negative integers.
// SOLUTION:
public class Task2_5 {
  public static String countingSheep(int num) {
    String s = new String();
    for (int i = 0; i < num; i++) {
      s = s + Integer.toString(i + 1) + " sheep...";
    }
    return s;
  }
  public static void main(String[] args) {
    
  }
}
