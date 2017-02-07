public class CoffeeMachine {
    private final MachineDriver driver;

    public CoffeeMachine(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        if (order.numberOfSugars() == 0) {
            driver.send("C::");
        } else {
            driver.send("C:1:0");
        }
    }
}
