import javafx.scene.image.Image;

public class Dish extends Tile implements Interactable {
    private boolean isPickedUp;
    private double xCoordinate;
    private double yCoordinate;
    private Table assignedTable;


    public Dish(double xCoordinate, double yCoordinate) {
        super(new Image("file:src/main/resources/dish.png"), false);
        this.isPickedUp = false;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(32);
        this.getTileImageView().setFitHeight(32);
    }

    public void pickUp() {
        this.isPickedUp = true;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    @Override
    public String interact(Waiter waiter) {
        if (!isPickedUp && !waiter.isCarryingDish()) {
            waiter.pickUpDish(this);
            isPickedUp = true;
            return "Picked up dish!";
        }
        return "";
    }

    @Override
    public boolean isInteractable() {
        return !isPickedUp;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
        this.getTileImageView().setX(xCoordinate);

    }
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
        this.getTileImageView().setY(yCoordinate);
    }
}
