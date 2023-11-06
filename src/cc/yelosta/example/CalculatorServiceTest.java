package cc.yelosta.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    public void testCalculateDivision() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final int actual = calculatorService.calculate('/', 8, 4);
        assertThat(actual).isEqualTo(2);
    }
    @Test
    public void testCalculateMultiplication() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final int actual = calculatorService.calculate('*', 1, 1);
        assertThat(actual).isEqualTo(1);
    }
    @Test
    public void testCalculateSubtraction() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final int actual = calculatorService.calculate('-', 1, 1);
        assertThat(actual).isEqualTo(0);
    }
    @Test
    public void testCalculateAddition() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final int actual = calculatorService.calculate('+', 1, 1);
        assertThat(actual).isEqualTo(2);
    }
}