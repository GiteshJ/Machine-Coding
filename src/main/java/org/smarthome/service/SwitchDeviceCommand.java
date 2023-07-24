package org.smarthome.service;

import org.smarthome.domain.SmartHomeDevice;

public class SwitchDeviceCommand implements Command {
  
  
  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    
    if (smartHomeDevice.isTurnedOn()) {
      smartHomeDevice.turnOff();
    } else {
      smartHomeDevice.turnOn();
    }
    
  }
}
