package HomeWork3;

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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не может быть пустым.");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) {
        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.mm.yyyy.");
        }
    }

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
