package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<Character> lf = new ArrayList<>();
        for (int i = 0; i < left.length(); i++) {
            lf.add(left.charAt(i));
        }
        List<Character> rt = new ArrayList<>();
        for (int i = 0; i < right.length(); i++) {
            rt.add(right.charAt(i));
        }
        int length = Math.min(lf.size(), rt.size());
        int count = Integer.compare(lf.size(), rt.size());
            for (int i = 0; i < length; i++) {
                int rsl = Character.compare(lf.get(i), rt.get(i));
                if (rsl != 0) {
                    return rsl;
                }
            }
        return count;
    }
}










