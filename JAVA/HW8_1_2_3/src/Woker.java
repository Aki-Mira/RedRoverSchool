public class Woker {
    double BaseSalary;
    double NumberOfSubordinates;

    public double getSalary() {
        if (NumberOfSubordinates > 0) {
            return BaseSalary * (NumberOfSubordinates / 100 * 3);
        } else {
            return BaseSalary;
        }
    }
}