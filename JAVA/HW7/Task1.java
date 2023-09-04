package JAVA.HW7;
//Decription:
//Необходимо создать класс Person с полями: имя, возраст, пол. Класс должен иметь метод - getName, метод возвращает имя с префиксом “Mr. ” если пол указан как мужской и префикс “Mrs. ” если женский.
//Solution:
public class Task1 {
    public static void main(String[] args) {

        Person Vanya = new Person("Vanya", 34, "male");
        System.out.println(Vanya.getName());
        Person Polina = new Person("Polina", 33, "female");
        System.out.println(Polina.getName());
        Person Lucy = new Person("Lucy", 12, "dog");
        System.out.println(Lucy.getName());
    }
}
