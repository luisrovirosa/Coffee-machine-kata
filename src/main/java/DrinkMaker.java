public class DrinkMaker {
    private final MachineDriver driver;

    public DrinkMaker(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        driver.send(productCommand(order) + ":" + numberOfSugars(order) + ":" + stickCommand(order));
    }

    public void message(String text) {
        driver.send("M:" + text);
    }

    private String productCommand(Order order) {
        if (order instanceof Coffee) {
            return "C";
        } else if (order instanceof Tea) {
            return "T";
        } else {
            return "H";
        }
    }

    private String stickCommand(Order order) {
        return containsSugar(order) ? "0" : "";
    }

    private String numberOfSugars(Order order) {
        return containsSugar(order) ? String.valueOf(order.numberOfSugars()) : "";
    }

    private boolean containsSugar(Order order) {
        return order.numberOfSugars() > 0;
    }
}