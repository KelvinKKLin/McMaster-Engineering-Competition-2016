package competition;
import java.util.Random; // import this for creating random value

/**
 * This class simulates a thermometer used to detect temperature.
 *
 * @author Weilin Hu, Kelvin Lin
 */
public class Thermometer extends Sensor{
	private double temperature; // The value of the temperature, with unit of celsius degree

	/**
	 * This method send the value from thermometer to internal communication network
	 * @param tank The internal communication network
	 */
	protected void send(InternalCommunicationNetwork tank){
		tank.put(4,this.temperature);
	}

	/**
	 * This method simulate that thermometer received data
	 */
	protected void received(){
		double max = 40; // Set the maximum value of the temperature range to 40 celsius.
		double min = -30; // Set the minimum value of the temperature range to -30 celsius.
		Random random = new Random(); // Start a constructor to create random value.

		// Create a random double value between (40.0 to -30.0) celsius and store the value into temperature parameter with 1 decimal place.

		this.temperature =Math.round((random.nextDouble()*max+min)*10.0)/10.0;
	}
}
