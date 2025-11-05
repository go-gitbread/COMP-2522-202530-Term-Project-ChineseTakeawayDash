public class Waiter extends Person {
    private double currentIncome;


    protected Waiter(String name, int xCoordinate, int yCoordinate, double currentIncome) {
        super(name, xCoordinate, yCoordinate);
        this.currentIncome = currentIncome;
    }

    public double getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(double currentIncome) {
        this.currentIncome = currentIncome;
    }
}
