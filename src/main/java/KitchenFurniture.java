import javafx.scene.image.Image;

public class KitchenFurniture extends Tile {

    public KitchenFurniture(Image tileImage, boolean isCollision) {
        super(new Image("file:src/main/resources/chair_facing_right.png"), isCollision);
    }
}
