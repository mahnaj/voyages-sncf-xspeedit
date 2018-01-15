package com.kata.voyagessncf.xspeedit.utils;

import com.kata.voyagessncf.xspeedit.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class RobotUtilsTest {
    private RobotUtils robotUtils;
    private HashSet<Integer> processedItemsIndexes;
    private List<Item> itemsList;

    @Before
    public void setUp() throws Exception {
        robotUtils = new RobotUtils();
        int[] input = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        itemsList = RobotUtils.createItems(input);
        initProcessedItemsList();
    }

    @Test
    public void should_return_true_when_index_is_already_processed() {
        assertThat(robotUtils.isItemAlreadyProcessed(processedItemsIndexes, 3)).isEqualTo(true);
    }

    @Test
    public void should_return_false_when_index_is_not_yet_processed() {
        assertThat(robotUtils.isItemAlreadyProcessed(processedItemsIndexes, 2)).isEqualTo(false);
    }

    @Test
    public void should_return_8_when_current_size_is_1_and_9_is_already_processed() {
        Integer bestNextItemIndex = robotUtils.findBestNextItem(itemsList, processedItemsIndexes, 1);
        assertThat(bestNextItemIndex).isNotNull();
        assertThat(itemsList.get(bestNextItemIndex).getSize()).isEqualTo(8);
    }

    @Test
    public void should_return_null_when_current_size_is_9_and_1_is_already_processed() {
        assertThat(robotUtils.findBestNextItem(itemsList, processedItemsIndexes, 9)).isNull();
    }

    private void initProcessedItemsList() {
        int[] indexArray = {8, 3, 1, 0, 5};
        processedItemsIndexes = Arrays.stream(indexArray).boxed().collect(Collectors.toCollection(HashSet::new));
    }
}

