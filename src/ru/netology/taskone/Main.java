package ru.netology.taskone;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        // Деление на ноль невозможно
        // Перепишем операцию деления на ноль, чтобы при попытке разделить на ноль она возвращала ноль
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);
    }
}
