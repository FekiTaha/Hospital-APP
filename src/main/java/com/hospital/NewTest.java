package com.hospital;

import java.util.ArrayList;
import java.util.List;

import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Doctor;
import com.hospital.service.DoctorService;
import com.hospital.service.DoctorServiceImpl;

public class NewTest {
    public static void main(String[] args) {
        HospitalManagementSystem hms= new HospitalManagementSystem(new ArrayList<>(),new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        DoctorService doctorService= new DoctorServiceImpl(hms);
        Doctor doc1= doctorService.createDoctor("Smith", "Smith@hospital.com", "001", "Cardiology", "1515785102");
        try {
            doctorService.createDoctor("Jones", "Jones@hospital.com", "001", "Neurology", "5644545452");
            System.out.println("Error should have thrown an exception, ID must be unique");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught duplicate: "+ e.getMessage());
        }
        Doctor found= doctorService.getDoctorById("001");
        System.out.println("Found"+ found.getName());
        doctorService.createDoctor("Lee", "Lee@hospital.com", "002", "Cardiology", "56498785");
        List<Doctor> cardiologists= doctorService.searchDoctorBySpecialization("Cardiology");
        System.out.println("Cardiologists: "+ cardiologists.size());
        System.out.println("Total Doctors: "+ doctorService.getAllDoctors().size());
    }
    
}
