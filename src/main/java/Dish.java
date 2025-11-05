public class Dish {
    private final String dishName;
    private final DishType dishType;
    private final double price;


    public Dish(String dishName, DishType dishType, double price) {
        this.dishName = dishName;
        this.dishType = dishType;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public DishType getDishType() {
        return dishType;
    }

    public double getPrice() {
        return price;
    }
}
