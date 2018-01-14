package com.kata.voyagessncf.xspeedit;

import com.kata.voyagessncf.xspeedit.model.Box;
import com.kata.voyagessncf.xspeedit.model.Item;

import java.util.List;

public interface Robot {
    List<Box> packageItems(final List<Item> items);
}
