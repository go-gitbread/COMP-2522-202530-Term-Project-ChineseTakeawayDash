import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Table extends Sprite {
    private List<Customer> seatedCustomers;
    private Boolean isFull;
    private Boolean isClean;
    private double xCoordinate;
    private double yCoordinate;

    /**
     * Constructs a Sprite object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Table(double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate, new Image("file:src/main/resources/table.png"));
        this.isClean = true;
        this.isFull = false;
        this.seatedCustomers = new ArrayList<>();
    }



}
