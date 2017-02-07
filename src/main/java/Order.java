abstract public class Order {
    protected final int numberOfSugars;

    public Order(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
