package ru.job4j.array;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        boolean rsl = !name.isEmpty()
                && !Character.isDigit(name.charAt(0)) && !Character.isUpperCase(name.charAt(0));
        for (int i = 0; i < name.length(); i++) {
            int code = name.codePointAt(i);
            if (!isSpecialSymbol(code) && !isLowerLatinLetter(code)
                    && !isUpperLatinLetter(code) && !Character.isDigit(code)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }

    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }
}