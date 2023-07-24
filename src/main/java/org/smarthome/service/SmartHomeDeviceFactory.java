package org.smarthome.service;

import org.smarthome.domain.DeviceType;
import org.smarthome.domain.Fan;
import org.smarthome.domain.Light;
import org.smarthome.domain.SmartHomeDevice;

public class SmartHomeDeviceFactory {
  
  public SmartHomeDevice buildSmartHomeDevice(String deviceName, DeviceType deviceType, String location) {
    switch (deviceType) {
      case LIGHT:
        return new Light(deviceName, location);
      case FAN:
        return new Fan(deviceName, location);
      default:
        System.out.println("Device not supported");
    }
    return null;
  }
}
