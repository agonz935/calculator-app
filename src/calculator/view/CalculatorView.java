package calculator.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {


    private JButton numButton1, numButton2, numButton3, numButton4, numButton5, 
            numButton6, numButton7, numButton8, numButton9, numButton0, //numbers 0-9
             addButton, subtractButton, multiplyButton, divideButton, equalButton, //operator and calculation
            clearButton,deleteButton, decimalButton, negativeButton, squareRootButton; //special buttons
    
    private JTextField currentText, previousText; //textboxes for previous and current strings
    
    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);


    public CalculatorView() {
        initializeUI();
    }

    private void initializeUI() {
        // Set up the frame
        setTitle("Calculator");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Font pfont = new Font("Arial", Font.PLAIN, 25);
        Font cfont = new Font("Arial", Font.PLAIN, 30);

        JPanel jpMain = new JPanel();
        jpMain.setLayout(new GridBagLayout());
        jpMain.setBackground(customBlack);

        // Grid bag layout
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(1, 1, 1, 1);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;

        //Number buttons
        numButton1 = new JButton("1");
        numButton2 = new JButton("2");
        numButton3 = new JButton("3");
        numButton4 = new JButton("4");
        numButton5 = new JButton("5");
        numButton6 = new JButton("6");
        numButton7 = new JButton("7");
        numButton8 = new JButton("8");
        numButton9 = new JButton("9");
        numButton0 = new JButton("0");

        //Operators and special
        clearButton = new JButton("C");
        deleteButton = new JButton("DEL");
        decimalButton = new JButton(".");
        negativeButton = new JButton("+/-");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("÷");
        equalButton = new JButton("=");
        squareRootButton = new JButton("s");


        //Previous text box
        previousText = new JTextField(10);
        previousText.setFont(pfont);
        previousText.setHorizontalAlignment(JTextField.RIGHT);
        previousText.setBackground(customBlack);
        previousText.setBorder(BorderFactory.createEmptyBorder());
        previousText.setForeground(Color.WHITE);
        previousText.setEditable(false);

        //Output textbox
        currentText = new JTextField(10);
        currentText.setHorizontalAlignment(JTextField.RIGHT);
        currentText.setBackground(customBlack);
        currentText.setBorder(BorderFactory.createEmptyBorder());
        currentText.setFont(cfont);
        currentText.setForeground(Color.WHITE);
        currentText.setEditable(false);

        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(customBlack);

        //adding to results panel
        textPanel.add(previousText, BorderLayout.NORTH);
        textPanel.add(currentText, BorderLayout.CENTER);

        //Adding result textbox to main panel
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 4;
        jpMain.add(textPanel, gridConstraints);
        gridConstraints.gridwidth = 1;


        //first row
        setButtonDesign(clearButton, deleteButton, negativeButton, divideButton);
        setButtonRow(jpMain, gridConstraints, 1, clearButton, deleteButton, negativeButton, divideButton);

        //second row
        setButtonDesign(numButton7, numButton8, numButton9, multiplyButton);
        setButtonRow(jpMain, gridConstraints,2, numButton7, numButton8, numButton9, multiplyButton);

        //third row
        setButtonDesign(numButton4, numButton5, numButton6, subtractButton);
        setButtonRow(jpMain, gridConstraints,3, numButton4, numButton5, numButton6, subtractButton);

        //fourth row
        setButtonDesign(numButton1, numButton2, numButton3, addButton);
        setButtonRow(jpMain, gridConstraints, 4, numButton1, numButton2, numButton3, addButton);

        //fifth row
        setButtonDesign(decimalButton, numButton0, squareRootButton, equalButton);
        setButtonRow(jpMain, gridConstraints, 5, decimalButton, numButton0, squareRootButton, equalButton);

        this.add(jpMain);
    }

    //Adds buttons per row
    private void setButtonRow(JPanel jpMain, GridBagConstraints gridConstraints, int row, JButton... button) {
        gridConstraints.gridy = row;
        int col = 1;

        for(JButton b : button) {
            gridConstraints.gridx = col;
            jpMain.add(b, gridConstraints);
            col++;
        }
    }

    //Button row formatting
    public void setButtonDesign(JButton... button) {

        for(JButton b : button) {
            b.setFont(new Font("Arial", Font.PLAIN, 23));
            b.setFocusable(false);
            b.setBorder(new LineBorder(customBlack));


            String buttonText = b.getText();
            
            if(buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("x") 
                    || buttonText.equals("÷") || buttonText.equals("=") || buttonText.equals("s")) {
                b.setBackground(customOrange);
                b.setForeground(Color.white);
            } else if(buttonText.equals("C") || buttonText.equals("DEL") || buttonText.equals("+/-")) {
                b.setBackground(customLightGray);
                b.setForeground(customBlack);
            } else{
                b.setBackground(customDarkGray);
                b.setForeground(Color.white);
            }
        }

    }

    //Setters and getters for operands
    public void setCurrentText(String text) {
        currentText.setText(text);
    }
    
    public String getCurrentText(){
        return currentText.getText();
    }

    public void setPreviousText(String text) {
        previousText.setText(text);
    }

    public String getPreviousText(){
        return previousText.getText();
    }

    //Adding ActionListeners to buttons 
    public void addNumberButtonListener (ActionListener listenForCalc) {
        numButton0.addActionListener(listenForCalc);
        numButton1.addActionListener(listenForCalc);
        numButton2.addActionListener(listenForCalc);
        numButton3.addActionListener(listenForCalc);
        numButton4.addActionListener(listenForCalc);
        numButton5.addActionListener(listenForCalc);
        numButton6.addActionListener(listenForCalc);
        numButton7.addActionListener(listenForCalc);
        numButton8.addActionListener(listenForCalc);
        numButton9.addActionListener(listenForCalc);
    }

    public void addOperatorButtonListener (ActionListener listenForOperation) {
        addButton.addActionListener(listenForOperation);
        subtractButton.addActionListener(listenForOperation);
        multiplyButton.addActionListener(listenForOperation);
        divideButton.addActionListener(listenForOperation);
    }

    public void addDecimalButtonListener (ActionListener listenForDecimal) {
        decimalButton.addActionListener(listenForDecimal);
    }

    public void addNegativeButtonListener (ActionListener listenForNegative) {
        negativeButton.addActionListener(listenForNegative);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addSquareRootButtonListener (ActionListener listener) { squareRootButton.addActionListener(listener); }
}