package com.hospital.models;
import java.util.ArrayList;

public class Patient extends Person{
    private ArrayList<Appointment>appointments;

    public Patient(String name, String email, String id, String phone){
        super(name, email, id, phone);
        this.appointments = new ArrayList<>();
    }

    public Patient(String name, String email, String id, ArrayList appointments, String phone){
        super(name, email, id, phone);
        this.appointments=appointments;
    }

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }
    public void setAppointments(ArrayList<Appointment> appointments){
        this.appointments=appointments;
    }
    @Override
    public String toString(){
    return "Patient{" +
           "name='" + getName() + '\'' +
           ", id='" + getId() + '\'' +
           ", email='" + getEmail() + '\'' +
           ", phone='" + getPhone() + '\'' +
           ", appointments=" + (appointments != null ? appointments.size() : 0) +
           '}';
}
}