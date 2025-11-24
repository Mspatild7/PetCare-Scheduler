package com.pet.scheduler;

import java.time.LocalDateTime;


public class Appointment {

    private String appointmentType;
    private LocalDateTime schedule;
    private String notes;


   public Appointment(String appointmentType, LocalDateTime appointment, String notes){
       this.appointmentType = appointmentType;
       this.schedule = schedule;
       this.notes = notes;
   }

   //getters

  public String getappointmentType(){
      return appointmentType;
  }

  public LocalDateTime getSchedule(){
      return schedule;
  }

  public String getNotes(){
      return notes;
  }

  //setters
  public void setappointmentType(String appointmentType){
      this.appointmentType = appointmentType;
  }

  public void setSchedule(LocalDateTime schedule){
      this.schedule = schedule;
  }

  public void setNotes(String notes){
      this.notes = notes;
  }

  public String toString(){
      return "Appointment [appointmentType=" + appointmentType + ", schedule=" + schedule + ", notes=" + notes + "]";
  }
}
