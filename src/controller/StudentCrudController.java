/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 9:40 AM
 */
package controller;

import entity.Student;
import javafx.scene.control.Alert;
import util.CrudUtil;
import view.tm.StudentTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<StudentTM> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentTM> studentTMS = new ArrayList();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");
        while (resultSet.next()){
            studentTMS.add(new StudentTM(
                    resultSet.getString("student_id"),resultSet.getString("student_name"),resultSet.getString("email"),
                    resultSet.getString("contact"),resultSet.getString("address"),resultSet.getString("nic")
            ));
        }
        return studentTMS;
    }

    public static Student searchStudentById(String studentId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE student_id=?",studentId);
        if(resultSet.next()){
            return new Student(
                    resultSet.getString("student_id"),resultSet.getString("student_name"),resultSet.getString("email"),
                    resultSet.getString("contact"),resultSet.getString("address"),resultSet.getString("nic")
            );
        }
        return null;
    }
}
