package HomeWork2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Введенное число: " + number);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float number;

        while (true) {
            System.out.print("Введите дробное число через запятую: ");
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                break;
            } else {
                System.out.println("Ошибка ввода. Пожалуйста, повторит ввод дробного числа через запятую.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return number;
    }
}
