/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sabbir Hosen
 */
public class AddEmployeeController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Button hourly;
     @FXML
    private Button salarid;
     @FXML
    private Button commission;
     @FXML
    private Button home;
    
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
            alert.showAndWait();         }
    }
    @FXML
    void goToSalaried(ActionEvent event){
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
