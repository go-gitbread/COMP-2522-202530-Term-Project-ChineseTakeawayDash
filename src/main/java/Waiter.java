import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Waiter extends Sprite {

    private static final double INTERACTION_BOX_WIDTH = 50;
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
    private TileManager tileManager;


    /**
     * Constructs a Waiter object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Waiter(double xCoordinate, double yCoordinate, TileManager tileManager) {
        super(xCoordinate,
                yCoordinate, new Image("file:src/main/resources/front.png"));
        this.currentIncome = 0;
        this.tileManager = tileManager;
        loadWaiterImage();
        updateSpriteImage();
    }

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

        double currentX = this.getXCoordinate();
        double currentY = this.getYCoordinate();

        double attemptedX = currentX;
        double attemptedY = currentY;

        if (keysPressed.contains(KeyCode.A)) {
            attemptedX -= SPEED;
            direction = "left";
        }
        if (keysPressed.contains(KeyCode.D)) {
            attemptedX += SPEED;
            direction = "right";
        }
        if (keysPressed.contains(KeyCode.W)) {
            attemptedY -= SPEED;
            direction = "up";
        }
        if (keysPressed.contains(KeyCode.S)) {
            attemptedY += SPEED;
            direction = "down";
        }

        if (!tileManager.isCollision(this, attemptedX, currentY)) {
            currentX = attemptedX;
        }
        if (!tileManager.isCollision(this, currentX, attemptedY)) {
            currentY = attemptedY;
        }

        this.setXCoordinate(currentX);
        this.setYCoordinate(currentY);

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

    public void interact() {
        tileManager.checkInteraction(this);
    }

    public Rectangle2D getInteractionBox() {
        double x = this.getXCoordinate();
        double y = this.getYCoordinate();
        double w = this.getNewImageWidth();
        double h = this.getNewImageHeight();

        switch (direction) {
            case "up":
                return new Rectangle2D(x, y - INTERACTION_BOX_HEIGHT, w, INTERACTION_BOX_HEIGHT);
            case "down":
                return new Rectangle2D(x, y + h, w, INTERACTION_BOX_HEIGHT);
            case "left":
                return new Rectangle2D(x - INTERACTION_BOX_WIDTH, y, INTERACTION_BOX_WIDTH, h);
            case "right":
                return new Rectangle2D(x + w, y, INTERACTION_BOX_WIDTH, h);
            default:
                return new Rectangle2D(x, y, w, h);
        }
    }

}
