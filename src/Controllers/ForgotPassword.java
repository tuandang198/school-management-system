package Controllers;

import Controllers.Controller;
import Models.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForgotPassword {

    @FXML
    private TextField recoverUsername;

    @FXML
    private TextField answer;

    @FXML
    private TextField recoverPassword;

    @FXML
    private Button searchUsername;

    @FXML
    private Button returnBtn;
    @FXML
    private TextField nameTextfiled;


    public void setReturnBtn() throws IOException {
        Controller.changeScence("../Views/fxml/login.fxml");
    }
    public void searchUsername(){
        try {
            String sql = "select * from account where `username`='"+recoverUsername.getText()+"'";
            Connection con = new DatabaseConnection().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
             if(rs.next()){
                 nameTextfiled.setText(rs.getString(4));
             }else {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText(null);
                 alert.setContentText("No username was found.");
                 alert.showAndWait();
             }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }



}
