import org.junit.Test;

import static org.mockito.Mockito.mock;
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
}
