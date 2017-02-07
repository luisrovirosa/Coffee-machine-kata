public class CoffeeMachine {
    private final MachineDriver driver;

    public CoffeeMachine(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        driver.send("C:" + numberOfSugars(order) + ":" + stickCommand(order));
    }

    private String stickCommand(Order order) {
        return order.numberOfSugars() > 0 ? "0" : "";
    }

    private String numberOfSugars(Order order) {
        return order.numberOfSugars() > 0 ? String.valueOf(order.numberOfSugars()) : "";
    }
}
