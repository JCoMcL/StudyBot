package frontEnd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Data.DataInsert;

public class UiInsert
{
	private JFrame mainFrame;
	private JLabel lbl;
	private JTextField one;
	private JTextField two; 
	private JTextField tri;
	private JTextField four;
	private JTextField five;
	private JButton btn;
	
	public UiInsert()
		{prepareGUI();}
		
	private void prepareGUI()
	{
		mainFrame = new JFrame("Insert");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.addWindowListener(new WindowAdapter()
		
		{
			public void windowClosing(WindowEvent windowEvent)
				{System.exit(0);}        
		});
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0;
		c.weighty = 1;
		c.gridx = 0;
		GridBagConstraints d = new GridBagConstraints();
		d.weightx = 1;
		d.weighty = 1;
		d.gridx = 1;
		d.fill = GridBagConstraints.BOTH;

		c.gridy=0;
		lbl = new JLabel("Desc 1");
		lbl.setSize(10, 5);
		mainFrame.add(lbl,c);

		d.gridy=0;
		one = new JTextField("", 20);
		mainFrame.add(one,d);
		
		c.gridy=1;
		lbl = new JLabel("Desc 2");
		mainFrame.add(lbl,c);

		d.gridy=1;
		two = new JTextField("", 20);
		//two.addKeyListener(keyListener);
		mainFrame.add(two,d);
		
		c.gridy=2;
		lbl = new JLabel("Subject");
		mainFrame.add(lbl,c);

		d.gridy=2;
		tri = new JTextField("", 20);
		mainFrame.add(tri,d);
		
		c.gridy=3;
		lbl = new JLabel("Section");
		mainFrame.add(lbl,c);

		d.gridy=3;
		four = new JTextField("", 20);
		mainFrame.add(four,d);
		
		c.gridy=4;
		lbl = new JLabel("Type");
		mainFrame.add(lbl,c);	

		d.gridy=4;
		five = new JTextField("", 20);
		mainFrame.add(five,d); 
		
		d.gridy=5;
		d.weighty=0.2;
		btn = new JButton("Submit");   
		mainFrame.add(btn, d);                    
		btn.addActionListener(new clickListener());
		mainFrame.getRootPane().setDefaultButton(btn);
		
		mainFrame.setVisible(true);  
	}       

	public static void main(String[] args) 
		{new UiInsert();}
	
	private class clickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			DataInsert in = new DataInsert();
			
			String Desc1 	= one.getText();
			String Desc2 	= two.getText();
			String Subject 	= tri.getText();
			String Topic 	= four.getText();
			String Type		= five.getText();
			
			in.insert(Desc1, Desc2, Subject, Topic, Type);
			
			one.setText("");
			two.setText("");
		}		
	}
};