public class Order {
    private final Dish dish;
    private final OrderStatus orderStatus;
    private final Boolean isCompleted;
    private final Boolean isPaidFor;


    public Order(Dish dish, OrderStatus orderStatus, Boolean isCompleted, Boolean isPaidFor) {
        this.dish = dish;
        this.orderStatus = orderStatus;
        this.isCompleted = isCompleted;
        this.isPaidFor = isPaidFor;
    }

    public Dish getDish() {
        return dish;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public Boolean getPaidFor() {
        return isPaidFor;
    }
}
