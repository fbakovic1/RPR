package com.example.vjezbafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public TextField txtResult;

    String op = "";
    float num1 = 0;
    float num2 = 0;


    public void Number(ActionEvent event) {
        String val = ((Button)event.getSource()).getText();
        txtResult.setText(txtResult.getText() + val);
    }

    public void Operator(ActionEvent event) {
        String operation = ((Button)event.getSource()).getText();
        if (!operation.equals("=")) {
            if (!op.equals("")) return;
            op = operation;
            num1 = Float.parseFloat(txtResult.getText());
            txtResult.setText("");
        } else {
            if (op.equals("")) return;
            num2 = Float.parseFloat(txtResult.getText());
            calculate(num1, num2, op);
            op = "";
        }
    }

    public void calculate(float num1, float num2, String op) {
        switch (op) {
            case "+":
                txtResult.setText(num1 + num2 + ""); break;
            case "-":
                txtResult.setText(num1 - num2 + "");break;
            case "x":
                txtResult.setText(num1 * num2 + "");break;
            case "/":
                txtResult.setText(num1 / num2 + "");break;
            case "%":
                txtResult.setText(num1 % num2 + "");break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
