import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

/**
 * Represents a Chair.
 *
 * @author Jossie Yan
 * @version 2025
 */
public class Chair extends Tile {
    /**
     * Chair size.
     */
    public static final int CHAIR_SIZE = 50;
    private double xCoordinate;
    private double yCoordinate;
    private DirectionFace directionFace;

    /**
     * Constructs a chair object.
     *
     * @param xCoordinate the x coordinate of the chair
     * @param yCoordinate the y coordinate of the chair
     * @param isCollision if the chair
     * @param directionFace the direction the chair is facing
     */
    public Chair(final double xCoordinate,
                 final double yCoordinate,
                 final Boolean isCollision,
                 final DirectionFace directionFace) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.directionFace = directionFace;
        if (this.directionFace == DirectionFace.LEFT) {
            this.setTileImage(new Image("file:src/main/resources/chair_facing_left.png"));
            this.setTileImageView(new ImageView(this.getTileImage()));
        }
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(CHAIR_SIZE);
        this.getTileImageView().setFitHeight(CHAIR_SIZE);
    }

    /**
     * Return the chairs y coordinate.
     *
     * @return the  chairs y coordinate
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Return the chairs x coordinate.
     *
     * @return the chairs x coordinate
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Chair{");
        sb.append("xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", directionFace=").append(directionFace);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Returns true if the objects are equal, otherwise false.
     *
     * @param object the reference object with which to compare.
     * @return true if the object is equal to the comparing object
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Chair chair)) {
            return false;
        }
        return Double.compare(xCoordinate, chair.xCoordinate) == 0
                && Double.compare(yCoordinate, chair.yCoordinate) == 0
                && directionFace == chair.directionFace;
    }

    /**
     * Returns the hashcode representation of the chair object.
     *
     * @return the hashcode of the chair object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, directionFace);
    }
}
