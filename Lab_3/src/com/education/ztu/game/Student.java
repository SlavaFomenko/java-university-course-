package com.education.ztu.game;

public class Student extends Participant {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student{name='" + getName() + "', age=" + getAge() + "}";
    }
}

