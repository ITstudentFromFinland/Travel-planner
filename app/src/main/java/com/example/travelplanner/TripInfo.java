package com.example.travelplanner;

public class TripInfo {
  private int id;
  private String name;
  private String passenger1;
  private String passenger2;
  private String passenger3;
  private String passenger4;

 public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getPassenger1() {
    return passenger1;
  }

  public void setPassenger1(String passenger1) {
    this.passenger1 = passenger1;

  }
  public String getPassenger2() {
    return passenger2;
  }

  public void setPassenger2(String passenger2) {
    this.passenger2 = passenger2;

  }
  public String getPassenger3() {
    return passenger3;
  }

  public void setPassenger3(String passenger3) {
    this.passenger3 = passenger3;

  }
  public String getPassenger4() {
    return passenger4;
  }

  public void setPassenger4(String passenger4) {
    this.passenger4 = passenger4;
  }

 @Override
public String toString() {
 return name;
 }
}
