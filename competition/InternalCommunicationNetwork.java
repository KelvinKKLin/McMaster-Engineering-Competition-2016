package competition;

public class InternalCommunicationNetwork {

	Object[] data; //The data system

	/**
	 * The default constructor.
	 *
	 * Initializes the data array to size 5
	 */
	public InternalCommunicationNetwork(){
		data = new Object[5];
	}

	/**
	 * Constructor
	 *
	 * This allows the user to specify the size of the data array.
     * @param i The node to access
	 * @throws Exception Invalid parameter exception
	 */
	public InternalCommunicationNetwork(int i) throws Exception{
		if(i > 0){
			data = new Object[i];
		} else{
			throw new Exception("Index out of Bounds");
		}
	}

	/**
	 * This method allows the user to put an Object into the data array
	 * @param i		The index to insert
	 * @param data	The data to insert
	 */
	public void put(int i, Object data){
		this.data[i] = data;
	}

	/**
	 * This method allows the user to get data from the data array
	 * @param i
	 * 	To index to get from
	 * @return		The data at index i
	 */
	public Object get(int i){
		return data[i];
	}

}
