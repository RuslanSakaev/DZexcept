public class Main {
    public static void main(String[] args) {
        //int[] array1 = {5, 2, 7, 6};
        int[] array1 = {5, 2, 7};
        int[] array2 = {4, 5, 6};

        try {
            double[] result = ArrayDivider.divideArrays(array1, array2);
            for (double value : result) {
                System.out.println(value);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
Cоздаем два целочисленных массива array1 и array2,
вызываем метод divideArrays и обрабатываем исключение RuntimeException, если длины массивов не равны.
Если длины массивов равны, результат деления выводится на экран.
 */