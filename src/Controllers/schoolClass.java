package Controllers;

import Models.ClassModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class schoolClass implements Initializable {

        @FXML
        private AnchorPane Studentclass;

        @FXML
        private TableView<ClassModel> tbData;

        @FXML
        private TableColumn<ClassModel, Integer> classID;

        @FXML
        private TableColumn<ClassModel, String> className;

        @FXML
        private TableColumn<ClassModel, Integer> numberStudent;

        @FXML
        private TextField searchBar;

    public schoolClass() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        classID.setCellValueFactory(new PropertyValueFactory<>("classID"));
        className.setCellValueFactory(new PropertyValueFactory<>("className"));
        numberStudent.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        tbData.setItems(schoolClass);
    }
    private final ObservableList schoolClass = FXCollections.observableArrayList(
            ClassModel.classModel()
    );


    }

