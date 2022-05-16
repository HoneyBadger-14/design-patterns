package bridge;

import Device.Device;
import Device.Radio;
import Device.Tv;
import Remote.AdvancedRemote;
import Remote.BasicRemote;

public class Main {

	public static void main(String[] args) {

        testDevice(new Tv());
        testDevice(new Radio());
        
	}
	
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

}
