package org.smarthome.service;

import org.smarthome.domain.SmartHomeDevice;

public interface Command {
   void execute(SmartHomeDevice smartHomeDevice);
}
