import java.util.List;

public class Restaurant {
    private final String restaurantName;
    private final List<Customer> customerList;
    private final Waiter waiter;
    private final List<Table> tables;

    public Restaurant(String restaurantName, List<Customer> customerList, Waiter waiter, List<Table> tables) {
        this.restaurantName = restaurantName;
        this.customerList = customerList;
        this.waiter = waiter;
        this.tables = tables;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public List<Table> getTables() {
        return tables;
    }
}
