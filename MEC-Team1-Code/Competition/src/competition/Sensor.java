package competition;

public abstract class Sensor {
	protected abstract void send(InternalCommunicationNetwork tank); // abstract function of sensor to send info
	protected abstract void received(); // abstract function of sensor receive info

}
