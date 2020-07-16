import java.util.*;
import java.io.*;
public class HomeScreen
{
	public static boolean homeScreen() throws IOException, InterruptedException
	{
		Utility.cls();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcome to College Simulator");
		System.out.println();
		System.out.println("1. Start new game");
		System.out.println("2. Load");
		System.out.println("3. Help");
		System.out.println("4. Exit");
		boolean exit=false;
		while(choice==0)
		{
			choice = input.nextInt();
			switch (choice)
			{
				case 1: newGame();break;
				case 2: load();break;
				case 3: help(input);break;
				case 4: exit = exit(exit);break;
				default: break;
			}
		}
		return exit;
	}
	
	private static void newGame() throws IOException, InterruptedException
	{
		Utility.cls();
		System.out.println("newGame");
		GameDriver.play(1);
	}
	
	private static void load()throws FileNotFoundException, IOException,InterruptedException
	{
		try
		{
			GameDriver.play(0);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No file to load\nEnter to continue");
			Utility.getEnter();
		}
	}
	
	public static void help(Scanner input) throws InterruptedException, IOException
	{
		Utility.cls();
		System.out.println("Bold of you to assume I have this all figured out. psh. \n");
		System.out.println("Press Enter to return to Home");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}
	
	private static boolean exit(boolean exit)
	{
		return exit=true;
	}
}
