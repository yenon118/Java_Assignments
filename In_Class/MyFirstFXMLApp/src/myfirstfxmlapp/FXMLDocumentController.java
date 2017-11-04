/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstfxmlapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class FXMLDocumentController implements Initializable {
    
    
    /*
        The @FXML anotation is used to tag non-public controller member fields
        and handler methods for use by FXML markup
    */
    @FXML
    private VBox root;
    
    @FXML
    private TextArea textArea;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem close;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void open(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.showOpenDialog(stage);
        
    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
    }
    
    public void helloWorld(){
        System.out.println("Hello World");
    }
    
    
    /*
    Model View Controller (MVC)
        
        *FXML File (UI code) -> View
    
        *Java Class handle the events for UI -> Controller
    
        *Domain Object, on the java side, that connect to the view
            through the controller -> model
    */
    
    
}
