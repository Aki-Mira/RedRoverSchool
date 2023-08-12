package JAVA.HW2;

import java.util.Scanner;

/*Задача №2
Создать программу дележа добычи на пиратском корабле. По обычаю, половина добычи идет владельцу корабля, половина оставшегося — капитану, остальное делится поровну между всеми членами команды, включая капитана.

Размер добычи (например, в пиастрах) и количество пиратов на корабле задать переменными.

Вывести на экран кому сколько пиастров полагается.
Дополнительное задание со звездочкой
Попробовать придумать как программа может проверить правильность дележа.
 */
public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите колличество награбленного:");
    double gold = sc.nextDouble();
    System.out.println("Введите колличество членов экипажа не включая капитана и владельца корабля:");
    int people = sc.nextInt();
    double boss = gold / 2;
    double captain = boss / 2;
    double team = captain / (people + 1);
    System.out.printf("Владелец корабля получает %.2f\n", boss);
    System.out.printf("Капитан корабля получает %.2f\n", captain);
    System.out.printf("Каждый член команды получает %.2f\n", team);
    System.out.printf("Итого награбили %.2f, теперь складываем долю владельца %.2f, долю капитана %.2f, долю команды %.2f, получаем: %.2f\n", gold, boss, captain, (people + 1) * team, boss + captain + ((people + 1) * team));
  }
}
