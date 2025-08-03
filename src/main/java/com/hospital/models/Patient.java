package com.hospital.models;

import java.util.ArrayList;



public class Patient extends Person{
    ArrayList<Appointment>appointments;

    public Patient(String name, String email, String id){
        super(name, email, id);
    }

    public Patient(String name, String email, String id, ArrayList appointments){
        super(name, email, id);
        this.appointments=appointments;
    }

    public String getName(){
        return name;
    }

    @Override

    void specInfo(){
        for (Appointment app : appointments) {
            app.displayInfo();
        }
    } 
}