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
                return "This is the stove. It's hot!";
            case DESK:
                return "A tidy desk with some papers on it.";
            case FRYER:
                return "The fryer is bubbling with oil.";
            case SINK:
                return "Dirty dishes pile up in the sink.";
            case SHELF:
                return "A shelf full of ingredients.";
            case INSTRUCTIONS_BOOK:
                return "“Welcome to the diner!\nPress E to continue...”";
            case COW_PAINTING:
                return "A cute cow painting. Moo!";
            case MOUNTAIN_PAINTING:
                return "A peaceful mountain landscape.";
            case BOXES:
                return "A stack of boxes full of supplies.";
            case PLANTS:
                return "Some lovely green plants.";
            default:
                return "none";
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
