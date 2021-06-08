/**
 * 
 */

/**
 * @author User Ian Chow Matriculation Number:150021126
 *
 */
public class Test {

	/**
	 * 
	 */

	public Test() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * Test all possible scenarios and methods in a stack
	 */
	public void stackTest() {
		// construct empty list
		List numbers = new List();

		int temp; // used to assign the deleted item
		int temp1; // used to assign the deleted item

		// calculates the number of value in the stack
		System.out.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

		// removing a number in an empty stack; unsuccessful as stack is empty
		// thus displays error message.
		try {
			temp = numbers.pop();

		} catch (DataStructureException e) {
			System.out.println(e.getMessage() + "\n");
		}

		// insert into empty stack
		numbers.push(8);
		System.out.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

		// insert in list of one item
		numbers.push(6);
		System.out.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

		// inserting multiple(5) nodes in a list of 2
		numbers.push(4);
		numbers.push(8);
		numbers.push(2);
		numbers.push(3);
		numbers.push(2);
		System.out.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

		// popping values in stack; successful
		try {
			// popping from a stack
			temp = numbers.pop();
			System.out.println("Number popped:" + temp + "\n");

			System.out
					.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

			// popping two numbers from a stack
			temp = numbers.pop();
			temp1 = numbers.pop();
			System.out.println("Numbers popped:" + temp + "," + temp1);
			System.out
					.println("Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());
		} catch (DataStructureException e) {
			System.out.println(e.getMessage() + "\n");
		}

		// peeking in the stack for certain values; successful
		try {
			// finding number 6 in the stack
			temp = numbers.peek(6);
			System.out.println("Number found:" + temp);

			// finding number 100 which does not exist in stack
			temp = numbers.peek(100);
			System.out.println("Number found:" + temp);

		} catch (DataStructureException e) {
			System.out.println(e.getMessage() + "\n");
		}

		// deleting various values in the stack
		try {
			// deleting number 8(first number) in the stack; successful
			temp = numbers.delete(8);
			System.out.println("\n" + "Number deleted:" + temp);
			System.out.println(
					"\n" + "Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

			// deleting number 6(number in the middle of the stack); successful
			temp = numbers.delete(6);
			System.out.println("\n" + "Number deleted:" + temp);
			System.out.println(
					"\n" + "Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

			// deleting number 8(last number) in the stack; successful
			temp = numbers.delete(8);
			System.out.println("\n" + "Number deleted:" + temp);
			System.out.println(
					"\n" + "Number of items in the Stack:" + numbers.getNumberOfItems() + "\n" + numbers.toString());

			// deleting a non existent number in the stack
			temp = numbers.delete(99);

		} catch (DataStructureException e) {
			System.out.println(e.getMessage() + "\n");
		}

	}

	/**
	 * Testing various scenarios in the RPN Class
	 */
	public void RPNTest() {

		String testData = "15,7 1,1,+,- /,3,*,2,1 1,+,+,-"; // ((15/(7-(1+1)))*3)-(2+(1+1))=5
		String testData1 = "9 4 - 10 5 - *"; // (9-4) *(10-5)=25
		String testData2 = "3,7,2,*,+,5,-"; // (3+(7*2))-5=12

		// erroneous mathematical formulas to test error handling
		String testData3 = "3,+ ";
		String testData4 = "4,6,2,+";
		String testData5 = "68a 0 -";
		String testData6 = "% ^ &";

		List numbers = new List();

		// splitting the string base on various conditions; single or no empty
		// space followed by a comma
		// or more than one or one blank space followed by zero or more blank
		// spaces (regex expressions used)
		String[] splitString = testData.split("\\s*(,|\\s+)\\s*");
		String[] splitString1 = testData1.split("\\s*(,|\\s+)\\s*");
		String[] splitString2 = testData2.split("\\s*(,|\\s+)\\s*");
		String[] splitString3 = testData3.split("\\s*(,|\\s+)\\s*");
		String[] splitString4 = testData4.split("\\s*(,|\\s+)\\s*");
		String[] splitString5 = testData5.split("\\s*(,|\\s+)\\s*");
		String[] splitString6 = testData6.split("\\s*(,|\\s+)\\s*");

		int operand; // temporarily stores the numbers in the string.

		// first test for a large formula with an empty space, the division
		// operator and minus operator
		System.out.println("Test data = " + testData);

		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i].equals("+")) {
				System.out.println("Plus operator");
				numbers.push(numbers.pop() + numbers.pop());
			} else if (splitString[i].equals("-")) {

				System.out.println("Minus operator");
				numbers.push(-numbers.pop() + numbers.pop());

			} else if (splitString[i].equals("*")) {
				System.out.println("Multiplication operator");
				numbers.push(numbers.pop() * numbers.pop());
			} else if (splitString[i].equals("/")) {
				System.out.println("Division operator");
				int divisor = numbers.pop();
				numbers.push(numbers.pop() / divisor);
			} else {
				operand = Integer.parseInt(splitString[i]);
				numbers.push(operand);
				System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
			}

		}
		System.out.println("Final Answer:\t" + numbers.toString());
		numbers.pop(); // removing remaining values in the stack
		RPNCalculator.splitter();

		// second test to test a formula with only empty space
		System.out.println("Test data1 = " + testData1);

		for (int i = 0; i < splitString1.length; i++) {
			if (splitString1[i].equals("+")) {
				System.out.println("Plus operator");
				numbers.push(numbers.pop() + numbers.pop());
			} else if (splitString1[i].equals("-")) {

				System.out.println("Minus operator");
				numbers.push(-numbers.pop() + numbers.pop());

			} else if (splitString1[i].equals("*")) {
				System.out.println("Multiplication operator");
				numbers.push(numbers.pop() * numbers.pop());
			} else if (splitString1[i].equals("/")) {
				System.out.println("Division operator");
				int divisor = numbers.pop();
				numbers.push(numbers.pop() / divisor);
			} else {
				operand = Integer.parseInt(splitString1[i]);
				numbers.push(operand);
				System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
			}

		}
		System.out.println("Final Answer:\t" + numbers.toString());
		numbers.pop();
		RPNCalculator.splitter();

		// Logic testing; third test to test the subtraction operation to see if
		// the values are subtracted in proper order
		System.out.println("Test data2 = " + testData2);

		for (int i = 0; i < splitString2.length; i++) {
			if (splitString2[i].equals("+")) {
				System.out.println("Plus operator");
				numbers.push(numbers.pop() + numbers.pop());
			} else if (splitString2[i].equals("-")) {

				System.out.println("Minus operator");
				numbers.push(-numbers.pop() + numbers.pop());

			} else if (splitString2[i].equals("*")) {
				System.out.println("Multiplication operator");
				numbers.push(numbers.pop() * numbers.pop());
			} else if (splitString2[i].equals("/")) {
				System.out.println("Division operator");
				int divisor = numbers.pop();
				numbers.push(numbers.pop() / divisor);
			} else {
				operand = Integer.parseInt(splitString2[i]);
				numbers.push(operand);
				System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
			}

		}
		System.out.println("Final Answer:\t" + numbers.toString());
		numbers.pop();
		RPNCalculator.splitter();

		// Error testing for invalid ; when a string has only a single value and
		// an operator.
		try {
			System.out.println("Test data3 = " + testData3);

			for (int i = 0; i < splitString3.length; i++) {
				if (splitString3[i].equals("+")) {
					System.out.println("Plus operator");
					numbers.push(numbers.pop() + numbers.pop());
				} else if (splitString3[i].equals("-")) {

					System.out.println("Minus operator");
					numbers.push(-numbers.pop() + numbers.pop());

				} else if (splitString3[i].equals("*")) {
					System.out.println("Multiplication operator");
					numbers.push(numbers.pop() * numbers.pop());
				} else if (splitString3[i].equals("/")) {
					System.out.println("Division operator");
					int divisor = numbers.pop();
					numbers.push(numbers.pop() / divisor);
				} else {
					operand = Integer.parseInt(splitString3[i]);
					numbers.push(operand);
					System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
				}

			}

			System.out.println("Final Answer:\t" + numbers.toString());
			numbers.pop();
			RPNCalculator.splitter();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
			RPNCalculator.splitter();

		}

		// testing for invalid extreme; when the string has only a single
		// operator and multiple values
		System.out.println("Test data4 = " + testData4);

		for (int i = 0; i < splitString4.length; i++) {
			if (splitString4[i].equals("+")) {
				System.out.println("Plus operator");
				numbers.push(numbers.pop() + numbers.pop());
			} else if (splitString4[i].equals("-")) {

				System.out.println("Minus operator");
				numbers.push(-numbers.pop() + numbers.pop());

			} else if (splitString4[i].equals("*")) {
				System.out.println("Multiplication operator");
				numbers.push(numbers.pop() * numbers.pop());
			} else if (splitString4[i].equals("/")) {
				System.out.println("Division operator");
				int divisor = numbers.pop();
				numbers.push(numbers.pop() / divisor);
			} else {
				operand = Integer.parseInt(splitString4[i]);
				numbers.push(operand);
				System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
			}

		}

		if (numbers.toString().length() > 1) {

			System.out.println("Stack is not empty");
			System.out.println("String entered is not a valid mathematical formula");
			RPNCalculator.splitter();
		} else {
			System.out.println("Final Answer:\t" + numbers.toString());
			numbers.pop();
			RPNCalculator.splitter();
		}

		// Error testing;testing for a string that has a valid value followed by
		// a invalid character
		try {
			System.out.println("Test data5 = " + testData5);

			for (int i = 0; i < splitString5.length; i++) {
				if (splitString5[i].equals("+")) {
					System.out.println("Plus operator");
					numbers.push(numbers.pop() + numbers.pop());
				} else if (splitString5[i].equals("-")) {

					System.out.println("Minus operator");
					numbers.push(-numbers.pop() + numbers.pop());

				} else if (splitString5[i].equals("*")) {
					System.out.println("Multiplication operator");
					numbers.push(numbers.pop() * numbers.pop());
				} else if (splitString5[i].equals("/")) {
					System.out.println("Division operator");
					int divisor = numbers.pop();
					numbers.push(numbers.pop() / divisor);
				} else {
					operand = Integer.parseInt(splitString5[i]);
					numbers.push(operand);
					System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
				}

			}

			if (numbers.toString().length() > 1) {

				System.out.println("Stack is not empty");
				System.out.println("String entered is not a valid mathematical formula");
			} else {
				System.out.println("Final Answer:\t" + numbers.toString());
				numbers.pop();
				RPNCalculator.splitter();
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
			RPNCalculator.splitter();

		}

		// Testing error for erroneous input
		try {
			System.out.println("Test data6 = " + testData6);

			for (int i = 0; i < splitString6.length; i++) {
				if (splitString6[i].equals("+")) {
					System.out.println("Plus operator");
					numbers.push(numbers.pop() + numbers.pop());
				} else if (splitString6[i].equals("-")) {

					System.out.println("Minus operator");
					numbers.push(-numbers.pop() + numbers.pop());

				} else if (splitString6[i].equals("*")) {
					System.out.println("Multiplication operator");
					numbers.push(numbers.pop() * numbers.pop());
				} else if (splitString6[i].equals("/")) {
					System.out.println("Division operator");
					int divisor = numbers.pop();
					numbers.push(numbers.pop() / divisor);
				} else {
					operand = Integer.parseInt(splitString6[i]);
					numbers.push(operand);
					System.out.println("Numbers in the Stack:" + "\n" + numbers.toString());
				}

			}

			if (numbers.toString().length() > 1) {

				System.out.println("Stack is not empty");
				System.out.println("String entered is not a valid mathematical formula");
			} else {
				System.out.println("Final Answer:\t" + numbers.toString());
				numbers.pop();
				RPNCalculator.splitter();
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
			RPNCalculator.splitter();

		}
	}

}
