package HomeWork2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Введите строку: ");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    throw new Exception("Пустые строки вводить нельзя!");
                }

                // Если пользователь ввел непустую строку, делаем необходимые действия
                System.out.println("Вы ввели: " + input);
                break; // Выходим из цикла, если ввод корректен
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
