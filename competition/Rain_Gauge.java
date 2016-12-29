package competition;
import java.util.Random; // import this for creating random value

/**
 * The Rain_Guage class simulates a rain guage sensor that can
 * detect rain levels.
 *
 * @author Weilin Hu, Kelvin Lin
 */
public class Rain_Gauge extends Sensor{
	private double rain_level; // the value of rain level with unit mm/h

	/**
	 * This method send the value from rain gauge sensor to internal communication network
	 * @param tank The internal communication network
	 */
	protected void send(InternalCommunicationNetwork tank){
		tank.put(0,this.rain_level);
	}

	/**
	 * This method simulate that the rain gauge sensor received date
	 */
	protected void received(){
		double max = 100; // this is the maximum value rain level range, the unit is mm/h.
		Random random = new Random(); // Start a constructor to create random value.

		// Create a random double value between (0 to 400) mm/h and store the value into rain level parameter with 2 decimal places.
		this.rain_level = Math.abs(random.nextGaussian() + 5);
	}
}
