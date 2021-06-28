package akvelon_task_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BalanceVerificatorTest {

    @Test
    public void shouldBePassedTestOne() {
        BalanceVerificator verificator = new BalanceVerificator();

        assertEquals(-1, verificator.verify("{[()]}"));
    }

    @Test
    public void shouldBePassedTestTwo() {
        BalanceVerificator verificator = new BalanceVerificator();

        assertEquals(-1, verificator.verify("{{[[(())]]}}"));
    }

    @Test
    public void shouldBeNotPassed() {
        BalanceVerificator verificator = new BalanceVerificator();

        assertEquals(3, verificator.verify("{[(]}"));
    }

    @Test
    public void whenOpenBracketsAtEndShouldBeNotPassed() {
        BalanceVerificator verificator = new BalanceVerificator();

        assertEquals(2, verificator.verify("{[()]}{{"));
    }

    @Test
    public void whenCharNotBracketShouldThrowException() {
        BalanceVerificator verificator = new BalanceVerificator();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> verificator.verify("s[]")
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "The string must have only characters: [, ], {, }, (, )";

        assertEquals(expectedMessage, actualMessage);
    }
}