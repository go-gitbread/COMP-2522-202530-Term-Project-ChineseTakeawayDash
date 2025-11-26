import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Waiter extends Sprite {
    private static final int TILE_SIZE = 40;
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

    /**
     * Constructs a Waiter object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Waiter(double xCoordinate, double yCoordinate) {
        super(xCoordinate,
                yCoordinate, new Image("file:src/main/resources/front.png"));
        this.currentIncome = 0;
        loadWaiterImage();
        updateSpriteImage();
    }

    public void loadWaiterImage() {
        try {
            up1 = new Image("file:src/main/resources/back.png");
            up2 = new Image("file:src/main/resources/back_step_left.png");
            up3 = new Image("file:src/main/resources/back_step_right.png");

            down1 = new Image("file:src/main/resources/front.png");
            down2 = new Image("file:src/main/resources/front_step_left.png");
            down3 = new Image("file:src/main/resources/front_step_right.png");

            left1 = new Image("file:src/main/resources/left_walk.png");
            left2 = new Image("file:src/main/resources/left_walk_swingbackwards.png");
            left3 = new Image("file:src/main/resources/left_walk_swingforward.png");

            right1 = new Image("file:src/main/resources/right_walk.png");
            right2 = new Image("file:src/main/resources/right_walk_swingbackwards.png");
            right3 = new Image("file:src/main/resources/right_walk_swingforward.png");

        } catch (Exception e) {
            System.out.println("Image not found");
        }

    }
    

    public double getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(double currentIncome) {
        this.currentIncome = currentIncome;
    }

    /**
     *
     */
    public void update() {
        if (keysPressed.contains(KeyCode.A)) {
            System.out.println("Moving left!");
            double currentXCoordinate = this.getXCoordinate();
            this.setXCoordinate(currentXCoordinate - SPEED);

            direction = "left";
        }
        if (keysPressed.contains(KeyCode.D)) {
            double currentXCoordinate = this.getXCoordinate();
            this.setXCoordinate(currentXCoordinate + SPEED);
            direction = "right";
        }
        if (keysPressed.contains(KeyCode.W)) {
            double currentYCoordinate = this.getYCoordinate();
            this.setYCoordinate(currentYCoordinate - SPEED);
            direction = "up";
        }
        if (keysPressed.contains(KeyCode.S)) {
            double currentYCoordinate = this.getYCoordinate();
            this.setYCoordinate(currentYCoordinate + SPEED);
            direction = "down";
        }

        updateSpriteImage();

    }

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

    public void handleKeyPressed(KeyCode code) {
        keysPressed.add(code);
    }

    public void handleKeyReleased(KeyCode code) {
        keysPressed.remove(code);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
