package org.smarthome.domain;

public class Light extends SmartHomeDevice {
  private int brightness;
  private Color color;
  
  public Light(String deviceName, String location)
  {
    super(deviceName, location);
  }
  public int getBrightness() {
    return brightness;
  }
  
  public void setBrightness(int brightness) {
    System.out.println("Light brightness set to - " + brightness);
    this.brightness = brightness;
  }
  public Color getColor() {
    return color;
  }
  
  public void setColor(Color color) {
    System.out.println("Light color set to - " + color.name());
    this.color = color;
  }
  
}