public class Employee {
    String name;
    int age;
    String sex;
    int salary;

    public Employee(String name, int age, String sex, int salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public boolean isSameName(Employee employee) {
        if (employee.name.equals(this.name)) {
            return true;
        } else  {
            return false;
        }
    }
}
