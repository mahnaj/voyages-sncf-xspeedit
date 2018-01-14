package com.kata.voyagessncf.xspeedit.utils;

import com.kata.voyagessncf.xspeedit.model.Box;
import com.kata.voyagessncf.xspeedit.model.Item;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RobotUtils {
    public boolean isItemAlreadyProcessed(List<Integer> alreadyProcessedItemsIndexes, int i) {
        return alreadyProcessedItemsIndexes.contains(i);
    }

    public Integer findBestNextItem(List<Item> items, List<Integer> alreadyProcessedItemsIndexes, int givenSize) {
        Integer result = null;
        int maxTotalSize = 0;
        for (int j = 0; j < items.size(); j++) {
            if (!isItemAlreadyProcessed(alreadyProcessedItemsIndexes, j)) {
                int currentItemSize = items.get(j).getSize();
                if (givenSize + currentItemSize <= Box.MAX_CAPACITY && givenSize + currentItemSize > maxTotalSize) {
                    maxTotalSize = givenSize + currentItemSize;
                    result = Integer.valueOf(j);
                }
            }
        }
        return result;
    }

    public static List<Item> createItems(int[] values ) {
        return Stream.iterate(0, n -> n + 1).limit(values.length)
                .map(n -> Item.builder().size(values[n]).build())
                .collect(Collectors.toList());
    }

    public static int countBoxes(List<Box> boxList) {
        return boxList.size();
    }

    public static String printDetails(List<Box> boxList) {
        return boxList.stream()
                .map(b -> b.toString())
                .collect(Collectors.joining("/"));
    }
}
