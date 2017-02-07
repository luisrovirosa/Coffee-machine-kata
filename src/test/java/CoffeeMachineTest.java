import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {
    @Test
    public void should_send_the_order_to_serve_a_coffee_without_sugar(){
        Order order = new Coffee(0);
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(order);

        verify(driver).send("C::");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_one_sugar(){
        Order order = new Coffee(1);
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(order);

        verify(driver).send("C:1:0");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_two_sugar(){
        Order order = new Coffee(2);
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(order);

        verify(driver).send("C:2:0");
    }
}
