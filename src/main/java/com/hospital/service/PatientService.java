package com.hospital.service;

import java.util.List;

import com.hospital.models.Patient;

public interface PatientService {
    Patient createPatient(String name, String email, String id, String phone);
    Patient getPatientById(String id);
    List<Patient> getAllPatients();
    boolean updatePatient(Patient patient);
    boolean deletePatient(String id);
    List<Patient> searchPatientByName(String namePart);
}
