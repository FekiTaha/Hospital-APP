package com.hospital.controllers;

import com.hospital.utils.AppNavigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private BorderPane mainRoot;

    @FXML
    void handleAddDoctor(ActionEvent event) {

    }

    @FXML
    private void handleAddPatient(ActionEvent event) {
        Stage stage =new Stage();
        AppNavigator.loadScene(stage, "AddPatientScene.fxml", "Add Patient");

    }

    @FXML
    void handleAppointments(ActionEvent event) {

    }

    @FXML
    void handleViewDoctor(ActionEvent event) {

    }

}

