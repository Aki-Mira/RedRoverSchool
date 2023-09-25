package org.example;
import org.apache.commons.lang3.StringUtils;

public class AbbreviateExample {

    public static void main(String[] args) {
        String input = "Привет всем кто живет на луне!";

        // Сокращаем строку до 10 символов
        String result1 = StringUtils.abbreviate(input, 10);
        System.out.println(result1); // Выводит: Привет ...

        // Сокращаем строку до 20 символов
        String result2 = StringUtils.abbreviate(input, 20);
        System.out.println(result2); // Выводит: Привет всем кто ж...
    }
}

