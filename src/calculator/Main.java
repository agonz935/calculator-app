package calculator;

import calculator.controller.CalculatorController;
import calculator.view.CalculatorView;
import calculator.model.CalculatorModel;

public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        view.setVisible(true);
    }
}