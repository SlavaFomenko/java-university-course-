package models;

import enums.Gender;
import enums.Location;

public class Teacher extends Person {
    private static int counter = 0;
    private String subject;
    private String university;
    private Car car;

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Teacher");
    }

    public static void showCounter() {
        System.out.println("Teachers created: " + counter);
    }
}
