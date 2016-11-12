package buoy;

import static org.junit.Assert.*;

import org.junit.*;

public class SystemTest {

	// Variable declarations for the data
	private double rainLevel;									// Direction
	private double windSpeed;									// Wind speed
	private int directionLabel;									// Direction as integer
	private double visibility;									// Visibility
	private double temperature;									// Temperature
	private int criticality;									// Criticality
	private enum windDirection {N,E,S,W,NE,NW,SE,SW,Null};		// Current wind direction

	// Variable declarations for the system instances
	private InternalCommunicationNetwork icn;
	private Buoy b;
	private Thermometer th;
	private Wind_Gauge wg;
	private Rain_Gauge rg;
	private Radio r;
	private Laser l;

	// Constant declarations
	private final static int DIRECTIONS = 9;					// Number of wind directions					
	private final static int RANGE=100;							// Range of percentage
	private final static double CRITICALITY = 4;				// Criticality level

	@Before
	public void setUp() throws Exception{
		icn = new InternalCommunicationNetwork();
		b = new Buoy();
		wg = new Wind_Gauge();
		th = new Thermometer();
		rg = new Rain_Gauge();
		r = new Radio();
		l = new Laser();

	}


	/**
	 * Test whether the thermometer is able to send the data message
	 */
	@Test
	public void testThermometer() {

		double expected = 13.0;
		icn.put(4, expected);
		//th.send(icn);
		b.receive(icn);
		assertTrue(b.temp==expected);
	}
	
	/**
	 * Test whether the wind gauge is able to send the data message
	 */
	@Test
	public void testWindGauge() {

		double expectedspeed = 35.6;
		double expecteddirection = 4;
		icn.put(1, expectedspeed);
		icn.put(2, expecteddirection);
		b.receive(icn);
		//wg.send(icn);
		assertTrue(b.windspeed==expectedspeed);
	}
	
	/**
	 * Test whether the rain gauge is able to send the data message
	 */
	@Test
	public void testRainGauge() {

		double expectedspeed = 35.6;
		icn.put(0, expectedspeed);
		rg.setSpeed(expectedspeed);
		b.receive(icn);
		assertTrue(b.precip==expectedspeed);
	}
	
	/**
	 * Check if all channels available
	 * Lock onto one channel to see if locked properly
	 * Release one channel to see if released properly
	 */
	@Test
	public void testRadio(){
		
		for(int i=0;i<40; i++){
			assertFalse(r.channels[i]);
		}
		
		r.lockOn(0);
		assertEquals(r.channels[0],true);
		
		r.release(0);
		assertEquals(r.channels[0],false);

	}
	
	/**
	 * Test whether the laser is able to send the data message
	 */
	@Test
	public void testLaser() {

		double expected = 13.0;
		icn.put(3, expected);
		b.receive(icn);
		//l.send(icn)
		System.out.println(b.vis);
		assertTrue(b.vis==expected);
	}
	
	
	/**
	 * Test whether the buoy is able to send the data message
	 */
	@Test
	public void testSend() {
		icn.put(0,10.0);
		b.receive(icn);
		
		String actual = b.send(r);
		assertFalse(actual=="");
	}

	/**
	 * Test whether icn is producing the correct criticality
	 */
	@Test
	public void testCorrectCriticality() {
		
		/*
		 * Criticality is 4 if either one of the conditions are true
		 */
		b.precip = 60;
		assertTrue(b.isCritical()==4);
		b.windspeed = 119;
		assertTrue(b.isCritical()==4);
		b.vis = 30;
		assertTrue(b.isCritical()==4);

	}


}
