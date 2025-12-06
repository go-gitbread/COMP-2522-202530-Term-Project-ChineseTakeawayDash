import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Table extends Tile {

    private List<Customer> seatedCustomers;
    private boolean isFull;
    private boolean isClean;
    private double xCoordinate;
    private double yCoordinate;
    public static final int TILE_SIZE = 50;
    /**
     * Constructs a Sprite object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Table(double xCoordinate, double yCoordinate, boolean isCollision) {
        super(new Image("file:src/main/resources/table.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isClean = true;
        this.isFull = false;
        this.seatedCustomers = new ArrayList<>();
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(TILE_SIZE);
        this.getTileImageView().setFitHeight(TILE_SIZE);


    }

}
