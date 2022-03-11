package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean prosthetics;

    public Dentist(String name, String surname, String education, String birthday, boolean vet, boolean prosthetics) {
        super(name, surname, education, birthday, vet);
        this.prosthetics = prosthetics;
    }

    public boolean getProsthetics() {
        return prosthetics;
    }
}
