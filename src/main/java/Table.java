import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Table extends Tile implements Interactable {
    private int tableSize;
    private List<Customer> seatedCustomers;
    private boolean isFull;
    private Dish placedDish;
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
        this.isFull = false;
        this.seatedCustomers = new ArrayList<>();
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(TILE_SIZE);
        this.getTileImageView().setFitHeight(TILE_SIZE);
        this.tableSize = 1;

    }

    public void addCustomer(Customer customer) {
        seatedCustomers.add(customer);
        this.isFull = true;
    }

    public boolean isAtMax() {
        if (seatedCustomers.size() == this.tableSize) {
            return true;
        }
        return false;
    }

    public boolean hasCustomer() {
        return this.isFull;
    }

    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }

    public void removeCustomer(Customer customer) {
        this.seatedCustomers.remove(customer);
        this.isFull = false;
    }


    public boolean hasDish() {
        if (this.placedDish != null) {
            return true;
        }
        return false;
    }

    public void placeDish(Dish dish) {
        if (this.hasCustomer()) {
            this.placedDish = dish;
            dish.setXCoordinate(this.getXCoordinate() + 5);
            dish.setYCoordinate(this.getYCoordinate() - 10);
        }
        else {
            System.out.println("this table has no customer");
        }

    }

    public Dish getDish() {
        return placedDish;
    }

    public void removeDish() {
        placedDish = null;
    }
    @Override
    public boolean isInteractable() {
        return true;
    }

    @Override
    public String interact(Waiter waiter) {
        if (waiter.isCarryingCustomer()) {
            boolean seated = waiter.seatCustomerAtTable(this);
            if (seated) {
                return "Customer seated!\n" +
                        "Go grab the dish they ordered from the kitchen.";
            }
            return "";
        }
        if (waiter.isCarryingDish()) {

            if (!this.hasDish() && this.isFull) {
                Dish dish = waiter.getCarriedDish();
                this.placeDish(dish);
                waiter.deleteDish();
                waiter.addIncome(24.50);

                return "The customer thanks you for bring the dish!\n" +
                        "Your day's total income is: " + waiter.getCurrentIncome();

            } else {
                return "This table already has a dish or there is no customer here!";
            }
        }
        return "";
    }
}
