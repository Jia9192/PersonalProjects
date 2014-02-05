import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

//display window class
public class DisplayWindow extends JFrame implements ActionListener
{
	JButton okay, back, exit;
	JRadioButton action, drama, romantic, science_fiction, all;
	JLabel BoxLabel;
	JPanel radioButtonP, displayP;
	JTextArea textArea;
	JLabel newMovieLabel;
	JLabel type, title, year, rate, summary;
	ButtonGroup bg2;
	JScrollPane scrolledText;
	
	//create the display window
	public DisplayWindow()
	{
		this.setTitle("Display Window");
		this.setSize(900, 400);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//set up panels
		radioButtonP = new JPanel(new GridLayout(9,1));
		radioButtonP.setBorder(BorderFactory.createLineBorder(Color.yellow, 10));
		radioButtonP.setBackground(Color.yellow);
		displayP = new JPanel(new BorderLayout());
		displayP.setBorder(BorderFactory.createLineBorder(Color.yellow, 10));		
		
		//set radio button and button panel
		BoxLabel = new JLabel("Check the movie types you wanna display");
		action = new JRadioButton("Action");
		action.setBackground(Color.pink);
		drama = new JRadioButton("Drama");
		drama.setBackground(Color.lightGray);
		romantic = new JRadioButton("Romantic");
		romantic.setBackground(Color.cyan);
		science_fiction = new JRadioButton("Science Fiction");
		science_fiction.setBackground(Color.orange);
		all = new JRadioButton("All");
		all.setBackground(Color.green);
	
		bg2 = new ButtonGroup();
		bg2.add(action);
		bg2.add(drama);
		bg2.add(romantic);
		bg2.add(science_fiction);
		bg2.add(all);
		
		okay = new JButton("OK");
		okay.addActionListener(this);
		back = new JButton("Back");
		back.addActionListener(new back());
		exit = new JButton("Exit");
		exit.addActionListener(new exit());
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		radioButtonP.add(BoxLabel);
		radioButtonP.add(action);
		radioButtonP.add(drama);
		radioButtonP.add(romantic);
		radioButtonP.add(science_fiction);
		radioButtonP.add(all);
		radioButtonP.add(okay);
		radioButtonP.add(back);
		radioButtonP.add(exit);
	
		//set scroll bar and text area
		scrolledText = new JScrollPane(textArea);
		scrolledText.setHorizontalScrollBarPolicy(
					 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrolledText.setVerticalScrollBarPolicy(
					 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		
		
		displayP.add(scrolledText, BorderLayout.CENTER);
		
		this.add(radioButtonP, BorderLayout.WEST);
		this.add(displayP, BorderLayout.CENTER);
	
	}
	
	//when user click on Okay button
	public void actionPerformed(ActionEvent e)
	{
		String discriptionOfMovie = "";
		String text = "" ;
		try 
		{
			//if there is nothing in the file, do nothing
			if(Movie.GetAllMovies() == null)
			{
				return;
			}
			//else, use for each loop to check all the objects in the arraylist				
			for(Movie element : Movie.GetAllMovies())
			{
				int n = 1;
				//check which button the user selected and print out the movie of the type that
				//user selected
				if (action.isSelected() && element.getType().equals("Action"))
				{					
					discriptionOfMovie = element.toString() + "\n";
					text += discriptionOfMovie + "\n";
					textArea.setText(text);
				}
				if (drama.isSelected() && element.getType().equals("Drama"))
				{
					discriptionOfMovie = element.toString() + "\n";
					text += discriptionOfMovie + "\n";
					textArea.setText(text);
				}
				
				if (romantic.isSelected() && element.getType().equals("Romantic"))
				{
					discriptionOfMovie = element.toString() + "\n";
					text += discriptionOfMovie + "\n";
					textArea.setText(text);
				}
				
				if (science_fiction.isSelected() && element.getType().equals("Science Fiction"))
				{					
					discriptionOfMovie = element.toString() + "\n";
					text += discriptionOfMovie + "\n";
					textArea.setText(text);
				}					
				if (all.isSelected())
				{
					discriptionOfMovie = element.toString() + "\n";					
					text += discriptionOfMovie + "\n";
					textArea.setText(text);
				}			
			}			
		} 
		catch (Exception e1) 
		{				
			e1.printStackTrace();
		}
	}
	
	//do nothing if user click on radio button
	private class radio implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		}
	}
	
	//back to the add movie window when user click on back button
	private class back implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
	
	//exit when user click on exit button
	private class exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println("Thank you for using!!");
			System.exit(0);
		}
	}
}
