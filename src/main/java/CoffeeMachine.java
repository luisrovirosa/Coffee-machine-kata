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
        if (amount >= 0.4){
            drinkMaker.serve(order);
        } else {
            DecimalFormat format = new DecimalFormat("#.#");
            String missingAmount = format.format(0.4 - amount);
            drinkMaker.message(missingAmount + " euros");
        }

    }
}
