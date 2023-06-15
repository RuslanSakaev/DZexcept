package HomeWork3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserDataValidator {
    public UserData parseUserInput(String userInput) {
        String[] data = userInput.split(" ");

        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных. Ожидается 6 элементов.");
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        validateName(lastName, "Фамилия");
        validateName(firstName, "Имя");
        validateName(middleName, "Отчество");
        validateDateOfBirth(dateOfBirth);
        validatePhoneNumber(phoneNumber);
        validateGender(gender);

        return new UserData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
    }

    private void validateName(String name, String fieldName) {
        if (name.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Некорректное значение " + fieldName + ", не должно содержать чисел.");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate parsedDate = LocalDate.parse(dateOfBirth, formatter);
            LocalDate currentDate = LocalDate.now();

            int dayOfMonth = parsedDate.getDayOfMonth();
            int monthValue = parsedDate.getMonthValue();
            int year = parsedDate.getYear();

            int currentYear = currentDate.getYear();
            int currentMonthValue = currentDate.getMonthValue();
            int currentDayOfMonth = currentDate.getDayOfMonth();

            if (dayOfMonth < 1 || dayOfMonth > parsedDate.lengthOfMonth()) {
                throw new IllegalArgumentException("Некорректный день рождения");
            }

            if (monthValue < 1 || monthValue > 12) {
                throw new IllegalArgumentException("Некорректный месяц рождения");
            }

            if (year > currentYear || (year == currentYear && monthValue > currentMonthValue) ||
                    (year == currentYear && monthValue == currentMonthValue && dayOfMonth > currentDayOfMonth)) {
                throw new IllegalArgumentException("Дата рождения не может быть в будущем");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Некорректный формат даты рождения");
        }
    }
    //private void validateDateOfBirth(String dateOfBirth) {
    //    if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
    //        throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается дд.мм.гггг ");
    //    }
    //}

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое число без форматирования.");
        }
    }

    private void validateGender(String gender) {
        if (!gender.matches("[fm]")) {
            throw new IllegalArgumentException("Неверный формат пола. Ожидается символ латиницей f или m.");
        }
    }
}
