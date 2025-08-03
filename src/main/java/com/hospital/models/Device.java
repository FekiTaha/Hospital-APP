package com.hospital.models;

public class Device{
    String name;
    String status;
    public Device(String name, String status){
        this.name=name;
        this.status=status;
    }
    void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    public String getName(){
        return name;
    }

    public void displayInfo(){
        System.out.println("Device: "+name+"Status: "+ status);
    }
}