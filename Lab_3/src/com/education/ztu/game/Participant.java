package com.education.ztu.game;

public abstract class Participant implements Comparable<Participant> {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Participant clone() throws CloneNotSupportedException {
        return (Participant) super.clone();
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
