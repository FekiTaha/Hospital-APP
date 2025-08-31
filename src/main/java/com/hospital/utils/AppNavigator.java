package com.hospital.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
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
}