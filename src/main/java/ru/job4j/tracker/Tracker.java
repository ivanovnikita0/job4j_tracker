package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[this.size];
        int n = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[n] = item;
                n++;
            }
        }
        return Arrays.copyOf(rsl, this.size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[this.size];
        int n = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                    rsl[n] = item;
                    n++;
                }
            }
            return Arrays.copyOf(rsl, n);
        }
    }