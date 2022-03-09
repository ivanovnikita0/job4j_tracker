package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printData() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error firstUser = new Error();
        firstUser.printData();
        Error secondUser = new Error(false, 555, "Сломалось");
        secondUser.printData();
        Error thirdUser = new Error(true, 0, "Работает");
        thirdUser.printData();
    }
}
