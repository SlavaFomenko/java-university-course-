
class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password format or passwords do not match.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}