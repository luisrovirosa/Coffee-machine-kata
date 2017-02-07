public class Coffee extends Order {
    private final int numberOfSugars;

    public Coffee(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
