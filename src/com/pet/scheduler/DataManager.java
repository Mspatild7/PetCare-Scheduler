package com.pet.scheduler;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.*;

public class DataManager {

   public static void saveData(HashMap<Integer, Pet> map) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("pet.json"));
        bw.write("[\n");

        int index = 0;
        int size = map.size();

        for (Pet p : map.values()) {
            bw.write(p.toJson());
            if (index < size - 1) {
                bw.write(",\n"); // separate objects in array
            }
            index++;
        }

        bw.write("\n]");
        bw.close();
        System.out.println("Data Saved Successfully.");
    } catch (Exception e) {
        System.out.println("Error saving data: " + e.getMessage());
    }
}

    public static void loadData(HashMap<Integer, Pet> map) {
        try {
            File file = new File("pet.json");
            if (!file.exists())
                return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                sb.append(line);
            br.close();

            JSONArray array = new JSONArray(sb.toString());
            int maxId = 0;

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                int id = obj.getInt("uniqueId");
                Pet pet = new Pet(
                        id,
                        obj.getString("name"),
                        obj.getString("breed"),
                        obj.getInt("age"),
                        obj.getString("ownerName"),
                        obj.getString("contactInfo"),
                        LocalDate.parse(obj.getString("regDate")));

                JSONArray appts = obj.getJSONArray("appointments");
                for (int j = 0; j < appts.length(); j++) {
                    JSONObject a = appts.getJSONObject(j);
                    AppointmentType type = AppointmentType.valueOf(a.getString("appointmentType"));
                    LocalDateTime time = LocalDateTime.parse(a.getString("appointmentDateTime"));
                    String notes = a.getString("notes");
                    pet.addAppointment(new Appointment(type, time, notes));
                }

                map.put(id, pet);
                if (id > maxId)
                    maxId = id;
            }

            InputHelper.id = maxId;

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

}
