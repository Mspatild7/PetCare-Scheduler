package com.pet.scheduler;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pet {

    private Integer uniqueId;
    private String name;
    private String breed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate regDate;
    private ArrayList<Appointment>appointment;

    public Pet(int uniqueId , String name , String breed , int age , String ownerName, String contactInfo, LocalDate regDate){
        this.uniqueId = uniqueId;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.regDate = regDate;
        this.appointment = new ArrayList<>();
    }

    //getters and setters
    public Integer getUniqueId(){
        return uniqueId;
    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public LocalDate getRegDate(){
        return regDate;
    }

    public ArrayList<Appointment> getappointment(){
        return appointment;
    }

    // Setters

    public void setUniqueId(Integer uniqueId){
        this.uniqueId = uniqueId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }

    public void setRegDate(LocalDate regDate){
        this.regDate = regDate;
    }

    public void setappointment(ArrayList<Appointment> appointment){
        this.appointment = appointment;
    }

    public void addAppointment(Appointment appointment){
        this.appointment.add(appointment);
    }

    public void removeAppointment(Appointment appointment){
        this.appointment.remove(appointment);
    }

    public String toString(){
        return "Pet [uniqueId=" + uniqueId + ", name=" + name + ", breed=" + breed + ", age=" + age + ", ownerName=" + ownerName + ", contactInfo=" + contactInfo + ", regDate=" + regDate + ", appointment=" + appointment + "]";
        
    }
}
