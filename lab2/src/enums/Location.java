package enums;

public enum Location {
    KIEV, ZHYTOMYR, VINNYTSYA, RIVNE;

    public static Location fromString(String value) {
        return Location.valueOf(value.toUpperCase());
    }
}
