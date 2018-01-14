package com.kata.voyagessncf.xspeedit.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private int size;

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
