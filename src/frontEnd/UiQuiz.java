package frontEnd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Data.DataQuery;
import Interface.Schedule;
import Interface.Verify;

public class UiQuiz 
{
	private JFrame mainFrame;
	private JLabel lbl;
	private JTextField output;
	private JTextField input; 
	private JButton btn;
	private static Integer Instance = 1;
	
	public UiQuiz(String Question)
	{
		mainFrame = new JFrame("Quiz");
		mainFrame.setSize(500,100);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.addWindowListener(new WindowAdapter()
		
		{
			public void windowClosing(WindowEvent windowEvent)
				{System.exit(0);}        
		});
		
		lbl = new JLabel("Quiz");
		lbl.setSize(10, 5);
		mainFrame.add(lbl,BorderLayout.NORTH);

		output = new JTextField(Question, 20);
		output.setEditable(false);
		mainFrame.add(output,BorderLayout.WEST);

		input = new JTextField("", 20);
		mainFrame.add(input,BorderLayout.EAST);
		
		btn = new JButton("Enter");   
		mainFrame.add(btn,BorderLayout.SOUTH);                    
		btn.addActionListener(new clickListener());
		mainFrame.getRootPane().setDefaultButton(btn);
		
		mainFrame.setVisible(true);  
	}
		
	public static void main(String[] args) 
	{
		Schedule.generateSubject("Maths");
		new UiQuiz(DataQuery.queryDesc1(Schedule.decrypt(Instance)));
		System.out.println(Schedule.length());
	}
	
	private class clickListener implements ActionListener
	{public void actionPerformed(ActionEvent e)
	{
		if	(Verify.Translation(Instance, input.getText()))
				{System.out.println("Correct");}
		else	{System.out.println("Incorrect: "+ DataQuery.queryDesc2(Schedule.decrypt(Instance)));}
		if	(Instance < Schedule.length())
			{
			Instance ++;
			input.setText("");
			output.setText(DataQuery.queryDesc1(Schedule.decrypt(Instance)));	
			}
		else	{System.exit(0);}
	}}
};