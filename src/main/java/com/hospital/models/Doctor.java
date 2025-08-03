package com.hospital.models;

import java.util.ArrayList;




public class Doctor extends Person{
    String specialization;
    ArrayList<Appointment>appointments;

    public Doctor(String name, String email, String id, String specialization){
        super(name, email, id);
        this.specialization=specialization;
    }

    public Doctor(String name, String email, String id, ArrayList appointments, String specialization ){
        super(name, email, id);
        this.appointments=appointments;
        this.specialization=specialization;
    }

    public String getName(){
        return name;
    }
    
    @Override

    public void specInfo(){
        System.out.println("Specialization: "+ specialization);
        for (Appointment app : appointments) {
            app.displayInfo();
        }
    } 
}