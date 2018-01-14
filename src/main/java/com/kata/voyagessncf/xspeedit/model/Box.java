package com.kata.voyagessncf.xspeedit.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Box {
    public static final int MAX_CAPACITY = 10;

    private int capacity;
    private List<Item> items;

    private Box() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (this.items == null) this.items = new ArrayList<>();
        this.items.add(item);
        this.capacity = this.capacity + item.getSize();
    }

    public boolean isMaxCapacityReached() {
        return this.getCapacity() == MAX_CAPACITY;
    }

    public static Box initBox(final Item item) {
        Box box = new Box();
        box.addItem(item);
        return box;
    }

    @Override
    public String toString() {
        return items.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining());
    }
}
