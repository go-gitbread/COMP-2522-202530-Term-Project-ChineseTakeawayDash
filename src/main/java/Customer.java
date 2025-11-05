public class Customer extends Person implements Payee {
    private final Order order;
    private final CustomerSatisfaction customerSatisfaction;
    private final double patienceAmount;

    protected Customer(String name,
                       int xCoordinate,
                       int yCoordinate,
                       Order order,
                       CustomerSatisfaction customerSatisfaction, double patienceAmount) {
        super(name, xCoordinate, yCoordinate);
        this.order = order;
        this.customerSatisfaction = customerSatisfaction;
        this.patienceAmount = patienceAmount;
    }

    // if the order is completed, and buffer time is over, pay
    @Override
    public void pay() {

    }

    //if paid/ or patience runs out, leave
    @Override
    public void leave() {

    }

    public double getPatienceAmount() {
        return patienceAmount;
    }

    public CustomerSatisfaction getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public Order getOrder() {
        return order;
    }
}
