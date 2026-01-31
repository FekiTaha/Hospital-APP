package com.hospital.utils;

public class InputValidator{
    
    public static boolean isValidName(String name){

            if(name==null || name.trim().isEmpty()){
                return false;
            }

            if (name.length() > 20) {
                return false;
    }

            if (!name.matches("[A-Z][a-zA-Z]*")) {
                return false;
            }
            return true;
            }

    public static boolean isValidNumeric(String nb) {
    try {
        int value = Integer.parseInt(nb);
        if (value <= 0) {
            
            return false;
        }
        return true;
    } catch (NumberFormatException e) {

        return false;
    }
}
    public static boolean isValidEmailFormat(String email){
        String regex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!email.matches(regex)){
            return false;
        }
        return true;
}
    //private static HospitalManagementSystem hms;
    
}