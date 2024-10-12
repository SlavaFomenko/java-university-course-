package models;

import enums.Gender;
import enums.Location;
import interfaces.Human;

public abstract class Person implements Human {
    protected int age;
    protected String firstname;
    protected String lastname;
    protected Gender gender;
    protected Location location;
    protected String fullInfo;

    public Person() {
        this.age = 18;
        this.firstname = "Default";
        this.lastname = "Default";
        this.gender = Gender.MALE;
        this.location = Location.KIEV;
    }

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public abstract void getOccupation();

    public String getFullInfo() {
        return String.format("Name: %s %s, Age: %d, Gender: %s, Location: %s", firstname, lastname, age, gender, location);
    }

    public void sayFullName() {
        System.out.println("Full Name: " + firstname + " " + lastname);
    }

    public void sayAge() {
        System.out.println("Age: " + age);
    }

    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    public void sayGender() {
        System.out.println("Gender: " + gender);
    }
}
