import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class AddMovie extends JFrame implements Serializable
{
	private JPanel wholePanel, radioButtonP, textFieldP, buttonP, textAreaP;
	private JRadioButton action, drama, roman, science;
	private ButtonGroup bg;
	private JTextField name, year, rate;
	private JTextArea introduction;
	private JLabel Type, MovieName, Year, Rate, Intro;
	private JButton adding, clear, display, exit;
	private	JScrollPane scrolledText;
	
	
	public AddMovie()
	{
		super("Add My Movie");
		this.setSize(650, 300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//create color
		Color purple = new Color((float)0.5, (float)0.0, (float)0.5);
		Color brown = new Color((float)(200.0/255), (float)(150.0/255), (float)0.0);
		
		//define all panels
		wholePanel = new JPanel(new GridLayout(1,3,10,10));
		wholePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		radioButtonP = new JPanel(new GridLayout(5,1,0,0));
		radioButtonP.setBorder(BorderFactory.createEtchedBorder(1,Color.pink, Color.pink));
		
		textFieldP = new JPanel(new GridLayout(6,1,0,0));
		textFieldP.setBorder(BorderFactory.createEtchedBorder(1,Color.pink, Color.pink));
		
		buttonP = new JPanel(new GridLayout(1,4,10,10));
		buttonP.setBorder(BorderFactory.createEtchedBorder(1,Color.pink, Color.pink));
		textAreaP = new JPanel(new BorderLayout());
		textAreaP.setBorder(BorderFactory.createEtchedBorder(1,Color.pink, Color.pink));
		
		
		//set color to panels
		wholePanel.setBackground(Color.yellow);
		buttonP.setBackground(Color.yellow);
		radioButtonP.setBackground(Color.yellow);
		textFieldP.setBackground(Color.yellow); 
		textAreaP.setBackground(Color.yellow);
		
		
		//Add radio button panel
		Type = new JLabel("Movie Type");
		Type.setForeground(purple);
				
		action = new JRadioButton("Action");
		action.setBackground(Color.orange);
		drama = new JRadioButton("Drama");
		drama.setBackground(Color.magenta);
		roman = new JRadioButton("Romantic");
		roman.setBackground(Color.cyan);
		science = new JRadioButton("Science Fiction");
		science.setBackground(Color.green);
		bg = new ButtonGroup();
		bg.add(action);
		bg.add(drama);
		bg.add(roman);
		bg.add(science);
		
		radioButtonP.add(Type);
		radioButtonP.add(action);
		radioButtonP.add(drama);
		radioButtonP.add(roman);
		radioButtonP.add(science);
				
		wholePanel.add(radioButtonP);
		
		
		//add text field panel		
		MovieName = new JLabel("Movie Name");
		MovieName.setForeground(purple);		
		name = new JTextField(12);
		
		Year = new JLabel("Publish Year");
		Year.setForeground(purple);
		year = new JTextField(12);
		
		Rate = new JLabel("Movie Rate");
		Rate.setForeground(purple);
		rate = new JTextField(12);
		
		textFieldP.add(MovieName);
		textFieldP.add(name);
		textFieldP.add(Year);
		textFieldP.add(year);
		textFieldP.add(Rate);
		textFieldP.add(rate);
		
		wholePanel.add(textFieldP);
		
		
		//add text area panel
		Intro = new JLabel("Movie Summary");
		Intro.setForeground(purple);
		
		introduction = new JTextArea();
		introduction.setLineWrap(true);
		
		scrolledText = new JScrollPane(introduction);
		scrolledText.setVerticalScrollBarPolicy(
					 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
				
		textAreaP.add(Intro, BorderLayout.NORTH);
		textAreaP.add(scrolledText, BorderLayout.CENTER);
		
		wholePanel.add(textAreaP);
		
		//add button panel
		adding = new JButton("Add Movie");
		adding.addActionListener(new AddButtonListener());
		clear = new JButton("Clear Input");
		clear.addActionListener(new ClearButtonListener());
		display = new JButton("Display Exist Movies");
		display.addActionListener(new DisplayButtonListener());
		exit = new JButton("Exit");
		exit.addActionListener(new exit());
				
		buttonP.add(adding);
		buttonP.add(clear);
		buttonP.add(display);
		buttonP.add(exit);
		
		this.add(wholePanel, BorderLayout.CENTER);
		
		this.add(buttonP, BorderLayout.SOUTH);		
	}
	
	//operation when user click Add
	public class AddButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{		
			//get text in the text field	
			String MovieTitle = name.getText();
			String MovieYear = year.getText();
			String MovieRate = rate.getText();
			String MovieSummary = introduction.getText();
			String MovieType= "";
			int yearNum = Integer.parseInt(MovieYear);
			double rateNum = Double.parseDouble(MovieRate);
			
			if(action.isSelected())
			{
				MovieType = "Action";
			}
			if(drama.isSelected())
			{
				MovieType = "Drama";
			}
			if(roman.isSelected())
			{
				MovieType = "Romantic";
			}
			if(science.isSelected())
			{
				MovieType = "Science Fiction";
			}
			
			//pass variable to the Movie constructor
			Movie aMovie = new Movie(MovieType, MovieTitle, 
								 yearNum, rateNum, MovieSummary);
			try 
			{
				Movie.AddMovie(aMovie);
			} 
			catch (Exception e1) 
			{					
			}			
		}
	}
	
	//When user click on clear button
	public class ClearButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//set all the text field empty
			name.setText("");
			year.setText("");
			rate.setText("");
			introduction.setText("");
		}
	}	
	
	//when user click display button
	public class DisplayButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			//call display window class
			/*
			DisplayWindow display_window = new DisplayWindow();
			display_window.setVisible(true);
			*/
			
			MoviePoster movie_poster = new MoviePoster();
			movie_poster.setVisible(true);
		}	
	}
	
	//exit the program when user click on exit button
	private class exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			System.out.println("Thank you for using!!");
			System.exit(0);
		}
	}
}