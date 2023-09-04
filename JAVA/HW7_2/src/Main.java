//DESCRIPTION:
//Необходимо создать класс Employee с полями как у Person (из предыдущего задания) и поле зарплата. Класс должен иметь метод isSameName(Employee employee) который возвращает true, если у сотрудника у которого был вызван метод и сотрудника который был передан как параметр, одинаковое имя.
//SOLUTION:
public class Main {
    public static void main(String[] args) {
        Employee Vanya = new Employee("Polina", 34, "male", 21);
        Employee Polina = new Employee("Polina", 33, "female", 43);
        Employee Lucy = new Employee("Lucy", 12, "dog", 65);
        System.out.println(Vanya.isSameName(Polina));
    }
}