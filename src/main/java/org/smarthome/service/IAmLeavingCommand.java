package org.smarthome.service;

import org.smarthome.domain.SmartHomeDevice;

public class IAmLeavingCommand implements Command {
  
  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    smartHomeDevice.turnOff();
  }
}
