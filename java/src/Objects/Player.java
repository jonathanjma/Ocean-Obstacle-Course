package Objects;

/**
 * The Player
 * @author Jonathan Ma
 * @version 1.0
 */

public class Player extends ImageObject {

    private int health;

    /**
     * Creates a new player
     * @param inX the starting x coordinate
     * @param inY the starting y coordinate
     * @param img the image filepath
     * @param inHealth the player's health
     */
    public Player(int inX, int inY, String img, int inHealth) {
        super(inX, inY, img, false);
        health = inHealth;
    }

    /**
     * Sets the player's health
     * @param newHealth the player's new health
     */
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    /**
     * Gets the player's health
     * @return the player's health
     */
    public int getHealth() {
        return health;
    }
}
