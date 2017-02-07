import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {

    private MachineDriver driver;

    @Before
    public void setUp(){
        driver = mock(MachineDriver.class);
    }
    @Test
    public void should_send_the_order_to_serve_a_coffee_without_sugar(){
        CoffeeMachine machine = machine();

        machine.serve(coffeeWithoutSugar());

        verify(driver).send("C::");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_one_sugar(){
        CoffeeMachine machine = machine();

        machine.serve(coffeeWithSugar(1));

        verify(driver).send("C:1:0");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_two_sugar(){
        CoffeeMachine machine = machine();

        machine.serve(coffeeWithSugar(2));

        verify(driver).send("C:2:0");
    }

    private CoffeeMachine machine() {
        return new CoffeeMachine(driver);
    }

    private Order coffeeWithoutSugar() {
        return coffeeWithSugar(0);
    }

    private Order coffeeWithSugar(int numberOfSugars) {
        return new Coffee(numberOfSugars);
    }
}
