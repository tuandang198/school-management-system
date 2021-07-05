package Controllers;

import Models.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherController implements Initializable{

    @FXML
    private AnchorPane Studentclass;

    @FXML
    private TableView<Teacher> tbData;

    @FXML
    private TableColumn<Teacher, Integer> teacherID;

    @FXML
    private TableColumn<Teacher, String> name;

    @FXML
    private TableColumn<Teacher, String> teacherEmail;

    @FXML
    private TableColumn<Teacher, String> teachClass;

    @FXML
    private TableColumn<Teacher, String> teachSubject;

    @FXML
    private TextField searchBar;

    public TeacherController() throws SQLException, ClassNotFoundException {
    }

    public void initialize(URL location, ResourceBundle resourceBundle){
        teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        name.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        teacherEmail.setCellValueFactory(new PropertyValueFactory<>("teacherEmail"));
        teachClass.setCellValueFactory(new PropertyValueFactory<>("teachClass"));
        teachSubject.setCellValueFactory(new PropertyValueFactory<>("teachSubject"));
        tbData.setItems(teacher);
    }
    private final ObservableList teacher= FXCollections.observableArrayList(
            Teacher.getAllTeacher()
    );

}
