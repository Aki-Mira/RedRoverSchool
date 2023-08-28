package JAVA.HW6_2;
// DECRIPTION:
// 0  1  2  3  4  5  6  7  8  9
//    0  1  2  3  4  5  6  7  8
//       0  1  2  3  4  5  6  7
//          0  1  2  3  4  5  6
//             0  1  2  3  4  5
//                0  1  2  3  4
//                   0  1  2  3
//                      0  1  2
//                         0  1
//                            0
// SOLUTION:
public class Task2 {
  public static void main(String[] args) {
    for (int j = 9; j >= 0; j--) {
        for (int k = 0; k < 9 - j; k++) {
          System.out.print("  ");
        }
        for (int i = 0; i <= j; i++) {
          System.out.print(i + " ");
        }
      System.out.println("");
    }
  }
}
