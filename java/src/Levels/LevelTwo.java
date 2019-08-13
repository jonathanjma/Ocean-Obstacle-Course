package Levels;

import java.util.ArrayList;

import Objects.ImageObject;
import Objects.MovingObject;
import Objects.RectangleObj;
import Objects.SimpleObject;

/**
 * Level 2
 * @author Jonathan Ma
 * @version 1.0
 */

public class LevelTwo extends Level {

    /**
     * Creates the second level
     * @param num the level number
     * @param name the level name
     * @param leftLimit the starting x coordinate of the player
     *                  used to prevent moving left behind the start
     */
    public LevelTwo(int num, String name, int leftLimit) {
        super(num, name, leftLimit);
    }

    /**
     * Adds obstacles to the second level
     * @return the list of obstacles in the first level
     */
    @Override
    public ArrayList<SimpleObject> addOb() {
        ArrayList<SimpleObject> obList = getObList();

        setFirstObj(new ImageObject(0, 200, "img/coral2.png", false));
        obList.add(new ImageObject
                (getFirstObj().getX() + getFirstObj().getW(), 210, "img/coral1.png", false));
        obList.add(new ImageObject
                (getFirstObj().getX() + 2*getFirstObj().getW(), 200, "img/coral2.png", false));
        obList.add(new ImageObject
                (getFirstObj().getX() + 3*getFirstObj().getW(), 210, "img/coral1.png", false));
        obList.add(new ImageObject
                (getFirstObj().getX() + 4*getFirstObj().getW(), 200, "img/coral2.png", false));
        obList.add(new RectangleObj(0, 260, 2100, 170, true));

        obList.add(new MovingObject(30, 30, 400, 30, "img/trop5.png", true));
        obList.add(new MovingObject(50, 120, 280, 150, "img/trop4.png", true));
        obList.add(new MovingObject(700, 150, 300, 80, "img/trop7.png", true));
        obList.add(new MovingObject(350, 150, 670, 220, "img/trop1.png", true));
        obList.add(new MovingObject(420, 30, 770, 80, "img/trop6.png", true));

        obList.add(new MovingObject(850, 180, 980, 90, "img/turtle.png", true));
        obList.add(new ImageObject(1200, 5, "img/seaw1.png", true));
        obList.add(new ImageObject(960, 110, "img/seaw1.png", true));

        obList.add(new MovingObject(1450, 45, 1450, 190, "img/pufferfish.png", true));
        obList.add(new MovingObject(1650, 190, 1650, 40, "img/lionfish.png", true));
        obList.add(new MovingObject(1850, 40, 1850, 190, "img/blueringocto.png", true));

        setLastObj(new ImageObject(2100, 500, "img/buoy.png", true));

        return obList;
    }
}
