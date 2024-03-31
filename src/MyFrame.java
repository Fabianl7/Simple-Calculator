import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, divButton, multButton;
    JButton eqButton, decButton, delButton, clButton, negButton;
    Font myFont = new Font("Comic Sans", Font.BOLD, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    public MyFrame(){
        // Instantiate frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.darkGray);

        // Instantiate text field
        textField = new JTextField();
        textField.setFont(myFont);
        textField.setBounds(15, 20, 380, 50);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setVisible(true);

        // Instantiate panel
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setBounds(50, 80, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 20, 20));
        panel.setVisible(true);

        // Instantiate buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("x");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        decButton = new JButton(".");
        delButton = new JButton("Delete");
        clButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = decButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clButton;
        functionButtons[8] = negButton;

        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
    }

        negButton.setBounds(40, 390, 80, 50);
        delButton.setBounds(130, 390, 130, 50);
        clButton.setBounds(270,390,100,50);

        // Add components to the frame and panel
        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clButton);
        frame.add(negButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[5]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[4]);
        panel.add(functionButtons[3]);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            if(!textField.getText().contains("."))
                textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == multButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == eqButton){
            if(textField.getText().length() != 0) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
            }

            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == clButton){
            num1 = 0;
            num2 = 0;
            result = 0;
            textField.setText("0");
        }
        if(e.getSource() == delButton){
            if(textField.getText().length() != 0) {
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
