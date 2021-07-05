package Controllers;

import Models.Student;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class student implements Initializable {

    @FXML
    private AnchorPane Studentclass;

    @FXML
    private TableView<Student> tbData;

    @FXML
    private TableColumn<Student,String> studentId;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, Float> avrGrade;

    @FXML
    private TableColumn<Student, String> studentClass;

    @FXML
    private TextField searchBar;

    public student() throws SQLException {
    }

    public void initialize(URL location, ResourceBundle resources){
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        avrGrade.setCellValueFactory(new PropertyValueFactory<>("avrGrade"));
        studentClass.setCellValueFactory(new PropertyValueFactory<>("studentClass"));
        tbData.setItems(student);
        tbData.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(""));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                Controller.changeScence("../Views/fxml/studentGrade.fxml");



            }
        });


    }
    private final ObservableList student = FXCollections.observableArrayList(
            Student.getAllStudent()
   );
}
