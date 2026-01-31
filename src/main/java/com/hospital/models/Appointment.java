package com.hospital.models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment{
    private String id;
    private LocalDateTime appointmentDateTime;
    private Doctor doctor;
    private Patient patient;
    private Device device;
    public Appointment(String id, Doctor doctor, Patient patient, Device device, LocalDateTime appointmentDateTime){
        this.id=id;
        this.doctor=doctor;
        this.patient=patient;
        this.appointmentDateTime=appointmentDateTime;
        this.device=device;
    }
    public Appointment(Doctor doctor, Patient patient, Device device, LocalDateTime appointmentDateTime){
        this.doctor=doctor;
        this.patient=patient;
        this.device=device;
        this.appointmentDateTime=appointmentDateTime;
    }

    public LocalDateTime getAppointmentDateTime(){
        return appointmentDateTime;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public Patient getPatient(){
        return patient;
    }
    public Device getDevice(){
        return device;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime){
        this.appointmentDateTime=appointmentDateTime;
    }
    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    public void setPatient(Patient patient){
        this.patient=patient;
    }
    public void setDevice(Device device){
        this.device=device;
    }

    @Override
    public boolean equals(Object o){
            /**
     * Compares this Appointment with another object for equality.
     * Two Appointments are considered equal if and only if they have the same id.*/

        if(this==o) return true; //check if both references point to the exact same object in memory ex: app1.equals(app2); this-->app1 o(appointment in argument)-->app2
        if(!(o instanceof Appointment)) return false; // check if the parameter is null or not an Appointment
        Appointment argumentAppointment= (Appointment) o; // cast the object parameter to Appointment type so we can access its fields
        return Objects.equals(this.id, argumentAppointment.id);
    }

    @Override
    //need to figure this out more ! 
    public int hashCode(){
        return Objects.hash(id);
    }



    @Override
    public String toString(){
        return "Appointment{" +
           "dateTime=" + appointmentDateTime +
           ", doctor=" + (doctor != null ? doctor.getName() : "null") +
           ", patient=" + (patient != null ? patient.getName() : "null") +
           ", device=" + (device != null ? device.getName() : "null") +
           '}';
    }
    public void displayInfo(){
        System.out.println(toString());
    }
}