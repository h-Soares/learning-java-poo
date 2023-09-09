import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void sumTwoNumbers() {
        int result = calculator.sum(3, 1);
        Assertions.assertEquals(4, result);
    }

    @Test
    void subtractTwoNumbers() {
        int result = calculator.subtract(3, 5);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void multiplyTwoNumbers() {
        int result = calculator.multiply(3, 4);
        Assertions.assertEquals(12, result);
    }

    @Test
    void ifDivideByZeroThrowsArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0),
                "/ by zero");
    }

    @Test
    void divideTwoNumbers() {
        int result = calculator.divide(72, 9);
        Assertions.assertEquals(8, result);
    }
}