package Device;

public interface Device {

	boolean isEnabled();
	
	void enabled();
	
	void disabled();
	
	int getVolume();
	
	void setVolume(int percent);
	
	int getChannel();
	
	void setChannel(int channel);

	void printStatus();
}
