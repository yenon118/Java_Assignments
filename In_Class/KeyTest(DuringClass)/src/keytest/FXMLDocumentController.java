/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keytest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class FXMLDocumentController implements Initializable {
    
    
    private Stage stage;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    public void ready(Stage stage) {
        this.stage = stage;
        textArea.setText("hello!\n");
        
        
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("Clear Button Pressed!"); 
    }   
}