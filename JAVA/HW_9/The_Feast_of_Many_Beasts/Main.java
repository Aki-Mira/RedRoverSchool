package JAVA.HW_9.The_Feast_of_Many_Beasts;
// DESCRIPTION:
// All of the animals are having a feast! Each animal is bringing one dish. There is just one rule: the dish must start and end with the same letters as the animal's name. For example, the great blue heron is bringing garlic naan and the chickadee is bringing chocolate cake.

import java.util.Scanner;

// Write a function feast that takes the animal's name and dish as arguments and returns true or false to indicate whether the beast is allowed to bring the dish to the feast.

// Assume that beast and dish are always lowercase strings, and that each has at least two letters. beast and dish may contain hyphens and spaces, but these will not appear at the beginning or end of the string. They will not contain numerals.

// SOLUTION:
public class Main {

  public static boolean feast(String beast, String dish) {
    String[] beast_letters = beast.split("");
    String[] dish_letters = dish.split("");
    return (beast_letters[0].equals(dish_letters[0]) && beast_letters[beast.length() - 1].equals(dish_letters[dish.length() - 1]));
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String beast = scanner.nextLine();
      String dish = scanner.nextLine();
      System.out.println(feast(beast, dish));
    }
}
}