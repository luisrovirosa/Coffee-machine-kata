import org.junit.Test;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {
    @Test
    public void send_the_order_to_prepare_a_coffee_when_there_is_enough_money(){
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(0.4);

        Order order = new Coffee(0);
        machine.serve(order);

        verify(drinkMaker).serve(order);
    }

    @Test
    public void do_not_send_the_order_to_prepare_a_coffee_when_there_is_no_enough_money(){
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(0.39);

        Order order = new Coffee(0);
        machine.serve(order);

        verify(drinkMaker, never()).serve(order);
    }

    @Test
    public void send_a_message_with_the_missing_amount(){
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        CoffeeMachine machine = new CoffeeMachine(drinkMaker);
        machine.pay(0.30);

        Order order = new Coffee(0);
        machine.serve(order);

        verify(drinkMaker).message(contains("0,1 euros"));
    }
}
