public class Chocolate extends Order {
    private final int numberOfSugars;

    public Chocolate(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
