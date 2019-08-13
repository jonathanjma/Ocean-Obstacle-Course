package Levels;

import java.util.ArrayList;

import Objects.MovingObject;
import Objects.Player;
import Objects.SimpleObject;

/**
 * A Basic Obstacle Course Level
 * <p>The Base Class for all Levels
 * @author Jonathan Ma
 * @version 1.0
 */

public abstract class Level {

    private SimpleObject firstObj;
    private SimpleObject lastObj;
    private ArrayList<SimpleObject> obList;
    private Player p;
    private int lvlNum;
    private String lvlName;
    private int leftLimit;

    /**
     * Creates a new Level
     * @param num the level number
     * @param name the level name
     * @param leftLimit the starting x coordinate of the player
     *                  used to prevent moving left behind the start
     */
    public Level(int num, String name, int leftLimit) {
        lvlNum = num;
        lvlName = name;
        this.leftLimit = leftLimit;
        obList = new ArrayList<>();
    }

    /**
     * Adds obstacles to the level, put level obstacles here
     * @return the list of obstacles
     */
    public abstract ArrayList<SimpleObject> addOb();

    /**
     * Adds a Player to the Level
     * @param inX starting x coordinate
     * @param inY starting y coordinate
     * @param img the image filepath
     * @param inHealth amount of health for the level
     * @return the player for this level
     */
    public Player addPlayer(int inX, int inY, String img, int inHealth) {
        p = new Player(inX, inY, img, inHealth);
        return p;
    }

    /**
     * Checks if the player has hit a stationary obstacle by
     * checking if their bounding boxes intersect
     * @return whether the player has hit a stationary obstacle
     */
    public boolean checkIntersectReg() {
        for (int i = 0; i < obList.size(); i++) {
            SimpleObject s = obList.get(i);
            if (!(s instanceof MovingObject) && s.doesDamage() && p.getNode().intersects(s.getNode().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player has hit a moving obstacle by
     * checking if their bounding boxes intersect
     * @return whether the player has hit a moving obstacle
     */
    public boolean checkIntersectMov() {
        for (int i = 0; i < obList.size(); i++) {
            SimpleObject s = obList.get(i);
            if (s instanceof MovingObject && s.doesDamage() && p.getNode().intersects(s.getNode().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player has past the last object, completing the level
     * @return whether the player has past the last object of the level
     */
    public boolean checkCompleted() {
        return p.getX() > lastObj.getX();
    }

    /**
     * Sets the first object of the level
     * @param firstObj the first object
     */
    public void setFirstObj(SimpleObject firstObj) {
        this.firstObj = firstObj;
        obList.add(firstObj);
    }

    /**
     * Sets the last object of the level
     * @param lastObj the last object
     */
    public void setLastObj(SimpleObject lastObj) {
        this.lastObj = lastObj;
        obList.add(lastObj);
    }

    /**
     * Sets the move left boundary
     * @param newLeftLimit the boundary's x coordinate
     */
    public void setLeftLimit(int newLeftLimit) {
        leftLimit = newLeftLimit;
    }

    /**
     * Gets the level number
     * @return the level number
     */
    public int getLvl() {
        return lvlNum;
    }

    /**
     * Gets the level name
     * @return the level name
     */
    public String getLvlName() {
        return lvlName;
    }

    /**
     * Gets the move left boundary
     * @return the boundary's x coordinate
     */
    public int getLeftLimit() {
        return leftLimit;
    }

    /**
     * Gets the first object
     * @return the first object
     */
    public SimpleObject getFirstObj() {
        return firstObj;
    }

    /**
     * Gets the last object
     * @return the last object
     */
    public SimpleObject getLastObj() {
        return lastObj;
    }

    /**
     * Gets the list of obstacles
     * @return the list of obstacles
     */
    public ArrayList<SimpleObject> getObList() {
        return obList;
    }
}
