package org.smarthome.service;

import org.smarthome.domain.Light;
import org.smarthome.domain.SmartHomeDevice;

public class LightBrightnessCommand implements Command {
  
  private int brightness;

  public LightBrightnessCommand(int brightness) {
    this.brightness = brightness;
  }

  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    ((Light)smartHomeDevice).setBrightness(brightness);
  }
}
