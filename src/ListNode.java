
/**
 * AC12001
 * 
 * @author Ian Chow Matriculation Number:150021126
 * @version v1.0
 */
public class ListNode {
	// fields to store the data being held in this list node (values to compute)
	private int data;

	// field to store a reference to the next node in the list after this one
	private ListNode next;

	/**
	 * Default constructor. Initialise fields to default values
	 * 
	 * @param newData
	 *            data value
	 */
	public ListNode(int newData) {
		// set id and mark to default / empty values

		setData(newData);

		// set next node to null - no valid next node yet
		next = null;
	}

	/**
	 * Get the value contained in this list node
	 * 
	 * @return The value of the node
	 */
	public int getData() {
		return data;
	}

	/**
	 * mutator for the data
	 * 
	 * @param newData
	 *            the new value for the node
	 */

	public void setData(int newData) {

		data = newData;

	}

	/**
	 * Accesor for the next node
	 * 
	 * @return The value of the node
	 * 
	 */
	public ListNode getNext() {
		// return the list node reference
		return next;
	}

	/**
	 * Mutator for the next
	 * 
	 * @param The
	 *            new value for the next
	 * 
	 * 
	 */
	public void setNext(ListNode node) {
		// store your list node reference
		next = node;
	}

}
