package JAVA.HW6_2;
// DECRIPTION:
// 9 8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 7 8 9
//   8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 7 8
//     7 6 5 4 3 2 1 0 1 2 3 4 5 6 7
//       6 5 4 3 2 1 0 1 2 3 4 5 6
//         5 4 3 2 1 0 1 2 3 4 5
//           4 3 2 1 0 1 2 3 4
//             3 2 1 0 1 2 3
//               2 1 0 1 2
//                 1 0 1
//                   0
// SOLUTION:
public class Task3 {
  public static void main(String[] args) {
    for (int j = 9; j >= 0; j--) {
      for (int o = 0; o < 9 - j; o++) {
        System.out.print("  ");
      }
      for (int k = 0; k < j; k++) {
        System.out.print((j - k) + " ");
      }
      for (int i = 0; i <= j; i++) {
        System.out.print(i + " ");
      }
    System.out.println("");
  }
  }
}
