/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class DocumentEditor1 extends Application {
    
    public String title = "Document Editor";
    public int width = 800;
    public int height = 700;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(20);
        
        Label titleLabel = new Label("Title");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        root.add(titleFieldBox, 0, 0);
        
//        TextArea editor = new TextArea(); 
//        editor.setPrefRowCount(25);
//        editor.setPrefColumnCount(50);
//        root.add(editor, 0, 1);
        
        HTMLEditor editor = new HTMLEditor();
        editor.setPrefSize(600, 500);
        root.add(editor, 0, 1);
        
        Button saveButton = new Button("Save");
        HBox saveButtonBox = new HBox();
        saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
        saveButtonBox.getChildren().add(saveButton);
        root.add(saveButtonBox, 0, 2);
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
