package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 200);
        Book noCode = new Book("No Code", 50);
        Book javaCode = new Book("Java Code ", 1250);
        Book pythonCode = new Book("Python Code", 300);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = noCode;
        books[2] = javaCode;
        books[3] = pythonCode;
        for (int i = 0; i < books.length; i++) {
            Book bcs = books[i];
            System.out.println("\"" + bcs.getName() + "\" - " + bcs.getPage() + " pages");
        }
        System.out.println();
        System.out.println("Replace first with fourth.");
        Book bc = books[0];
        books[0] = books[3];
        books[3] = bc;
        for (int i = 0; i < books.length; i++) {
            Book bcs = books[i];
            System.out.println("\"" + bcs.getName() + "\" - " + bcs.getPage() + " pages");
        }
        System.out.println();
        System.out.println("Only \"Clean Code\"");
        for (int i = 0; i < books.length; i++) {
            Book bcs = books[i];
            if ("Clean Code".equals(bcs.getName())) {
            System.out.println("\"" + bcs.getName() + "\" - " + bcs.getPage() + " pages");
            }
        }
    }
}
