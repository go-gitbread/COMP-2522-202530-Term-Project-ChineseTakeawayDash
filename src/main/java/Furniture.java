import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Furniture extends Tile implements Interactable {
    public static final int TILE_SIZE = 50;
    private final FurnitureName furnitureName;
    private final double xCoordinate;
    private final double yCoordinate;
    private boolean isInteractable;

    public Furniture(double xCoordinate, double yCoordinate, Boolean isCollision, FurnitureName furnitureName) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.furnitureName = furnitureName;
        switch (this.furnitureName) {
            case FurnitureName.FRYER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/fryer.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE + 10);
                this.getTileImageView().setFitHeight(TILE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureName.HORIZONTAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(100);
                this.getTileImageView().setFitHeight(TILE_SIZE);
                this.isInteractable = false;
            }
            case FurnitureName.VERTICAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/vertical_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(80);
                this.isInteractable = true;
            }
            case FurnitureName.SHELF -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/shelf.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(80);
                this.isInteractable = true;
            }
            case FurnitureName.STOVE -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/stove.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(TILE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureName.SINK -> {
                this.setTileImage(new Image("file:src/main/resources/kitchen/sink.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(TILE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureName.INSTRUCTIONS_BOOK -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/instructions_book.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE / 2.0);
                this.getTileImageView().setFitHeight(TILE_SIZE / 2.0);
                this.isInteractable = true;
            }
            case FurnitureName.BOXES -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/boxes.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE + 15);
                this.getTileImageView().setFitHeight(TILE_SIZE + 15);
                this.isInteractable = true;
            }
            case FurnitureName.PLANTS -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/plants.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(TILE_SIZE);
                this.isInteractable = true;
            }
            case FurnitureName.COW_PAINTING -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/cow_painting.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(38);
                this.getTileImageView().setFitHeight(38);
                this.isInteractable = true;
            }
            case FurnitureName.MOUNTAIN_PAINTING -> {
                this.setTileImage(new Image("file:src/main/resources/furniture/mountain_painting.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(38);
                this.isInteractable = true;
            }
            default -> {
                this.isInteractable = false;
                System.out.println("error, no furniture");
            }

        }
    }


    @Override
    public void interact(Waiter waiter) {
        switch (furnitureName) {
            case STOVE:
                System.out.println("this a stove");
                break;
            case FRYER:
                System.out.println("this a fryer...");
                break;
            case SINK:
                System.out.println("dishes!");
                break;
            case SHELF:
                System.out.println("shelf of food");
                break;
            case INSTRUCTIONS_BOOK:
                System.out.println("print out the dialopoghue here");
                break;
            case COW_PAINTING:
                System.out.println("cow  painitng");
                break;
            case MOUNTAIN_PAINTING:
                System.out.println("mountian painitng");
                break;
            case BOXES:
                System.out.println("this a stack of boxes");
                break;
            case PLANTS:
                System.out.println("some plants");
                break;
            default:
                System.out.println("nothing here");
        }

    }

    @Override
    public boolean isInteractable() {
        return isInteractable;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
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
