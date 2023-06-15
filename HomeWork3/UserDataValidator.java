package HomeWork3;

public class UserDataValidator {
    public UserData validate(String userInput) {
        String[] userData = userInput.split(" ");

        if (userData.length != 4) {
            throw new IllegalArgumentException("Неверное количество данных!");
        }

        String fullName = userData[0];
        String dateOfBirth = userData[1];
        String phoneNumber = userData[2];
        String gender = userData[3];

        validateFullName(fullName);
        validateDateOfBirth(dateOfBirth);
        validatePhoneNumber(phoneNumber);
        validateGender(gender);

        return new UserData(fullName, dateOfBirth, phoneNumber, gender);
    }

    private void validateFullName(String fullName) {
        if (!fullName.matches("^[а-яА-ЯёЁa-zA-Z]+[а-яА-ЯёЁa-zA-Z]+[а-яА-ЯёЁa-zA-Z]+$")) {
            throw new IllegalArgumentException("Некорректное ФИО!");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) {
        if (!dateOfBirth.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            throw new IllegalArgumentException("Некорректная дата рождения!");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("Некорректный номер телефона!");
        }
    }

    private void validateGender(String gender) {
        if (!gender.matches("^[fm]$")) {
            throw new IllegalArgumentException("Некорректный пол!");
        }
    }
}
