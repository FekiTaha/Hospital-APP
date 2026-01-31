package com.hospital.utils;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppNavigator {
    
    public static void loadScene(Stage stage, String fxmlFile, String title){
        try{
        FXMLLoader loader= new FXMLLoader(AppNavigator.class.getResource("/com/hospital/views/"+fxmlFile));
        
        Parent root= loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
    catch(IOException e){
        e.printStackTrace();
        }
    }

    // Switch scenes without opening new windows
    public static void switchScene(String fxmlFile, ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(AppNavigator.class.getResource("/com/hospital/views/"+fxmlFile));
        Parent root= loader.load();
        // Get the current stage from the event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
        // Replace the scene
        stage.setScene(new Scene(root));
        stage.show();
}

}