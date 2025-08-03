package com.hospital.models;


public abstract class Person{
    String name;
    String email;
    String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    public void afficherInfo(){
        System.out.println("Name: "+ name+"\nEmail: "+email+"\nID: "+id);
        specInfo();
    }
    
    abstract void specInfo();
}