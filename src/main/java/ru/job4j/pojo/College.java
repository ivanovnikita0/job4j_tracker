package ru.job4j.pojo;
import java.util.Date;

public class College {
    @SuppressWarnings("checkstyle:WhitespaceAfter")
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setPatronymic("Ivanovich");
        student.setStudyGroup("C - 08 - 12");
        student.setReceipt(new Date());

        System.out.println(student.getSurname() + " " + student.getName() + " " + student.getPatronymic() + " study in a group " + student.getStudyGroup() + " since " + student.getReceipt());
    }
}
