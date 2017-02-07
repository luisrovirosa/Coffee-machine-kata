import java.text.DecimalFormat;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private double amount;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void pay(double amount) {
        this.amount = amount;
    }

    public void serve(Order order) {
        if (!(amount >= order.getOrderPrice())) {
            drinkMaker.message(missingAmountMessage(order));
            return;
        }
        drinkMaker.serve(order);
    }

    private String missingAmountMessage(Order order) {
        DecimalFormat format = new DecimalFormat("#.#");
        String missingAmount = format.format(order.getOrderPrice() - amount);
        return missingAmount + " euros";
    }

}
