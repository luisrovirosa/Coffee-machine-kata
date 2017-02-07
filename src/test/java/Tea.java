public class Tea implements Order {
    private final int numberOfSugars;

    public Tea(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
