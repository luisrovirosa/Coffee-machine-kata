public class CoffeeMachine {
    private final MachineDriver driver;

    public CoffeeMachine(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        if (order.numberOfSugars() == 0) {
            driver.send("C::");
        }else if (order.numberOfSugars() == 1) {
            driver.send("C:1:0");
        } else {
            driver.send("C:2:0");
        }
    }
}
