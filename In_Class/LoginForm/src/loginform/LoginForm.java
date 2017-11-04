/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class LoginForm extends Application {
    
    public String title = "My First JavaFX Login"; 
    public int width = 600;
    public int height = 400;
    
    public String fontStyle = "Comic";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome, Please Login.");
        sceneTitle.setFont(Font.font(fontStyle, FontWeight.BOLD, 26));
        root.add(sceneTitle, 0, 0, 2, 1);   // Column span:2 ; Row span: 1
        
        Label userName = new Label("Username");
        userName.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(userName, 0, 1);
        
        TextField userNameTextField = new TextField();
        root.add(userNameTextField, 1, 1);
        
        Label password = new Label("Password");
        password.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(password, 0, 2);
        
        PasswordField passwordTextField = new PasswordField();
        root.add(passwordTextField, 1, 2);        
        
        root.setGridLinesVisible(true);
        
        Button button = new Button("Sign In");
        HBox hBoxForButton = new HBox(10);
        hBoxForButton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxForButton.getChildren().add(button);
        root.add(button, 1, 4);
        
        final Text actionTarget = new Text();
        GridPane.setColumnIndex(actionTarget, 1);
        GridPane.setRowIndex(actionTarget, 2);
        root.getChildren().add(actionTarget);

        button.setOnAction((ActionEvent e)->{
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sign In Button Pressed.");
            
            if(userNameTextField.getText().length() < 1){
                System.out.println("ERROR. Enter Username.");
            }
            else{
                // if they meet the criteria, usually database
                // go to another page
                System.out.println("Username: " + userNameTextField.getText());
            }
            
            if(passwordTextField.getText().length() < 1){
                System.out.println("ERROR. Enter Password.");
            }
            else{
                // if they meet the criteria, usually database
                // go to another page
                System.out.println("Password: " + passwordTextField.getText());
            }
        });
        
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
