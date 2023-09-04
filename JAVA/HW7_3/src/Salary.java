import java.util.Arrays;
public class Salary {

    Employee [] employeeArray;
    public static int getSum(Employee[] employeeArray) {
        int [] employeeArraySalary = new int [employeeArray.length];
        for (int i = 0; i < employeeArray.length; i++ ) {
            employeeArraySalary[i] = employeeArray[i].salary;
        }
        int sum = Arrays.stream(employeeArraySalary).sum();
        return sum / employeeArraySalary.length;
    }
}
