/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class DocumentEditor2 extends Application {
    
    public String title = "Document Editor 2";
    public int width = 800;
    public int height = 700;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        VBox root = new VBox(20);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(20);
        
        Label titleLabel = new Label("Title");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        grid.add(titleFieldBox, 0, 0);
        
//        TextArea editor = new TextArea(); 
//        editor.setPrefRowCount(25);
//        editor.setPrefColumnCount(50);
//        root.add(editor, 0, 1);
        
        HTMLEditor editor = new HTMLEditor();
        editor.setPrefSize(600, 500);
        grid.add(editor, 0, 1);
        
        Button saveButton = new Button("Save");
        HBox saveButtonBox = new HBox();
        saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
        saveButtonBox.getChildren().add(saveButton);
        grid.add(saveButtonBox, 0, 2);
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(saveMenuItem);
        
        openMenuItem.setOnAction((ActionEvent event)->{
            System.out.println("Open Chosen.");
        });
        
        saveMenuItem.setOnAction((ActionEvent event)->{
            System.out.println("Save Chosen.");
        });
        
        saveButton.setOnAction((ActionEvent e)->{
            System.out.println("Save Button Clicked.");
        });
        
        saveButton.setRotate(45);
        editor.setRotate(-90);
        titleField.setRotate(5);
        
        root.getChildren().add(menuBar);
        
        root.getChildren().add(grid);
        
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
