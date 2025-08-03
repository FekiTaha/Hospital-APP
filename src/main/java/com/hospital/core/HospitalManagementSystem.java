package com.hospital.core;

import java.util.ArrayList;

import com.hospital.models.Appointment;
import com.hospital.models.Device;
import com.hospital.models.Doctor;
import com.hospital.models.Patient;


public class HospitalManagementSystem{
    public ArrayList<Patient> patients;
    public ArrayList<Doctor> doctors;
    public ArrayList<Device> devices;
    public ArrayList<Appointment> appointments;

    public HospitalManagementSystem(
        ArrayList<Patient> patients,
        ArrayList<Doctor> doctors,
        ArrayList<Device> devices,
        ArrayList<Appointment> appointments){

        this.patients=new ArrayList<>(patients);
        this.doctors=new ArrayList<>(doctors);
        this.devices=new ArrayList<>(devices);
        this.appointments=new ArrayList<>(appointments);
    }

    public void showDevices(){
        for (Device dev : devices) {
            dev.displayInfo();
        }
    }

    public void showDoctors(){
        for (Doctor doc : doctors) {
            doc.afficherInfo();
        }
    }

    public void showPatients(){
        for (Patient pat : patients) {
            pat.afficherInfo();
        }
    }

    public void showAppointments(){
        for (Appointment app : appointments) {
            app.displayInfo();
        }
    }


    public void addPatientInList(Patient patient){
        patients.add(patient);
    }

    public void addDoctorInList(Doctor doctor){
        doctors.add(doctor);
    }

    public void addAppointmentInList(Appointment appointment){
        appointments.add(appointment);
    }

    public void addDeviceInList(Device device){
        devices.add(device);
    }
}