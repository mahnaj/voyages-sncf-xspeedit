package com.kata.voyagessncf.xspeedit;

import com.kata.voyagessncf.xspeedit.impl.OptimizedRobot;
import com.kata.voyagessncf.xspeedit.model.Box;
import com.kata.voyagessncf.xspeedit.model.Item;
import com.kata.voyagessncf.xspeedit.utils.RobotUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OptimizedRobot optimizedRobot = new OptimizedRobot();
        List<Item> itemList = RobotUtils.createItems(new int[]{1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3});
        List<Box> boxList = optimizedRobot.packageItems(itemList);

        System.out.println("Number of Boxes: " + RobotUtils.countBoxes(boxList));
        System.out.println(RobotUtils.printDetails(boxList));
    }


}
