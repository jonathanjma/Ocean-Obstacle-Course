package Objects;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * An Image Obstacle
 * @author Jonathan Ma
 * @version 1.0
 */

public class ImageObject extends SimpleObject {

    private ImageView i;
    private RectangleObj r;

    /**
     * Creates a new image obstacle
     * @param inX the starting x coordinate
     * @param inY the starting y coordinate
     * @param img the image filepath
     * @param doesDamage whether the obstacle does damage to the player
     */
    public ImageObject(int inX, int inY, String img, boolean doesDamage) {
        super(inX, inY, doesDamage);
        i = new ImageView(img);
        setW((int) i.getImage().getWidth());
        setH((int) i.getImage().getHeight());
        i.setX(getX());
        i.setY(getY());

        getChildren().add(i);
        /*r = new RectangleObj(i.getBoundsInLocal());
        getChildren().add(r);*/
    }

    /**
     * Updates the image's x and y coordinates, drawing it on the screen
     */
    @Override
    public void draw() {
        i.setX(getX());
        i.setY(getY());

        /*getChildren().removeAll(r);
        r = new RectangleObj(i.getBoundsInLocal());
        getChildren().add(r);*/
    }

    /**
     * Gets the image
     * @return the image
     */
    @Override
    public Node getNode() {
        return i;
    }
}
