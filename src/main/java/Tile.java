import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a Tile.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Tile {

    protected final Image tileImage;
    protected ImageView tileImageView;
    private boolean isCollision;

    public Tile(Image tileImage, boolean isCollision) {
        this.tileImage = tileImage;
        this.isCollision = isCollision;
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
     * Returns the tile's TileImageView.
     *
     * @return the tile's TileImageView
     */
    public ImageView getTileImageView() {
        return this.tileImageView;
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
    public void setCollision(boolean newCollision) {
        this.isCollision = newCollision;
    }
}
