/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 9:18 AM
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    public void addBtnOnAction(ActionEvent actionEvent) {
    }

    public void searchBarOnAction(ActionEvent actionEvent) {
    }
}
