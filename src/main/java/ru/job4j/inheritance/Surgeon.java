package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String direction;

    public Surgeon(String name, String surname, String education, String birthday, boolean vet, String direction) {
        super(name, surname, education, birthday, vet);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
