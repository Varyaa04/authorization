package com.example.authorization;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegister;

    @FXML
    private Label labalProgramm;

    @FXML
    private Label labelAuth;

    @FXML
    private Label labellogin;

    @FXML
    private Label labelname;

    @FXML
    private Label labelpassword;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtRepeatPassw;

    @FXML
    private TextField txtboxLogin;

    @FXML
    private PasswordField txtboxPassword;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        btnRegister.setOnAction(event -> {
            String name = txtName.getText();
            String login = txtboxLogin.getText();
            String password = txtboxPassword.getText();
            String repeatPassword = txtRepeatPassw.getText();

            if (name.isEmpty() || login.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                // Вывести сообщение об ошибке о незаполненных полях
                System.out.println("Пожалуйста, заполните все поля.");
                return;
            }

            if (!password.equals(repeatPassword)) {
                // Вывести сообщение об ошибке, если пароли не совпадают
                System.out.println("Пароли не совпадают. Пожалуйста, введите одинаковые пароли.");
                return;
            }

            dbHandler.signUpUser(name, login, password);

            Stage currentStage = (Stage) btnBack.getScene().getWindow();
            currentStage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();

                Stage authStage = new Stage();
                authStage.setScene(new Scene(root));
                authStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnBack.setOnAction(event -> {
            Stage currentStage = (Stage) btnBack.getScene().getWindow();
            currentStage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();

                Stage authStage = new Stage();
                authStage.setScene(new Scene(root));
                authStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }}