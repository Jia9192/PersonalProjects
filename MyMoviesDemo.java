/* 
   Problem Statement: 
   		Write a project that allow user to add the movie into file, read out certian 
   		type of movies from the file and display in the window
   
   Overall Plan
   1.Create a Movie class
   		a. define all the variables of Movie
   		b. create constructor, getters and setters.
   		c. create an arraylist that store all the movies,
   		d. create a method that write the movies in the arraylist to the file. 
   		e. create a method that can read all the movie from the file, return the movies as arraylist.
   		
   2.Create a addMovie class
   		a. create a window that allows user to add movie's type, title, year, rate, and summary.
   		b. add action listener to the buttons, create inner classes for certian button
   		c. When user click add movie button, get the information user entered in the window, call the 
   				method in the Movie class to add into arraylist
   		d. When user click on display movie button, call the displayWindow class.
   		e. When user click on exit button, end the program.
   		
   3.Create a displayWindow class
   		a. create a display window that ask the user to choose the type of movie he want to display
   		b. create a text area for output.
   		c. if use click on Okay button, check which radio button he selected and use enhanced for loop
   				to find the movie type and output into the text area.
   		d. if the user click back button, dispose the display window
   		e. if the user click on exit button, end the program.   
   		
   4.Create a demo class
   		a. create a main method.
   		b. ask the user to input the name of file he want to save into.
   		c. call the AddMovie class and start the demo.
    
 */


import java.util.Scanner;

public class MyMoviesDemo
{
	public static void main(String[] args)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to use Self Movie Storage!!");
		System.out.println("Do you like movie?");
		System.out.println("This program will help you record all the movies you have seen before.");
		System.out.println("Let's START it!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
			
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the file name you want to save in");
		String name = keyboard.nextLine();
		
		
		Movie movie = new Movie();
		movie.setFileName(name);
		
		
		AddMovie newMovie = new AddMovie();
		newMovie.setVisible(true);
	}
}