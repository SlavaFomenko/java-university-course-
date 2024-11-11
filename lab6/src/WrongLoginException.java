class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login format.");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}