//DESCRIPTION:
//        Задача №1
//
//        Необходимо создать класс Employee со следующими методами:
//        • getBaseSalary - получить базовую ставку
//        • setBaseSalary
//        • getName - получить имя
//        • setName
//        • getSalary - получить зарплату
//
//
//        Задача №2
//
//        Необходимо создать класс Worker где метод getSalary будет возвращать базовую ставку.
//
//        Необходимо создать класс Manager в который нужно добавить следующие методы:
//        • getNumberOfSubordinates - получить количество подчиненных
//        • setNumberOfSubordinates
//
//        в классе, метод getSalary будет возвращать значение по формуле - <базовая ставка> * (<количество подчиненных> / 100 * 3). Если количество подчиненных 0, то результат как у обычного рабочего.
//
//        Необходимо создать класс Director с теми же методами, что и Manager, но метод getSalary должен возвращать результат по формуле - <базовая ставка> * (<количество подчиненных> / 100 * 9). Если количество подчиненных 0, то результат как у обычного рабочего.
//
//
//        Задача №3
//
//        Необходимо создать утилитарный класс со следующими методами:
//        • поиск сотрудника в массиве по его имени
//        • поиск сотрудника в массиве по вхождению указанной строки в его имени
//        • подсчет зарплатного бюджета для всех сотрудников в массиве
//        • поиск наименьшей зарплаты в массиве
//        • поиск наибольшей зарплаты в массиве
//        • поиск наименьшего количества подчиненных в массиве менеджеров
//        • поиск наибольшего количества подчиненных в массиве менеджеров
//        • поиск наибольшей надбавки (разнице между базовой ставкой и зарплатой) в массиве менеджеров
//        • поиск наименьшей надбавки (разнице между базовой ставкой и зарплатой) в массиве менеджеров
//SOLUTION:
public class Main {
public static void main(String[] args) {
    Employee Vasya = new Employee();
    Vasya.setName("Vasilij");
    Vasya.setSalary(23);
    Vasya.setBaseSalary(10);
    Employee Anya = new Employee();
    Anya.setName("Anna");
    Anya.setSalary(65);
    Anya.setBaseSalary(48);
    Employee Nastya = new Employee();
    Nastya.setName("Anastasia");
    Nastya.setSalary(49);
    Nastya.setBaseSalary(5);
    Employee Lusya = new Employee();
    Lusya.setName("Ludmila");
    Lusya.setSalary(487);
    Lusya.setBaseSalary(55);
    System.out.println(Nastya.getSalary());
    System.out.println(Vasya.getBaseSalary());
    System.out.println(Lusya.getName());
    Manager NumberOfSubordinatesManager = new Manager();
    NumberOfSubordinatesManager.setNumberOfSubordinates(50);
    Woker Manager1 = new Woker();
    Manager1.BaseSalary = Anya.getBaseSalary();
    Manager1.NumberOfSubordinates = NumberOfSubordinatesManager.getNumberOfSubordinates();
    System.out.println(Manager1.getSalary());
    Director director = new Director();
    director.BaseSalary = Anya.getBaseSalary();
    director.NumberOfSubordinates = NumberOfSubordinatesManager.getNumberOfSubordinates();
    System.out.println(director.getSalary());
    }
}