package HomeWork1;/*
Реализуйте метод, принимающий в качестве аргументов два
целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны,необходимо как-то оповестить пользователя.
Важно:При выполнении метода единственное исключение,
которое пользователь может увидеть-RuntimeException,т.е.ваше
 */

import java.util.Arrays;

public class ArrayDivider {
    public static void main(String[] args) {
        int[] array1 = {34, 673, 799};
        int[] array2 = {2745, 464, 45, 52};

        try {
            int[] result = divideArrays(array1, array2);
            System.out.println("Результат: " + Arrays.toString(result));
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int[] divideArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new RuntimeException("Один или оба массива являются null");
        }

        int length1 = array1.length;
        int length2 = array2.length;

        if (length1 != length2) {
            throw new RuntimeException("Длины массивов не равны");
        }

        int[] result = new int[length1];
        for (int i = 0; i < length1; i++) {
            if (array2[i] == 0) {
                throw new RuntimeException("Деление на ноль не поддерживается");
            }
            result[i] = array1[i] / array2[i];
        }

        return result;
    }
}
/*
    Метод divideArrays передает два целочисленных массива array1 и array2.
    Если хотя бы один из них равен null, будет выброшено исключение RuntimeException.
    Если длины массивов не равны, также будет выброшено исключение RuntimeException.
    В случае деления на ноль во время вычисления элементов результирующего массива также будет выброшено исключение RuntimeException.
    Исключение RuntimeException является непроверяемым исключением.
*/