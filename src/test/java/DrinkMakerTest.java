import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrinkMakerTest {

    private MachineDriver driver;

    @Before
    public void setUp() {
        driver = mock(MachineDriver.class);
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_without_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(coffeeWithoutSugar());

        verify(driver).send("C::");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_one_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(coffeeWithSugar(1));

        verify(driver).send("C:1:0");
    }

    @Test
    public void should_send_the_order_to_serve_a_coffee_with_two_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(coffeeWithSugar(2));

        verify(driver).send("C:2:0");
    }


    @Test
    public void should_send_the_order_to_serve_a_extra_hot_coffee() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(extraHotCoffeeWithoutSugar());

        verify(driver).send("Ch::");
    }

    @Test
    public void should_send_the_order_to_serve_a_tea_without_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(teaWithoutSugar());

        verify(driver).send("T::");
    }

    @Test
    public void should_send_the_order_to_serve_a_tea_with_one_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(teaWithSugar(1));

        verify(driver).send("T:1:0");
    }

    @Test
    public void should_send_the_order_to_serve_a_extra_hot_tea() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(extraHotTeaWithoutSugar());

        verify(driver).send("Th::");
    }

    @Test
    public void should_send_the_order_to_serve_a_chocolate_without_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(chocolateWithoutSugar());

        verify(driver).send("H::");
    }

    @Test
    public void should_send_the_order_to_serve_a_chocolate_with_one_sugar() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(chocolateWithSugar(1));

        verify(driver).send("H:1:0");
    }


    @Test
    public void should_send_the_order_to_serve_a_extra_hot_chocolate() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.serve(extraHotChocolateWithoutSugar());

        verify(driver).send("Hh::");
    }

    @Test
    public void should_send_the_message_to_the_user() {
        DrinkMaker drinkMaker = drinkMaker();

        drinkMaker.message("a Message");

        verify(driver).send("M:a Message");
    }

    private DrinkMaker drinkMaker() {
        return new DrinkMaker(driver);
    }

    private Order coffeeWithoutSugar() {
        return coffeeWithSugar(0);
    }

    private Order coffeeWithSugar(int numberOfSugars) {
        return new Coffee(numberOfSugars, false);
    }

    private Order extraHotCoffeeWithoutSugar() {
        return new Coffee(0, true);
    }

    private Order teaWithoutSugar() {
        return teaWithSugar(0);
    }

    private Order teaWithSugar(int numberOfSugars) {
        return new Tea(numberOfSugars, false);
    }

    private Order extraHotTeaWithoutSugar() {
        return new Tea(0, true);
    }

    private Order chocolateWithoutSugar() {
        return chocolateWithSugar(0);
    }

    private Chocolate chocolateWithSugar(int numberOfSugars) {
        return new Chocolate(numberOfSugars, false);
    }

    private Order extraHotChocolateWithoutSugar() {
        return new Chocolate(0, true);
    }
}
