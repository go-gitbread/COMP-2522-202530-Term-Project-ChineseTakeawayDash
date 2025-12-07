import javafx.scene.image.Image;
import java.util.Objects;

/**
 * Represents a Dish.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Dish extends Tile implements Interactable {
    /**
     * Dish size.
     */
    public static final int DISH_SIZE = 32;
    private boolean pickedUp;
    private double xCoordinate;
    private double yCoordinate;


    /**
     * Constructs a Dish object.
     *
     * @param xCoordinate the x coordinate of the dish
     * @param yCoordinate the y coordinate of the dish
     */
    public Dish(final double xCoordinate, final double yCoordinate) {
        super(new Image("file:src/main/resources/dish.png"), false);
        this.pickedUp = false;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(DISH_SIZE);
        this.getTileImageView().setFitHeight(DISH_SIZE);
    }

    /**
     * Set the Dish's X coordinate to the new xCoordinate.
     *
     * @param newXCoordinate as a double.
     */
    public void setXCoordinate(final double newXCoordinate) {
        this.xCoordinate = newXCoordinate;
        this.getTileImageView().setX(this.xCoordinate);

    }

    /**
     * Set the Dish's y coordinate to the new yCoordinate.
     *
     * @param newYCoordinate as a double.
     */
    public void setYCoordinate(final double newYCoordinate) {
        this.yCoordinate = newYCoordinate;
        this.getTileImageView().setY(this.yCoordinate);
    }

    /**
     * Sets pickedUp to be true.
     */
    public void pickUp() {
        this.pickedUp = true;
    }

    /**
     * Returns pickedUp.
     *
     * @return pickedUp
     */
    public boolean isPickedUp() {
        return pickedUp;
    }

    /**
     * Triggers waiter to pick up the dish, and returns string confirmation.
     *
     * @param waiter that will interact with the object
     * @return string to confirm that the dish was picked up
     */
    @Override
    public String interact(final Waiter waiter) {
        if (!pickedUp && !waiter.isCarryingDish()) {
            waiter.pickUpDish(this);
            pickedUp = true;
            return "Picked up dish!";
        }
        return "";
    }

    /**
     * Returns true if the dish has not been picked up yet.
     *
     * @return true if the dish has not been picked up yet.
     */
    @Override
    public boolean isInteractable() {
        return !pickedUp;
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Dish{");
        sb.append("pickedUp=").append(isPickedUp());
        sb.append(", xCoordinate=").append(xCoordinate);
        sb.append(", yCoordinate=").append(yCoordinate);
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
        if (!(object instanceof Dish dish)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        return pickedUp == dish.pickedUp
                && Double.compare(xCoordinate, dish.xCoordinate) == 0
                && Double.compare(yCoordinate, dish.yCoordinate) == 0;
    }

    /**
     * Returns the hashcode representation of the sprite object.
     *
     * @return the hashcode of the sprite object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pickedUp, xCoordinate, yCoordinate);
    }
}
