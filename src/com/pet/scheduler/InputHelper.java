package com.pet.scheduler;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class InputHelper {

    private Scanner scanner;
    private int id = 0;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer userChoice() {
        Integer choice = scanner.nextInt();
        // scanner.nextLine();
        return choice;
    }

    public int petId() {
        ++id;
        return id;
    }

    public String petName() {
        System.out.print("Enter Pet Name : ");
        return scanner.nextLine();
    }

    public String petBreed() {
        System.out.print("Enter Pet Breed : ");
        return scanner.nextLine();
    }

    public int petAge() {
        System.out.print("Enter Pet Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return age;
    }

    public String petOwnerName() {
        System.out.print("Enter Pet Owner Name : ");
        return scanner.nextLine();
    }

    public String petContactInfo() {
        System.out.print("Enter Pet Contact Info : ");
        return scanner.nextLine();
    }

    public LocalDate petRegDate() {
        return LocalDate.now();
    }

    public AppointmentType petappointmentType() {
        
        System.out.println("1. Vet Visit");
        System.out.println("2. Grooming");
        System.out.println("3. Vaccination");
        System.out.print("Choose Appointment Type: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        AppointmentType type = switch (choice) {
            case 1 -> AppointmentType.VET_VISIT;
            case 2 -> AppointmentType.GROOMING;
            case 3 -> AppointmentType.VACCINATION;
            default -> null;
        };

        return type;

    }

    public LocalDateTime petSchedule() {
        System.out.print("Enter Appointment Date and Time (dd-MM-yyyy HH:mm): ");
        String localDateTime = scanner.nextLine();
        System.out.println(localDateTime);
        return LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public String petNotes() {
        System.out.print("Please Describe pet behaviour : ");
        return scanner.nextLine();
    }
}