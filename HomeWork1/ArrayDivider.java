package HomeWork1;/*
Реализуйте метод, принимающий в качестве аргументов два
целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны,необходимо как-то оповестить пользователя.
Важно:При выполнении метода единственное исключение,
которое пользователь может увидеть-RuntimeException,т.е.ваше
 */

public class ArrayDivider {
    public static double[] divideArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }

        double[] result = new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = (double) array1[i] / array2[i];
        }

        return result;
    }
}