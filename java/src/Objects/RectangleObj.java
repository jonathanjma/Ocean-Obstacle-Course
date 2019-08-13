package Objects;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * A Rectangle
 * @author Jonathan Ma
 * @version 1.0
 */

public class RectangleObj extends SimpleObject {

    private Rectangle r;

    /**
     * Creates a new rectangle obstacle
     * (can also be used as a hit box for irregularly shaped obstacles)
     * @param inX the starting x coordinate
     * @param inY the starting y coordinate
     * @param inWidth the width of the obstacle
     * @param inHeight the height of the obstacle
     * @param doesDamage whether the obstacle does damage to the player
     */
    public RectangleObj(int inX, int inY, int inWidth, int inHeight, boolean doesDamage) {
        super(inX, inY,  inWidth, inHeight, doesDamage);
        
        r = new Rectangle(inX, inY,  inWidth, inHeight);
        r.setFill(Color.TRANSPARENT);
        //r.setStroke(Color.LIGHTGRAY.deriveColor(1, 1, 1, 0.5));
        r.setStrokeType(StrokeType.INSIDE);
        r.setStrokeWidth(3);
        getChildren().add(r);
    }

    /**
     * For debugging and development purposes only
     * <p>Creates a rectangle representing the bounding box/hit box of an obstacle
     * @param b the bounding box of an obstacle
     */
    public RectangleObj(Bounds b) {
        super((int)b.getMinX(), (int)b.getMinY(),  (int)b.getWidth(), (int)b.getHeight(), false);

        r = new Rectangle();
        createBoundsRectangle(b);
        getChildren().add(r);
    }

    /**
     * Creates a rectangle representing the bounding box/hit box of an obstacle
     * @param bounds the bounding box of an obstacle
     */
    public void createBoundsRectangle(Bounds bounds) {
        r.setFill(Color.TRANSPARENT);
        //r.setStroke(Color.LIGHTGRAY.deriveColor(1, 1, 1, 0.5));
        r.setStrokeType(StrokeType.INSIDE);
        r.setStrokeWidth(3);

        r.setX(bounds.getMinX());
        r.setY(bounds.getMinY());
        r.setWidth(bounds.getWidth());
        r.setHeight(bounds.getHeight());
    }

    /**
     * Updates the rectangle's x and y coordinates, drawing it on the screen
     */
    @Override
    public void draw() {
        r.setX(getX());
        r.setY(getY());
    }

    /**
     * Gets the rectangle
     * @return the rectangle
     */
    @Override
    public Node getNode() {
        return r;
    }
}
