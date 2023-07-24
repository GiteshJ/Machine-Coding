package org.smarthome.service;

import org.smarthome.domain.Fan;
import org.smarthome.domain.SmartHomeDevice;

public class FanSpeedCommand implements Command {
  
  private int speed;

  public FanSpeedCommand(int speed) {
    this.speed = speed;
  }

  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    ((Fan)smartHomeDevice).setSpeed(speed);
  }
}
