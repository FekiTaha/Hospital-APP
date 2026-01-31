package com.hospital.controllers;

import java.io.IOException;

import com.hospital.MainTest;
import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Doctor;
import com.hospital.utils.AppNavigator;
import com.hospital.utils.InputValidator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class DoctorFromController {
    private HospitalManagementSystem hms = MainTest.getHospitalManagementSystem();

    @FXML private ComboBox<String> cmbSpecialization;
    @FXML private GridPane doctorRoot;
    @FXML private Label statusLabel;
    @FXML private TextField txtEmail;
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;
    @FXML private TextField txtId;

    @FXML private void initialize() {
        // Populate the ComboBox with specializations
        cmbSpecialization.setItems(FXCollections.observableArrayList(
        "Cardiology",
        "Neurology",
        "Orthopedics",
        "Pediatrics"
    ));
}

    @FXML
    void handleBackToHome(ActionEvent event) throws IOException {
        AppNavigator.switchScene("Home.fxml",event);

    }
    @FXML
    void handleCancel(ActionEvent event) {

        txtEmail.clear();
        txtName.clear();
        txtPhone.clear();
        txtId.clear();
    }

    @FXML
    void handleSaveDoctor(ActionEvent event) {

        String name= txtName.getText();
        String phone= txtPhone.getText();
        String email= txtEmail.getText();
        String id= txtId.getText();
        String specialization= cmbSpecialization.getValue();

        if(specialization==null){
            statusLabel.setText("Please select the specialization!");
            return;
        }

        if(!InputValidator.isValidName(name)){
            statusLabel.setText("Invalid Name!");
            return;
        }

        if(!InputValidator.isValidEmailFormat(email)){
            statusLabel.setText("Invalid Email!");
            return;
        }

        if(!InputValidator.isValidNumeric(phone)){
            statusLabel.setText("Invalid Phone!");
            return;
        }

        Doctor doctor= new Doctor(name,email,id,specialization,phone);
        hms.addDoctorInList(doctor);
        statusLabel.setText("Doctor added!");

    }
}

