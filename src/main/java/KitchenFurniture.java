import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class KitchenFurniture extends Tile {
    public static final int TILE_SIZE = 50;
    private final FurnitureName furnitureName;
    private final double xCoordinate;
    private final double yCoordinate;

    public KitchenFurniture(double xCoordinate, double yCoordinate, Boolean isCollision, FurnitureName furnitureName) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.furnitureName = furnitureName;
        switch (this.furnitureName) {
            case FurnitureName.FRYER -> {
                this.setTileImage(new Image("file:src/main/resources/fryer.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE + 10);
                this.getTileImageView().setFitHeight(TILE_SIZE);
            }
            case FurnitureName.HORIZONTAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/horizontal_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(100);
                this.getTileImageView().setFitHeight(TILE_SIZE);
            }
            case FurnitureName.VERTICAL_COUNTER -> {
                this.setTileImage(new Image("file:src/main/resources/vertical_counter.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(80);
            }
            case FurnitureName.SHELF -> {
                this.setTileImage(new Image("file:src/main/resources/shelf.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(80);
            }
            case FurnitureName.STOVE -> {
                this.setTileImage(new Image("file:src/main/resources/stove.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(TILE_SIZE);
            }
            case FurnitureName.SINK -> {
                this.setTileImage(new Image("file:src/main/resources/sink.png"));
                this.setTileImageView(new ImageView(this.getTileImage()));
                this.getTileImageView().setX(xCoordinate);
                this.getTileImageView().setY(yCoordinate);
                this.getTileImageView().setFitWidth(TILE_SIZE);
                this.getTileImageView().setFitHeight(TILE_SIZE + 20);
            }
            default -> System.out.println("error, no furniture");
        }

    }

}
