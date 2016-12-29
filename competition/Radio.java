package competition;
/**
 * This class represents a simulated radio network. It will consist of a variety of
 * channels that can be open/ broadcasted onto. It is based on the FM radio signal band.
 * @author Karl Knopf, Kelvin Lin
 */
public class Radio {
	public static boolean channels[]; //represents the various radio channels
	public static int size; // represents the amount of the channels.

	/**
	 * The constructor method for the radio simulation class. It creates a radio broadcast
	 * frequency array of 40 different frequencies.
	 */
	public Radio(){
		size =40;
		channels = new boolean[size];
	}

	/**
	 * The public scan method for the radio. It returns if a current radio channel is in use.
	 * @param i the channel to check
	 * @return is the channel to be checked free (true: no, false: yes)
	 */
	public boolean scan(int i){
		return channels[i];
	}

	/**
	 * The public lock on method that allows the radio to select a radio station and
	 * claim it as its own to broadcast on.
	 * @param i the channel to lock on to.
	 */
	public void lockOn(int i ){
		channels[i] = true;
	}

	/**
	 * The public release method that allows the radio to release the current channel
	 * that is being used, so that it might be broad cast on by another buoy.
	 * @param i the channel to release
	 */
	public void release(int i){
		channels[i] = false;
	}

	/**
	 * A public method that returns the amount of available radio channels
	 * @return the amount of possible broadcast signals
	 */
	public int size(){
		return size;
	}


}
