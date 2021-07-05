package Controllers;

import Models.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessage;

    @FXML
    private Button recoverPassBtn;

    @FXML
    private Button signupBtn;

    public void handleButtonClick(ActionEvent event){
        if(event.getSource() == cancelButton){
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }else if(event.getSource()== recoverPassBtn){
            changeScence("../Views/fxml/ForgotPassword.fxml");
        }else if(event.getSource()== loginButton){
            if (!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
                validateLogin();
            } else {
                loginMessage.setText("Do not leave blank space");
            }
        }else if(event.getSource()== signupBtn){
            changeScence("../Views/fxml/signup.fxml");
        }
    }


    public static void changeScence(String fxml)  {

//        try {
//            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(fxml)));
//            Stage stage = new Stage();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(fxml)));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void validateLogin()  {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection con = databaseConnection.getConnection();
            String verifyLogin = "SELECT * FROM `account` WHERE `username`='" + usernameTextField.getText() + "' AND `password`='" + passwordField.getText() + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(verifyLogin);

            if (rs.next()){
                changeScence("../Views/fxml/home.fxml");

            }else {
                loginMessage.setText("Invalid login");

            }
            System.out.println(verifyLogin);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

