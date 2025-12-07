import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Represents a Sprite.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Furniture extends Tile implements Interactable {
    /**
     * The base size of a furniture object.
     */
    public static final int FURNITURE_SIZE = 50;
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
    public Furniture(double xCoordinate, double yCoordinate, Boolean isCollision, FurnitureType furnitureType) {
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
                this.getTileImageView().setFitWidth(FURNITURE_SIZE / 2.0);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE / 2.0);
                this.isInteractable = true;
            }
            case FurnitureType.FRYER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/fryer.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE + 10);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.HORIZONTAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(100);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = false;
            }
            case FurnitureType.DESK -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(100);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.VERTICAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/vertical_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(80);
                this.isInteractable = false;
            }
            case FurnitureType.SHELF -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/shelf.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(80);
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
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureType.BOXES -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/boxes.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE + 15);
                this.getTileImageView().setFitHeight(FURNITURE_SIZE + 15);
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
                this.getTileImageView().setFitWidth(38);
                this.getTileImageView().setFitHeight(38);
                this.isInteractable = true;
            }
            case FurnitureType.MOUNTAIN_PAINTING -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/mountain_painting.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(FURNITURE_SIZE);
                this.getTileImageView().setFitHeight(38);
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

    @Override
    public String interact(Waiter waiter) {
        switch (furnitureName) {
            case STOVE:
                return "This is the stove. Looks like your dad is cooking something. It's hot!";
            case DESK:
                return "Welcome to Lok Lok Garden.\n" +
                        "You just moved to a small town with your family.\n" +
                        "They have opened a restaurant.\n" +
                        "Your parents don't really understand english, so you will have to:\n" +
                        "1. TAKE CUSTOMERS TO A TABLE\n" +
                        "2. TAKE THEIR ORDERS\n" +
                        "3. PICK UP THE DISHES\n" +
                        "3. AND PICK UP THE MONEY FROM THE TABLES\n";
            case FRYER:
                return "Hmmm, the warm smell of egg-rolls and sweet \n" +
                        "and sour chicken balls fills you with grease";
            case SINK:
                return "Dirty dishes pile up in the sink... Ew that's so gross.";
            case SHELF:
                return "Wow there sure are a lot kinds of soy sauces";
            case INSTRUCTIONS_BOOK:
                return "";
            case COW_PAINTING:
                return "A cute cow painting. Moo!\n" +
                        "Reminds you of a nice burger you had at A&W";
            case MOUNTAIN_PAINTING:
                return "A peaceful mountain landscape.\n" +
                        "You hope that one day you can see the real mountains.";
            case BOXES:
                return "A stack of boxes full random supplies...";
            case PLANTS:
                return "Some lovely green plants.\n" +
                        "You're 90% sure that one of them are fake...";
            default:
                return "";
        }

    }

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

}
