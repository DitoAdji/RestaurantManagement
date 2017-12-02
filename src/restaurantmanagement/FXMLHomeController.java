/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DITO
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private JFXButton order;
    @FXML
    private JFXButton admin;
    @FXML
    private JFXButton exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void prosesorder(ActionEvent event) {
    try{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLMENU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),410,509);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("MenuAwal");
        stage.show();
        }catch(IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void prosesadmin(ActionEvent event) {
        try{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),830,450);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("MenuAwal");
        stage.show();
        }catch(IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void prosesexit(ActionEvent event) {
        System.exit(0);
    }
    
}
