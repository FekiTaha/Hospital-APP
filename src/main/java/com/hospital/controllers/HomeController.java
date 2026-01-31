package com.hospital.controllers;

import java.io.IOException;

import com.hospital.utils.AppNavigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class HomeController {

    @FXML
    private BorderPane mainRoot;

    @FXML
    void handleAddDoctor(ActionEvent event) throws IOException {
        AppNavigator.switchScene("AddDoctorScene.fxml", event);

    }

    @FXML
    private void handleAddPatient(ActionEvent event) throws IOException {
        AppNavigator.switchScene("AddPatientScene.fxml", event);

    }

    @FXML
    void handleAppointments(ActionEvent event) {

    }

    @FXML
    void handleViewDoctor(ActionEvent event) {

    }

}

