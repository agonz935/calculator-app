package Test;

import calculator.model.CalculatorModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorModelTest {

    @Test
    public void testAdd() {
        CalculatorModel model = new CalculatorModel();

        model.setFirstOperand(50);
        model.setSecondOperand(10);
        model.setOperator('+');

        model.calculate();

        double result = model.getResult();

        assertEquals(60, result);

    }

}