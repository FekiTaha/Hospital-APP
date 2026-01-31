package com.hospital.models;

public class Device{
    private String name;
    private String status;
    public Device(String name, String status){
        this.name=name;
        this.status=status;
    }

    public String getStatus(){
        return status;
    }
    public String getName(){
        return name;
    }
    void setStatus(String status){
        this.status=status;
    }
    void setName(String name){
        this.name=name;
    }
    public String toString(){
        return "Device= "+getName()+"'\'"+"Status= "+getStatus();
    }


}