import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Represents a Sprite.
 *
 * @author BCIT
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Sprite {
    private static final int TILE_SIZE = 50;
    private double xCoordinate;
    private double yCoordinate;
    private Image image;
    private ImageView imageView;

    /**
     * Constructs a Sprite object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     * @param image       represents the visuals of the Sprite.
     */
    protected Sprite(final double xCoordinate, final double yCoordinate, final Image image) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.image = image;
        this.imageView = new ImageView(this.image);
        this.imageView.setFitWidth(TILE_SIZE);
        this.imageView.setFitHeight(TILE_SIZE);
        this.imageView.setX(xCoordinate);
        this.imageView.setY(yCoordinate);
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    /**
     * Returns a rectangle of as if the next block
     *
     * @return a rectangle of sprite's boundaries
     */
    public Rectangle2D getBounds(double nextX, double nextY) {
        return new Rectangle2D(
                nextX,
                nextY,
                this.getNewImageWidth(),
                this.getNewImageHeight()
        );
    }

    protected void setXCoordinate(double newXCoordinate) {
        this.xCoordinate = newXCoordinate;
        this.imageView.setX(newXCoordinate);
    }

    protected void setYCoordinate(double newYCoordinate) {
        this.yCoordinate = newYCoordinate;
        this.imageView.setY(newYCoordinate);
    }

    protected void setNewImage(Image newImage) {
        this.image = newImage;
        this.imageView.setImage(newImage);
    }

    protected double getNewImageHeight() {
        return this.imageView.getFitHeight();

    }
    protected double getNewImageWidth() {
        return this.imageView.getFitWidth();

    }




    /**
     * Returns the xCoordinate coordinate of the sprite.
     *
     * @return the xCoordinate coordinate as a double
     */
    public double getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Returns the yCoordinate coordinate of the sprite.
     *
     * @return the yCoordinate coordinate as a double
     */
    public double getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Returns the image of the sprite.
     *
     * @return the image of the sprite
     */
    protected Image getImage() {
        return image;
    }




    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Sprite{");
        sb.append("xCoordinate=").append(xCoordinate);
        sb.append(", yCoordinate=").append(yCoordinate);
        sb.append(", image=").append(image);
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
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Sprite sprite = (Sprite) object;
        return Double.compare(xCoordinate, sprite.getXCoordinate()) == 0
                && Double.compare(yCoordinate, sprite.getYCoordinate()) == 0
                && Objects.equals(image, sprite.getImage());
    }

    /**
     * Returns the hashcode representation of the sprite object.
     *
     * @return the hashcode of the sprite object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, image);
    }



}

