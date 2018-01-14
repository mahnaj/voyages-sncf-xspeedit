package com.kata.voyagessncf.xspeedit.impl;

import com.kata.voyagessncf.xspeedit.model.Box;
import com.kata.voyagessncf.xspeedit.model.Item;
import com.kata.voyagessncf.xspeedit.utils.RobotUtils;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class OptimizedRobotTest {
    private OptimizedRobot optimizedRobot;
    private List<Item> itemList;

    @Before
    public void setUp() throws Exception {
        optimizedRobot = new OptimizedRobot();
    }

    @Test
    public void should_return_8_boxes() throws Exception {
        int[] input = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        itemList = RobotUtils.createItems(input);
        List<Box> boxList = optimizedRobot.packageItems(itemList);
        assertThat(boxList).isNotNull();
        assertThat(boxList.size()).isEqualTo(8);
    }

    @Test
    public void should_return_5_boxes() throws Exception {
        int[] input = {9, 5, 4, 2, 6, 3, 1, 7, 4};
        itemList = RobotUtils.createItems(input);
        List<Box> boxList = optimizedRobot.packageItems(itemList);
        assertThat(boxList).isNotNull();
        assertThat(boxList.size()).isEqualTo(5);
    }

}