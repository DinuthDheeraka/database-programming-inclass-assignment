/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 9:40 AM
 */
package controller;

import javafx.scene.control.Alert;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudController {

    public static void insertStudent(Object... params) throws SQLException, ClassNotFoundException {
        if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",params)){
            new Alert(Alert.AlertType.CONFIRMATION,"Student added").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't add student").show();
        }
    }

    public static void updateStudent(Object... params) throws SQLException, ClassNotFoundException {
        if (CrudUtil.execute("UPDATE Student SET student_name=?,email=?,contact=?,address=?,nic=? WHERE student_id = ?",params)){
            new Alert(Alert.AlertType.CONFIRMATION,"Student updated").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't update student").show();
        }
    }

    public static void getAllStudents() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");

    }
}
