public class Chocolate implements Order {
    private final int numberOfSugars;

    public Chocolate(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
