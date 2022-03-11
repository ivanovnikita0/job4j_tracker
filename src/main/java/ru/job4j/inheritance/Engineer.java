package ru.job4j.inheritance;

public class Engineer extends Profession {
    private byte category;

    public Engineer(String name, String surname, String education, String birthday, byte category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public byte getCategory() {
        return category;
    }
}
