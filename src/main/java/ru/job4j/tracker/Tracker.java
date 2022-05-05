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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
        items[index].setName(item.getName());
        }
        return index != -1;
    }
}