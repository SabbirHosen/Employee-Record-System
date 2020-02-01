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
public class HourlyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button salaried;

    @FXML
    private Button commission;
    @FXML
    private Button home;
    @FXML
    private TextField hourlyName;
    @FXML
    private TextField hourlyId;
    @FXML
    private TextField hourlyDesignation;
    @FXML
    private TextField hourlyWorked;
    @FXML
    private TextField hourlyRate;
    @FXML
    private Button submit;

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
    void goToSalaried(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Salaried.fxml"));
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
    private void getHourlyInput(ActionEvent event) {
        if(hourlyName.getText().equals("")||hourlyId.getText().equals("")||hourlyDesignation.getText().equals("")||hourlyWorked.getText().equals("")||hourlyRate.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Missing!");
            alert.setHeaderText("Complete Information Properly!");
            alert.showAndWait();
        }else{
            try {
                String name = hourlyName.getText();
                String id = hourlyId.getText();
                String des = hourlyDesignation.getText();
                String hw = hourlyWorked.getText();
                String hr = hourlyRate.getText();
                double hlw = Double.parseDouble(hw);
                int hlr = Integer.parseInt(hr);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successed!");
                alert.setHeaderText("Employee added successfully!");
                alert.showAndWait();
                Communication c = new Communication();
                c.hourly(name, id, des, hlw, hlr);
                hourlyName.setText("");
                hourlyId.setText("");
                hourlyDesignation.setText("");
                hourlyWorked.setText("");
                hourlyRate.setText("");
            } catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Inavlid Input");
                alert.setHeaderText("Hourly Worked and Hourly rate must be in NUMBER Formate.");
                alert.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
