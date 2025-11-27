package com.pet.scheduler;

import java.time.LocalDateTime;

import org.json.JSONObject;

public class Appointment {

    private AppointmentType appointmentType;
    private LocalDateTime appointmentDateTime;
    private String notes;

    public Appointment(AppointmentType appointmentType, LocalDateTime appointmentDateTime, String notes) {
        this.appointmentType = appointmentType;
        this.appointmentDateTime = appointmentDateTime;
        this.notes = notes;
    }

    // getters

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public String getNotes() {
        return notes;
    }

    // setters
    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    /*
     * public void setSchedule(LocalDateTime schedule){
     * this.schedule = schedule;
     * }
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Type:        " + appointmentType + "\n" +
                "Date/Time:   " + appointmentDateTime + "\n" +
                "Notes:       " + notes + "\n" +
                "----------------------";
    }

    public JSONObject toJson() {
    JSONObject obj = new JSONObject();
    obj.put("appointmentType", appointmentType.toString());
    obj.put("appointmentDateTime", appointmentDateTime.toString());
    obj.put("notes", notes);
    return obj;
}

}
