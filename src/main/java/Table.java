import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Table.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Table extends Tile implements Interactable {
    /**
     * Maximum number of people the table can hold.
     */
    public static final int MAXIMUM_TABLE_SIZE = 1;
    /**
     * the table size.
     */
    public static final int TABLE_SIZE = 50;
    /**
     * Dish offset x coordinate.
     */
    public static final int DISH_X_OFFSET = 5;
    /**
     * Dish offset y coordinate.
     */
    public static final int DISH_Y_OFFSET = 10;
    /**
     * The price of a meal.
     */
    public static final double PRICE_OF_A_MEAL = 24.50;
    private int tableSize;
    private List<Customer> seatedCustomers;
    private boolean isFull;
    private Dish placedDish;
    private double xCoordinate;
    private double yCoordinate;

    /**
     * Constructs a table class.
     *
     * @param xCoordinate the table x coordinate
     * @param yCoordinate the table y coordinate
     * @param isCollision if the table is solid
     */
    protected Table(final double xCoordinate,
                    final double yCoordinate,
                    final boolean isCollision) {
        super(new Image("file:src/main/resources/table.png"), isCollision);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isFull = false;
        this.seatedCustomers = new ArrayList<>();
        this.getTileImageView().setX(xCoordinate);
        this.getTileImageView().setY(yCoordinate);
        this.getTileImageView().setFitWidth(TABLE_SIZE);
        this.getTileImageView().setFitHeight(TABLE_SIZE);
        this.tableSize = MAXIMUM_TABLE_SIZE;

    }

    /**
     * Return the table x Coordinate.
     *
     * @return table x coordinate
     */
    public double getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Return the table y Coordinate.
     *
     * @return table y coordinate
     */
    public double getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Add the customer to the list of seated customers.
     *
     * @param customer to be added
     */
    public void addCustomer(final Customer customer) {
        seatedCustomers.add(customer);
        this.isFull = true;
    }

    /**
     * Return true if the number of seated customers is equal to table size.
     *
     * @return if the seated customers is the is at max.
     */
    public boolean isAtMax() {
        if (seatedCustomers.size() == this.tableSize) {
            return true;
        }
        return false;
    }

    /**
     * Return if the table has customer.
     *
     * @return if the table has customer
     */
    public boolean hasCustomer() {
        return this.isFull;
    }


    /**
     * Remove the customer from the list.
     *
     * @param customer to be removed
     */
    public void removeCustomer(final Customer customer) {
        this.seatedCustomers.remove(customer);
        this.isFull = false;
    }


    /**
     * Return true if the table has a dish, otherwise false.
     *
     * @return is the table has a dish
     */
    public boolean hasDish() {
        if (this.placedDish != null) {
            return true;
        }
        return false;
    }

    /**
     * Place the dish on the tables coordinates if the table has a customer.
     *
     * @param dish to be placed
     */
    public void placeDish(final Dish dish) {
        if (this.hasCustomer()) {
            this.placedDish = dish;
            dish.setXCoordinate(this.getXCoordinate() + DISH_X_OFFSET);
            dish.setYCoordinate(this.getYCoordinate() - DISH_Y_OFFSET);
        }
        System.out.println("this table has no customer");

    }

    /**
     * Return the placed dish.
     *
     * @return the placed dish.
     */
    public Dish getDish() {
        return placedDish;
    }

    /**
     * Sets the placedDish to null.
     */
    public void removeDish() {
        placedDish = null;
    }

    /**
     * Returns true since the table is interactable.
     *
     * @return true
     */
    @Override
    public boolean isInteractable() {
        return true;
    }

    /**
     * If the waiter is carrying a customer, interact will seat the customer.
     * If the waiter is carrying a dish, they will place the dish.
     * After the dish has been placed, the waiter's income increases.
     *
     * @param waiter that will interact with the object
     * @return the correct confirmation string.
     */
    @Override
    public String interact(final Waiter waiter) {
        if (waiter.isCarryingCustomer()) {
            boolean seated = waiter.seatCustomerAtTable(this);
            if (seated) {
                return "Customer seated!\n"
                        + "Go grab the dish they ordered from the kitchen.";
            }
            return "";
        }
        if (waiter.isCarryingDish()) {

            if (!this.hasDish() && this.isFull) {
                Dish dish = waiter.getCarriedDish();
                this.placeDish(dish);
                waiter.deleteDish();
                waiter.addIncome(PRICE_OF_A_MEAL);

                return "The customer thanks you for bring the dish!\n"
                        + "Your day's total income is: "
                        + waiter.getCurrentIncome();

            } else {
                return "This table already has a dish or there is no customer here!";
            }
        }
        return "";
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Table{");
        sb.append("tableSize=").append(tableSize);
        sb.append(", seatedCustomers=").append(seatedCustomers);
        sb.append(", isFull=").append(isFull);
        sb.append(", placedDish=").append(placedDish);
        sb.append(", xCoordinate=").append(xCoordinate);
        sb.append(", yCoordinate=").append(yCoordinate);
        sb.append(", XCoordinate=").append(getXCoordinate());
        sb.append(", YCoordinate=").append(getYCoordinate());
        sb.append(", hasCustomer=").append(hasCustomer());
        sb.append(", dish=").append(getDish());
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
        if (!(object instanceof Table table)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        return tableSize == table.tableSize
                && isFull == table.isFull
                && Double.compare(xCoordinate, table.xCoordinate) == 0
                && Double.compare(yCoordinate, table.yCoordinate) == 0
                && Objects.equals(seatedCustomers, table.seatedCustomers)
                && Objects.equals(placedDish, table.placedDish);
    }
    /**
     * Returns the hashcode representation of the table object.
     *
     * @return the hashcode of the table object as int
     */

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                tableSize,
                seatedCustomers,
                isFull,
                placedDish,
                xCoordinate,
                yCoordinate);
    }
}


