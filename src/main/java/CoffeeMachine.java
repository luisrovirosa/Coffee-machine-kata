public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void pay(double amount) {

    }

    public void serve(Order order) {
        drinkMaker.serve(order);

    }
}
