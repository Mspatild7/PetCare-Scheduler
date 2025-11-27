package com.pet.scheduler;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Pet> map = new HashMap<>();

        DataManager.loadData(map);

        //map.put(1, new Pet(1,"Buddy","Golden Retriever",3,"Alice Johnson","alice@gmail.com",LocalDate.of(2024, 5, 12)));
        //ArrayList<Appointment> appointment = new ArrayList<>();

         // Auto-Load data during program run , It will work as a Local database

        InputHelper inputHelper = new InputHelper(scanner);
        PetService petService = new PetService(scanner);
        try {
            // Display the menu and process user choices in a loop
            while (true) {
                 //System.out.println("----------------------");
                System.out.println(
                        "Press 1 for Pet Registration\nPress 2 for Appointment\nPress 3 for Display Details\nPress 4 for Generate Reports\nPress 5 for Save Data\nPress 6 for Exit");
                System.out.print("Please Select one option : ");
                // Read user input
                Integer userChoice = inputHelper.userChoice();

                // Consume the newline character left by nextInt()
                scanner.nextLine();

                switch (userChoice) {
                    case 1: //Register Pet
                        petService.register(map);
                        break;

                    case 2: // Take an Appointment
                        petService.appointment(map);
                        break;

                    case 3: // Display Details
                        petService.display(map);
                        break;

                    case 4: // Generate Reports
                        System.out.println("===================================");
                        petService.generateReports(map);
                        break;

                    case 5: // Save Data
                        DataManager.saveData(map);
                        break;

                    case 6:
                        return;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }finally{
            scanner.close();
        }
    }
}

