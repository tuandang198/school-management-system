package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class ClassModel {
    private int classID;
    private String className;
    private int studentNumber;

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public ClassModel(){}
    public ClassModel(int id, String name,int num){
        classID=id;
        className=name;
        studentNumber=num;
    }

    public static ObservableList classModel() throws SQLException {
        String query ="SELECT classID ,className ,COUNT(b.studentClass) from class as a join student as b on a.classID =b.studentClass GROUP BY b.studentClass \n";
        ResultSet rs = null;

        Connection con = null;
        try {
            con = (new DatabaseConnection()).getConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return FXCollections.observableArrayList(dbClass(rs));

    }
    public static ArrayList dbClass(ResultSet resultSet) throws SQLException {
        ArrayList<ClassModel> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new ClassModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
        }
        return arrayList;
    }


}
