package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class home {

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button studentBtn;

    @FXML
    private Button calendarBtn;

    @FXML
    private Button classBtn;

    @FXML
    private Button teacherBtn;
    public void handleBtn(ActionEvent event) {
        if (event.getSource() == dashboardBtn) {
            Controller.changeScence("../Views/fxml/dashboard.fxml");
        } else if (event.getSource() == studentBtn) {
            Controller.changeScence("../Views/fxml/student.fxml");
        } else if (event.getSource() == calendarBtn) {
            Controller.changeScence("../Views/fxml/timeTable.fxml");
        } else if (event.getSource() == classBtn) {
            Controller.changeScence("../Views/fxml/schoolClass.fxml");
        } else if (event.getSource() == teacherBtn) {
            Controller.changeScence("../Views/fxml/teacher.fxml");
        }

    }
}
