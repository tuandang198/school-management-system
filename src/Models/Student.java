package Models;

import Controllers.student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.sql.*;
import java.util.ArrayList;

public class Student {
    private String name;
    private int studentID;
    private float avrGrade;
    private String studentClass;
    private int mark;
    private String subjectName;
    private String studentName;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getAvrGrade() {
        return avrGrade;
    }

    public void setAvrGrade(float avrGrade) {
        this.avrGrade = avrGrade;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Student() {

    }

    public Student(int id, String studentName, float averageGrade, String StudentClass) {
        name = studentName;
        studentID = id;
        avrGrade = averageGrade;
        studentClass = StudentClass;
    }

    public Student(String student, String subject, Integer studentMark) {
        studentName = student;
        subjectName = subject;
        mark = studentMark;
    }

    public static ObservableList getAllStudent() throws SQLException {
        String query = "SELECT * FROM `student` AS a join `class` as b WHERE a.studentClass=b.classID";
        ResultSet rs = null;
        try {
            Connection con = (new DatabaseConnection()).getConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        assert rs != null;
        return FXCollections.observableArrayList(dbStudent(rs));

    }

    private static ArrayList dbStudent(ResultSet resultSet) throws SQLException {
        ArrayList<Student> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add(new Student(resultSet.getInt(1)
                    , resultSet.getString(2)
                    , resultSet.getFloat(3),
                    resultSet.getString(6)));
        }
        return arrayList;

    }

    public static ObservableList getStudentMark(int studentID) throws SQLException {
        String query = "SELECT studentName,c.subjectName,b.mark from student as a " +
                "join student_subject as b on a.studentID = b.studentID  JOIN subject as c on b.subjectID =c.id WHERE b.studentID = " + studentID + "";
        ResultSet rs = null;

        try {
            Connection con = (new DatabaseConnection()).getConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return FXCollections.observableArrayList(dbStudentMark(rs));
    }

    public static ArrayList dbStudentMark(ResultSet resultSet) throws SQLException {
        ArrayList<Student> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add(new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        return arrayList;

    }

}

