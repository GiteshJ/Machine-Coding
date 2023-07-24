package org.smarthome.service;

import org.smarthome.domain.SmartHomeDevice;

public class IAmHomeCommand implements Command {

  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    smartHomeDevice.turnOn();
  }
}
