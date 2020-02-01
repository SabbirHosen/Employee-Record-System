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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sabbir Hosen
 */
public class UpdateSalaryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button home;
    @FXML
    private TextField employeeId;
    @FXML
    private Button update;
    @FXML
    private TextField amount;

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
    
    @FXML
    private void getUpdate(ActionEvent event) {
        try {
            if(employeeId.getText().equals("")||amount.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Missing!");
            alert.setHeaderText("Complete Information Properly!");
            alert.showAndWait();
        }else{
            String id = employeeId.getText();
            String am = amount.getText();
            double amt = Double.parseDouble(am);
            Communication c = new Communication();
            c.searchId = id;
            c.amt = amt;
            String s = c.updateSlary();
            if(s == "Y"){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful.");
                alert.setHeaderText("Salary Updated.");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Not Found!");
                alert.setHeaderText("Employee Not Found!");
                alert.showAndWait();
            }
            }
            
        } catch (NumberFormatException numberFormatException) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Inavlid Input");
            alert.setHeaderText("Salary must be in NUMBER Formate.");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
