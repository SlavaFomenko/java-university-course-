class MyClass {
    public String publicField;
    private int privateField;

    public MyClass() {
        this.publicField = "Default";
        this.privateField = 42;
    }

    public MyClass(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    private void privateMethod(String message) {
        System.out.println("Private method called with message: " + message);
    }
}