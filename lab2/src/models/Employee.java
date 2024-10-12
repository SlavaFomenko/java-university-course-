package models;

import enums.Gender;
import enums.Location;

public class Employee extends Person {
    private static int counter = 0;
    private String company;
    private String position;
    private models.Car car;

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, String company, String position, models.Car car) {
        super(firstname, lastname, age, gender, location);
        this.company = company;
        this.position = position;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Employee");
    }

    public static void showCounter() {
        System.out.println("Employees created: " + counter);
    }
}
