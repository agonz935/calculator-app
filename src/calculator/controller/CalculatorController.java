package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.addNumberButtonListener(new NumberButtonListener());
        view.addOperatorButtonListener(new OperatorButtonListener());
        view.addEqualsButtonListener(new EqualButtonListener());
        view.addClearButtonListener(new ClearButtonListener());
        view.addDeleteButtonListener(new DeleteButtonListener());
        view.addDecimalButtonListener(new DecimalButtonListener());
        view.addNegativeButtonListener(new NegativeButtonListener());
    }

    private class NumberButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            view.setCurrentText(view.getCurrentText() + source.getText());
        }
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            view.setPreviousText(view.getCurrentText() + " " + source.getText() + " ");
            view.setCurrentText("");
        }
    }

    private class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            view.setPreviousText(view.getPreviousText() + view.getCurrentText());
            String expression = view.getPreviousText();
            String[] stringToCalc = expression.split(" ");

            //Prevent out of bounds
            if (stringToCalc.length == 3) {
                double firstNumber = Double.parseDouble(stringToCalc[0]);
                char operator = stringToCalc[1].charAt(0);
                double secondNumber = Double.parseDouble(stringToCalc[2]);
                model.setFirstOperand(firstNumber);
                model.setSecondOperand(secondNumber);
                model.setOperator(operator);
                model.calculate();
                //Gets rid of decimal if it is zero, up to 15 decimal places.
                String df = new DecimalFormat("#.###############").format(model.getResult());
                view.setCurrentText(df);
            }

        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setCurrentText("");
            view.setPreviousText("");
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!view.getCurrentText().isEmpty()){
                view.setCurrentText(view.getCurrentText().substring(0, view.getCurrentText().length() - 1));
            }
        }
    }

    private class DecimalButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if(!view.getCurrentText().contains(".")){
                view.setCurrentText(view.getCurrentText() + source.getText());
            }
        }
    }

    private class NegativeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getCurrentText().isEmpty()){
                view.setCurrentText("-");
            }else{
                view.setCurrentText("-" + view.getCurrentText());
            }
        }
    }



}