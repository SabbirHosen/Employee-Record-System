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
public class CommissionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button salaried;

    @FXML
    private Button hourly;
    @FXML
    private Button home;
    @FXML
    private TextField commissionName;
    @FXML
    private TextField commissionId;
    @FXML
    private TextField commissionDesignation;
    @FXML
    private TextField commission;
    @FXML
    private TextField commissionSale;
    @FXML
    private Button commissionSubmit;

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
    private void getCommissionInput(ActionEvent event) {
        if(commissionName.getText().equals("")||commissionId.getText().equals("")||commissionDesignation.getText().equals("")||commission.getText().equals("")||commissionSale.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Missing!");
            alert.setHeaderText("Complete Information Properly!");
            alert.showAndWait();
        }else{
            try {
                String name = commissionName.getText();
                String id = commissionId.getText();
                String des = commissionDesignation.getText();
                String com = commission.getText();
                String comSale = commissionSale.getText();
                double comm = Double.parseDouble(com);
                double comsale = Double.parseDouble(comSale);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successed!");
                alert.setHeaderText("Employee added successfully!");
                alert.showAndWait();
                Communication c = new Communication();
                c.commission(name, id, des, comm, comsale);
                commissionName.setText("");
                commissionId.setText("");
                commissionDesignation.setText("");
                commission.setText("");
                commissionSale.setText("");
            } catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Inavlid Input");
                alert.setHeaderText("Commission and Sale must be in NUMBER Formate.");
                alert.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
