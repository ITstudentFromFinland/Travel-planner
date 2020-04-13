package com.example.travelplanner;

public class DisplayEvent {
  private int tripID;
  private String tripTitle;
  private String Passenger1;
  private String Passenger2;
  private String Passenger3;
  private String Passenger4;

  // constructors
  public DisplayEvent() {
  }

  public DisplayEvent(int id, String title, String passenger1, String passenger2, String passenger3, String passenger4) {
    this.tripID = id;
    this.tripTitle = title;
    /*this.Passenger1 = passenger1;
    this.Passenger2 = passenger2;
    this.Passenger1 = passenger3;
    this.Passenger2 = passenger4;*/
  }

  // properties
  public void setDate(int id) {
    this.tripID = id;
  }

  public int getID() {
    return this.tripID;
  }

  public void setEventDescription(String title) {
    this.tripTitle = title;
    /*this.Passenger1 = passenger1;
    this.Passenger2 = passenger2;
    this.Passenger3 = passenger3;
    this.Passenger4 = passenger4;*/
  }

  public String getEventDescription() {
    return this.tripTitle;
  }
}
