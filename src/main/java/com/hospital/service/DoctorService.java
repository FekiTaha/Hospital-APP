package com.hospital.service;

import java.util.List;

import com.hospital.models.Doctor;

public interface DoctorService {
    Doctor createDoctor(String name, String email, String id, String Specialization, String phone);
    Doctor getDoctorById(String id);
    List<Doctor> getAllDoctors();
    List<Doctor> searchDoctorByName(String namePart);
    List<Doctor> searchDoctorBySpecialization(String specialization);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(String id);
}
