package preToPostGUIConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	static class ConverterGUI extends JFrame{
		
		private static final long serialVersionUID = 1L;

		// add elements to create our frame, panel, and buttons
		JFrame window= new JFrame("Expression Converter");
		JPanel panel = new JPanel();
		JButton preToPost = new JButton("Prefix to Postfix");
		JButton postToPre = new JButton("Postfix to Prefix");
		static JTextField inputTxt = new JTextField(20);
		static JTextField outputTxt = new JTextField(20);
		JLabel result = new JLabel("Result:");
		JLabel enter = new JLabel("Enter Expression:");
		
		// create constructor
		public ConverterGUI() {		
				
			// set the layout and add buttons to the JPanel
			panel.setLayout(null);
			panel.add(preToPost);
			panel.add(postToPre);
			panel.add(inputTxt);
			panel.add(outputTxt);
			panel.add(enter);
			panel.add(result);
			
			//set size and location of buttons
			preToPost.setBounds(40, 70, 150, 40);
			postToPre.setBounds(300, 70, 150, 40);
			inputTxt.setBounds(140,20,320,30);
			outputTxt.setBounds(120,140,300,30);
			outputTxt.setEditable(false);
			enter.setBounds(30, 20, 250, 30);
			result.setBounds(60,140,350,30);
			
									
			// call an instance of the lower event class to add Action listeners to the buttons
			event action = new event();
			preToPost.addActionListener(action);
			postToPre.addActionListener(action);
			
			
		} // end constructor class

	
	
	static class event implements ActionListener{
		Converter.Evaluate convert = new Converter.Evaluate();
		
		@Override
		public void actionPerformed(ActionEvent convertAction) {
			
			// create a string to read the actionCommand of the action taken
			String operator = convertAction.getActionCommand();
			
			//use an if loop to direct the users choice to the proper direction
			if (operator.equals("Prefix to Postfix")) {
				try {
				String input = inputTxt.getText();
				
				outputTxt.setText(convert.PreToPostConv(input));
				} 
				catch(StackEmptyException e) {
					JOptionPane.showMessageDialog(null, "Your input field is empty");
				}
				catch (StackFullException e) {
					JOptionPane.showMessageDialog(null, "Your input field is full");
				}
			}	
			
			
			else if (operator.equals("Postfix to Prefix")) {
				String input = inputTxt.getText();
				
				outputTxt.setText(convert.PostToPreConv(input));
			}
			
			
		} // end action performed method

	} // end event class

	public static void main(String[] args) {
		ConverterGUI GUI = new ConverterGUI();
		
		//add the JPanel
		GUI.window.add(GUI.panel);
		
		
		// set the GUI attributes
		GUI.window.setSize(500, 230);
		GUI.window.setLocation(500, 300);
		GUI.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.window.setVisible(true);
	}
	}
}

