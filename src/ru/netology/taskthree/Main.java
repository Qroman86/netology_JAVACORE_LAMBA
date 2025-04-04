package ru.netology.taskthree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем список и добавляем числа
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(16);
        numbers.add(-1);
        numbers.add(-2);
        numbers.add(0);
        numbers.add(32);
        numbers.add(3);
        numbers.add(5);
        numbers.add(8);
        numbers.add(23);
        numbers.add(4);

        // 1. Фильтруем положительные числа
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // 2. Оставляем только четные
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer num : positiveNumbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        // 3. Сортируем по возрастанию
        Collections.sort(evenNumbers);

        // 4. Выводим результат
        System.out.println(evenNumbers); // [2, 4, 8, 16, 32]

    }
}
