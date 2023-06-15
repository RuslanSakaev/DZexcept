package HomeWork1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {10, 20, 30, 40};
        int[] array2 = {2, 5, 0, 4};

        try {
            int[] result = divideArrays(array1, array2);
            System.out.println("Результат: " + Arrays.toString(result));
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int[] divideArrays(int[] array1, int[] array2) {
        // Реализация метода divideArrays
        return array1;
    }
}


/*
Cоздаем два целочисленных массива array1 и array2,
вызываем метод divideArrays и обрабатываем исключение RuntimeException, если длины массивов не равны.
Если длины массивов равны, результат деления выводится на экран.
 */