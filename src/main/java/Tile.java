import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


    public Tile(Image tileImage, boolean isCollision) {
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
     * Returns the tile's TileImageView.
     *
     * @return the tile's TileImageView
     */
    public ImageView getTileImageView() {
        return this.tileImageView;
    }


    public void setTileImageView(ImageView newImageView) {
        this.tileImageView = newImageView;
    }

    public void setTileImage(Image newImage) {
        this.tileImage = newImage;
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


    @Override
    public String interact(Waiter waiter) {
        return("");
    }

    @Override
    public boolean isInteractable() {
        return false;
    }

    public Rectangle2D getBounds() {
        return new Rectangle2D(
                tileImageView.getX(),
                tileImageView.getY(),
                tileImageView.getImage().getWidth(),
                tileImageView.getImage().getHeight()
        );
    }
}
