package com.hospital.utils;

public class InputValidator{
    
    public static boolean isValidName(String name){

            if(name.trim().isEmpty()){
                System.out.print("Name cannot be empty. Try again: ");
                return false;
            }

            if (name.length() > 20) {
        System.out.println("Name must not exceed 20 characters. Try again:");
        return false;
    }

            if (!name.matches("[A-Z][a-zA-Z]*")) { 
        System.out.println("Name must start with a capital letter and contain only alphabetic letters. Try again:");
        return false;
    }
            return true;
            }

    public static boolean isValidId(String id) {
    try {
        int value = Integer.parseInt(id);
        if (value <= 0) {
            System.out.println("ID must be a positive number.");
            return false;
        }
        return true;
    } catch (NumberFormatException e) {
        System.out.println("ID must be a numeric value.");
        return false;
    }
}
    public static boolean isValidEmailFormat(String email){
        String regex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!email.matches(regex)){
            System.out.println("Email is not valid. Emails must be like: example@mail.com");
            return false;
        }
        return true;
}
    //private static HospitalManagementSystem hms;
    
}