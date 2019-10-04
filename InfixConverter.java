/**
 * @author Kyle Kaminski
 * These four imports and crucial to this class.
 * The BufferedReader class is used to read the console input.
 * The IOException class is used as an exception handler.
 * The InputStreamReader class is used to stream the input from the console to the
 * methods below for calculation.
 * The stack class is used for the calculation of the infix into a post fix expression.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConverter 
{
	
	/**
	 * The driver method houses the part of the program that is run.
	 * First, a string variable for the infix expression is created.
	 * The buffered reader class then reads the inputed infix expression.
	 * The console then prints out two lines to the console:
	 * The first line is the infix expression that was entered into the program.
	 * The second line is the post fix expression that results from the infix expression.
	 * That post fix expression was calculated with the code that is below the driver.
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String args[]) throws IOException 
	{
		String infix;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter an infix expression: ");
		infix = input.readLine();
		System.out.println("Your Infix Expression: " + infix);
		System.out.println("Resulting Postfix Expression: " + infixToPostfix(infix));
	}
	
	/**
	 * This method is how we translate the infix expression to post fix.
	 * A post fix String is created.
	 * A stack is created. This is how we will calculate the post fix expression.
	 * A char object called poppedOp is created.
	 * This char object is used for moving the operation when converting to post fix.
	 * A for loop is created for when there is still input to be read.
	 * The for loop creates a char variable.
	 * Another for loop is created for when there is not an operator left in the stack.
	 * The else if statement is for when there is a right parenthesis.
	 * This will pop the stack until there is a left parenthesis to be read.
	 * The else statement has a while loop for when the infix still has an operator,
	 * and if the next character is not a left parenthesis.
	 * This pops the operator to the end of the stack.
	 * The else statement then pushes the operator so the next character can be read.
	 * The for loop then ends with returning the postfix expression, which the driver uses
	 * to print to the console when the program is run.
	 * @param infix
	 * @return postfix
	 */
	
	private static String infixToPostfix(String infix) 
	{
		String postfix = "";
		Stack <Character> operator = new Stack <Character>();
		char poppedOp;
		for (int i = 0; i < infix.length(); i++) 
		{
			char next = infix.charAt(i);
			if (!isOperator(next))
			{
				postfix += next;
			}
			else if (next == ')')
			{
				while ((poppedOp = operator.pop()) != '(')
				{
					postfix += poppedOp;
				}
			}
			else
			{
				while (!operator.isEmpty() && next != '(' && precedence(operator.peek()) >= precedence(next))
				{
					postfix += operator.pop();
				}
				operator.push(next);
			}
		}
		while (!operator.isEmpty())
		{
			postfix += operator.pop();
		}
		return postfix;
	}
	
	/**
	 * This method simply says if there is an operator in the stack.
	 * It directs the program to the next method, which determines what operators
	 * have precedence over the others.
	 * @param i
	 * @return precedence(i) > 0
	 */
	
	private static boolean isOperator(char i) 
	{
		return precedence(i) > 0;
	}
	
	/**
	 * This method is used for determining the precedence of the operators in the infix expression.
	 * If the symbol in the infix is a left or right parenthesis, then whatever is inside them
	 * has the highest priority over everything else in the stack.
	 * If the symbol is a plus or a minus, then it is given the second priority, behind the 
	 * left and right parenthesis.
	 * If the symbol is a star or division sign, then it is given the third priority, behind
	 * the plus and minus, and the left and right parenthesis, respectively.
	 * If there is no symbol to be read (meaning that the infix expression is empty, all of the
	 * symbols have already been read, or the infix expression does not contain any symbols), then
	 * there is no precedence to be given to anything, since there are no symbols in the expression.
	 * @param i
	 * @return 1, 2, 3, 0
	 */
	
	private static int precedence(char symbol) 
	{
		if (symbol == '(' || symbol == ')') 
		{
			return 1;
		}
		else if (symbol == '+' || symbol == '-') 
		{
			return 2;
		}
		else if (symbol == '*' || symbol == '/') 
		{
			return 3;
		}
		else 
		{
			return 0;
		}
	}
}