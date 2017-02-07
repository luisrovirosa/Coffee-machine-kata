import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    public static final double PRICE_OF_COFFEE = 0.6;
    public static final double PRICE_OF_TEA = 0.4;
    public static final double PRICE_OF_CHOCOLATE = 0.5;
    public static final double PRICE_OF_ORANGE = 0.6;
    private DrinkMaker drinkMaker;

    @Before
    public void setUp() throws Exception {
        drinkMaker = mock(DrinkMaker.class);
    }

    @Test
    public void send_the_order_to_prepare_an_order_when_there_is_enough_money() {
        for (Map.Entry<Order, Double> entry : validOrders().entrySet()) {
            Order order = entry.getKey();
            double price = entry.getValue();
            verifyServeOrder(price, order);
        }
    }

    @Test
    public void do_not_send_the_order_to_prepare_an_order_when_there_is_no_enough_money() {
        for (Map.Entry<Order, Double> entry : validOrders().entrySet()) {
            Order order = entry.getKey();
            double price = entry.getValue() - 0.1;
            verifyDoNotServeOrder(price, order);
        }
    }

    @Test
    public void send_a_message_with_the_missing_amount() {
        verifyMessageIsSentWith(0.40, new Coffee(0), "0,2 euros");
    }

    @Test
    public void send_a_message_with_the_missing_amount_when_prepare_a_tea_without_enough_money() {
        verifyMessageIsSentWith(0.30, new Tea(0), "0,1 euros");
    }

    @Test
    public void send_a_message_with_the_missing_amount_when_prepare_a_chocolate_without_enough_money() {
        verifyMessageIsSentWith(0.30, new Chocolate(0), "0,2 euros");
    }

    private HashMap<Order, Double> validOrders() {
        HashMap<Order, Double> validOrders = new HashMap<Order, Double>();
        validOrders.put(new Coffee(0), PRICE_OF_COFFEE);
        validOrders.put(new Tea(0), PRICE_OF_TEA);
        validOrders.put(new Chocolate(0), PRICE_OF_CHOCOLATE);
        validOrders.put(new Orange(0), PRICE_OF_ORANGE);
        return validOrders;
    }

    private void verifyServeOrder(double payedAmount, Order order) {
        serveOrderWithPayment(payedAmount, order);

        verify(drinkMaker).serve(order);
    }

    private void verifyDoNotServeOrder(double payedAmount, Order order) {
        serveOrderWithPayment(payedAmount, order);

        verify(drinkMaker, never()).serve(order);
    }

    private void verifyMessageIsSentWith(double payedAmount, Order order, String message) {
        serveOrderWithPayment(payedAmount, order);

        verify(drinkMaker).message(contains(message));
    }

    private void serveOrderWithPayment(double payedAmount, Order order) {
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(payedAmount);

        machine.serve(order);
    }
}
