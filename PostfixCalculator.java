
/**
 * @author Kyle Kaminski
 * These two imports are made so that I can create and use scanner and stack objects.
 * The scanner class allows me to take in user input (in the terminal)
 * The stack class is crucial for the calculation of the postfix expression.
 **/

import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculator
{
	
	/**
	 * This method evaluates the "character" value, which will be our final answer at the end.
	 * Our final answer will return as the "answer" variable.
	 * First, a new stack is created that will help calculate the input.
	 * A for loop is created for when there is still input to be read.
	 * The char variable character is made.
	 * An if loop is made for when there is input to be read for character.
	 * This pushes the stack as long as there is input in the stack.
	 * If the stack cannot be pushed, then the else statement is performed.
	 * This statement pops the first and second values of the stack.
	 * A switch statement is made for the 4 types of operands that can be performed on our 
	 * first and second values ( + - * / )
	 * If an equals sign is typed, it is ignored.
	 * The stack is then returned to the loop and it continues the stack until an answer is found.
	 * 
	 * @param answer
	 * @return stack.pop()
	 */
	
	static int evaluatePostfix(String answer)
	{
		Stack <Integer> stack = new Stack<>();
		for(int i = 0; i < answer.length(); i++)
		{
			char character = answer.charAt(i);
			if(Character.isDigit(character))
			{
				stack.push(character - '0');
			}
			else
			{
				int firstValue = stack.pop();
				int secondValue = stack.pop();
				switch(character)
				{
				case '+':
					stack.push(firstValue + secondValue);
					break;	
				case '-':
					stack.push(secondValue - firstValue);
					break;
				case '/':
					stack.push(secondValue / firstValue);
					break;
				case '*':
					stack.push(firstValue * secondValue);
					break;
				case '=':
					System.out.println("You cannot type an equals sign in a stack.");
					System.out.println("The stack will complete but the equals sign will be ignored.");
					break;
				}
			}
		}
		
		return stack.pop();  
	}
	
	/**
	 * This is the driver that is what executes the program when the run button is pressed.
	 * The scanner object asks for the stack input from the user.
	 * The information received is then sent to the loop above to be calculated.
	 * When it is calculated, it is printed in the console as the answer.
	 * The scanner object is then closed.
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your postfix expression");
		System.out.println("and press 'Enter' when you are done: ");
		String answer = scanner.nextLine();
		System.out.println("Your postfix answer is: " + evaluatePostfix(answer));
		scanner.close();
	}
}