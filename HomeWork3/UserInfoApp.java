/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом:
ФИО, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
что он ввел меньше или больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java или создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида:
<Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.

 */

package HomeWork3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInfoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные в произвольном порядке, разделенные пробелом (Фамилия Имя Отчество Дата_рождения Номер_телефона Пол): ");
        String userInput = scanner.nextLine();

        UserDataValidator validator = new UserDataValidator();

        try {
            UserData userData = validator.parseUserInput(userInput);
            System.out.println("Все данные корректны. Сохранение информации...");

            String fileName = userData.getLastName() + ".txt";
            saveUserDataToFile(userData, fileName);

            System.out.println("Данные сохранены в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void saveUserDataToFile(UserData userData, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String dataLine = userData.getLastName() + " " + userData.getFirstName() + " " + userData.getMiddleName() + " " +
                    userData.getDateOfBirth() + " " + userData.getPhoneNumber() + " " + userData.getGender();
            writer.write(dataLine + "\n");
        }
    }
}
