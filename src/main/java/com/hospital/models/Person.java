package com.hospital.models;

public abstract class Person{
    private String name;
    private String email;
    private String id;
    private String phone;

    protected Person(String name, String email, String id, String phone) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.phone=phone;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getId(){
        return id;
    }
    public String getPhone(){
        return phone;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    @Override
    public String toString(){
        return "Person{"+"name"+getName()+'\'' +
           ", id='" + getId() + '\'' +
           ", email='" + getEmail() + '\'' +
           ", phone='" + getPhone();
    }
}