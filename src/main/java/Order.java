abstract public class Order {
    protected final int numberOfSugars;
    private double price;
    private final boolean isExtraHot;

    public Order(int numberOfSugars, double price, boolean isExtraHot) {
        this.numberOfSugars = numberOfSugars;
        this.price = price;
        this.isExtraHot = isExtraHot;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }

    double getOrderPrice() {
        return price;
    }

    public boolean isExtraHot() {
        return isExtraHot;
    }
}
