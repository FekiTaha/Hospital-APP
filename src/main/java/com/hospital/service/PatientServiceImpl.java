package com.hospital.service;

import java.util.ArrayList;
import java.util.List;

import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Patient;

public class PatientServiceImpl implements PatientService {

    private final HospitalManagementSystem hms;
    public PatientServiceImpl(HospitalManagementSystem hms){ // dependecy injection
        if (hms==null){
            throw new IllegalArgumentException("Hospital Management System cannot be null !");
        }
        this.hms=hms;
    }
    @Override
    public Patient createPatient(String name, String email, String id, String phone){
        Patient existing= getPatientById(id);
        if(existing!=null){
            throw new IllegalArgumentException("Patient with ID:"+id+" already exists");
        }
        Patient patient= new Patient(name, email, id, phone);
        hms.addPatientInList(patient);
        return patient;
    }

    @Override
    public Patient getPatientById(String id){
        for (Patient p : hms.getPatients()){
            if (id.equals(p.getId())){
                return p;
                }
            }
            return null;
            }

    @Override
    public List<Patient> getAllPatients(){
        return new ArrayList<>(hms.getPatients());
    }

    @Override
    public boolean updatePatient(Patient patient){
        if(patient==null || patient.getId()==null){
            return false;
        }
        Patient existing= getPatientById(patient.getId());
        if(existing==null){
            return false;
        }
        // patient is the input updates from the controller
        existing.setName(patient.getName());
        existing.setEmail(patient.getEmail());
        existing.setPhone(patient.getPhone());
        return true;
    }

    @Override
    public boolean deletePatient(String id){
        if(id==null){
            return false;
        }
        Patient patient=getPatientById(id);
        if(patient==null){
            return false;
        }
        boolean removed= hms.getPatients().remove(patient);
        return removed;
    }

    @Override
    public List<Patient> searchPatientByName(String namePart){
        List<Patient> results= new ArrayList<>();
        for(Patient p : hms.getPatients()){
            if(p.getName().toLowerCase().contains(namePart.toLowerCase().trim())){
                results.add(p); 
            }
        }
        return results;
    }
}
