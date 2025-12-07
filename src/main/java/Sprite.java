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
    /**
     * The size of the sprite.
     */
    private static final int SPRITE_SIZE = 50;
    private double xCoordinate;
    private double yCoordinate;
    private Image image;
    private final ImageView imageView;

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
        this.imageView = setUpImageViewForSprite(xCoordinate, yCoordinate);
    }

    /**
     * Helper function to set up ImageView for the constructor.
     *
     * @param startXCoordinate represents the xCoordinate coordinate value as a double
     * @param startYCoordinate represents the yCoordinate coordinate value as a double
     * @return view for the constructor
     */
    protected ImageView setUpImageViewForSprite(final double startXCoordinate, final double startYCoordinate) {
        ImageView view = new ImageView(this.image);
        view.setFitWidth(SPRITE_SIZE);
        view.setFitHeight(SPRITE_SIZE);
        view.setX(startXCoordinate);
        view.setY(startYCoordinate);
        return view;
    }

    /**
     * Return the sprite's image view.
     *
     * @return the sprite's image view
     */
    public ImageView getImageView() {
        return this.imageView;
    }

    /**
     * Set the sprite's xCoordinate to the new xCoordinate.
     *
     * @param newXCoordinate the new x Coordinate
     */
    protected void setXCoordinate(final double newXCoordinate) {
        this.xCoordinate = newXCoordinate;
        this.imageView.setX(newXCoordinate);
    }

    /**
     * Set the sprite's yCoordinate to the new yCoordinate.
     *
     * @param newYCoordinate the new y Coordinate
     */
    protected void setYCoordinate(final double newYCoordinate) {
        this.yCoordinate = newYCoordinate;
        this.imageView.setY(newYCoordinate);
    }

    /**
     * Set the image and imageView to the newImage.
     *
     * @param newImage the image and image view to the newImage.
     */
    protected void setNewImage(final Image newImage) {
        this.image = newImage;
        this.setImageView(image);
    }

    /**
     * Sets the imageview to the image.
     *
     * @param image the image for the image view
     */
    protected void setImageView(final Image image) {
        imageView.setImage(image);
    }

    /**
     * Return the sprites imageview's height.
     *
     * @return the current imageview's height
     */
    protected double getImageViewHeight() {
        return this.imageView.getFitHeight();

    }

    /**
     * Return the sprites imageview's width.
     *
     * @return the current imageview's width
     */
    protected double getImageViewWidth() {
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
     * Returns a rectangle representing of the sprite at the coordinates
     *
     * @param nextX the next xCoordinate of the sprite
     * @param nextY the next yCoordinate of the sprite
     * @return rectangle that represents the sprite's boundaries
     */
    public Rectangle2D getBounds(final double nextX, final double nextY) {
        return new Rectangle2D (
                nextX,
                nextY,
                this.getImageViewWidth(),
                this.getImageViewHeight()
        );
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
        sb.append(", image=").append(getImage());
        sb.append(", imageView=").append(getImageView());
        sb.append(", XCoordinate=").append(getXCoordinate());
        sb.append(", YCoordinate=").append(getYCoordinate());
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
        if (this == object ) {
            return true;
        }
        if (!(object instanceof Sprite sprite)) {
            return false;
        }
        return Double.compare(xCoordinate, sprite.xCoordinate) == 0
                && Double.compare(yCoordinate, sprite.yCoordinate) == 0
                && Objects.equals(image, sprite.image)
                && Objects.equals(imageView, sprite.imageView);
    }
    /**
     * Returns the hashcode representation of the sprite object.
     *
     * @return the hashcode of the sprite object as int
     */

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, image, imageView);
    }
}
