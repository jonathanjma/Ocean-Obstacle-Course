package Objects;

import javafx.animation.PathTransition;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * A Moving Obstacle
 * @author Jonathan Ma
 * @version 1.0
 */

public class MovingObject extends ImageObject {

    private Line path1;
    private Line path2;
    private PathTransition moveOb1;
    private PathTransition moveOb2;
    private PathTransition curTrans;
    private int x1, x2;

    /**
     * Creates a new moving obstacle
     * @param x1 the x coordinate of the first point
     * @param y1 the y coordinate of the first point
     * @param x2 the x coordinate of the second point
     * @param y2 the y coordinate of the second point
     * @param img the image filepath
     * @param doesDamage whether the obstacle does damage to the player
     */
    public MovingObject(int x1, int y1, int x2, int y2, String img, boolean doesDamage) {
        super(x1, y1, img, doesDamage);
        this.x1 = x1; this.x2 = x2;

        path1 = new Line(x1, y1, x2, y2);
        path2 = new Line(x2, y2, x1, y1);
        int dist = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        int time = dist * 15;
        //System.out.println(dist + ", " + time);

        moveOb1 = new PathTransition(Duration.millis(time), path1, getNode()); curTrans = moveOb1;
        moveOb2 = new PathTransition(Duration.millis(time), path2, getNode());
        moveOb1.setOnFinished(e -> {
            curTrans = moveOb2;
            moveOb2.play();
        });
        moveOb2.setOnFinished(e -> {
            curTrans = moveOb1;
            moveOb1.play();
        });
    }

    /**
     * Updates the image, path, and animation's x and y coordinates, drawing it on the screen
     */
    @Override
    public void draw() {
        super.draw();

        int diffX = (int) (path1.getEndX()-path1.getStartX());
        x1 = getX(); x2 = x1 + diffX;
        path1.setStartX(x1); path1.setEndX(x2);
        path2.setStartX(x2); path2.setEndX(x1);

        Duration stopTime = curTrans.getCurrentTime();
        curTrans.stop();
        if (curTrans == moveOb1) curTrans.setPath(path1);
        else if (curTrans == moveOb2) curTrans.setPath(path2);
        curTrans.jumpTo(stopTime);
        curTrans.play();
    }

    /**
     * Starts the moving animation, which causes the obstacle to move
     */
    public void startMove() {
        moveOb1.play();
    }

    /**
     * Stops the moving animation
     */
    public void stopMove() {
        moveOb1.stop();
    }

    /**
     * Gets the obstacle's path
     * @return the obstacle's path
     */
    public Line getPath() {
        return path1;
    }
}