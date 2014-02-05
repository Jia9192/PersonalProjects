import java.io.*;
import java.util.ArrayList;

public class Movie implements Serializable
{
	private String title, summary, type;
	private int year;
	private double rating;
    static private String fileName;
    
    //set up constructors
	public Movie()
	{
		title = null;
		type = null;
		summary = null;
		year = 0;
		rating = 0.0;
	}
	
	public Movie(String TYPE, String TITLE, int YEAR, double RATE, String SUMMARY)
	{
		this.type = TYPE;
		this.title = TITLE;
		this.year = YEAR;
		this.rating = RATE;
		this.summary = SUMMARY;
	}
	
	//getters and setters
	public void setFileName(String name)
	{
		this.fileName = name;
	}
	
	public void setType(String theType)
	{
		this.type = theType;
	}
	
	public String getType()
	{
		return type;
	}
	
	//toString method
	public String toString()
	{
		return "Type: " + type + "\n" + "Title: " + title + "\n" 
			   + "Year: " + year + "\n" + "Rate: " + rating + "\n" 
			   + "Summary: " + summary + "\n";
	} 
	
	//addMovie method to add movies into arraylist
	public static void AddMovie(Movie object) throws Exception
	{
		ArrayList<Movie> currentList = GetAllMovies();
		//if the array list is empty, create a new arraylist
		if(currentList == null)
		{
			currentList = new ArrayList<Movie>();
		}
		currentList.add(object);
		
		//write the informations of the movie to the file
		ObjectOutputStream outputStream = new ObjectOutputStream(
        							   new FileOutputStream(fileName));
        for(Movie element : currentList)
        {
        	outputStream.writeObject(element);
        }      
        
        outputStream.close();    
	}
	
	//GetAllMovies method to read all the movies in the file, return the arraylist
	public static ArrayList<Movie> GetAllMovies() throws Exception
	{
		boolean endOfFile = false;
		
		try{		
			//read all the arraylist from the file.
			ObjectInputStream inputStream = new ObjectInputStream(
				    				new FileInputStream(fileName));
			
			ArrayList<Movie> list = new ArrayList<Movie>(20);
			
			Movie aMovie = new Movie();
			
	        while(!endOfFile)
	        {
	        	try 
	        	{
					aMovie = (Movie)inputStream.readObject();
					list.add(aMovie);
				}
				catch (EOFException e)
				{
					endOfFile = true;				
				}        	
	        	
	        }			        
	        inputStream.close();
			
	        return list;
		}
		catch(FileNotFoundException e)
		{
			return null;
		}
	}
}