package edu.csc413.calculator.evaluator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "C", "CE", "^", "+", "7", "8", "9", "-", "4", "5", "6",
        "*", "1", "2", "3", "/", "0", "(", ")", "=", "!", "%"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private JButton[] buttons = new JButton[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        // Set initial value to 0
        txField.setText("0");
        txField.setEditable(false);
        txField.setForeground(Color.white);
        txField.setBackground(Color.black);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(6, 4));

        //create 20 buttons with corresponding text in bText[] array
        JButton bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new JButton(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            bt.setForeground(Color.lightGray);
            bt.setBackground(new Color(50, 50, 50));
            bt.setOpaque(true);
            bt.setBorder(new LineBorder(Color.lightGray, 2));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(40, 40, 40));
    }

    public void actionPerformed(ActionEvent arg0) {
        // You need to fill in this function
        switch (arg0.getActionCommand()) {
            case "=":
                try {
                    Evaluator ev = new Evaluator();
                    txField.setText(Integer.toString(ev.eval(txField.getText())));
                } catch (EmptyStackException e) {
                    txField.setText("0");
                    System.out.println(e + ": Invalid expression");
                }
                break;
            case "C":
                txField.setText("0");
                break;
            case "CE":
                // Erases text one character at a time; backspace
                if (txField.getText().length() == 1) {
                    txField.setText("0");
                } else if (txField.getText().length() > 1) {
                    txField.setText(txField.getText().substring(0, txField.getText().length() - 1));
                }
                break;
            default:
                // Overwrite text field if 0 is shown
                txField.setText(txField.getText().equals("0") ? arg0.getActionCommand() : txField.getText() + arg0.getActionCommand());
                break;
        }
    }
}
