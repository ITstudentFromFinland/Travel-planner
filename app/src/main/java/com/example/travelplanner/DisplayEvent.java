package com.example.travelplanner;

public class DisplayEvent {
  private int tripID;
  private String tripTitle;
  private String passenger1;
  private String passenger2;
  private String passenger3;
  private String passenger4;

  public DisplayEvent(int id, String title, String passenger1, String passenger2, String passenger3, String passenger4) {
    this.tripID = id;
    this.tripTitle = title;
    this.passenger1 = passenger1;
    this.passenger2 = passenger2;
    this.passenger3 = passenger3;
    this.passenger4 = passenger4;
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
    this.passenger1 = passenger1;
    this.passenger2 = passenger2;
    this.passenger3 = passenger3;
    this.passenger4 = passenger4;
  }

  public String getEventDescription() {
    return this.tripTitle;
  }
}
