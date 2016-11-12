package competition;
import java.util.Random;

/**
 * This class represents an individual buoy in the network of
 * buoys in the ocean. It can receive information from the various
 * on board hardware components and broadcast this information
 * to nearby people using an FM/AM signal.
 * @author Karl Knopf, Kelvin Lin
 */
public class Buoy {
	public static double precip; 			//represents the level of precipitation, measured in mm
	public static double windspeed; 		//represents the current windspeed, measured in km
	public enum windDir{ 					//an enum for the various possible directions the wind could be blowing
		N,E,S,W,NE,NW,SE,SW,Null;
	};
	public static windDir dir; 				//the current direction of that the wind is blowing
	public static double vis; 				//the current visibility around the buoy, measured in %
	public static double temp; 				//the current tempurature in Celsius
	public static int danger; 				//the current level of danger for the system on a three point scale
	public static int flag = 0; 			//flag for feedback loop of system check

	/**
	 * This constructor method represents the creation of a buoy class to manage the buoy's operations
	 */
	public Buoy(){
		precip = 0.0;
		windspeed = 0.0;
		dir = windDir.Null;
		vis = 0.0;
		temp = 0.0;
		danger = 0;
	}

        /**
	 	 * This public method represents that the buoy's ability to receive
         * @param i The reference to the internal communication's network
         */
	public void receive(InternalCommunicationNetwork i){
		//include error handling for wrong data types
		try {
		    precip = (double)i.get(0);
		} catch (Exception ex) {
		     System.out.println("Input is not proper! Something is wrong");
		     if(flag < 3){ //feedback loop if a system failed
		    	 flag++;
		    	 this.receive(i);
		     }
		     else{
		    	 precip = -1.0;
		    	 flag = 0;
		     }
		}
		try {
		    windspeed = (double)i.get(1);
		} catch (Exception ex) {
		     System.out.println("Input is not proper! Something is wrong");
		     if(flag < 3){ //feedback loop if a system failed
		    	 flag++;
		    	 this.receive(i);
		     }
		     else{
		    	 windspeed = -1.0;
		    	 flag = 0;
		     }

		}
		try {
			int tempDir;
		    tempDir = (int)i.get(2);
		    dir =  windDir.values()[tempDir];
		} catch (Exception ex) {
		     System.out.println("Input is not proper! Something is wrong");

		     if(flag < 3){ //feedback loop if a system failed
		    	 flag++;
		    	 this.receive(i);
		     }
		     else{
		    	 dir = windDir.Null;
		    	 flag = 0;
		     }
		}
		try {
		    vis =(double)i.get(3);
		} catch (Exception ex) {
			System.out.println("Input is not proper! Something is wrong");
		     if(flag < 3){ //feedback loop if a system failed
		    	 flag++;
		    	 this.receive(i);
		     }
		     else{
		    	 vis = -1.0;
		    	 flag = 0;
		     }

		}
		try {
		    temp = (double)i.get(4);
		} catch (Exception ex) {
			System.out.println("Input is not proper! Something is wrong");
		     if(flag < 3){ //feedback loop if a system failed
		    	 flag++;
		    	 this.receive(i);
		     }
		     else{
		    	 temp = 0.0;
		    	 flag = 0;
		     }
		}
		danger = isCritical();

	}

	/**
	 * This public method represents that the buoy's ability to broadcast the message
	 * @param r The radio object to send messages to
	 * @return returns a string that represents the current broadcast message
	 */
	public static String send(Radio r){
		// look for open channel
		int channel = -1;
		for(int i=0;i<r.size();i++){
			if(r.scan(i) == false){
				r.lockOn(i);
				channel = i;
				break;
			}
		}
		// if none open and message is critical, randomly pick a channel and broadcast over it
		if(channel == -1 && danger >=3){
			Random ran = new Random();
			channel = ran.nextInt(40);
			r.lockOn(channel);
		}
		System.out.println( String.format("Danger Level: %1$d",danger));
		System.out.println( String.format("Danger Level: %1$d, Hourly Precipitation: %2$.03f, Wind Speed: %3$.01f, Wind Direction: %4$s, Visibility: %5$.01f, Tempurature: %6$.01f C",danger,precip,windspeed,dir.toString(),vis,temp));
		r.release(channel);
		return String.format("Danger Level: %1$d, Hourly Precipitation: %2$.03f, Wind Speed: %3$.01f, Wind Direction: %4$s, Visibility: %5$.01f, Tempurature: %6$.01f C",danger,precip,windspeed,dir.toString(),vis,temp);
		//r.release(channel);
	}

	/**
	 * This private method represents the buoy's ability to determine the criticality of the message
	 * Critical levels were determined using: https://en.wikipedia.org/wiki/Severe_weather_terminology_(United_States)
	 * @return an integer that represents the current danger level
	 */
	private static int isCritical(){
		int newDanger = 0; //no danger
		if(precip >= 50.0 || windspeed >= 118.0 || vis <= 50.0){
			newDanger = 4; //super danger: hurricane
		}
		else if(windspeed >= 89 || vis <= 70){
			newDanger = 3; //panic : storm
		}
		else if(windspeed >= 63 || vis <= 80){
			newDanger = 2; // oh no : gale
		}
		else if( windspeed >= 38 || vis <= 90){
			newDanger  = 1; // little danger
		}
		return newDanger;
	}



}
