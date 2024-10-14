package com.education.ztu.game;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Schoolar schoolar1 = new Schoolar("ivan", 13);
        Schoolar schoolar2 = new Schoolar("dasha", 15);

        Team<Schoolar> schoolarTeam = new Team<>("sch000l");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        System.out.println("original team " + schoolarTeam);

        Team<Schoolar> clonedTeam = Team.deepClone(schoolarTeam);
        System.out.println("clone team " + clonedTeam);

        System.out.println("equal team " + schoolarTeam.equals(clonedTeam));
        System.out.println("hash original team: " + schoolarTeam.hashCode());
        System.out.println("HashCode clone team: " + clonedTeam.hashCode());

        clonedTeam.addNewParticipant(new Schoolar("Ольга", 14));
        System.out.println("original team after modifying the clone " + schoolarTeam);
        System.out.println("cloned team after adding a new participant " + clonedTeam);

        System.out.println("hash original team: " + schoolarTeam.hashCode());
        System.out.println("HashCode clone team: " + clonedTeam.hashCode());
    }
}
