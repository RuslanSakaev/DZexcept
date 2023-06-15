package HomeWork3;

import java.util.regex.Pattern;

public class UserDataValidator {

    public void validateFullName(String fullName, String fieldName) {
        String regex = "^[а-яА-ЯёЁa-zA-Z]+ [а-яА-ЯёЁa-zA-Z]+ [а-яА-ЯёЁa-zA-Z]+$";
        if (fullName == null || !Pattern.matches(regex, fullName.trim())) {
            throw new IllegalArgumentException(fieldName + " имеет неверный формат.");
        }
    }
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

        validateFullName(lastName, "Фамилия");
        validateFullName(firstName, "Имя");
        validateFullName(middleName, "Отчество");
        validateDateOfBirth(dateOfBirth);
        validatePhoneNumber(phoneNumber);
        validateGender(gender);

        return new UserData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
    }

    private void validateDateOfBirth(String dateOfBirth) {
        if (!dateOfBirth.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.mm.yyyy.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое число без форматирования.");
        }
    }

    private void validateGender(String gender) {
        if (!gender.matches("^[fm]$")) {
            throw new IllegalArgumentException("Неверный формат пола. Ожидается символ латиницей f или m.");
        }
    }
}
