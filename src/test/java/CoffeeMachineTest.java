import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    public static final double PRICE_OF_COFFEE = 0.4;
    private DrinkMaker drinkMaker;

    @Before
    public void setUp() throws Exception {
        drinkMaker = mock(DrinkMaker.class);
    }

    @Test
    public void send_the_order_to_prepare_a_coffee_when_there_is_enough_money() {
        verifyServeOrder(PRICE_OF_COFFEE, new Coffee(0));
    }

    @Test
    public void do_not_send_the_order_to_prepare_a_coffee_when_there_is_no_enough_money() {
        verifyDoNotServeOrder(PRICE_OF_COFFEE - 0.1, new Coffee(0));
    }

    @Test
    public void send_a_message_with_the_missing_amount() {
        verifyMessageIsSentWith(0.30, new Coffee(0), "0,1 euros");
    }

    private void verifyServeOrder(double payedAmount, Order order) {
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(payedAmount);

        machine.serve(order);

        verify(drinkMaker).serve(order);
    }

    private void verifyDoNotServeOrder(double payedAmount, Order order) {
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(payedAmount);

        machine.serve(order);

        verify(drinkMaker, never()).serve(order);
    }

    private void verifyMessageIsSentWith(double amount, Order order, String message) {
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(amount);

        machine.serve(order);

        verify(drinkMaker).message(contains(message));
    }
}
