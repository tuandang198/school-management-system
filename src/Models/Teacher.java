package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.image.RescaleOp;
import java.sql.*;
import java.util.ArrayList;

public class Teacher {
    private int teacherID;
    private String teacherName;
    private String teacherEmail;
    private String teachClass;
    private String teachSubject;

    public String getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(String teachClass) {
        this.teachClass = teachClass;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public void setTeachSubject(String teachSubject) {
        this.teachSubject = teachSubject;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public Teacher() {
    }

    public Teacher(int id, String name, String email, String teacherClass, String teacherSubject) {
        teacherID = id;
        teacherName = name;
        teacherEmail = email;
        teachClass = teacherClass;
        teachSubject = teacherSubject;
    }

    public static ObservableList getAllTeacher() throws SQLException {
        String query = "SELECT b.teacherID ,teacherName,teacherEmail,d.className,c.subjectName FROM `teacher` AS a join `teacher_subject` as b on a.teacherID =b.teacherID join `subject` as c on c.id =b.subjectID JOIN `class` as d on a.teacherID=d.teacherID ";
        Connection con = null;
        ResultSet rs=null;
        try {
            con = (new DatabaseConnection()).getConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            rs = pstm.executeQuery(query);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return FXCollections.observableArrayList(dbTeacher(rs));

    }

    public static ArrayList dbTeacher(ResultSet resultSet) throws SQLException {
        ArrayList<Teacher> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add((new Teacher(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
                    )));
        }
        return arrayList;
    }
}
