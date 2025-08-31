package com.hospital.controllers;

import com.hospital.MainTest;
import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Patient;
import com.hospital.utils.InputValidator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientFromController {
    @FXML private TextField txtName;
    @FXML private TextField txtId;
    @FXML private TextField txtEmail;
    @FXML private Label statusLabel;

    private HospitalManagementSystem hms = MainTest.getHospitalManagementSystem();

    @FXML
    void handleCancelPatient(ActionEvent event) {
        txtName.clear();
        txtId.clear();
        txtEmail.clear();
        statusLabel.setText("");

    }

    @FXML
    void handleSavePatient(ActionEvent event) {
        String name= txtName.getText();
        String id= txtId.getText();
        String email=txtEmail.getText();

        if(!InputValidator.isValidName(name)){
            statusLabel.setText("Invalid name !");
            return;
        }
        if(!InputValidator.isValidId(id)){
            statusLabel.setText("Invalid ID !");
            return;
        }
        if(!InputValidator.isValidEmailFormat(email)){
            statusLabel.setText("Invalid E-mail !");
            return;
        }

        Patient patient= new Patient(name,email,id);
        hms.addPatientInList(patient);
        statusLabel.setText("Patient added!");

        txtName.clear();
        txtId.clear();
        txtEmail.clear();

    }
    
    
}
