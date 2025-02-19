package calculator.model;


import static java.lang.Math.sqrt;

public class CalculatorModel {
    private double firstOperand;
    private double secondOperand;
    private double result;
    private char operator;

    //Set first number
    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    //Set second number
    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    //Set operation we want to run
    public void setOperator(char operator) {
        this.operator = operator;
    }

    //Compute
    public void calculate() {
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case 'x':
                result = firstOperand * secondOperand;
                break;
            case '÷':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    result = Double.NaN;
                }
                break;
            case 's':
                result = sqrt(firstOperand);
                break;
        }
    }

    //Return result of calculation
    public double getResult() {
        return result;
    }


}
