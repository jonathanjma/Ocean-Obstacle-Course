package Objects;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A Simple Obstacle
 * <p>The Base Class for All Obstacles
 * @author Jonathan Ma
 * @version 1.0
 */

public abstract class SimpleObject extends Pane {

    private int x, y;
    private int width, height;
    private boolean doesDamage;

    /**
     * Creates a simple obstacle
     * @param inX the starting x coordinate
     * @param inY the starting y coordinate
     * @param inWidth the width of the obstacle
     * @param inHeight the height of the obstacle
     * @param doesDamage whether the obstacle does damage to the player
     */
    public SimpleObject(int inX, int inY, int inWidth, int inHeight, boolean doesDamage) {
        x = inX;
        y = inY;
        width = inWidth;
        height = inHeight;
        this.doesDamage = doesDamage;
    }

    /**
     * Image Obstacle Constructor- images can find their own width/height
     * @param inX the starting x coordinate
     * @param inY the starting y coordinate
     * @param doesDamage whether the obstacle does damage to the player
     */
    public SimpleObject(int inX, int inY, boolean doesDamage) {
        x = inX;
        y = inY;
        this.doesDamage = doesDamage;
    }

    /**
     * Updates the obstacle's x and y coordinates, drawing it on the screen
     */
    public abstract void draw();

    /**
     * Gets the obstacle
     * @return the obstacle
     */
    public abstract Node getNode();

    /**
     * Gets whether the obstacle does damage to the player
     * @return whether the obstacle does damage to the player
     */
    public boolean doesDamage() {
        return doesDamage;
    }

    /**
     * Sets the obstacle's x coordinate
     * @param newX the new x coordinate
     */
    public void setX(int newX) {
        x = newX;
    }

    /**
     * Sets the obstacle's y coordinate
     * @param newY the new y coordinate
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * Sets the obstacle's width
     * @param newWidth the new width
     */
    public void setW(int newWidth) {
        width = newWidth;
    }

    /**
     * Sets the obstacle's height
     * @param newHeight the new height
     */
    public void setH(int newHeight) {
        height = newHeight;
    }

    /**
     * Gets the obstacle's x coordinate
     * @return the obstacle's x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the obstacle's y coordinate
     * @return the obstacle's y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the obstacle's width
     * @return the obstacle's width
     */
    public int getW() {
        return width;
    }

    /**
     * Gets the obstacle's height
     * @return the obstacle's height
     */
    public int getH() {
        return height;
    }
}
