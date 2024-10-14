package com.education.ztu.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("ivan", 13);
        Schoolar schoolar2 = new Schoolar("mariya", 15);
        Schoolar schoolar3 = new Schoolar("anna", 14);

        Team<Schoolar> schoolarTeam = new Team<>("sch000l");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);
        schoolarTeam.addNewParticipant(schoolar3);

        List<Schoolar> participants = new ArrayList<>(schoolarTeam.getParticipants());
        Collections.sort(participants);
        System.out.println("Sorted by name: " + participants);

        participants.sort(new AgeComparator());
        System.out.println("Sorted by age: " + participants);

        participants.sort(NameAgeComparator.getNameAgeComparator());
        System.out.println("Sorted by name and then by age: " + participants);
    }
}
