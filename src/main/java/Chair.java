import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;

public class Chair extends Tile {
    public static final int TILE_SIZE = 50;
    private double xCoordinate;
    private double yCoordinate;
    private boolean hasCustomer;
    private DirectionFace directionFace;

    public Chair(double xCoordinate, double yCoordinate, Boolean isCollision, DirectionFace directionFace) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.directionFace = directionFace;
        if (this.directionFace == DirectionFace.LEFT) {
            this.setTileImage(new Image("file:src/main/resources/chair_facing_left.png"));
            this.setTileImageView(new ImageView(this.getTileImage()));
        }
        this.hasCustomer = false;
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(TILE_SIZE);
        this.getTileImageView().setFitHeight(TILE_SIZE);
    }

    public boolean isHasCustomer() {
        return this.hasCustomer;
    }

    public void setHasCustomer(boolean hasCustomer) {
        this.hasCustomer = hasCustomer;
    }
}
