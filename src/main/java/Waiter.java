import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Waiter
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public final class Waiter extends Sprite {

    /**
     * The width of the waiter's interaction box.
     */
    private static final double INTERACTION_BOX_WIDTH = 50;
    /**
     * The height of the waiter's interaction box.
     */
    private static final double INTERACTION_BOX_HEIGHT = 50;
    
    
    private double currentIncome;
    private int speed;
    public Image up1;
    public Image up2;
    public Image up3;

    public Image down1;
    public Image down2;
    public Image down3;

    public Image left1;
    public Image left2;
    public Image left3;

    public Image right1;
    public Image right2;
    public Image right3;
    private final Set<KeyCode> keysPressed = new HashSet<>();
    private static final double SPEED = 4;
    private String direction = "down";
    private final TileManager tileManager;

    private Customer carryingCustomer;
    private Dish carriedDish;


    /**
     * Creates a waiter.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     * @param tileManager represents the tile manager
     */
    Waiter(double xCoordinate, double yCoordinate, TileManager tileManager) {
        super(xCoordinate,
                yCoordinate, new Image("file:src/main/resources/front.png"));
        this.currentIncome = 0.0;
        this.tileManager = tileManager;
        loadWaiterImage();
        updateSpriteImage();
    }

    /**
     * Loads the sprite images.
     */
    public void loadWaiterImage() {
        try {
            up1 = new Image("file:src/main/resources/waiter/back.png");
            up2 = new Image("file:src/main/resources/waiter/back_step_left.png");
            up3 = new Image("file:src/main/resources/waiter/back_step_right.png");

            down1 = new Image("file:src/main/resources/waiter/front.png");
            down2 = new Image("file:src/main/resources/waiter/front_step_left.png");
            down3 = new Image("file:src/main/resources/waiter/front_step_right.png");

            left1 = new Image("file:src/main/resources/waiter/left_walk.png");
            left2 = new Image("file:src/main/resources/waiter/left_walk_swingbackwards.png");
            left3 = new Image("file:src/main/resources/waiter/left_walk_swingforward.png");

            right1 = new Image("file:src/main/resources/waiter/right_walk.png");
            right2 = new Image("file:src/main/resources/waiter/right_walk_swingbackwards.png");
            right3 = new Image("file:src/main/resources/waiter/right_walk_swingforward.png");

        } catch (Exception e) {
            System.out.println("Image not found");
        }

    }

    /**
     * Returns the income of the waiter.
     *
     * @return the income of the waiter
     */
    public double getCurrentIncome() {
        return currentIncome;
    }

    /**
     * Sets the waiter's income to the current income
     *
     * @param newIncome the new income
     */
    public void setCurrentIncome(double newIncome) {
        this.currentIncome = newIncome;
    }

    /**
     * update the locations of the waiter based on the key pressed.
     */
    public void update() {

        double currentX = this.getXCoordinate();
        double currentY = this.getYCoordinate();

        double attemptedX = currentX;
        double attemptedY = currentY;

        if (keysPressed.contains(KeyCode.A)) {
            attemptedX -= SPEED;
            this.setDirection("left");
        }
        if (keysPressed.contains(KeyCode.D)) {
            attemptedX += SPEED;
            this.setDirection("right");
        }
        if (keysPressed.contains(KeyCode.W)) {
            attemptedY -= SPEED;
            this.setDirection("up");
        }
        if (keysPressed.contains(KeyCode.S)) {
            attemptedY += SPEED;
            this.setDirection("down");
        }

        if (!tileManager.isCollision(this, attemptedX, currentY)) {
            currentX = attemptedX;
        }
        if (!tileManager.isCollision(this, currentX, attemptedY)) {
            currentY = attemptedY;
        }



        this.setXCoordinate(currentX);
        this.setYCoordinate(currentY);

        if (carryingCustomer != null) {
            carryingCustomer.setXCoordinate(this.getXCoordinate());
            carryingCustomer.setYCoordinate(this.getYCoordinate() - 20);
        }

        if (carriedDish != null) {
            carriedDish.setXCoordinate(this.getXCoordinate() + 10);
            carriedDish.setYCoordinate(this.getYCoordinate() - 10);
        }

        updateSpriteImage();
    }

    /**
     * Updates the image based on the direction.
     */
    private void updateSpriteImage() {
        Image newImage = up2;
        if (direction == null) {
            direction = "down";
        }
        switch (direction) {
            case "up":
                newImage = up1;
                break;
            case "down":
                newImage = down1;
                break;
            case "left":
                newImage = left1;
                break;
            case "right":
                newImage = right1;
                break;
        }
        if (newImage != null) {
            this.setNewImage(newImage);
        }

    }

    /**
     * Records that key was pressed.
     *
     * @param code the pressed key
     */
    public void handleKeyPressed(KeyCode code) {
        keysPressed.add(code);
    }

    /**
     * Records that key was released.
     *
     * @param code the key released
     */
    public void handleKeyReleased(KeyCode code) {
        keysPressed.remove(code);
    }

    /**
     * Returns the direction of the waiter is facing as string.
     *
     * @return the direction of the waiter as a string
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the new direction.
     *
     * @param direction the new direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Triggers the tile manager to check interaction.
     */
    public void interact() {
        tileManager.checkInteraction(this);
    }

    /**
     * Returns a rectangle that represents the interaction area in front, depending on the waiter's direction.
     *
     * @return rectangular interaction zone that is in front of the waiter depending on the direction.
     */
    public Rectangle2D getInteractionBox() {
        double xCoordinateHold = this.getXCoordinate();
        double yCoordinateHold = this.getYCoordinate();
        double imageViewWidth = this.getImageViewWidth();
        double imageViewHeight = this.getImageViewHeight();

        switch (this.direction) {
            case "up":
                return new Rectangle2D(xCoordinateHold, yCoordinateHold - INTERACTION_BOX_HEIGHT, imageViewWidth, INTERACTION_BOX_HEIGHT);
            case "down":
                return new Rectangle2D(xCoordinateHold, yCoordinateHold + imageViewHeight, imageViewWidth, INTERACTION_BOX_HEIGHT);
            case "left":
                return new Rectangle2D(xCoordinateHold - INTERACTION_BOX_WIDTH, yCoordinateHold, INTERACTION_BOX_WIDTH, imageViewHeight);
            case "right":
                return new Rectangle2D(xCoordinateHold + imageViewWidth, yCoordinateHold, INTERACTION_BOX_WIDTH, imageViewHeight);
            default:
                return new Rectangle2D(xCoordinateHold, yCoordinateHold, imageViewWidth, imageViewHeight);
        }
    }

    /**
     * @param money the money to be added to income
     */
    public void addIncome(double money) {
        this.currentIncome += money;
    }

    public void pickUpCustomer(Customer customer) {
        this.carryingCustomer = customer;
        customer.setCollision(false);
        tileManager.remove(customer);
    }

    public boolean seatCustomerAtTable(Table table) {
        if (carryingCustomer != null && !table.isAtMax()) {
            carryingCustomer.assignTable(table);
            carryingCustomer.sitDown();
            table.addCustomer(carryingCustomer);
            tileManager.spawnDishForCustomer();
            carryingCustomer = null;
            return true;
        }
        return false;
    }
    public void pickUpDish(Dish dish) {
        if (carriedDish == null) {
            this.carriedDish = dish;
            dish.pickUp();
        }
    }


    public boolean isCarryingCustomer() {
        return carryingCustomer != null;
    }

    public boolean isCarryingDish() {
        return carriedDish != null;
    }

    public Customer getCarryingCustomer() {
        return carryingCustomer;
    }
    public void deleteDish() {
        this.carriedDish = null;
    }
    public Dish getCarriedDish() {
        return carriedDish;
    }
    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Waiter{");
        sb.append("currentIncome=").append(getCurrentIncome());
        sb.append(", speed=").append(speed);
        sb.append(", up1=").append(up1);
        sb.append(", up2=").append(up2);
        sb.append(", up3=").append(up3);
        sb.append(", down1=").append(down1);
        sb.append(", down2=").append(down2);
        sb.append(", down3=").append(down3);
        sb.append(", left1=").append(left1);
        sb.append(", left2=").append(left2);
        sb.append(", left3=").append(left3);
        sb.append(", right1=").append(right1);
        sb.append(", right2=").append(right2);
        sb.append(", right3=").append(right3);
        sb.append(", keysPressed=").append(keysPressed);
        sb.append(", direction='").append(getDirection()).append('\'');
        sb.append(", tileManager=").append(tileManager);
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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Waiter waiter)) return false;
        if (!super.equals(object)) return false;
        return Double.compare(currentIncome, waiter.currentIncome) == 0
                && speed == waiter.speed
                && Objects.equals(up1, waiter.up1)
                && Objects.equals(up2, waiter.up2)
                && Objects.equals(up3, waiter.up3)
                && Objects.equals(down1, waiter.down1)
                && Objects.equals(down2, waiter.down2)
                && Objects.equals(down3, waiter.down3)
                && Objects.equals(left1, waiter.left1)
                && Objects.equals(left2, waiter.left2)
                && Objects.equals(left3, waiter.left3)
                && Objects.equals(right1, waiter.right1)
                && Objects.equals(right2, waiter.right2)
                && Objects.equals(right3, waiter.right3)
                && Objects.equals(keysPressed, waiter.keysPressed)
                && Objects.equals(direction, waiter.direction)
                && Objects.equals(tileManager, waiter.tileManager);
    }
    /**
     * Returns the hashcode representation of the waiter object.
     *
     * @return the hashcode of the waiter object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                currentIncome,
                speed,
                up1,
                up2,
                up3,
                down1,
                down2,
                down3,
                left1,
                left2,
                left3,
                right1,
                right2,
                right3,
                keysPressed,
                direction,
                tileManager);
    }



}
