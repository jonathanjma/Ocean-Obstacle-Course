package Objects;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * For debugging and development purposes only
 * <p>A Line
 * @author Jonathan Ma
 * @version 1.0
 */

public class LineObj extends SimpleObject {

    private Line l;
    private int x1, x2;

    /**
     * Creates a new line as a SimpleObject
     * @param inL the line
     */
    public LineObj(Line inL) {
        super((int) inL.getStartX(), (int) inL.getStartY(), 0, 0, false);
        x1 = (int) inL.getStartX();     x2 = (int) inL.getEndX();
        int y1 = (int) inL.getStartY(); int y2 = (int) inL.getEndY();

        l = new Line(x1, y1, x2, y2);
        l.setStroke(Color.LIGHTGRAY.deriveColor(1, 1, 1, 0.5));
        getChildren().add(l);
    }

    /**
     * Updates the line's x and y coordinates, drawing it on the screen
     */
    @Override
    public void draw() {
        int diffX = (int) (l.getEndX()-l.getStartX());
        x1 = getX(); x2 = x1 + diffX;
        l.setStartX(x1);
        l.setEndX(x2);
    }

    /**
     * Gets the line
     * @return the line
     */
    @Override
    public Node getNode() {
        return l;
    }
}
