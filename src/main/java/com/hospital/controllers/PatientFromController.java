package com.hospital.controllers;

import java.io.IOException;

import com.hospital.MainTest;
import com.hospital.models.Patient;
import com.hospital.service.PatientService;
import com.hospital.service.PatientServiceImpl;
import com.hospital.utils.AppNavigator;
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
    @FXML private TextField txtPhone;

    private PatientService patientService;
    @FXML
    public void initialize(){
        patientService = new PatientServiceImpl(MainTest.getHospitalManagementSystem());
    }
    

    @FXML void handleBackToHome(ActionEvent event) throws IOException{
        AppNavigator.switchScene("Home.fxml", event);
    }

    @FXML
    void handleCancelPatient(ActionEvent event) {
        txtName.clear();
        txtPhone.clear();
        txtId.clear();
        txtEmail.clear();
        statusLabel.setText("");

    }

    @FXML
    void handleSavePatient(ActionEvent event) {
        String name= txtName.getText();
        String id= txtId.getText();
        String email=txtEmail.getText();
        String phone=txtPhone.getText();

        if(!InputValidator.isValidName(name)){
            statusLabel.setText("Invalid name !");
            return;
        }
        if(!InputValidator.isValidNumeric(id)){
            statusLabel.setText("Invalid ID !");
            return;
        }
        if(!InputValidator.isValidEmailFormat(email)){
            statusLabel.setText("Invalid E-mail !");
            return;
        }
        if(!InputValidator.isValidNumeric(phone)){
            statusLabel.setText("Invalid phone number");
            return;
        }
        try {
            Patient patient= patientService.createPatient(name, email, id, phone);
            showSuccess("Patient added successfully: "+ patient.getName());
            clearForm();
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
        catch(Exception e){
            showError("An error has occured: " + e.getMessage());

        }
    }
    private void showError(String message){
        statusLabel.setStyle("-fx-text-fill: red;");
        statusLabel.setText(message);
    }

    private void showSuccess(String message){
        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText(message);
    }
    private void clearForm(){
        txtName.clear();
        txtId.clear();
        txtEmail.clear();
        txtPhone.clear();
    }
    
}
