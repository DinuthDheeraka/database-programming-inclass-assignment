/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 9:18 AM
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MainFormController {
    public TableView studentTbl;
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
    }

    public void searchBarOnAction(ActionEvent actionEvent) {
    }

    public void addNewStudentBtnOnAction(ActionEvent actionEvent) {
        addBtn.setText("ADD");
    }
}
