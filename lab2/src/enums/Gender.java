package enums;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromString(String value) {
        return Gender.valueOf(value.toUpperCase());
    }
}
