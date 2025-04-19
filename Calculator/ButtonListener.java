import java.awt.event.*;
import javax.swing.*;

public class ButtonListener implements ActionListener {
    private JTextField ecran;
    private double result;
    private String operator;
    private boolean startNewNumber;

    public ButtonListener(JTextField ecran) {
        this.ecran = ecran;
        this.result = 0;
        this.operator = "=";
        this.startNewNumber = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            if (startNewNumber) {
                ecran.setText(command.equals(".") ? "0." : command);
            } else {
                if (!(command.equals(".") && ecran.getText().contains("."))) {
                    ecran.setText(ecran.getText() + command);
                }
            }
            startNewNumber = false;
        } else {
            if (startNewNumber && !command.equals("C")) {
                operator = command;
            } else {
                double x = Double.parseDouble(ecran.getText());
                calculate(x);
                operator = command;
                startNewNumber = true;
            }

            if (command.equals("C")) {
                result = 0;
                operator = "=";
                startNewNumber = true;
                ecran.setText("0");
            } else if (command.equals("±")) {
                ecran.setText("" + (-Double.parseDouble(ecran.getText())));
            }
        }
    }

    private void calculate(double x) {
        switch (operator) {
            case "+": result += x; break;
            case "-": result -= x; break;
            case "×": result *= x; break;
            case "÷": result = x != 0 ? result / x : 0; break;
            case "%": result = result * x / 100; break;
            case "=": result = x; break;
        }
        ecran.setText("" + result);
    }
}
