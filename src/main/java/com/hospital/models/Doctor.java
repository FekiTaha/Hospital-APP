package com.hospital.models;
import java.util.ArrayList;

public class Doctor extends Person{
    private String specialization;
    private ArrayList<Appointment>appointments;

    public Doctor(String name, String email, String id, String specialization, String phone){
        super(name, email, id,phone);
        this.specialization=specialization;
        this.appointments= new ArrayList<>();
    }

    public Doctor(String name, String email, String id, ArrayList<Appointment> appointments, String specialization, String phone){
        super(name, email, id, phone);
        this.appointments=appointments;
        this.specialization=specialization;
    }

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }
    public String getSpecialization(){
        return specialization;
    }
    public void setAppointments(ArrayList<Appointment> appointments){
        this.appointments=appointments;
    }
    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }
    @Override
    public String toString(){
    return "Patient{" +
           "name='" + getName() + '\'' +
           ", id='" + getId() + '\'' +
           ", email='" + getEmail() + '\'' +
           ", phone='" + getPhone() + '\'' +
           ", specialization='"+ getSpecialization()+ '\''+
           ", appointments=" + (appointments != null ? appointments.size() : 0) +
           '}';
}
}