// Discription:
// Необходимо создать класс Salary с единственным методом - getSum(Employee[] employeeArray), метод должен возвращать сумму зарплат всех сотрудников из массива переданного в качестве аргумента вызова метода.
// Solution:
public class Main {
    public static void main(String[] args) {
        Employee Vanya = new Employee("Polina", 34, "male", 21);
        Employee Polina = new Employee("Polina", 33, "female", 43);
        Employee Lucy = new Employee("Lucy", 12, "dog", 100);
        Employee [] employee = new Employee [] {Vanya, Polina, Lucy};
        System.out.println(Salary.getSum(employee));
    }
}