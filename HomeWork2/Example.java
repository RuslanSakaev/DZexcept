package HomeWork2;

// Задание 2
// Исходный код:
/*
        try{
                int d=0;
                double catchedRes1=intArray[8]/d;
                System.out.println("catchedRes1 = "+catchedRes1);
                }catch(ArithmeticException e){
                System.out.println("Catching exception: "+e);
                }
 */
// Исправленный код:
/*
try {
    int d = 0;
    double catchedRes = 0;

    try {
        catchedRes = intArray[7] / d;
    } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
    }

    System.out.println("catchedRes = " + catchedRes1);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index out of bounds: " + e);
}
В исправленном коде добил try-catch, чтобы перехватить ArithmeticException, возникающее при делении на ноль.
А так же ArrayIndexOutOfBoundsException, которое возникает, когда индекс (8) выходит за пределы массива intArray (7).
Это позволяет обработать оба исключения и вывести соответствующие сообщения.

Что бы код корректно работа необходимо поменят значение d отличное от 0,
а значение индекса массива указат в промежутке от 0 до 6.
 */
// Пример реализации код с испавлениями:
/*
public class Example {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};

        try {
            int d = 1;
            double catchedRes = 0;

            try {
                catchedRes = intArray[3] / d;
            } catch (ArithmeticException e) {
                System.out.println("Поймано исключение: " + e);
            }

            System.out.println("catchedRes = " + catchedRes);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индес масива выходит за границы массива: " + e);
        }
    }
}
 */
// Но можно доработат код и выводить соответвующее сообщение о неверном вводе до тех пор,
// пока не будут ввдены валидные значения.

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};

        Scanner scanner = new Scanner(System.in);
        int index;
        int d;
        double res = 0;

        do {
            try {
                System.out.print("Введите индекс массива: ");
                index = scanner.nextInt();

                System.out.print("Введите значение d: ");
                d = scanner.nextInt();

                res = intArray[index] / d;

                System.out.println("res = " + res);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Значение индекса выходит за пределы массива. Пожалуйста, попробуйте снова.");
                scanner.nextLine(); // Очистка буфера ввода
            } catch (ArithmeticException e) {
                System.out.println("Невозможно разделить на ноль. Пожалуйста, попробуйте снова.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        } while (res == 0);

        scanner.close();
    }
}

