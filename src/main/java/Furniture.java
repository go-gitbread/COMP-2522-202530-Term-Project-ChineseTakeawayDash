import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Represents a Furniture.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Furniture extends Tile implements Interactable {
    /**
     * The base size of a furniture object.
     */
    public static final int FURNITURE_SIZE = 50;
    /**
     * Boxes size.
     */
    public static final int BOXES_SIZE = FURNITURE_SIZE + 15;
    /**
     * Sink width.
     */
    public static final int SINK_WIDTH_SIZE = FURNITURE_SIZE - 20;
    /**
     * Fryer size.
     */
    public static final int FRYER_WIDTH = FURNITURE_SIZE + 10;
    /**
     * Instruction book size.
     */
    public static final double INSTRUCTION_BOOK_SIZE = FURNITURE_SIZE / 2.0;
    /**
     * Counter width.
     */
    public static final int HORIZONTAL_COUNTER_WIDTH_SIZE = 100;
    /**
     * Counter height.
     */
    public static final int VERTICAL_COUNTER_HEIGHT_SIZE = 80;
    /**
     * Painting size.
     */
    public static final int PAINTING_COW_SIZE = 38;
    private final FurnitureType furnitureName;
    private final double xCoordinate;
    private final double yCoordinate;
    private final boolean isInteractable;

    /**
     * Create a furniture object at a certain coordinate and depending on the Furniture type.
     *
     * @param xCoordinate The furniture object's xCoordinate
     * @param yCoordinate The furniture object's yCoordinate
     * @param isCollision If the furniture object's considered a collision
     * @param furnitureType the type of furniture as an enumeration
     */
    public Furniture(final double xCoordinate,
                     final double yCoordinate,
                     final Boolean isCollision,
                     final FurnitureType furnitureType) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.furnitureName = furnitureType;
        switch (this.furnitureName) {
            case FurnitureType.INSTRUCTIONS_BOOK -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/instructions_book.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(INSTRUCTION_BOOK_SIZE);
                this.getTileImageView().setFitHeight(INSTRUCTION_BOOK_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.FRYER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/fryer.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FRYER_WIDTH);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.HORIZONTAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(HORIZONTAL_COUNTER_WIDTH_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = false;
            }
            case FurnitureType.DESK -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(HORIZONTAL_COUNTER_WIDTH_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.VERTICAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/vertical_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(VERTICAL_COUNTER_HEIGHT_SIZE);
                this.isInteractable = false;
            }
            case FurnitureType.SHELF -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/shelf.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(VERTICAL_COUNTER_HEIGHT_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.STOVE -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/stove.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.SINK -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/sink.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(SINK_WIDTH_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.BOXES -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/boxes.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(BOXES_SIZE);
                this.getTileImageView().setFitHeight(BOXES_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.PLANTS -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/plants.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.COW_PAINTING -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/cow_painting.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(PAINTING_COW_SIZE);
                this.getTileImageView().setFitHeight(PAINTING_COW_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.MOUNTAIN_PAINTING -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/mountain_painting.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(PAINTING_COW_SIZE);
                this.isInteractable = true;
            }
            default -> {
                this.isInteractable = false;
                System.out.println("error, no furniture");
            }

        }
    }

    /**
     * Return the furniture object's xCoordinate.
     *
     * @return the furniture's xCoordinate
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Return the furniture object's yCoordinate.
     *
     * @return the furniture's yCoordinate
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Return the correct string depending on the interaction object.
     *
     * @param waiter that will interact with the object
     * @return the correct string depending on the object
     */
    @Override
    public String interact(final Waiter waiter) {
        switch (furnitureName) {
            case STOVE:
                return "This is the stove. Looks like your dad is cooking something. It's hot!";
            case DESK:
                return "Welcome to Lok Lok Garden. You need to help the family biz.\n"
                        + "1. TAKE CUSTOMERS TO A TABLE\n"
                        + "2. PICK UP THE DISHES\n"
                        + "3. BRING THEM THE FOOD\n"
                        + "WASD is for walking\n"
                        + "I to check your income\n"
                        + "P is to save your income for next time\n"
                        + "J is for interacting/picking up/closing dialogue";
            case FRYER:
                return "Hmmm, the warm smell of egg-rolls and sweet \n"
                        + "and sour chicken balls fills you with grease";
            case SINK:
                return "Dirty dishes pile up in the sink... Ew that's so gross.";
            case SHELF:
                return "Wow there sure are a lot kinds of soy sauces";
            case COW_PAINTING:
                return "A cute cow painting. Moo!\n"
                        + "Reminds you of a nice burger you had at A&W";
            case MOUNTAIN_PAINTING:
                return "A peaceful mountain landscape.\n"
                        + "You hope that one day you can see the real mountains.";
            case BOXES:
                return "A stack of boxes full random supplies...";
            case PLANTS:
                return "Some lovely green plants.\n"
                        + "You're 90% sure that one of them are fake...";
            default:
                return "";
        }

    }

    /**
     * Returns the furniture isInteractable instance variable.
     *
     * @return isInteractable
     */
    @Override
    public boolean isInteractable() {
        return isInteractable;
    }

    /**
     * Returns a rectangle of sprite's boundaries.
     *
     * @return a rectangle of sprite's boundaries
     */
    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(
                tileImageView.getX(),
                tileImageView.getY(),
                tileImageView.getBoundsInParent().getWidth(),
                tileImageView.getBoundsInParent().getHeight()
        );
    }
    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Furniture{");
        sb.append("furnitureName=").append(furnitureName);
        sb.append(", xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", isInteractable=").append(isInteractable());
        sb.append(", interactable=").append(isInteractable());
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
        if (!(object instanceof Furniture furniture)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        return Double.compare(xCoordinate, furniture.xCoordinate) == 0
                && Double.compare(yCoordinate, furniture.yCoordinate) == 0
                && isInteractable == furniture.isInteractable
                && furnitureName == furniture.furnitureName;
    }

    /**
     * Returns the hashcode representation of the object.
     *
     * @return the hashcode of the object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), furnitureName, xCoordinate, yCoordinate, isInteractable);
    }
}
