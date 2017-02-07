abstract public class Order {
    protected final int numberOfSugars;
    private double price;

    public Order(int numberOfSugars, double price) {
        this.numberOfSugars = numberOfSugars;
        this.price = price;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }

    double getOrderPrice() {
        return price;
    }
}
