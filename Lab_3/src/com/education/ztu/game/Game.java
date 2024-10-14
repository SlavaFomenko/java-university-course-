package com.education.ztu.game;

public class Game {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("john", 13);
        Schoolar schoolar2 = new Schoolar("kate", 15);
        Student student1 = new Student("alex", 20);
        Student student2 = new Student("angel", 21);
        Employee employee1 = new Employee("smith", 28);
        Employee employee2 = new Employee("eva", 25);

        Team<Schoolar> schoolarTeam = new Team<>("sch000l");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("stUUUUdent");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("w0000rkers");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> schoolarTeam2 = new Team<>("sch0000l2");
        Schoolar schoolar3 = new Schoolar("alan", 12);
        Schoolar schoolar4 = new Schoolar("olga", 14);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        schoolarTeam.playWith(schoolarTeam2);
//         schoolarTeam.playWith(employeeTeam); //err
    }
}
