package org.smarthome.domain;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeAssistant{

  private Map<String, SmartHomeDevice> smartHomeDeviceMap;
  private String activationKeyword;
  private String location;
  private String name;

  public Map<String, SmartHomeDevice> getStringSmartHomeDeviceMap() {
    return smartHomeDeviceMap;
  }

  public void setActivationKeyword(String activationKeyword) {
    this.activationKeyword = activationKeyword;
  }

  public String getLocation() {
    return location;
  }

  public String getActivationKeyword() {
    return activationKeyword;
  }

  public SmartHomeDevice getSmartHomeDevice(String deviceName) {
    return smartHomeDeviceMap.get(deviceName);
  }

  public SmartHomeAssistant(String activationKeyword, String location, String name) {
    this.location = location;
    smartHomeDeviceMap = new HashMap<>();
    this.activationKeyword = activationKeyword;
    this.name = name;
  }

  public void registerDevice(SmartHomeDevice smartHomeDevice) {
    smartHomeDeviceMap.putIfAbsent(smartHomeDevice.getDeviceName(), smartHomeDevice);
  }

  public void deRegisterDevice(SmartHomeDevice smartHomeDevice) {
    smartHomeDeviceMap.remove(smartHomeDevice.getDeviceName());
  }

  public String getName() {
    return name;
  }
}
