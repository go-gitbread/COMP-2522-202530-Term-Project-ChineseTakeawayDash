import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Represents a Customer.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Customer extends Tile implements Interactable {
    /**
     * Customer size.
     */
    public static final int CUSTOMER_SIZE = 25;
    /**
     * Offset for the customer to sit.
     */
    public static final int CUSTOMER_SIT_OFFSET = 35;
    private CustomerState customerState;
    private Table assignedTable;
    private boolean hasFood;
    private boolean orderReady;
    private double xCoordinate;
    private double yCoordinate;
    private final boolean isInteractable;

    /**
     * Constructs a Customer object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Customer(final double xCoordinate, final double yCoordinate) {
        super(new Image("file:src/main/resources/chicken.png"), true);
        this.customerState = CustomerState.WAITING_FOR_SEAT;
        this.setTileImageView(new ImageView(this.getTileImage()));
        this.getTileImageView().setFitWidth(CUSTOMER_SIZE);
        this.getTileImageView().setFitHeight(CUSTOMER_SIZE);

        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);

        this.isInteractable = true;
    }

    /**
     * Set the Customer's X coordinate to the new xCoordinate.
     *
     * @param newXCoordinate as a double.
     */
    public void setXCoordinate(final double newXCoordinate) {
        this.xCoordinate = newXCoordinate;
        this.getTileImageView().setX(this.xCoordinate);

    }

    /**
     * Set the Customer's y coordinate to the new yCoordinate.
     *
     * @param newYCoordinate as a double.
     */
    public void setYCoordinate(final double newYCoordinate) {
        this.yCoordinate = newYCoordinate;
        this.getTileImageView().setY(this.yCoordinate);
    }


    /**
     * Return the current state of the customer.
     *
     * @return the current state of customer
     */
    public CustomerState getState() {
        return this.customerState;
    }

    /**
     * Sets customer state to the new state.
     *
     * @param newCustomerState sets state to the new state
     */
    public void setState(final CustomerState newCustomerState) {
        this.customerState = newCustomerState;
    }

    /**
     * Assigns a table to the customer.
     *
     * @param table to assign the customer
     */
    public void assignTable(final Table table) {
        this.assignedTable = table;
    }

    /**
     * Returns the assigned table.
     *
     * @return the assigned table
     */
    public Table getAssignedTable() {
        return this.assignedTable;
    }

    /**
     * Sits the customer down at the table.
     */
    public void sitDown() {
        if (assignedTable != null) {
            customerState = CustomerState.SEATED;
            this.setXCoordinate(assignedTable.getXCoordinate() - CUSTOMER_SIT_OFFSET);
            this.setYCoordinate(assignedTable.getYCoordinate());
        }

    }


    /**
     * Updates the customer's state accordingly for getting food.
     */
    public void receiveFood() {
        if (customerState == CustomerState.WAITING_FOR_FOOD) {
            customerState = CustomerState.EATING;
        }
    }

    /**
     * Return is the customer is in finished state.
     *
     * @return if the customer is finished
     */
    public boolean isFinished() {
        return customerState == CustomerState.FINISHED;
    }


    /**
     * Sets customer state to leave.
     */
    public void leave() {
        customerState = CustomerState.LEAVING;
    }

    /**
     * Updates the states of the customer.
     * Triggers teh waiter to pick up the customer.
     *
     * @param waiter that will interact with the object
     * @return empty String.
     */
    @Override
    public String interact(final Waiter waiter) {
        if (customerState != CustomerState.WAITING_FOR_SEAT) {
            return "";
        }

        if (waiter.isCarryingCustomer()) {
            return "";
        }

        waiter.pickUpCustomer(this);
        this.customerState = CustomerState.BEING_CARRIED;

        System.out.println("Customer picked up!");
        return "";
    }

    /**
     * Returns true as all customers are interactable.
     *
     * @return true
     */
    @Override
    public boolean isInteractable() {
        return true;
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Customer{");
        sb.append("customerState=").append(customerState);
        sb.append(", assignedTable=").append(getAssignedTable());
        sb.append(", hasFood=").append(hasFood);
        sb.append(", orderReady=").append(orderReady);
        sb.append(", xCoordinate=").append(xCoordinate);
        sb.append(", yCoordinate=").append(yCoordinate);
        sb.append(", isInteractable=").append(isInteractable());
        sb.append(", state=").append(getState());
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
        if (!(object instanceof Customer customer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        return hasFood == customer.hasFood
                && orderReady == customer.orderReady
                && Double.compare(xCoordinate, customer.xCoordinate) == 0
                && Double.compare(yCoordinate, customer.yCoordinate) == 0
                && isInteractable == customer.isInteractable
                && customerState == customer.customerState
                && Objects.equals(assignedTable, customer.assignedTable);
    }

    /**
     * Returns the hashcode representation of the object.
     *
     * @return the hashcode of the object as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                customerState,
                assignedTable,
                hasFood,
                orderReady,
                xCoordinate,
                yCoordinate,
                isInteractable);
    }
}
