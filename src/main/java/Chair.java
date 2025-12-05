import javafx.scene.image.Image;

public class Chair extends Tile {
    private double xCoordinate;
    private double yCoordinate;
    private boolean hasCustomer;

    public Chair(Image tileImage, Boolean isCollision, double xCoordinate, double yCoordinate) {
        super(tileImage, isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.hasCustomer = false;
    }


    public boolean isHasCustomer() {
        return this.hasCustomer;
    }

    public void setHasCustomer(boolean hasCustomer) {
        this.hasCustomer = hasCustomer;
    }
}
