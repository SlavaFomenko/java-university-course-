package enums;

public enum Location {
    KIEV, ZHYTOMYR, VINNYTSYA, RIVNE;

    // Перейменований метод для перетворення рядка в Location
    public static Location fromString(String value) {
        return Location.valueOf(value.toUpperCase());
    }
}
