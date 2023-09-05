import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

public class Search {
    public static Employee findEmployeeByName(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public static List<Employee> findEmployeesBySubstring(List<Employee> employees, String substring) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().contains(substring)) {
                result.add(employee);
            }
        }
        return result;
    }
    public static double calculateTotalBudget(List<Employee> employees) {
        double totalBudget = 0;
        for (Employee employee : employees) {
            totalBudget += employee.getSalary();
        }
        return totalBudget;
    }
    public static double findMinimumSalary(List<Employee> employees) {
        double minSalary = MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }
    public static double findMaximumSalary(List<Employee> employees) {
        double maxSalary = MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }
    public static int findMinimumSubordinates(List<Manager> managers) {
        int minSubordinates = Integer.MAX_VALUE;
        for (Manager manager : managers) {
            if (manager.getNumberOfSubordinates() < minSubordinates) {
                minSubordinates = manager.getNumberOfSubordinates();
            }
        }
        return minSubordinates;
    }
    public static int findMaximumSubordinates(List<Manager> managers) {
        int maxSubordinates = Integer.MIN_VALUE;
        for (Manager manager : managers) {
            if (manager.getNumberOfSubordinates() > maxSubordinates) {
                maxSubordinates = manager.getNumberOfSubordinates();
            }
        }
        return maxSubordinates;
    }
    public static double findMaximumAllowance(List<Employee> employees) {
        double maxAllowance = MIN_VALUE;
        for (Employee employee : employees) {
            double allowance = employee.getSalary() - employee.getBaseSalary();
            if (allowance > maxAllowance) {
                maxAllowance = allowance;
            }
        }
        return maxAllowance;
    }

    public static double findMinimumAllowance(List<Employee> employees) {
        double minAllowance = MAX_VALUE;
        for (Employee employee : employees) {
            double allowance = employee.getSalary() - employee.getBaseSalary();
            if (allowance < minAllowance) {
                minAllowance = allowance;
            }
        }
        return minAllowance;
    }
}