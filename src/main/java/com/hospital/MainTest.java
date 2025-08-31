package com.hospital;

import java.util.ArrayList;

import com.hospital.core.HospitalManagementSystem;
import com.hospital.utils.AppNavigator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainTest extends Application{
    private static HospitalManagementSystem hms;

    @Override
    public void start(Stage primaryStage) throws Exception{
        hms= new HospitalManagementSystem(
            new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        AppNavigator.loadScene(primaryStage,"Home.fxml","Hospital Management System");
    }
    public static HospitalManagementSystem getHospitalManagementSystem(){
        return hms;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
