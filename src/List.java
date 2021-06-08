
/**
 * AC12001/AC22007
 * 
 * @author Ian Chow Matriculation Number:150021126
 * 
 * @version v1.0
 */
public class List {
	public static ListNode head; // used to hold a reference to an instance of a
						 			// ListNode object

	// which will be the first item in the list, i.e. at the 'head'
	// of the list
	public ListNode firstLink; // first node added to the list or the last node
								// added to the list

	private int numberOfItems; // used to hold the number of nodes in the list

	/**
	 * Default constructor. Initialise fields to default values.
	 */
	public List() {

		super(); // Call constructor of parent Exception

		// set the list to be empty, i.e. not referring to anything valid yet
		head = null;
	}

	/**
	 * Get the list node which is at the 'head' of the list
	 * 
	 * @return A reference to a ListNode object which represents the node at the
	 *         head of the list (or null if the list is empty, i.e. no 'head'
	 *         has been set yet).
	 */
	public ListNode getHead() {
		return head;
	}

	/**
	 * Set the 'head' of the list to the given node
	 * 
	 * @param newHead
	 *            A reference to a ListNode object which will be the head of the
	 *            list.
	 * 
	 *            NOTE: if a list already exists, the existing listing will be
	 *            lost since the head is being assigned to something new.
	 */
	public void setHead(ListNode newHead) {

		head = newHead;
	}

	/**
	 * accessor for number of Items
	 * 
	 * @return numberOfItems
	 */

	public int getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * toString Method is used to print all the nodes that remain in the stack.
	 * 
	 * @return the contents of the string
	 */
	public String toString() {
		String listString = "";
		ListNode current = head;
		while (current != null) {
			listString += current.getData() + "\n";
			current = current.getNext();

		}
		return listString;
	}

	/**
	 * Add a new node to the start of the list which will contain the data
	 * provided
	 * 
	 * 
	 */
	public void push(int data) {
		// add a new node to the list
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
		numberOfItems++;

	}

	/**
	 * Check is the head is empty
	 * 
	 * @return null if it is empty
	 */
	public static boolean isEmpty() {

		return (head == null);

	}

	/**
	 * Returns and removes the first node of the list. If the list is empty, the
	 * DataStructureException throws an error: "Empty Stack: Cannnot be poped!"
	 * 
	 * @return the first node removed.
	 */
	public int pop() {
		if (isEmpty()) {

			throw new DataStructureException("Empty Stack: Cannnot be poped!");
		} else {
			int deleted = head.getData();
			head = head.getNext();
			return deleted;

		}

	}

	/**
	 * returns and removes the first node in the list with data equal to
	 * searchData. If there is no such data an error message will be shown.
	 * 
	 * @param searchData
	 * @return the data deleted
	 */

	public int delete(int searchData) throws DataStructureException {
		ListNode current = head;
		ListNode previous = null;

		while (current != null && current.getData() != searchData) {
			previous = current;
			current = current.getNext();

		}
		if (current == null)// not found
		{
			throw new DataStructureException(" Not found: " + searchData + "\tCannot be deleted.");
		} else {
			if (current == head) {
				head = head.getNext();// delete head

			} else {
				previous.setNext(current.getNext());
				numberOfItems--;
				return current.getData();
			}
		}
		return searchData;

	}

	/**
	 * Method is used to return the first node on the list whose data is equal
	 * to searchData without removing it from the stack.
	 * 
	 * @return the data found
	 */
	public int peek(int searchData) {
		ListNode current = head;
		while (current != null && current.getData() != searchData) {
			current = current.getNext();
		}
		if (current == null) { // not found
			throw new DataStructureException(" Not found: " + searchData);
		} else {
			return current.getData();
		}
	}

}
