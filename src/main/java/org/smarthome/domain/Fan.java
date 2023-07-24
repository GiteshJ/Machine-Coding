package org.smarthome.domain;

public class Fan extends SmartHomeDevice {

  private int speed;

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    System.out.println("Fan speed set to - " + speed);
    this.speed = speed;
  }

  public Fan(String deviceName, String location) {
    super(deviceName, location);
  }


}
