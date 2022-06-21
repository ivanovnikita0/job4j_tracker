package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void whenFCBA() {
        Item a = new Item("A");
        Item b = new Item("B");
        Item c = new Item("C");
        Item d = new Item("D");

        List<Item> items = Arrays.asList(d, c, b, a);
        Collections.sort(items, new ItemAscByName());
        List<Item> ex = Arrays.asList(a, b, c, d);
        assertEquals(items, ex);
    }
}