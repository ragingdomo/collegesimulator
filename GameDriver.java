
//Class GameDriver runs the actual game.
import java.util.*;
import java.io.*;
public class GameDriver
{
	public static void play(int newGame) throws FileNotFoundException,IOException,InterruptedException
	{
		//Game object creation and set up. First events triggered if new game.
		Scanner f = new Scanner(System.in);
		Game g = new Game();
		if(newGame==0)
			g.loadGame();
		else
		{
			PlannedEvent.pickPersonality(g,f);
			PlannedEvent.firstDay(f);
		}
		
		//Day loop.
		boolean exit = false;
		do 
		{
			//checkDay(g);
			exit = dayScreen(g,f);
		}while(!exit);
	}
	private static boolean dayScreen(Game g, Scanner f) throws IOException,InterruptedException
	{
		System.out.println("The next day.\n\nToday is day "+g.getDay());
		Utility.getEnter();
		boolean exit = false;
		while(g.getTime()>0)//this is the loop for the day itself.
		{
			Utility.cls();
			System.out.println(g.getTime());
			System.out.println(g.toString()+"\n");
			System.out.println("What would you like to do?");
			System.out.println("1. Sleep\n2. Go to class\n3. Study\n4. Hang with friends\n5. Self care\n6. Work\n7. Pause");
			int choice = f.nextInt();
			if(g.getTime()<=17)
			{
				switch(choice)
				{
					case 1: sleep(g,f); break;
					case 2: 
					{
						if(g.getDOW()==6||g.getDOW()==7)
							System.out.println("It's the weekend. No classes.");
						else
							System.out.println("Classes are over for the day, my friend."); 
						Utility.getEnter();
						break;
					}
					case 3: study(g,f); break;
					case 4: hang(g,f); break;
					case 5: care(g,f); break;
					case 6: work(g,f); break;
					case 7: exit = pauseScreen(g,f); break;
					case 8: g.dayInc(); break;
					default: 
					{
						System.out.println("You gotta pick one, man."); 
						Utility.getEnter();
						break;
					}
				}
			}
			else
			{
				switch(choice)
				{
					case 1: sleep(g,f); break;
					case 2: classes(g); break;
					case 3: study(g,f); break;
					case 4: hang(g,f); break;
					case 5: care(g,f); break;
					case 6: work(g,f); break;
					case 7: exit = pauseScreen(g,f); break;
					default: 
					{
						System.out.println("You gotta pick one, man."); 
						Utility.getEnter();
						break;
					}
				}
			}
			if(exit)break;
		}
		g.dayInc();
		g.resetTime();
		return exit;
	}
	
	private static boolean pauseScreen(Game g, Scanner f) throws IOException,InterruptedException
	{
		boolean exit = false;
		Utility.cls();
		System.out.println("Pause Menu\n");
		System.out.println("1. Save & Quit\n2. How to play");
		int choice = f.nextInt();
		if(choice==1) 
		{
			g.saveGame();
			exit=true;
		}
		else if(choice==2)
		{
			HomeScreen.help(f);
		}
		return exit;
	}
			
	
	//sleep---------------------------------------------------
	private static void sleep(Game g, Scanner f) throws IOException,InterruptedException
	{
		if(g.getTime()<1)
		{
			System.out.println("No time for sleep. Today is a new day");
			Utility.getEnter();
		}
		else
		{
			System.out.println("How long are you sleeping? There are "+g.getTime()+" hours left in the day.");
			int choice = f.nextInt();
			if(g.adjustTime(choice)) 
			{
				System.out.println("Sleeping is a great way to forget about your problems and make time fly!");
				Utility.getEnter();
			}
		}
	}
	
	//classes------------------------------------------------------
	private static void classes(Game g) throws IOException,InterruptedException
	{
		int classesLeft = g.getTime()-17;
		g.adjustTime(classesLeft);
		if(classesLeft==7)
		{
			System.out.println("You made it to all of your classes! Bonus points!");
			g.adjustSchool(3);
		}
		else if(classesLeft<7&&classesLeft>3)
		{
			System.out.println("You went to a few classes. Not bad.");
			g.adjustSchool(2);
		}
		else
		{
			System.out.println("Dude, you went to like one class. Bare minimum, but I appreciate the effort.");
			g.adjustSchool(1);
		}
		Utility.getEnter();
	}
	
	//study--------------------------------------------------------
	private static void study(Game g,Scanner f) throws IOException,InterruptedException
	{
		while(true)
		{
			System.out.println("How long will you study? There are "+g.getTime()+" hours left.");
			int hours = f.nextInt();
			if(!g.adjustTime(hours)) Utility.getEnter();
			else
			{
				g.adjustSchool(1+hours/2);
				System.out.println("Decent study sesh. Good for you.");
				break;
			}
		}
		Utility.getEnter();
	}
	
	//hang----------------------------------------
	private static void hang(Game g, Scanner f) throws IOException,InterruptedException //broken
	{

		int choice = 0;
		if(g.getFriends()==0)
		{
			while(true)
			{
				System.out.println("You don't have any friends. Wanna go look for friends?");
				System.out.println("1. Yes\n2. No\n");
				choice = f.nextInt();
				if(choice == 2) break;
				else if(choice == 1)
				{
					System.out.println("You spent the rest of the day finding a friend.");
					System.out.println("You have a new friend named Sam!");
					Utility.getEnter();
					g.adjustTime(g.getTime());
					g.adjustSocial(1);
					g.setFriends(g.getFriends()+1);
					break;
				}
			}
		}
		else
		{
			while(true)
			{
				System.out.println("How long will you be hanging? There are "+g.getTime()+" hours left.");
				int hours = f.nextInt();
				if(!g.adjustTime(hours)) Utility.getEnter();
				else
				{
					g.adjustSocial(1+hours/2);
					System.out.println("Friends help to escape the piles of homework and crushing debt! Time well spent, I'd say.");
					break;
				}
			}
		}
	}
	
	//care-----------------------------------------
	private static void care(Game g, Scanner f) throws IOException,InterruptedException
	{
		while(true)
		{
			System.out.println("How much time will you spend self-caring? There are "+g.getTime()+" hours left.");
			int hours = f.nextInt();
			if(!g.adjustTime(hours)) Utility.getEnter();
			else
			{
				g.adjustSelfCare(1+hours/2);
				System.out.println("Upkeep is always a good idea. Cleaning your room, showering, and relaxing help keep a sharp mind.");
				break;
			}
		}
		Utility.getEnter();
	}
	
	//work-----------------------------------------------
	private static void work(Game g, Scanner f) throws IOException,InterruptedException
	{
		if(g.getJob()==0)
		{
			System.out.println("You have no job.");
			System.out.println("Would you like to apply for one?");
			System.out.println("1. Yes\n2. No");
			int choice = f.nextInt();
			if(choice == 1)
				findJob(g,f);
		}
		else
		{
			int job = g.getJob();
			switch(job)
			{
				case 1: //when job is mowing
				{
					while(true)
					{
						System.out.println("How many hours would you like to work? There are "+(g.getTime()-12)+" hours left to work.");
						int hours = f.nextInt();
						if(!g.adjustTime(hours)) Utility.getEnter();
						else
						{
							g.adjustMoney(1+hours/2);
							break;
						}
					}
					break;
				}
				case 2: //when job is coffee
				{
					if(g.getTime()>16) System.out.println("You can't go to work yet.");
					else if(g.getTime()==16)
					{
						System.out.println("Money can be exchanged for goods and services.");
						g.adjustTime(5);
						g.adjustMoney(5);
					}
					else System.out.println("You missed work for the day");
					break;
				}
				case 3: //when job is grocery
				{
					if(g.getTime()<=16&&g.getTime()>11) 
					{
						System.out.println("Your face hurts from smiling so much, but money is money.");
						g.adjustTime(g.getTime()-10);
						g.adjustMoney(3);
					}
					else if(g.getTime()>16)
						System.out.println("You can't go to work yet");
					else System.out.println("You missed work for the day.");
					break;
				}
				default: break;
			}
			
			Utility.getEnter();
		}
	}
	
	//findJob----------------------------------------------------
	public static void findJob(Game g, Scanner f) throws IOException,InterruptedException
	{
		while(true)
		{
			Utility.cls();
			System.out.println("Alright, lets see if we can find you a job.");
			System.out.println("Looks like there's 3 jobs available.\nEmpire Mowing, Coffee Coffee Coffee, and Gregg's Grocery\n");
			System.out.println("1. Empire Mowing\n2. Coffee Coffee Coffee\n3. Gregg's Grocery\n4. I don't want a job right now");
			int choice = f.nextInt();
			if(choice == 1)
			{
				System.out.println("\"Choose your own hours! Just grab a mower, and we'll tell you where to go!\"");
				System.out.println("Pay: $9.00/hr.\nHours: Any time between 8:00am and 8:00pm.\n");
				System.out.println("1. Apply for this job\n2. Reconsider");
				int apply = f.nextInt();
				if(apply == 1)
				{
					System.out.println("Doesn't pay much, but choosing your own hours will be nice.");
					g.setJob(1);
					break;
				}
			}
			else if(choice == 2)
			{
				System.out.println("\"We eat, sleep, and breathe coffee. Come join our ranks \nand prove that you're the biggest coffee snob alive!\"");
				System.out.println("Pay: $12.00/hr.\nHours: Shifts run from 4:00pm to 9:00pm, no exceptions.\n");
				System.out.println("1. Apply for this job\n2. Reconsider");
				int apply = f.nextInt();
				if(apply == 1)
				{
					System.out.println("Pays pretty well, but the hours are strict. Should be fine if you mange time well.");
					g.setJob(2);
					break;
				}
			}
			else if(choice == 3)
			{
				System.out.println("\"At Gregg's Grocery, we believe in helping our shoppers and smiling way too much. We'd love to have you!\"");
				System.out.println("Pay: $10.50.\nHours: Shift starts at 4:00pm. As long as you come in before 7:00pm, we don't care.\n");
				System.out.println("1. Apply for this job\n2. Reconsider");
				int apply = f.nextInt();
				if(apply == 1)
				{
					System.out.println("Decent pay and they allow you to be late. Great for a busy student with poor time management!");
					g.setJob(3);
					break;
				}
			}
			else if(choice==4)
			{
				System.out.println("I guess you can take time to work on school or whatever. Hope you don't need to buy anything soon...");
				break;
			}
		}
		Utility.getEnter();
	}
		
	
}
	