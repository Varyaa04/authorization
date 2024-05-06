package com.example.authorization;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuth;

    @FXML
    private Button btnReg;

    @FXML
    private Label labalProgramm;

    @FXML
    private Label labelAuth;

    @FXML
    private TextField txtboxLogin;

    @FXML
    private PasswordField txtboxPassword;

    @FXML
    void initialize() {
        btnAuth.setOnAction(event -> {
            String loginText = txtboxLogin.getText().trim();
            String loginPassword = txtboxPassword.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else
                System.out.println("Login and password is empty");
        });

        btnReg.setOnAction(event -> {
            Stage currentStage = (Stage) btnReg.getScene().getWindow();
            currentStage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
                Parent root = loader.load();

                Stage registerStage = new Stage();
                registerStage.setScene(new Scene(root));
                registerStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                // Вам здесь нужно обрабатывать результаты выборки, например, сравнивать возвращенные данные с введенными логином и паролем
                // Например:
                String dbLogin = result.getString("login");
                String dbPassword = result.getString("password");
                if (loginText.equals(dbLogin) && loginPassword.equals(dbPassword)) {
                    counter++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            System.out.println("Success!");
        }
    }
}
