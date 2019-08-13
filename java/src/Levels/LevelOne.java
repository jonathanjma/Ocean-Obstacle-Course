package Levels;

import java.util.ArrayList;

import Objects.ImageObject;
import Objects.RectangleObj;
import Objects.SimpleObject;

/**
 * Level 1
 * @author Jonathan Ma
 * @version 1.0
 */

public class LevelOne extends Level {

    /**
     * Creates the first level
     * @param num the level number
     * @param name the level name
     * @param leftLimit the starting x coordinate of the player
     *                  used to prevent moving left behind the start
     */
    public LevelOne(int num, String name, int leftLimit) {
        super(num, name, leftLimit);
    }

    /**
     * Adds obstacles to the first level
     * @return the list of obstacles in the first level
     */
    @Override
    public ArrayList<SimpleObject> addOb() {
        ArrayList<SimpleObject> obList = getObList();

        setFirstObj(new ImageObject(0, 80, "img/shore.png", false));
        obList.add(new RectangleObj(0, 350, 700, 60, true)); //bottom
        obList.add(new RectangleObj(0, 140, 200, 210, true)); //left
        obList.add(new RectangleObj(200, 225, 185, 125, true)); //2nd left
        obList.add(new RectangleObj(380, 290, 160, 60, true)); //3rd left

        obList.add(new ImageObject(5, 90, "img/seaw2.png", false));
        obList.add(new ImageObject(140, 120, "img/seaw1.png", false));
        obList.add(new ImageObject(260, 180, "img/seaw1.png", false));
        obList.add(new ImageObject(390, 240, "img/seaw1.png", false));
        obList.add(new ImageObject(30, 230, "img/crab.png", false));
        obList.add(new ImageObject(150, 260, "img/seaw2.png", false));
        obList.add(new ImageObject(10, 290, "img/seaw2.png", false));
        obList.add(new ImageObject(300, 330, "img/crab.png", false));
        obList.add(new ImageObject(540, 310, "img/starfish.png", false));
        obList.add(new ImageObject(570, 350, "img/starfish.png", false));
        obList.add(new ImageObject(620, 330, "img/starfish.png", false));
        obList.add(new ImageObject(670, 350, "img/starfish.png", false));

        obList.add(new ImageObject(440, 0, "img/hooks.png", true));

        obList.add(new ImageObject(775, 50, "img/jr1.png", false));
        obList.add(new RectangleObj(850, 85, 260, 150, true));

        obList.add(new ImageObject(1250, 110, "img/jr3.png", false));
        obList.add(new RectangleObj(1250, 210, 220, 160, true));

        obList.add(new ImageObject(1650, 25, "img/stshark.png", false));
        obList.add(new RectangleObj(1650, 25, 300, 90, true));

        obList.add(new ImageObject(1300, 290, "img/coralr1.png", true));
        obList.add(new ImageObject(1900, 270, "img/coral2.png", true));

        setLastObj(new ImageObject(2000, 500, "img/buoy.png", true));

        return obList;
    }
}
