package competition;
import java.util.Random;

/**
 * This class simulates a wind guage used to detect win speeds.
 *
 * @author Weilin Hu, Kelvin Lin
 */
public class Wind_Gauge extends Sensor{
	private double wind_speed; // The value of the wind speed
	private int wind_direction; // The value represent the direction of wind, value from integer 0 to 8
	private int boat_direction; // The value represent the direction of boat, value from integer 0 to 7

	/*
	 * Interger value 0 to 7 represents the direction N, E, S, W, NE, NW, SE, SW
	 * Integer value 8 represents no wind
	 */

	/**
	 * This method send the wind speed value and wind direction value to internal communication network
	 * @param tank  The internal communication network
	 */
	protected void send(InternalCommunicationNetwork tank){
		tank.put(1,this.wind_speed);
		tank.put(2,this.wind_direction);
	}

	/**
	 * This method simulate the four wind gauges received data
	 */
	protected void received(){
		this.boat_direction= (int)(Math.random() * 8);
		double max = 120.0;
		Random random = new Random();  // Start a constructor to create random value.
		double sensor1 = Math.round(random.nextDouble()*max*100.0)/100.0; // value from 0 to 120, with 2 decimal places
		double sensor2 = Math.round(random.nextDouble()*max*100.0)/100.0; // value from 0 to 120, with 2 decimal places
		double sensor3 = Math.round(random.nextDouble()*max*100.0)/100.0; // value from 0 to 120, with 2 decimal places
		double sensor4 = Math.round(random.nextDouble()*max*100.0)/100.0; // value from 0 to 120, with 2 decimal places
		this.wind_speed = Math.round((sensor1+sensor2+sensor3+sensor4)/4.0*100.0)/100.0; // get the average from four sensors, with 2 decimal places
		this.wind_direction = (int)(Math.random() *9 ); // value from 0 to 8, represent 8 directions and no wind
	}

}
