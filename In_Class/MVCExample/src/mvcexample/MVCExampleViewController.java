/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author WIN
 */
public class MVCExampleViewController implements Initializable {

    MVCExampleModal modal = new MVCExampleModal();
    TextInputDialog dialog;
    
    @FXML
    private VBox root;
    @FXML
    private MenuItem getEveryone;
    @FXML
    private MenuItem deleteEveryone;
    @FXML
    private TextArea textArea;
    @FXML
    private MenuItem addPerson;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickGetEveryone(ActionEvent event) {
        textArea.setText(modal.getEveryone().toString());
    }

    @FXML
    private void clickDeleteEveryone(ActionEvent event) {
        if(modal.deleteEveryone()){
            textArea.setText("Everyone is deleted. ");
        }
        else{
            textArea.setText("Everyone is not deleted. ");
        }
    }

    @FXML
    private void clickAddPerson(ActionEvent event) {
        dialog = new TextInputDialog();
        dialog.setContentText("Please enter person's name: ");
        
        Optional<String> result = dialog.showAndWait();
        
        System.out.println("Result: " + result.toString());
        System.out.println("Result2: " + result.get());
        
        if(result.isPresent()){
            if(modal.addPerson(result.get())){
                textArea.setText("Person " + result.get() + " was added successfully.");
            }
            else{
                textArea.setText("Person " + result.get() + " was not added.");
            }
        }
        else{
            System.out.println("No result!!!");
        }
    }
    
}
