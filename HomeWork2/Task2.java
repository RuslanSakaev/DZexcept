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

public class Task2 {
    public static void main(String[] args) {
        int[] intArray = {3534, 44, 689, 9065, -3636, -334, 34, 7};
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        int index = 0;
        double d = 0;
        double res = 0;

        while (!validInput) {
            try {
                System.out.print("Введите индекс массива: ");
                index = scanner.nextInt();
                System.out.print("Введите значение переменной d: ");
                d = scanner.nextDouble();

                res = intArray[index] / d;
                validInput = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Индекс выходит за пределы массива. Попробуйте снова.");
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль. Попробуйте снова.");
            } catch (Exception e) {
                System.out.println("Неверный ввод. Попробуйте снова.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        System.out.println("res = " + res);
    }
}
