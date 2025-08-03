package com.hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.hospital.core.HospitalManagementSystem;
import com.hospital.models.Appointment;
import com.hospital.models.Device;
import com.hospital.models.Doctor;
import com.hospital.models.Patient;
import com.hospital.utils.InputValidator;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static HospitalManagementSystem hms;

    public static void main(String[] args) {
        //initialize the hospital system
        hms = new HospitalManagementSystem(
            new ArrayList<>(),
            new ArrayList<>(), 
            new ArrayList<>(), 
            new ArrayList<>());
            
        run();
    }
    public static void run() {
        while (true) {
            System.out.println("\n--- Hospital Management Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Device");
            System.out.println("4. Schedule appointment");
            System.out.println("5. Show Devices");
            System.out.println("6. Show Patients");
            System.out.println("7. Show Doctors");
            System.out.println("8. Show appointments");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addPatientFromInput();
                    break;
                case 2:
                    addDoctorFromInput();
                    break;
                case 3:
                    addDeviceFromInput();
                    break;
                case 4:
                    addAppointmentFromInput();
                    break;
                case 5:
                    hms.showDevices();
                    break;
                case 6:
                    hms.showPatients();
                    break;
                case 7:
                    hms.showDoctors();
                    break;
                case 8:
                    hms.showAppointments();
                    break;
                case 9:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static void addPatientFromInput() {

        System.out.println("\n--- Add New Patient ---");

        String name;
        while(true){
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if(InputValidator.isValidName(name)){
            System.out.println("Name successfully added! ");
            break;
            }
        }

        String id;
        while(true){
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if(InputValidator.isValidId(id)){
            System.out.println("ID successfully added! ");
            break;
        }
        }
        String email;
        while (true) { 
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if(InputValidator.isValidEmailFormat(email)){
                System.out.println("E-mail successfully added! ");
                break;
            }
        }

        Patient newPatient = new Patient(name, email, id);
        hms.addPatientInList(newPatient);
        System.out.println("Patient added!");
    }

    public static void addDoctorFromInput() {
        System.out.println("\n--- Add New Doctor ---");
        String name;
        while(true){
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if(InputValidator.isValidName(name)){
                break;
            } 
        }

        String id;
        while(true){
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if(InputValidator.isValidId(id)){
                break;
            }
            
        }

        String email;
        while(true){
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if(InputValidator.isValidEmailFormat(email)){
                break;
            }
            System.out.println("Try again: ");
        }

        String specialization;
        while (true) { 
            System.out.print("Enter specialization: ");
            specialization = scanner.nextLine();
            if(specialization.matches("[A-Za-z]+")){
                break;
            }
            System.out.println("Invalid format. Try again: ");
        }
        Doctor newDoctor = new Doctor(name, email, id, specialization);
        hms.addDoctorInList(newDoctor);
        System.out.println("Doctor added!");
    }

    public static void addDeviceFromInput(){
        
        String name;
        while(true){
            System.out.println("Enter device name: ");
            name= scanner.nextLine();
            if(InputValidator.isValidName(name)){
                break;
            }
            System.out.println("Try Again: ");
        }

        String status;
        
        List<String> allowedStatuses = Arrays.asList("Available", "In Use", "Under Maintenance");
        while (true) { 
            System.out.println("Enter Device Status: ");
            status= scanner.nextLine();
            if(!allowedStatuses.contains(status)){
                    System.out.println("Invalid status! Allowed: " + allowedStatuses);
            }
            else{
            System.out.println("Status updated successfully to: " + status);
            break;
                }
            }
    Device newDevice= new Device(name, status);
    hms.addDeviceInList(newDevice);
    System.out.println("Device added: " + newDevice.getName() + " | " + newDevice.getStatus());
    }

    public static void addAppointmentFromInput(){

        String doctorName;
        String patientName;
        Doctor selectedDoctor= null;
        
        while (true) { 
            System.out.println("Enter the Doctor: ");
            doctorName= scanner.nextLine();

            for(Doctor doc : hms.doctors){
            if(doc.getName().equalsIgnoreCase(doctorName)){
                selectedDoctor=doc;
                break;
            }
            }
            if(selectedDoctor!=null){
                System.out.println("Doctor added to the appointment");
                break;
            }
            System.out.println("Doctor not found. Try again: ");
            }

        Patient selectedPatient= null;

         while (true) { 
            System.out.println("Enter the Patient: ");
            patientName= scanner.nextLine();

            for(Patient pat : hms.patients){
            if(pat.getName().equalsIgnoreCase(patientName)){
                break;
            }
                }
            if(selectedPatient!=null){
                System.out.println("Patient added to the appointment");
                break;
            }
            System.out.println("Patient name not found. Try again: ");
        }

        Device selectedDevice=null;
        String deviceName;
        boolean nameCorrect;
        boolean availableStatus;

        while(true){
            System.out.println("Enter device name");
            deviceName=scanner.nextLine();
            
            nameCorrect=false;
            availableStatus=false;

            for(Device dev : hms.devices){
                if(dev.getName().equalsIgnoreCase(deviceName)){
                    nameCorrect=true;
                    if(dev.getStatus().equalsIgnoreCase("Available")){
                    availableStatus=true;
                    selectedDevice=dev;
                    break;
                    }
                }
            }
            if(selectedDevice!=null){
                System.out.println("Device added to the appointment");
                break;
            }
            else if(!nameCorrect){
                System.out.println("Device name not found. Try again");
            }
            else if(!availableStatus){
                System.out.println("Device is unavailable");
            }
        }

        LocalDate appointmentDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
        System.out.println("Enter appointment date (format: yyyy-MM-dd): ");
        String input = scanner.nextLine();
    
        try {
            appointmentDate = LocalDate.parse(input, formatter);
            break;
            } 
        catch (DateTimeParseException e) {
        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
    }
}
    Appointment newAppointment= new Appointment(selectedDoctor, selectedPatient, selectedDevice, appointmentDate);
    hms.addAppointmentInList(newAppointment);
    System.out.println("Appointment added succefully!");
    }
//next set status


}

