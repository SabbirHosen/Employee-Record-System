/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sabbir Hosen
 */
public class SalaryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button home;
    @FXML
    private TextField employeeId;
    @FXML
    private Button search;
    @FXML
    private TextArea outSalary;

    @FXML
    void goToHome(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Not Found!");
            alert.setHeaderText("FXML File not found!");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchEmployee(ActionEvent event) {
        if(employeeId.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Missing!");
            alert.setHeaderText("Complete Information Properly!");
            alert.showAndWait();
        }else{
            Communication c = new Communication();
            c.searchId = employeeId.getText();
            String out = c.salary();
            outSalary.setText(out);
        }
        
    }
    
}
