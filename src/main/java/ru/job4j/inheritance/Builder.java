package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String structures;

    public Builder(String name, String surname, String education, String birthday, byte category, String structures) {
        super(name, surname, education, birthday, category);
        this.structures = structures;
    }

    public String getStructures() {
        return structures;
    }
}
