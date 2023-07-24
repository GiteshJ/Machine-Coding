package org.smarthome.service;

import org.smarthome.domain.Color;
import org.smarthome.domain.Light;
import org.smarthome.domain.SmartHomeDevice;

public class LightColorCommand implements Command {
  

  private Color color;

  public LightColorCommand(Color color) {
    this.color = color;
  }

  @Override
  public void execute(SmartHomeDevice smartHomeDevice) {
    ((Light)smartHomeDevice).setColor(color);
  }
}
