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
    public void send_the_order_to_prepare_a_coffee_when_there_is_enough_money(){
        verifyIsValidOrder(PRICE_OF_COFFEE, new Coffee(0));
    }

    @Test
    public void do_not_send_the_order_to_prepare_a_coffee_when_there_is_no_enough_money(){
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(0.39);

        Order order = new Coffee(0);
        machine.serve(order);

        verify(drinkMaker, never()).serve(order);
    }

    @Test
    public void send_a_message_with_the_missing_amount(){
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(0.30);

        Order order = new Coffee(0);
        machine.serve(order);

        verify(drinkMaker).message(contains("0,1 euros"));
    }

    private void verifyIsValidOrder(double payedAmount, Order order) {
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(payedAmount);

        machine.serve(order);

        verify(drinkMaker).serve(order);
    }
}
