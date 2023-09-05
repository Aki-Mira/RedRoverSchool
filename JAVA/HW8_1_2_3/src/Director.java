public class Director {
    double BaseSalary;
    double NumberOfSubordinates;

        public double getSalary() {
            if (NumberOfSubordinates > 0) {
                return BaseSalary * (NumberOfSubordinates / 100 * 9);
            } else {
                return BaseSalary;
            }
        }
    }

