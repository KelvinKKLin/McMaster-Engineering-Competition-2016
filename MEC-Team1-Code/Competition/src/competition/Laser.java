package competition;
import java.util.Random;

/**
 * This class simulates a lazer used to detect visibility.
 *
 * @author Weilin Hu, Kelvin Lin
 */
public class Laser extends Sensor{

	private double visibility_percentage; // The percentage of visibility measured by laser, from 0% to 100%

	/**
	 * This method send the visibility percentage value to the internal communication network
	 * @param tank The internal communication network
	 */
	protected void send(InternalCommunicationNetwork tank){
		tank.put(3,this.visibility_percentage);
	}

	/**
	 * This method simulate that laser measure the visibility percentage
	 */
	protected void received(){
		double max = 100.0; // this is the maximum value visibility percentage, the unit is %
		Random random = new Random();  // Start a constructor to create random value.

		// the visibility percentage between 0% to 100% with 2 decimal places
		this.visibility_percentage =Math.round(random.nextDouble()*max*100.0)/100.0;
	}
}
