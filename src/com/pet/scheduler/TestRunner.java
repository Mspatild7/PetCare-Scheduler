package com.pet.scheduler;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;

public class TestRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Pet> map = new HashMap<>();
        PetService service = new PetService(scanner);

        map.put(101, new Pet(1,"Buddy","Golden Retriever",3,"Alice Johnson","alice@gmail.com",LocalDate.of(2024, 5, 12)));

        service.display(map);
    }
}

