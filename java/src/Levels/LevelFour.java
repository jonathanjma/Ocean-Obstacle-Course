package Levels;

import java.util.ArrayList;

import Objects.ImageObject;
import Objects.MovingObject;
import Objects.SimpleObject;

/**
 * Level 4
 * @author Jonathan Ma
 * @version 1.0
 */

public class LevelFour extends Level {

    /**
     * Creates the fourth level
     * @param num the level number
     * @param name the level name
     * @param leftLimit the starting x coordinate of the player
     *                  used to prevent moving left behind the start
     */
    public LevelFour(int num, String name, int leftLimit) {
        super(num, name, leftLimit);
    }

    /**
     * Adds obstacles to the fourth level
     * @return the list of obstacles in the first level
     */
    @Override
    public ArrayList<SimpleObject> addOb() {
        ArrayList<SimpleObject> obList = getObList();

        setFirstObj(new ImageObject(150, 150, "img/mineD.png", true));
        obList.add(new MovingObject(380, 60, 380, 200, "img/mine.png", true));
        obList.add(new ImageObject(550, 0, "img/mineU.png", true));
        obList.add(new MovingObject(770, 330, 770, 190, "img/mine.png", true));
        obList.add(new ImageObject(940, 150, "img/mineD.png", true));

        obList.add(new MovingObject(1150, 60, 1400, 60, "img/mine.png", true));
        obList.add(new MovingObject(1400, 170, 1150, 170, "img/mine.png", true));
        obList.add(new MovingObject(1150, 280, 1400, 280, "img/mine.png", true));
        obList.add(new ImageObject(1450, 0, "img/mineU.png", true));

        obList.add(new MovingObject(2050, 80, 2150, 170, "img/submarine.png", true));
        obList.add(new MovingObject(2050, 310, 2150, 220, "img/submarine.png", true));

        obList.add(new ImageObject(2470, 0, "img/mine.png", true));
        obList.add(new ImageObject(2470, 250, "img/mine.png", true));
        setLastObj(new ImageObject(2500, 500, "img/buoy.png", true));

        return obList;
    }
}
