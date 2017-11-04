/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 */
public class TextEditorFXMLController implements Initializable {

    @FXML
    private TextArea textArea; 
    
    @FXML
    private VBox root; 
    
    TextArea alertTextArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void handleOpen(ActionEvent event) throws IOException{
        FileChooser fileChooser = new FileChooser(); 
        
        Stage stage = (Stage) root.getScene().getWindow(); 
        
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt", "*.html", "*.c"));
        //fileChooser.showOpenDialog(stage); 
        
        File file = fileChooser.showOpenDialog(stage);
        
        if(file != null){
            BufferedReader br = null;
            
            String document = "";
            String line = "";
            
            try{
                br = new BufferedReader(new FileReader(file));
                
                while((line = br.readLine()) != null){
                    document += line + "\n";
                }
                
                textArea.setText(document);
            }
            catch(FileNotFoundException ex){
                displayExceptionAlert(ex);
            }
            catch(IOException ex){
                displayExceptionAlert(ex);
            }
            finally{
                if(br != null){
                    try{
                        br.close();
                    }
                    catch(IOException ex){
                        displayExceptionAlert(ex);
                    }
                }
            }
        }
    }
    
    @FXML
    public void handleSave(ActionEvent event){
        
        FileWriter writer;
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
        
        File file = fileChooser.showSaveDialog(stage);
        
        if(file != null){
            writer = null;
            
            try{
                writer = new FileWriter(file);
                writer.write(textArea.getText());
                writer.close();
            }
            catch(IOException ex){
                displayExceptionAlert(ex);
            }
            catch(Exception ex){
                displayExceptionAlert(ex);
            }
            finally{
                
            }
        }
    }
    
    
    private void displayExceptionAlert(Exception ex){
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText(ex.getClass().getCanonicalName());
        alert.setContentText(ex.getMessage());
        
        StringWriter sw = new StringWriter(); 
        PrintWriter pw = new PrintWriter(sw);
        
        ex.printStackTrace(pw);
        String exceptionText = sw.toString(); 
        
        
        Label label = new Label("The exception stacktrace was:"); 
        
        
        alertTextArea = new TextArea(exceptionText);
        alertTextArea.setEditable(true);
        alertTextArea.setWrapText(true);
        
        alertTextArea.setMaxWidth(Double.MAX_VALUE); 
        alertTextArea.setMaxHeight(Double.MAX_VALUE); 
        
        GridPane.setVgrow(alertTextArea, Priority.ALWAYS);
        GridPane.setHgrow(alertTextArea, Priority.ALWAYS);
        
        GridPane expContent = new GridPane(); 
        expContent.add(label, 0, 0); 
        expContent.add(alertTextArea, 0, 1); 
        
 
        // display
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
        
    }   
}