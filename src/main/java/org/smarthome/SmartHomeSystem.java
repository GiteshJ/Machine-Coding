package org.smarthome;

import org.smarthome.domain.Color;
import org.smarthome.domain.DeviceType;
import org.smarthome.service.Command;
import org.smarthome.service.FanSpeedCommand;
import org.smarthome.service.GoodNightCommand;
import org.smarthome.service.IAmHomeCommand;
import org.smarthome.service.IAmLeavingCommand;
import org.smarthome.service.LightBrightnessCommand;
import org.smarthome.service.LightColorCommand;
import org.smarthome.domain.SmartHome;
import org.smarthome.service.SwitchDeviceCommand;

public class SmartHomeSystem {

  public static void main(String[] args) {

    SmartHome smartHome = new SmartHome();

    smartHome.addSmartHomeAssistant("Google", "Room", "OK GOOGLE");
    smartHome.addSmartHomeAssistant("Alexa", "Room", "ALEXA");

    smartHome.makeDefault("OK GOOGLE");

    smartHome.addSmartHomeDevice("Fan", "Room", "ALEXA", DeviceType.FAN);
    smartHome.addSmartHomeDevice("Light", "Room", "ALEXA", DeviceType.LIGHT);

    smartHome.addSmartHomeDevice("Light 1", "Room", null, DeviceType.LIGHT);
    smartHome.addSmartHomeDevice("Fan 1", "Room", null, DeviceType.FAN);

    Command command = new SwitchDeviceCommand();
    smartHome.executeCommand("ALEXA", "Light", command);

    Command command1 = new SwitchDeviceCommand();
    smartHome.executeCommand("ALEXA", "Fan", command1);

    Command command2 = new FanSpeedCommand(5);
    smartHome.executeCommand("ALEXA", "Fan", command2);

    Command command3 = new LightBrightnessCommand(5);
    smartHome.executeCommand("ALEXA", "Light", command3);

    Command command4 = new LightColorCommand(Color.RED);
    smartHome.executeCommand("ALEXA", "Light", command4);

    Command command5 = new LightColorCommand(Color.BLUE);
    smartHome.executeCommand("ALEXA", "Light", command5);

    smartHome.connectSmartHomeDevice("OK GOOGLE", "Light 1");
    smartHome.connectSmartHomeDevice("OK GOOGLE", "Fan 1");


    Command command6 = new SwitchDeviceCommand();
    smartHome.executeCommand("OK GOOGLE", "Light 1", command6);

    Command command7 = new SwitchDeviceCommand();
    smartHome.executeCommand("OK GOOGLE", "Fan 1", command7);

    Command command8 = new FanSpeedCommand(6);
    smartHome.executeCommand("OK GOOGLE", "Fan 1", command8);

    Command command9 = new LightBrightnessCommand(2);
    smartHome.executeCommand("OK GOOGLE", "Light 1", command9);

    Command command10 = new LightColorCommand(Color.RED);
    smartHome.executeCommand("OK GOOGLE", "Light 1", command10);

    Command command11 = new LightColorCommand(Color.BLUE);
    smartHome.executeCommand("OK GOOGLE", "Light 1", command11);


    Command command12 = new IAmLeavingCommand();
    smartHome.executeCommand("OK GOOGLE", command12);
    smartHome.executeCommand("ALEXA", command12);

    Command command13 = new IAmHomeCommand();
    smartHome.executeCommand("OK GOOGLE", command13);
    smartHome.executeCommand("ALEXA", command13);

    Command command14 = new GoodNightCommand();
    smartHome.executeCommand("OK GOOGLE", command14);
    smartHome.executeCommand("ALEXA", command14);

  }

}