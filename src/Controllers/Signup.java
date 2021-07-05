package Controllers;

import Controllers.Controller;
import Models.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Signup {

    @FXML
    private TextField nameText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField ansText;

    @FXML
    private ComboBox<?> combText;
    @FXML
    private Button returnBtn;

    @FXML
    private Button btnSignup;
    Controller controller = new Controller();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void setBtnSignup() throws IOException {
        if (nameText.getText().isBlank() && usernameText.getText().isBlank() && passwordText.getText().isBlank()
                && ansText.getText().isBlank()) {
            alert.setTitle("Sign up");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blank space!!!");
            alert.showAndWait();
        }
        else {
            validateSignup();
            alert.setContentText("Register successfully!");
            alert.showAndWait();
            Controller.changeScence("../Views/fxml/login.fxml");
        }
    }

    public void validateSignup() {
        String sql = "INSERT INTO `account`(`username`, `password`, `name`, `answer`) VALUES ('" + usernameText.getText() + "'," +
                "'" + passwordText.getText() + "','" + nameText.getText() + "','" + ansText.getText() + "')";
        try {
            Connection con = (new DatabaseConnection()).getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
