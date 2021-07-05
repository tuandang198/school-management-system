package Controllers;

import Models.DatabaseConnection;
import Models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AlertboxStudent implements Initializable {


    @FXML
    private Text textStudent;

    @FXML
    private TableView<Student> tbData;

    @FXML
    private TableColumn<Student, String> subject;

    @FXML
    private TableColumn<Student, Integer> mark;

    public AlertboxStudent() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subject.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        tbData.setItems(studentMark);
    }
    private final ObservableList studentMark = FXCollections.observableArrayList(
            Student.getStudentMark((new Student()).getStudentID())
    );
}
