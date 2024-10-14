package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> implements Cloneable {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("В команду " + name + " добавлен участник " + participant.getName());
    }

    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("Команда " + winnerName + " победила!");
    }

    public Team(Team<T> other) {
        this.name = other.name;
        for (T participant : other.participants) {
            try {
                this.participants.add((T) participant.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T extends Participant> Team<T> deepClone(Team<T> other) {
        return new Team<>(other);
    }

    @Override
    public String toString() {
        return "Team{name='" + name + "', participants=" + participants + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team<?> team = (Team<?>) obj;
        return name.equals(team.name) && participants.equals(team.participants);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + participants.hashCode();
        return result;
    }

    public List<T> getParticipants() {
        return participants;
    }
}
