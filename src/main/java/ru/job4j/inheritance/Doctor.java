package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean vet;

    public Doctor(String name, String surname, String education, String birthday, boolean vet) {
        super(name, surname, education, birthday);
        this.vet = vet;
    }

    public boolean getVet() {
        return vet;
    }
}
