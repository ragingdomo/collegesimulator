
//This class holds the methods that perform planned events in the game.
import java.util.Scanner;
import java.io.*;
public class PlannedEvent
{
	public static void firstDay(Scanner f) throws IOException,InterruptedException
	{
		Utility.cls();
		System.out.println("Well, here you are. First day of college...\nYour room kind of sucks, but did you really expect that $40k going to nice living? Ha!");
		Utility.getEnter();
		System.out.println("You have a letter from the school. You should open it.\nOpen Letter?\n");
		System.out.println("1. Yes\n2. No");
		int choice = f.nextInt();
		if(choice == 1)
		{
			Utility.cls();
			System.out.println("\"Welcome to Generic University! We're so excited to have you joining us here!\n We hope orientation went well.\"\n\n It didn't.\n");
			Utility.getEnter();
			System.out.println("\"Your room advisor should've found you to help you get settled.\"\n\n You have a room advisor?\n\n");
			Utility.getEnter();
			System.out.println("\"Classes start tomorrow morning. We hope you have a wonderful time here. Go Bobcats!\"");
			Utility.getEnter();
		}
		else
		{
			System.out.println("You should really open it.");
			System.out.println("1. Open letter\n2. no u");
			choice = f.nextInt();
			if(choice == 1)
			{
				Utility.cls();
				System.out.println("\"Welcome to Generic University! We're so excited to have you joining us here!\n We hope orientation went well.\"\n\n It didn't.\n");
				Utility.getEnter();
				System.out.println("\"Your room advisor should've found you to help you get settled.\"\n\n You have a room advisor?\n\n");
				Utility.getEnter();
				System.out.println("\"Classes start tomorrow morning. We hope you have a wonderful time here. Go Bobcats!\"");
				Utility.getEnter();
			}
			else
			{
				Utility.cls();
				System.out.println(" Fine, I'll just read it for you.\n");
				System.out.println("\"Welcome to Generic University! We're so excited to have you joining us here!\n We hope orientation went well.\"\n\n It didn't.\n");
				Utility.getEnter();
				System.out.println("\"Your room advisor should've found you to help you get settled.\"\n\n You have a room advisor?\n\n");
				Utility.getEnter();
				System.out.println("\"Classes start tomorrow morning. We hope you have a wonderful time here. Go Bobcats!\"");
				Utility.getEnter();
			}
		}
		while(true)
		{
			System.out.println("Well, I guess all there is to do is sleep.\n");
			System.out.println("1. Sleep");
			choice = f.nextInt();
			if(choice != 1)
			{
				System.out.println("Bold, but nice try");
				Utility.getEnter();
			}
			else break;
		}
	}
	
	public static void pickPersonality(Game g, Scanner f) throws IOException,InterruptedException
	{
		Utility.cls();
		System.out.println("Before you start your *wonderful* college adventure, we need to know something first.\n");
		System.out.println("What's your personality type?");
		System.out.println("Your PERSONALITY will start you with a boost in one category and give extra points\nwhile making it harder to obtain points in other categories.\n");
		System.out.println("1. Social Butterfly - Extra SOCIAL at start and begin with a friend. Harder to obtain SCHOOL points.");
		System.out.println("2. Child Genius - Extra SCHOOL at start and bonus to SCHOOL scores. Harder to obtain SOCIAL points.");
		System.out.println("3. Money Bags - Extra MONEY at start and bonus to MONEY scores. Harder to obtain SELFCARE points.");
		System.out.println("4. Clean Freak - Extra SELFCARE at start and bonus to SELFCARE scores. Harder to obtain MONEY points.");
		System.out.println("5. Somehow Motivated - Start with no bonus, but gain all points a bit faster.");
		int choice = f.nextInt();
		boolean chosen = true;
		do
		{
			
			if(choice>=1&&choice<=5) 
				g.setPersonality(choice);
			else
			{
				System.out.println("Please choose a listen number");
				chosen = false;
				Utility.getEnter();
			}
		}while(!chosen);
		System.out.println("\nAwesome, lets get you started.");
		Utility.getEnter();
	}
		
		
		
		
		
		
		
		
		
		
}