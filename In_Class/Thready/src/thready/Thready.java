/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thready;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class Thready extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInterface.fxml"));
        Parent root = (Parent)loader.load();
        UserInterfaceController controller = (UserInterfaceController)loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        controller.ready(stage);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
