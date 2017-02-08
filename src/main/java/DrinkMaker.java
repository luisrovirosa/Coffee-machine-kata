public class DrinkMaker {
    private final MachineDriver driver;

    public DrinkMaker(MachineDriver driver) {
        this.driver = driver;
    }

    public void serve(Order order) {
        driver.send(command(order));
    }

    private String command(Order order) {
        return productCommand(order) + ":" + numberOfSugars(order) + ":" + stickCommand(order);
    }

    public void message(String text) {
        driver.send("M:" + text);
    }

    private String productCommand(Order order) {
        String command;
        if (order instanceof Coffee) {
            command = "C";
        } else if (order instanceof Tea) {
            command = "T";
        } else if (order instanceof Chocolate){
            command = "H";
        } else {
            command = "O";
        }
        command = order.isExtraHot() ? command + 'h' : command;
        return command;
    }

    private String stickCommand(Order order) {
        return order.containsSugar() ? "0" : "";
    }

    private String numberOfSugars(Order order) {
        return order.containsSugar() ? String.valueOf(order.numberOfSugars()) : "";
    }

}
