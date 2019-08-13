package Levels;

import java.util.ArrayList;

import Objects.ImageObject;
import Objects.MovingObject;
import Objects.RectangleObj;
import Objects.SimpleObject;

/**
 * Level 3
 * @author Jonathan Ma
 * @version 1.0
 */

public class LevelThree extends Level {

    /**
     * Creates the third level
     * @param num the level number
     * @param name the level name
     * @param leftLimit the starting x coordinate of the player
     *                  used to prevent moving left behind the start
     */
    public LevelThree(int num, String name, int leftLimit) {
        super(num, name, leftLimit);
    }

    /**
     * Adds obstacles to the third level
     * @return the list of obstacles in the first level
     */
    @Override
    public ArrayList<SimpleObject> addOb() {
        ArrayList<SimpleObject> obList = getObList();

        setFirstObj(new ImageObject(150, 500, "img/buoy.png", true));
        for (int i = 0; i <= 35; i++) {
            obList.add(new ImageObject(i*110, 300, "img/seaw2.png", false));
        }
        obList.add(new RectangleObj(0, 350, 2000, 350, true));

        obList.add(new MovingObject(70, 60, 550, 60, "img/dolphin.png", true));
        obList.add(new MovingObject(70, 240, 320, 240, "img/dolphin.png", true));
        obList.add(new MovingObject(620, 140, 620, 280, "img/manatee.png", true));

        obList.add(new ImageObject(850, 40, "img/oil.png", true));
        obList.add(new ImageObject(830, 100, "img/oil.png", true));
        obList.add(new ImageObject(810, 160, "img/oil.png", true));
        obList.add(new MovingObject(1200, -20, 1200, 10, "img/shipbottom.png", true));

        obList.add(new ImageObject(1550, 0, "img/fishnet.png", true));

        obList.add(new MovingObject(1500, 120, 1800, 120, "img/lobster.png", true));
        obList.add(new MovingObject(1450, 170, 1800, 170, "img/lobster.png", true));
        obList.add(new MovingObject(1800, 40, 1950, 180, "img/lobster.png", true));

        obList.add(new ImageObject(1130, 200, "img/hammershark.png", true));
        obList.add(new MovingObject(1350, 320, 2000, 320, "img/stingray.png", true));
        for (int i = 0; i <= 15; i++) {
            obList.add(new ImageObject(i*110+2100, 220, "img/seaw2.png", false));
        }
        obList.add(new RectangleObj(2100, 260, 500, 350, true));

        obList.add(new MovingObject(2200, 100, 2400, 100, "img/humpback.png", true));
        obList.add(new ImageObject(2750, 140, "img/seahorse.png", true));

        setLastObj(new ImageObject(3000, 500, "img/buoy.png", true));

        return obList;
    }
}
