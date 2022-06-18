package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] var : list) {
            for (int var2 : var) {
                rsl.add(var2);
            }

        }
        return rsl;
    }
}