package com.pet.scheduler;

import java.time.*;
import java.util.HashMap;
import java.util.Scanner;

public class PetService {

    Scanner scanner;
    InputHelper inputHelper;

    public PetService(Scanner scanner){
        this.scanner = scanner;
        inputHelper = new InputHelper(scanner);
        
    }

    public void register(HashMap<Integer,Pet> map) {

      try{
        System.out.println("Enter Pet Details : ");
        System.out.println("-------------------");
        String name = inputHelper.petName();
        String breed = inputHelper.petBreed();
        int age = inputHelper.petAge();
        String ownerName = inputHelper.petOwnerName();
        String contactInfo = inputHelper.petContactInfo();
        LocalDate regDate = inputHelper.petRegDate();
    

        Pet pet = new Pet(inputHelper.petId(), name, breed, age, ownerName, contactInfo, regDate);

        map.put(pet.getUniqueId(), pet);

        System.out.println("Pet Registered Successfully!");
        System.out.println("-------------------------------");
        System.out.println("Pet Details : " + pet.toString());
        System.out.println("-------------------------------");
        
      }catch(Exception e){
          System.out.println("Error : " + e.getMessage());
      }
    }

    public void appointment(HashMap<Integer,Pet> map) {
        if(map.isEmpty()){
            System.out.println("No Pet Registered");
            return;
        }
        System.out.print("Please Enter Pet uniqueID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if(!map.containsKey(id)){
            System.out.println("Pet not found with given ID.");
            return;
        }

        Pet pet = map.get(id);
        String appointmentType = inputHelper.petappointmentType();
        LocalDateTime localDateTime = inputHelper.petSchedule();
        String notes = inputHelper.petNotes();
        Appointment appointment = new Appointment(appointmentType, localDateTime, notes);

        pet.addAppointment(appointment);
    }

}