package enums;

public enum Gender {
    MALE, FEMALE;

    // Метод для перетворення рядка в Gender
    public static Gender fromString(String value) {
        return Gender.valueOf(value.toUpperCase());
    }
}
