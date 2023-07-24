package org.smarthome.domain;

public abstract class SmartHomeDevice {
  
  boolean isTurnedOn;
  
  private String deviceName;

  public String getLocation() {
    return location;
  }

  private String location;
  
  protected SmartHomeDevice(String deviceName, String location) {
    this.deviceName = deviceName;
    this.location = location;
  }
  public void turnOn() {
    System.out.println("Turning on the device - " + deviceName);
    isTurnedOn = true;
  }
  
  public void turnOff() {
    System.out.println("Turning off the device - " + deviceName);
    isTurnedOn = false;
  }
  public boolean isTurnedOn(){
    return isTurnedOn;
  }
  
  public String getDeviceName() {
    return deviceName;
  }

}
