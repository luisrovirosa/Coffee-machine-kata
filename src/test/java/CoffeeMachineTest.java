import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {
    @Test
    public void should_send_the_order_to_serve_a_coffee_without_sugar(){
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(coffeeWithoutSugar());

        verify(driver).send("C::");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_one_sugar(){
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(coffeeWithSugar(1));

        verify(driver).send("C:1:0");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_two_sugar(){
        MachineDriver driver = mock(MachineDriver.class);
        CoffeeMachine machine = new CoffeeMachine(driver);

        machine.serve(coffeeWithSugar(2));

        verify(driver).send("C:2:0");
    }

    private Order coffeeWithoutSugar() {
        return coffeeWithSugar(0);
    }

    private Order coffeeWithSugar(int numberOfSugars) {
        return new Coffee(numberOfSugars);
    }
}
