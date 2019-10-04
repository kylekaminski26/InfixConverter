/**
 * @author Kyle Kaminski
 * The imports are crucial to the construction of the class.
 * The container class is used for the collection of button objects.
 * The Border layout class sets how the window will look.
 * The grid layout class sets how big our window will look.
 * The font class sets the font.
 * The action event class performs an action when the action occurs.
 * The action listener class listens for a specific event.
 * The JButton class sets up our buttons for the GUI and what they do when clicked.
 * The JFrame class sets up our calculator.
 * The JPanel class creates a panel that displays the calculator's input and output.
 * The JRadioButton class creates bullet point choices.
 * The JTextField class sets the text size.
 * The ScriptEngineManager class is used for calculating the 
 * calculator's equation when the equals sign is pressed by the user.
 * The ScriptEngine class calculates the equation.
 * The Script Exception class catches an exception if the calculator cannot run.
 * The Stack class is used to calculate post fix expressions.
 */

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Stack;

public class CalculatorGUI
{	
	{
		
	/**
	 * The JFrame creates the overall calculator that will be used by the class.
	 * The JPanel creates the window and the size of the calculator.
	 * The Font creates the font and font window size that will be in the display of the calculator.
	 * The text field creates the size of the text that will be displayed.
	 * The text window will not be editable by the user.
	 * The window pane will be at the top of the window.
	 * The JRadioButtons infix and post fix will determine how the expression will be calculated.
	 */
		
	JFrame buttons = new JFrame("Kyle's Calculator");
		
	Container container = buttons.getContentPane();
		
	JPanel calculator = new JPanel();
	calculator.setLayout(new BorderLayout());
	calculator.setLayout(new GridLayout(5, 7, 7, 5));
		
	final JTextField text = new JTextField(100);
	text.setEditable(false);
	
	Font font = text.getFont().deriveFont(Font.BOLD, 75);
	text.setFont(font);
		
	container.add(text, BorderLayout.NORTH);
		
	final JRadioButton infix = new JRadioButton("Infix", true);
	final JRadioButton postfix = new JRadioButton("Postfix");
	
	/**
	 * The post fix actionListener is what listens to the user's input.
	 * For example, if the user clicks the "1" button, then the program knows to put a 1 in the calculator's display.
	 * It defines an action event so the program knows how to identify one and what to do when it occurs.
	 * There is also for statement for identifying post fix, and how to arrange it in a way that the calculator can still calculate it.
	 */
	
	postfix.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent action)
		{
			final Stack operators = new Stack();
			String infix;
			infix = text.getText();
			char leftParen;
			String postfix = "";
			for(int i = 0; i < infix.length(); ++i) //while there is input to be read
			{
				leftParen = infix.charAt(i); //if it's an operand, add it to the string
				if (Character.isLetter(leftParen))
				{
					postfix = postfix + leftParen;
				}
				else if (leftParen == '(' ) //push (
				{
					operators.push(leftParen);
				}
				else if (leftParen == ')' ) //push everything back to (
				{
					while (operators.peek() != "(" )
					{
						postfix = postfix + operators.pop();
					}
					operators.pop(); //remove '('
				}
				else //print operators occurring before it that have greater precedence
				{
					while (!operators.isEmpty() && !(operators.peek() == "(" ))
					{
						postfix = postfix + operators.pop();
					}
					operators.push(leftParen);
				}
			}
			while (!operators.isEmpty())
			{
				postfix = postfix + operators.pop();
			}
		}
	});
	
	/**
	 * This JButton method is for the button "1" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "1".
	 */
	
	final JButton button1 = new JButton("1");
	button1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button1.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});

	
	/**
	 * This JButton method is for the button "2" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "2".
	 */
		
	final JButton button2 = new JButton("2");
	button2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button2.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "3" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "3".
	 */
	
	final JButton button3 = new JButton("3");
	button3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button3.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "4" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "4".
	 */
	
	final JButton button4 = new JButton("4");
	button4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button4.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "5" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "5".
	 */
	
	final JButton button5 = new JButton("5");
	button5.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button5.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "6" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "6".
	 */
	
	final JButton button6 = new JButton("6");
	button6.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button6.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "7" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "7".
	 */
	
	final JButton button7 = new JButton("7");
	button7.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button7.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "8" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "8".
	 */
	
	final JButton button8 = new JButton("8");
	button8.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button8.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "9" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "9".
	 */
	
	final JButton button9 = new JButton("9");
	button9.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button9.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "0" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "0".
	 */
		
	final JButton button0 = new JButton("0");
	button0.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = button0.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the button "." on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a ".".
	 */
	
	final JButton buttonDecimal = new JButton(".");
	buttonDecimal.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonDecimal.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the operation "+" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "+".
	 * When the equals button is pressed, the calculator adds the two numbers that are connected with this operator.
	 */
	
	final JButton buttonPlus = new JButton("+");
	buttonPlus.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonPlus.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
			}
	});
	
	/**
	 * This JButton method is for the operation "-" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "-".
	 * When the equals button is pressed, the calculator subtracts the first number by the second number that are connected with this operator.
	 */
		
	final JButton buttonMinus = new JButton("-");
	buttonMinus.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonMinus.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the operation "*" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "*".
	 * When the equals button is pressed, the calculator multiplies the two numbers that are connected with this operator.
	 */
		
	final JButton buttonMultiply = new JButton("*");
	buttonMultiply.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonMultiply.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the operation "/" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "/".
	 * When the equals button is pressed, the calculator divides the first number by the second number that are connected with this operator.
	 */
		
	final JButton buttonDivide = new JButton("/");
	buttonDivide.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonDivide.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the operation "^" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "^".
	 * When the equals button is pressed, the calculator makes the first number the base and the second number an exponent of the first.
	 */
	
	final JButton buttonExponent = new JButton("^");
	buttonExponent.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonExponent.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the symbol "(" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a "(".
	 * When the equals button is pressed, the calculator prioritizes the operations within this symbol and the other parenthesis that closes them.
	 */
	
	final JButton buttonLeftParen = new JButton("(");
	buttonLeftParen.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonLeftParen.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the symbol ")" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will receive a ")".
	 * When the equals button is pressed, the calculator prioritizes the operations within this symbol and the other parenthesis that closes them.
	 */
	
	final JButton buttonRightParen = new JButton(")");
	buttonRightParen.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = buttonRightParen.getText();
			String global = text.getText();
			global = global.concat(number);
			text.setText(global);
		}
	});
	
	/**
	 * This JButton method is for the symbol "=" on the calculator.
	 * It is basically saying how if we click this button, the window in the calculator will perform all operations that it has received.
	 * If the post fix JRadioButton is selected, then the input will be read as if it were a post fix expression.
	 * If the infix JRadioButton is selected, then the input will be read normally.
	 * If there is an error, a script exception will be thrown.
	 */
		
	final JButton buttonEquals = new JButton("( = ) Equals");
	buttonEquals.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String global = text.getText();
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			try 
			{
				String string = engine.eval(global).toString();
				text.setText(string);
			}
			catch (ScriptException exceptionScript) 
			{
				exceptionScript.printStackTrace();
			}
		}
	});
	
	/**
	 * This JButton method clears all of the already entered input from the window.
	 */
	
	final JButton buttonClear = new JButton("Clear");
	buttonClear.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String global = text.getText();
			global = null;
			text.setText(global);
		}
	});
	
	/**
	 * These lines of code add all of the buttons onto our window when the program is ran.
	 * The order they are listed in specifies the order that the program reads them when compiled.
	 * They will show up in this order when the program is ran and the calculator window opens.
	 */
	
	calculator.add(buttonClear);
	calculator.add(button1);
	calculator.add(button2);
	calculator.add(button3);
	calculator.add(buttonPlus);
	calculator.add(button4);
	calculator.add(button5);
	calculator.add(button6);
	calculator.add(button7);
	calculator.add(buttonMinus);
	calculator.add(button8);
	calculator.add(button9);
	calculator.add(button0);
	calculator.add(buttonDecimal);
	calculator.add(buttonMultiply);
	calculator.add(buttonLeftParen);
	calculator.add(buttonRightParen);
	calculator.add(buttonExponent);
	calculator.add(buttonEquals);
	calculator.add(buttonDivide);
	calculator.add(infix);
	calculator.add(postfix);
	
	/**
	 * These lines of code handle the size of the window, the fact that it terminates on close, and that the window is in the center of the screen.
	 * The calculator will also be visible when the program executes (obviously).
	 */
	
	container.add(calculator, BorderLayout.CENTER);
	buttons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	buttons.setSize(550, 550); 
	buttons.setVisible(true);
	}
	
	/**
	 * This driver method is what runs the program when the run button is clicked.
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
			new CalculatorGUI();
	}
}