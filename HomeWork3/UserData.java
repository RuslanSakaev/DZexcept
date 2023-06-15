package HomeWork3;

public class UserData {
    private final String fullName;
    private final String dateOfBirth;
    private final String phoneNumber;
    private final String gender;

    public UserData(String fullName, String dateOfBirth, String phoneNumber, String gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        // Assuming the last name is at the beginning of the full name
        String[] nameParts = fullName.split(" ");
        return nameParts[0];
    }
}
