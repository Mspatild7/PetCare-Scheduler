package com.pet.scheduler;

import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetService {

    Scanner scanner;
    InputHelper inputHelper;

    public PetService(Scanner scanner) {
        this.scanner = scanner;
        inputHelper = new InputHelper(scanner);

    }

    public void register(HashMap<Integer, Pet> map) {

        try {
            System.out.println("Enter Pet Details : ");
            System.out.println("-------------------");
            String name = inputHelper.petName();
            String breed = inputHelper.petBreed();
            int age = inputHelper.petAge();
            while (age > 100) {
                System.out.println("InValid age, please input valid age");
                age = inputHelper.petAge();
            }
            String ownerName = inputHelper.petOwnerName();
            String contactInfo = inputHelper.petContactInfo();
            LocalDate regDate = inputHelper.petRegDate();

            Pet pet = new Pet(inputHelper.petId(), name, breed, age, ownerName, contactInfo, regDate);

            map.put(pet.getUniqueId(), pet);

            System.out.println("Pet Registered Successfully!");
            System.out.println("Pet Details : " + pet.toString());
            

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void appointment(HashMap<Integer, Pet> map) {
        if (map.isEmpty()) {
            System.out.println("No Pet Registered");
            return;
        }
        System.out.print("Please Enter Pet uniqueID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!map.containsKey(id)) {
            System.out.println("Pet not found with given ID.");
            return;
        }

        Pet pet = map.get(id);
        AppointmentType appointmentType = (inputHelper.petappointmentType());

        LocalDateTime localDateTime = inputHelper.petSchedule();
        while (localDateTime.isBefore(LocalDateTime.now())) {
            System.out.println("appointment should be after current time, please recheck date.");
            localDateTime = inputHelper.petSchedule();
        }
        String notes = inputHelper.petNotes();
        System.out.println("----------------------");
        Appointment appointment = new Appointment(appointmentType, localDateTime, notes);

        pet.addAppointment(appointment);

        System.out.println(appointment.toString());
    }
    public void display(HashMap<Integer, Pet> map) {
        try {
            if (map.isEmpty()) {
                System.out.println("No Pet Registered");
                return;
            }

            //Menu for display different details :
            /* 
            All registered pets
            All appointments for a specific pet
            Upcoming appointments for all pets
            Past appointment history for each pet
            */
             System.out.println("----------------------");
            System.out.println("Press 1 for Display Pet Details\nPress 2 for Display Appointment Details for pet\nPress 3 for Display Upcoming Appointment Details\nPress 4 for Display Past Appointment Details");
            System.out.print("Please Select one option : ");
            Integer userChoice = inputHelper.userChoice();
            scanner.nextLine();
            switch (userChoice){
                    case 1:
                        displayPetDetails(map);
                        break;
                    case 2:
                        displayAppointmentDetails(map);
                        break;
                    case 3:
                        displayUpcomingAppointmentDetails(map);
                        break;
                    case 4:
                        displayPastAppointmentDetails(map);
                        break;
                    default:
                        break;
            }

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
    public void displayPetDetails(HashMap<Integer, Pet> map){
        System.out.println("All Registered Pets:");
        for (Map.Entry<Integer, Pet> entry : map.entrySet()){
            //System.out.println("Pet ID : " + entry.getKey());
            System.out.println("----------------------");
            System.out.println(entry.getValue().toString());
        }
    }
    public void displayAppointmentDetails(HashMap<Integer, Pet> map){
        System.out.print("Please Enter Pet uniqueID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!map.containsKey(id)) {
            System.out.println("Pet not found with given ID.");
            return;
        }

        Pet p = map.get(id);

        if (p.getAppointment().isEmpty()) {
            System.out.println("No Appointments for " + p.getName());
            return;
        }

        System.out.println("========================================");
        System.out.println("Appointment Details for Pet: " + p.getName() + " (ID: " + p.getUniqueId() + ")");
        System.out.println("========================================");

        int index = 1;
        for (Appointment a : p.getAppointment()){
            System.out.println("#" + index++);
            System.out.println("----------------------");
            System.out.println(a.toString());
            System.out.println("----------------------\n");
        }
    }
    public void displayUpcomingAppointmentDetails(HashMap<Integer, Pet> map){
        int found = 0;

        for (Pet p : map.values()) {
            for (Appointment a : p.getAppointment()) {
                if (a.getAppointmentDateTime().isAfter(LocalDateTime.now())) {
                    System.out.println("----------------------");
                    System.out.println("Pet: " + p.getName() + " (ID: " + p.getUniqueId() + ")");
                    System.out.println(a.toString());
                    found++;
                }
            }
        }

        if (found == 0) {
            System.out.println("No Upcoming Appointments");
        }
    }
    public void displayPastAppointmentDetails(HashMap<Integer, Pet> map) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixMonthsAgo = now.minusMonths(6);
        int found = 0;

        for (Pet p : map.values()) {
            for (Appointment a : p.getAppointment()) {
                LocalDateTime appTime = a.getAppointmentDateTime();

                if (appTime.isBefore(now) && appTime.isAfter(sixMonthsAgo)) {
                    System.out.println("----------------------");
                    System.out.println("Pet: " + p.getName() + " (ID: " + p.getUniqueId() + ")");
                    System.out.println(a.toString());
                    found++;
                }
            }
        }

        if (found == 0) {
            System.out.println("No Past Appointments in last 6 months.");
        }
    }
    public void generateReports(HashMap<Integer, Pet> map){
        System.out.println("----------------------");
        System.out.println("Press 1 for Pets with upcoming appointments in the next week\nPress 2 for Pets overdue for a vet visit");
        System.out.print("Please Select one option : ");
        Integer userChoice = inputHelper.userChoice();
        scanner.nextLine();
        switch (userChoice){
                case 1:
                    displayUpcomingAppointmentDetails(map);
                    break;
                case 2:
                    displayPastAppointmentDetails(map);
                    break;
                default:
        }
    }

}