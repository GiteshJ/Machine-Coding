package org.smarthome.domain;

import java.util.HashMap;
import java.util.Map;
import org.smarthome.service.Command;
import org.smarthome.service.SmartHomeDeviceFactory;

public class SmartHome {

  static SmartHomeDeviceFactory smartHomeDeviceFactory;
  private SmartHomeAssistant smartHomeAssistantDefault;

  private Map<String, SmartHomeDevice> smartHomeDeviceMap = new HashMap<>();
  private Map<String, SmartHomeAssistant> smartHomeAssistantMap = new HashMap<>();

  public SmartHome() {
    smartHomeDeviceFactory = new SmartHomeDeviceFactory();
  }

  public String addSmartHomeAssistant(String name, String location, String activationKeyword){
    if(smartHomeAssistantMap.containsKey(activationKeyword)){
      return "Invalid Input";
    }
    SmartHomeAssistant smartHomeAssistant = new SmartHomeAssistant(name, location, activationKeyword);
    smartHomeAssistantMap.put(activationKeyword, smartHomeAssistant);
    System.out.println("SmartHomeAssistant added - " + name + " activationKeyword - " + activationKeyword);
    return "Added";
  }

  public void makeDefault(String activationKeyword) {
    smartHomeAssistantDefault = smartHomeAssistantMap.get(activationKeyword);
    System.out.println("SmartHomeAssistant default - " + smartHomeAssistantDefault.getName() + " activationKeyword - " + activationKeyword);

  }

  public String addSmartHomeDevice(String name, String location, String activationKeyword, DeviceType deviceType) {
    if(smartHomeDeviceMap.containsKey(name)) {
      return "Invalid Input";
    }
    SmartHomeDevice smartHomeDevice = smartHomeDeviceFactory.buildSmartHomeDevice(name, deviceType, location);
    smartHomeDeviceMap.put(smartHomeDevice.getDeviceName(), smartHomeDevice);
    if(activationKeyword == null && smartHomeAssistantDefault != null) smartHomeAssistantDefault.registerDevice(smartHomeDevice);
    else if(activationKeyword != null) smartHomeAssistantMap.get(activationKeyword).registerDevice(smartHomeDevice);
    System.out.println("SmartHomeDevice added - " + name);
    return "Added";
  }

  public String connectSmartHomeDevice(String activationKeyword , String deviceName) {
    smartHomeAssistantMap.get(activationKeyword).registerDevice(smartHomeDeviceMap.get(deviceName));
    System.out.println("SmartHomeAssistant - " + smartHomeAssistantMap.get(activationKeyword).getName()
        + " connected to SmartHomeDevice - " + deviceName);
    return "connected";
  }

  public String disConnectSmartHomeDevice(String activationKeyword , String deviceName) {
    smartHomeAssistantMap.get(activationKeyword).deRegisterDevice(smartHomeDeviceMap.get(deviceName));
    System.out.println("SmartHomeAssistant - " + smartHomeAssistantMap.get(activationKeyword).getName()
        + " disconnected from SmartHomeDevice - " + deviceName);
    return "disconnected";
  }

  public void executeCommand(String activationKeyword, String deviceName, Command command) {
    SmartHomeAssistant smartHomeAssistant = smartHomeAssistantMap.get(activationKeyword);
    System.out.println("SmartHomeAssistant - " + smartHomeAssistant.getActivationKeyword() + " started executing command");
    command.execute(smartHomeAssistant.getSmartHomeDevice(deviceName));
    System.out.println("SmartHomeAssistant - " + smartHomeAssistant.getActivationKeyword() + " finished executing command");
  }

  public void executeCommand(String activationKeyword, Command command) {
    SmartHomeAssistant smartHomeAssistant = smartHomeAssistantMap.get(activationKeyword);
    System.out.println("SmartHomeAssistant - " + smartHomeAssistant.getActivationKeyword() + " started executing command");
    smartHomeAssistantMap.get(activationKeyword).getStringSmartHomeDeviceMap().values().forEach(command::execute);
    System.out.println("SmartHomeAssistant - " + smartHomeAssistant.getActivationKeyword() + " finished executing command");
  }

  public SmartHomeAssistant getSmartHomeAssistant(String activationKeyword){
    return smartHomeAssistantMap.get(activationKeyword);
  }


}
