package models;

import enums.Gender;
import enums.Location;

public class Student extends Person {
    private static int counter = 0;
    private int course;
    private String speciality;
    private String university;

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String speciality, int course, String university) {
        super(firstname, lastname, age, gender, location);
        this.speciality = speciality;
        this.course = course;
        this.university = university;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Student");
    }

    public static void showCounter() {
        System.out.println("Students created: " + counter);
    }
}
