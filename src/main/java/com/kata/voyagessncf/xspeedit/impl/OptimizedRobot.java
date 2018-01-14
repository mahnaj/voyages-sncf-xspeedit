package com.kata.voyagessncf.xspeedit.impl;

import com.kata.voyagessncf.xspeedit.Robot;
import com.kata.voyagessncf.xspeedit.model.Box;
import com.kata.voyagessncf.xspeedit.model.Item;
import com.kata.voyagessncf.xspeedit.utils.RobotUtils;

import java.util.ArrayList;
import java.util.List;

public class OptimizedRobot implements Robot {
    private RobotUtils robotUtils;

    public OptimizedRobot() {
        this.robotUtils = new RobotUtils();
    }

    public List<Box> packageItems(List<Item> items) {
        List<Box> boxes = new ArrayList<>();
        List<Integer> alreadyProcessedItemsIndexes = new ArrayList<Integer>();

        for (int i = 0; i < items.size(); i++) {
            if (robotUtils.isItemAlreadyProcessed(alreadyProcessedItemsIndexes, i)) {
                continue;
            }

            Box box = Box.initBox(items.get(i));
            alreadyProcessedItemsIndexes.add(i);
            int currentSize = items.get(i).getSize();

            boolean noMatchingElementFound;
            do {
                final Integer next = robotUtils.findBestNextItem(items, alreadyProcessedItemsIndexes, currentSize);
                if (next != null) {
                    box.addItem(items.get(next.intValue()));
                    alreadyProcessedItemsIndexes.add(next.intValue());
                    currentSize = currentSize + items.get(next.intValue()).getSize();
                    noMatchingElementFound = false;
                } else {
                    noMatchingElementFound = true;
                }
            } while (!box.isMaxCapacityReached() && !noMatchingElementFound);

            boxes.add(box);
        }
        return boxes;
    }

}
