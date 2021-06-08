import java.util.Scanner;

/**
 * 
 */

/**
 * @author User Ian Chow Matriculation Number:150021126
 *
 */
public class RPNCalculator extends List {

	/**
	 * Inherits instance variables from list
	 */
	public RPNCalculator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	/**
	 * Method used to split the string base on various conditions; commas ,
	 * white spaces or both. The values are then placed individually into a
	 * stack until a mathematical operator is reached and the following
	 * operation if performed on the previous two numbers there were in the
	 * stack by popping them and push the result back into the stack.
	 * 
	 * If an invalid character is reached or the infix mathematical formula is
	 * erroneous an error message will be prompted.
	 */
	public void splitString() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Input a string of numbers and operations.");
			System.out.println(" * = Multiplication \n / = Division \n + = Addition \n - = Subtraction");
			String input = sc.nextLine();
			List numbers = new List();
			String[] splitString = input.split("\\s*(,|\\s+)\\s*"); // matches
																	// zero or
																	// more
																	// white
																	// spaces
																	// followed
																	// by either
																	// a , or
																	// one or
																	// more
																	// white
																	// space and
																	// zero or
																	// more
																	// white
																	// space
			String operator;
			int operand;

			System.out.println("Input entered = " + input);

			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].equals("+")) {

					numbers.push(numbers.pop() + numbers.pop());
					System.out.println(numbers);
				} else if (splitString[i].equals("-")) {

					numbers.push(-numbers.pop() + numbers.pop());
					System.out.println(numbers);
				} else if (splitString[i].equals("*")) {

					numbers.push(numbers.pop() * numbers.pop());
					System.out.println(numbers);
				} else if (splitString[i].equals("/")) {

					int divisor = numbers.pop();
					System.out.println(numbers);
					numbers.push(numbers.pop() / divisor);
				} else {
					operand = Integer.parseInt(splitString[i]);
					numbers.push(operand);

				}

			}
			System.out.println("Answer:" + "\n" + numbers.toString());
		} catch (Exception e) {
			System.out.println("\nInvalid Input!!\n");
			System.out.println(e + "\n");
			instructions();
			processUserChoices();
		}
	}

	/**
	 * Displays the Menu options
	 */
	private static void displayMenu() {
		splitter();
		System.out.println("\nPlease select one of the options below\n");
		System.out.println("1. Calculate");
		System.out.println("2. Test Stack");
		System.out.println("3. Test Calculator");
		System.out.println("4. Instructions");
		System.out.println("5. Exit");
	}

	/**
	 * Displays the instructions to use the RPN Calculator.
	 */
	public static void instructions() {
		System.out.println(
				"1. Numbers must be inputted followed by either a white \n   space or a comma(,) between subsequent numbers and \n   operators.\n");
		System.out.println("2.The first input must be a number without and spacing \n  or a comma(,) \n");
		System.out.println(
				"3. Aside from numbers, inputs can only be one of \n    the following operators: \n\t i) * = Multiplication \n\t ii) / = Division \n\t iii) + = Addition \n\t iv) - = Subtraction ");
		
	
	}

	/**
	 * process the selected choice made by the user and loads the subsequent
	 * methods.
	 */
	public static void processUserChoices() {

		Test testAll = new Test();
		boolean decision = true; // used to determine if the user has made the
									// choice to exit the program
		displayMenu();
		do {
			String choice; // to determine which Menu choice was chosen by the
							// user;leave as string to prevent any errors.

			Scanner sc8 = new Scanner(System.in);
			choice = sc8.nextLine();

			switch (choice) {
			case ("1"):
				splitter();
				RPNCalculator calculator = new RPNCalculator();
				calculator.splitString();

				processUserChoices();
				break;

			case ("2"):
				splitter();
				testAll.stackTest();

				processUserChoices();

				break;

			case ("3"):

				splitter();
				testAll.RPNTest();

				processUserChoices();

				break;
			case ("4"):

				splitter();
				instructions();

				processUserChoices();

				break;

			case ("5"):
				exit();
				break;

			default:

				System.out.println("Invalid Option was selected,please select again.");
				displayMenu();
				break;

			}
		} while (decision == true);

	}

	/**
	 * Displays message to notify the user the program has been closed.
	 */
	public static void exit() {

		System.out.println("\nGoodbye");
		return;
	}

	/**
	 * A splitter line used to present the program in a more readable format
	 * with the line denoting the end of various methods.
	 */
	public static void splitter() {
		System.out.println("_________________________________________________");
		System.out.println(""); // creates an extra line of space

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		processUserChoices();
	}
}
