package com.example.gasolinerajava;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label dniLabel;

    @FXML
    private TextField dniTextField;

    @FXML
    private Button loginButton;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleLogin() throws Exception {
        String name = nameTextField.getText();
        String dni = dniTextField.getText();

        // Clear text fields
        nameTextField.clear();
        dniTextField.clear();

        main.showPantallaCombustible();
    }
    @FXML
    private void initialize() {
        loginButton.setOnAction(e -> {
            String name = nameTextField.getText();
            String dni = dniTextField.getText();
            // Perform login validation here

            // Clear text fields
            nameTextField.clear();
            dniTextField.clear();
        });
    }
}
