import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Represents a Tile.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Tile implements Interactable {

    protected Image tileImage;
    protected ImageView tileImageView;
    private boolean isCollision;


    /**
     * Creates a tile object.
     *
     * @param tileImage the image for the tile
     * @param isCollision if the tile is solid
     */
    public Tile(final Image tileImage, final boolean isCollision) {
        this.isCollision = isCollision;
        this.tileImage = tileImage;
        this.tileImageView = new ImageView(this.tileImage);
    }

    /**
     * Returns the tile's image.
     *
     * @return the tile's image (raw pixels)
     */
    public Image getTileImage() {
        return this.tileImage;
    }

    /**
     * Set the tile image to the new Image.
     *
     * @param newImage the new image for tile Image.
     */
    public void setTileImage(final Image newImage) {
        this.tileImage = newImage;
    }

    /**
     * Returns the tile's TileImageView.
     *
     * @return the tile's TileImageView
     */
    public ImageView getTileImageView() {
        return this.tileImageView;
    }


    /**
     * Sets the tile image new to the new Image view.
     *
     * @param newImageView the new Image View
     */
    public void setTileImageView(final ImageView newImageView) {
        this.tileImageView = newImageView;
    }

    /**
     * Returns true if the tile is considered a collision.
     *
     * @return true if the tile is considered a collision
     */
    public boolean isCollision() {
        return this.isCollision;
    }

    /**
     * Sets the isCollision value to newCollision.
     *
     * @param newCollision is the isCollision value to be set.
     */
    public void setCollision(final boolean newCollision) {
        this.isCollision = newCollision;
    }

    /**
     * Returns the bounds of the tile as a rectangle.
     *
     * @return the bounds of the tile as a rectangle
     */
    public Rectangle2D getBounds() {
        return new Rectangle2D(
                tileImageView.getX(),
                tileImageView.getY(),
                tileImageView.getImage().getWidth(),
                tileImageView.getImage().getHeight()
        );
    }

    /**
     * Returns en empty string as default for a tile.
     *
     * @param waiter that will interact with the object
     * @return an empty string as default.
     */
    @Override
    public String interact(final Waiter waiter) {
        return "";
    }
    /**
     * Returns false as the default for tile.
     *
     * @return false.
     */
    @Override
    public boolean isInteractable() {
        return false;
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Tile{");
        sb.append("tileImage=").append(getTileImage());
        sb.append(", tileImageView=").append(getTileImageView());
        sb.append(", isCollision=").append(isCollision());
        sb.append(", collision=").append(isCollision());
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
        if (!(object instanceof Tile tile)) {
            return false;
        }
        return isCollision == tile.isCollision
                && Objects.equals(tileImage, tile.tileImage)
                && Objects.equals(tileImageView, tile.tileImageView);
    }

    /**
     * Returns the hashcode representation of the Tile object.
     *
     * @return the hashcode of the Tile object as int
     */

    @Override
    public int hashCode() {
        return Objects.hash(tileImage, tileImageView, isCollision);
    }
}
