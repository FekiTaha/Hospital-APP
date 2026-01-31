package com.hospital.core;

import java.util.ArrayList;
import java.util.List;

import com.hospital.models.Appointment;
import com.hospital.models.Device;
import com.hospital.models.Doctor;
import com.hospital.models.Patient;
public class HospitalManagementSystem {
    private  List<Patient> patients;
    private  List<Doctor> doctors;
    private  List<Device> devices;
    private  List<Appointment> appointments;

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
    public List<Device> getDevices(){
        return devices;
    }

    public List<Doctor> getDoctors(){
        return doctors;
    }

    public List<Patient> getPatients(){
        return patients;
    }

    public List<Appointment> getAppointments(){
        return appointments;
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
