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
public class SalariedController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Button commission;

    @FXML
    private Button hourly;
    @FXML
    private Button home;
    @FXML
    private TextField salariedName;
    @FXML
    private TextField salariedID;
    @FXML
    private TextField salaridDesignation;
    @FXML
    private TextField salariedMonthlySalary;
    @FXML
    private Button salariedSubmit;

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
    void goToCommission(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Commission.fxml"));
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
    void goToHourly(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Hourly.fxml"));
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
    private void getSalariedInput(ActionEvent event) {
        if(salariedName.getText().equals("")||salariedID.getText().equals("")||salaridDesignation.getText().equals("")||salariedMonthlySalary.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Missing!");
            alert.setHeaderText("Complete Information Properly!");
            alert.showAndWait();
        }else{
            try {
                String name = salariedName.getText();
                String id = salariedID.getText();
                String des = salaridDesignation.getText();
                String salary = salariedMonthlySalary.getText();
                double monthlySalary = Double.parseDouble(salary);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successed!");
                alert.setHeaderText("Employee added successfully!");
                alert.showAndWait();
                Communication c = new Communication();
                c.salaried(name, id, des, monthlySalary);
                salariedName.setText("");
                salariedID.setText("");
                salaridDesignation.setText("");
                salariedMonthlySalary.setText("");
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Inavlid Input");
                alert.setHeaderText("Salary must be in NUMBER Formate.");
                alert.showAndWait();
            }
        }
        
        
    }
    
}
