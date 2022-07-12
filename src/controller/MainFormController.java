/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 9:18 AM
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Navigations;
import view.tm.StudentTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public TableView<StudentTM> studentTbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colNic;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public TextField searchBar;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXButton addBtn;
    public JFXButton addNewStudentBtn;

    private StudentTM selectedStudentTM;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));

        studentTbl.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null)setSelectedStudentData(newValue);
                });

        setStudentTblData();
    }

    private void setSelectedStudentData(StudentTM newValue) {
        selectedStudentTM = newValue;
        txtId.setEditable(false);
        addBtn.setText("UPDATE");
        txtId.setText(newValue.getStudentId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtContact.setText(newValue.getContact());
        txtEmail.setText(newValue.getEmail());
        txtNic.setText(newValue.getNic());
    }

    private void setStudentTblData() {
        try {
            ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList(
                    StudentCrudController.getAllStudents()
            );
            studentTbl.setItems(studentTMS);
        }
        catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void addBtnOnAction(ActionEvent actionEvent) {
        if("ADD".equals(addBtn.getText())){
            try {
                StudentCrudController.insertStudent(
                        txtId.getText(),txtName.getText(),txtEmail.getText(), txtContact.getText(),txtAddress.getText(),txtNic.getText()
                );
            }
            catch (SQLException|ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
        }else{
            try {
                StudentCrudController.updateStudent(
                        txtName.getText(),txtEmail.getText(), txtContact.getText(),txtAddress.getText(),txtNic.getText(),txtId.getText()
                );
            }
            catch (SQLException|ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
        }
        setStudentTblData();
    }

    public void searchBarOnAction(ActionEvent actionEvent) {
        try {
            Student student = StudentCrudController.searchStudentById(searchBar.getText());
            if(student!=null){
                addBtn.setText("UPDATE");
                txtId.setEditable(false);
                txtId.setText(student.getStudentId());
                txtNic.setText(student.getNic());
                txtName.setText(student.getName());
                txtAddress.setText(student.getAddress());
                txtContact.setText(student.getContact());
                txtEmail.setText(student.getEmail());
            }else{
                new Alert(Alert.AlertType.ERROR,"Couldn't find student").show();
            }
        }
        catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addNewStudentBtnOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtNic.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.clear();
        addBtn.setText("ADD");
    }

    public void closeBtnOnAction(ActionEvent actionEvent) {
        Navigations.getInstance().closeStage(actionEvent);
    }

    public void minimizeBtnOnAction(ActionEvent actionEvent) {
        Navigations.getInstance().minimizeStage(actionEvent);
    }

    public void deleteCtxmOnAction(ActionEvent actionEvent) {
        try {
            StudentCrudController.deleteStudent(selectedStudentTM.getStudentId());
        }
        catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        setStudentTblData();
    }
}
