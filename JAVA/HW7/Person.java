package JAVA.HW7;

public class Person {
    String name;
    int age;
    String sex;
    public Person (String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public String getName () {
        if ( sex.equals("female") ) {
            return "Mrs." + name;
        }
        else if ( sex.equals("male") ) {
            return "Mr." + name;
        }
        else {
            return name;
        }
    }
}
