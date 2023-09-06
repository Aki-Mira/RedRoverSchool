//DESCRIPTION:
//        In this Kata we are passing a number (n) into a function.
//
//        Your code will determine if the number passed is even (or not).
//
//        The function needs to return either a true or false.
//
//        Numbers may be positive or negative, integers or floats.
//
//        Floats with decimal part non equal to zero are considered UNeven for this kata.
//SOLUTION:
public class Main {

    public static void main(String[] args) {
        double number = 0.4;
        System.out.println(isEven(number));
    }
    public static boolean isEven(double n) {
        if ( n % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}