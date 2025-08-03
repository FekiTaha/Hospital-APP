package com.hospital.models;

import java.time.LocalDate;

public class Appointment{
    LocalDate dateTime;
    Doctor doctor;
    Patient patient;
    Device device;
    
    public Appointment(Doctor doctor, Patient patient, Device device, LocalDate dateTime){
        this.doctor=doctor;
        this.patient=patient;
        this.device=device;
        this.dateTime=dateTime;
    }
    public void displayInfo(){
        System.out.println("Doctor: "+doctor+"\nPatient: "+ patient+ "\nDevice: " +device+ "\nDate: "+dateTime);
    }
}