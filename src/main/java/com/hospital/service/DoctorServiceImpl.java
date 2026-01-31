package com.hospital.service;

import java.util.ArrayList;
import java.util.List;

import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Doctor;

public class DoctorServiceImpl implements DoctorService {
    
    private final HospitalManagementSystem hms;
    public DoctorServiceImpl(HospitalManagementSystem hms){ // dependecy injection 
        if(hms==null){
            throw new IllegalArgumentException("Hospital Management System cannot be null !");    
        }
        this.hms=hms;
    }

    @Override
    public Doctor createDoctor(String name, String email, String id, String specialization, String phone){
        Doctor existing= getDoctorById(id);
        if(existing!=null){
            throw new IllegalArgumentException("Doctor with ID: "+id+" already exists !");
        }
        Doctor doctor= new Doctor(name, email, id, specialization, phone);
        hms.addDoctorInList(doctor);
        return doctor;
    }

    @Override
    public Doctor getDoctorById(String id){
        for(Doctor d : hms.getDoctors()){
            if(id.equals(d.getId())){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return new ArrayList<>(hms.getDoctors());
    }

    @Override
    public boolean updateDoctor(Doctor doctor){
        if(doctor==null || doctor.getId()==null){
            return false;
        }
        Doctor existing=getDoctorById(doctor.getId());
        if(existing==null){
            return false;
        }
        existing.setName(doctor.getName());
        existing.setEmail(doctor.getEmail());
        existing.setPhone(doctor.getPhone());
        return true;
    }

    @Override
    public boolean deleteDoctor(String id){
        if(id==null){
            return false;
        }
        Doctor doctor= getDoctorById(id);
        boolean removed= hms.getDoctors().remove(doctor);
        return removed;
    }

    @Override
    public List<Doctor> searchDoctorByName(String namePart){
        List<Doctor> results= new ArrayList<>();
        for(Doctor d : hms.getDoctors()){
            if(d.getName().toLowerCase().contains(namePart.toLowerCase().trim())){
            results.add(d);
            }
        }
        return results;
    }

    @ Override
    public List<Doctor> searchDoctorBySpecialization(String specialization){
        List<Doctor> results = new ArrayList<>();
        for(Doctor d : hms.getDoctors()){
            if(d.getSpecialization().equalsIgnoreCase(specialization)){
                results.add(d);
            }
        }
        return results;
    }




}
