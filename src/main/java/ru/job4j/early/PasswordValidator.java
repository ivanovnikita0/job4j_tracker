package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Empty line");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Length less than 8");
        }
        if (password.length() > 32) {
            throw new IllegalArgumentException("Length over 32");
        }
        if (isBanString(password)) {
            throw new IllegalArgumentException("Do not use qwerty, 12345, password, admin, user");
        }
        if (password.toLowerCase().equals(password)) {
            throw new IllegalArgumentException("No uppercase");
        }
        if (password.toUpperCase().equals(password)) {
            throw new IllegalArgumentException("No lowercase");
        }
        if (!isNumber(password)) {
            throw new IllegalArgumentException("No numbers");
        }

        if (!isSpecialS(password)) {
            throw new IllegalArgumentException("No special characters");
        }

        return "PASSWORD GOOD";
    }

    public static boolean isBanString(String pass) {
       return pass.toLowerCase().contains("qwerty".toLowerCase())
               || pass.toLowerCase().contains("12345".toLowerCase())
               || pass.toLowerCase().contains("password".toLowerCase())
               || pass.toLowerCase().contains("admin".toLowerCase())
               || pass.toLowerCase().contains("user".toLowerCase());
    }

    public static boolean isNumber(String pass) {
        boolean rsl = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                rsl = true;
            }
        }
        return rsl;
    }

    public static boolean isSpecialS(String pass) {
        boolean rsl = false;
        for (int i = 0; i < pass.length(); i++) {
            int code = pass.codePointAt(i);
            if (code >= 33 && code <= 47 || code >= 58 && code <= 64) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}