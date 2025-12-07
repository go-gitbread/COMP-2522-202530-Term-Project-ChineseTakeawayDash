import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Customer extends Tile implements Interactable {
    private CustomerState customerState;
    private Table assignedTable;
    private boolean hasFood;
    private boolean orderReady;
    private double moneyToPay;
    private double xCoordinate;
    private double yCoordinate;
    public static final int CUSTOMER_SIZE = 28;
    private final boolean isInteractable;
    /**
     * Constructs a Sprite object.
     *
     * @param xCoordinate represents the xCoordinate coordinate value as a double
     * @param yCoordinate represents the yCoordinate coordinate value as a double
     */
    protected Customer(double xCoordinate, double yCoordinate) {
        super(new Image("file:src/main/resources/chicken.png"), true);

        this.customerState = CustomerState.WAITING_FOR_SEAT;
        this.moneyToPay = 100.0;

        this.setTileImageView(new ImageView(this.getTileImage()));
        this.getTileImageView().setFitWidth(CUSTOMER_SIZE);
        this.getTileImageView().setFitHeight(CUSTOMER_SIZE);

        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);

        this.isInteractable = true;
    }

    public CustomerState getState() {
        return this.customerState;
    }
    public void setState(CustomerState customerState) {
        this.customerState = customerState;
    }

    public void assignTable(Table table) {
        this.assignedTable = table;
    }

    public Table getAssignedTable() {
        return this.assignedTable;
    }

    public void sitDown() {
        if (assignedTable != null) {
            customerState = CustomerState.SEATED;
            this.setXCoordinate(assignedTable.getXCoordinate() - 40);
            this.setYCoordinate(assignedTable.getYCoordinate());
        }

    }



    public void receiveFood() {
        if (customerState == CustomerState.WAITING_FOR_FOOD) {
            customerState = CustomerState.EATING;
        }
    }
    public boolean isFinished() {
        return customerState == CustomerState.FINISHED;
    }

    public double getMoneyToPay() {
        return this.moneyToPay;
    }

    public void leave() {
        customerState = CustomerState.LEAVING;
    }

    @Override
    public String interact(Waiter waiter) {
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

    @Override
    public boolean isInteractable() {
        return true;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
        this.getTileImageView().setX(xCoordinate);

    }
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
        this.getTileImageView().setY(yCoordinate);
    }



}
