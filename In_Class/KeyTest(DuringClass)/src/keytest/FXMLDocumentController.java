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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private VBox vBox;
    
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    public void ready(Stage stage) {
        this.stage = stage;
        textArea.setText("hello!\n");
        
        Image image = new Image(this.getClass().getResourceAsStream("car.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(150);
        imageView.setY(150);
        
        anchorPane.getChildren().add(imageView);
        
        /*  Why put event filter on stage?
            1. Top most UI object, so key presses from anywhere in the UI will work
            2. If no element in the UI that normally get key presses then putting the listener on a UI container other than stage will not work.
        */
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event)->{
            if("DOWN".equals(event.getCode().toString())){
                imageView.setY(imageView.getY() + 5);
            }
            else if("RIGHT".equals(event.getCode().toString())){
                imageView.setX(imageView.getX() + 5);
            }
            else if("UP".equals(event.getCode().toString())){
                imageView.setY(imageView.getY() - 5);
            }
            else if("LEFT".equals(event.getCode().toString())){
                imageView.setX(imageView.getX() - 5);
            }
            
            textArea.appendText(event.getCode() + "\n");
        });
        
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("Clear Button Pressed!"); 
        textArea.clear();
    }  
    
}
