//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class ErrorProcessing {

    // Метод, выбрасывающий ArithmeticException
    public static void method1() {
        int x = 10;
        int y = 0;
        int result = x / y; // Попытка деления на ноль
    }

    // Метод, выбрасывающий NullPointerException
    public static void method2() {
        String str = null;
        int length = str.length(); // Попытка вызова метода на нулевой ссылке
    }

    // Метод, выбрасывающий ArrayIndexOutOfBoundsException
    public static void method3() {
        int[] arr = new int[5];
        int element = arr[10]; // Попытка доступа к элементу массива по недопустимому индексу
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: " + e);
        }

        try {
            method2();
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: " + e);
        }

        try {
            method3();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }



}

