public class CoffeeMachine {
    private final MachineDriver driver;

    public CoffeeMachine(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        if (order.numberOfSugars() == 0) {
            driver.send("C::");
        } else {
            driver.send("C:" + numberOfSugars(order) + ":0");
        }
    }

    private String numberOfSugars(Order order) {
        return String.valueOf(order.numberOfSugars());
    }
}
