package com.example.authorization;

import java.io.IOException;
import java.net.URL;
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

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuth;

    @FXML
    private Button btnRegistr;

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
        btnAuth.setOnAction( event ->{
            String loginText = txtboxLogin.getText().trim();
            String loginPassword = txtboxPassword.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")){
                loinUser(loginText,loginPassword);
            }
            else
                System.out.println("Login and password is empty");
        });

        btnRegistr.setOnAction(event ->{
            btnRegistr.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com.example.authorization/registr.fxml"));

            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loinUser(String loginText, String loginPassword) {

    }

}
