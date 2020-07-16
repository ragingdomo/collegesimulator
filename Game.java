import java.util.*;
import java.io.*;
public class Game
{
	private int day;
	private int school;
	private int money;
	private int social;
	private int selfCare;
	private int personality;
	private int time;
	private int friends;
	private int job;
	private int dow;
	public Game()
	{
		day = 1;
		school = 0;
		money = 0;
		social = 0;
		selfCare = 0;
		personality = 0;
		time = 24;
		friends = 0;
		job = 0;
		dow = 1;
	}
	
	//Getters-----------------------------------------------------
	public int getDay()
	{
		return day;
	}
	public int getSchool()
	{
		return school;
	}
	public int getMoney()
	{
		return money;
	}
	public int getSocial()
	{
		return social;
	}
	public int getSelfCare()
	{
		return selfCare;
	}
	public int getPersonality()
	{
		return personality;
	}
	public int getTime()
	{
		return time;
	}
	public int getTOD()
	{
		int tod = 0;
		switch(time)
		{
			case 24: tod = 8; break;
			case 23: tod = 9; break;
			case 22: tod = 10; break;
			case 21: tod = 11; break;
			case 20: tod = 12; break;
			case 19: tod = 1; break;
			case 18: tod = 2; break;
			case 17: tod = 3; break;
			case 16: tod = 4; break;
			case 15: tod = 5; break;
			case 14: tod = 6; break;
			case 13: tod = 7; break;
			case 12: tod = 8; break;
			case 11: tod = 9; break;
			case 10: tod = 10; break;
			case 9: tod = 11; break;
			case 8: tod = 12; break;
			case 7: tod = 1; break;
			case 6: tod = 2; break;
			case 5: tod = 3; break;
			case 4: tod = 4; break;
			case 3: tod = 5; break;
			case 2: tod = 6; break;
			case 1: tod = 7; break;
			default: break;
		}
		return tod;
	}
		
	public int getFriends()
	{
		return friends;
	}
	public int getJob()
	{
		return job;
	}
	
	public int getDOW()
	{
		return dow;
	}
	
	//Setters-----------------------------------------------------------------
	
	//day setters
	public void setDay(int day)
	{
		this.day = day;
	}
	public void dayInc()
	{
		day = day+1;
		dow++;
		if(dow>7) dow = 1;
	}
	
	//School
	public void setSchool(int school)
	{
		this.school = school;
	}
	
	//money
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	//social
	public void setSocial(int social)
	{
		this.social = social;
	}
	
	//self care
	public void setSelfCare(int selfCare)
	{
		this.selfCare = selfCare;
	}

	//personality
	public void setPersonality(int personality)
	{
		this.personality = personality;
		personalityBoost();
	}
	
	//time
	public void setTime(int time)
	{
		this.time = time;
	}
	public void resetTime()
	{
		time = 24;
	}
	
	//friend
	public void setFriends(int friends)
	{
		this.friends=friends;
	}
	
	//job
	public void setJob(int job)
	{
		this.job = job;
	}
	
	//Adjusters---------------------------------------------------------------------
	
	//school
	public void adjustSchool(int adj)
	{
		int bonus = adj/2;
		int deficit = adj/2;
		switch(personality)
		{
			case 1:
			{
				if(bonus>1) school = school+adj+bonus;
				else school = school+adj+1;
			}
			case 2:
			{
				if(deficit>1) school = school+adj-deficit;
				else school = school = school+adj-1;
				break;
			}
			case 5: school = school+adj+1; break;
			default: school = school+adj; break;
		}
	}
	
	//social
	public void adjustSocial(int adj)
	{
		int bonus = adj/2;
		int deficit = adj/2;
		switch(personality)
		{
			case 2:
			{
				if(bonus>1) social = social+adj+bonus;
				else social = social+adj+1;
			}
			case 1:
			{
				if(deficit>1) social = social+adj-deficit;
				else social = social = social+adj-1;
				break;
			}
			case 5: social = social+adj+1; break;
			default: social = social+adj; break;
		}
	}
	
	//money
	public void adjustMoney(int adj)
	{
		int bonus = adj/2;
		int deficit = adj/2;
		switch(personality)
		{
			case 3:
			{
				if(bonus>1) money = money+adj+bonus;
				else money = money+adj+1;
			}
			case 4:
			{
				if(deficit>1) money = money+adj-deficit;
				else money = money = money+adj-1;
				break;
			}
			case 5: money = money+adj+1; break;
			default: money = money+adj; break;
		}
	}
	
	//selfCare
	public void adjustSelfCare(int adj)
	{
		int bonus = adj/2;
		int deficit = adj/2;
		switch(personality)
		{
			case 4:
			{
				if(bonus>1) selfCare = selfCare+adj+bonus;
				else selfCare = selfCare+adj+1;
			}
			case 3:
			{
				if(deficit>1) selfCare = selfCare+adj-deficit;
				else selfCare = selfCare = selfCare+adj-1;
				break;
			}
			case 5: selfCare = selfCare+adj+1; break;
			default: selfCare = selfCare+adj; break;
		}
	}
	
	//personality
	private void personalityBoost()
	{
		switch(personality)
		{
			case 1: 
			{
				social = 25;
				friends = 1;
				break;
			}
			case 2: school = 25; break;
			case 3: money = 25; break;
			case 4: selfCare = 25; break;
			default: break;
		}
	}
	
	//time
	public boolean adjustTime(int adj)
	{
		boolean enoughTime = true;
		int newTime = 0;
		newTime = time-adj;
		if(newTime<0)
		{
			System.out.println("Not enough time");
			enoughTime = false;
		}
		else
			time = newTime;
		return enoughTime;
	}
	
	//friends
	public void adjustFriends(int adj)
	{
		friends = friends+adj;
	}
	
	
	// save/load methods------------------------------------------------
	public void saveGame() throws FileNotFoundException,IOException
	{
		ObjectOutputStream writeSave = new ObjectOutputStream(new FileOutputStream("save.data"));
		writeSave.writeInt(day);
		writeSave.writeInt(school);
		writeSave.writeInt(money);
		writeSave.writeInt(social);
		writeSave.writeInt(selfCare);
		writeSave.writeInt(personality);
		writeSave.writeInt(time);
		writeSave.writeInt(friends);
		writeSave.writeInt(job);
		writeSave.writeInt(dow);
		writeSave.close();
	}
	public void loadGame() throws FileNotFoundException,IOException
	{
		ObjectInputStream readSave = new ObjectInputStream(new FileInputStream("save.data"));
		day = readSave.readInt();
		school = readSave.readInt();
		money = readSave.readInt();
		social = readSave.readInt();
		selfCare = readSave.readInt();
		personality = readSave.readInt();
		time = readSave.readInt();
		friends = readSave.readInt();
		job = readSave.readInt();
		dow = readSave.readInt();
		readSave.close();
	}
	
	//toStrings----------------------------------------------------
	private String dayOfWeek()
	{
		String s = "";
		switch(dow)
		{
			case 1: s = "Monday"; break;
			case 2: s = "Tuesday"; break;
			case 3: s = "Wednesday"; break;
			case 4: s = "Thursday"; break;
			case 5: s = "Friday"; break;
			case 6: s = "Saturday"; break;
			case 7: s = "Sunday"; break;
			default: break;
		}
		return s;
	}
	
	public String jobString()
	{
		String s = "";
		switch(job)
		{
			case 1: s = "Empire mowing"; break;
			case 2: s = "Coffee Coffee Coffee"; break;
			case 3: s = "Greg's Grocery"; break;
			default: s = "None"; break;
		}
		return s;
	}
	
	public String personalityString()
	{
		String s = "";
		switch(personality)
		{
			case 1: s = "Social Butterfly"; break;
			case 2: s = "Child Genius"; break;
			case 3: s = "Money Bags"; break;
			case 4: s = "Clean Freak"; break;
			case 5: s = "Somehow Motivated"; break;
		}
		return s;
	}
	
	public String toString()
	{
		String clock = "";
		String s = "";
		if(time<=8||time>=21)
			clock = ":00am";
		else clock = ":00pm";
		s = s+"Day: "+getDay()+" - "+dayOfWeek()+"    Time: "+getTOD()+clock;
		s = s+"\nSchool: "+getSchool()+"  Money: "+getMoney()+"  Social: "+getSocial()+"  Self Care: "+getSelfCare();
		s = s+"\nPersonality: "+personalityString()+"\nJob: "+jobString()+"   Friends: "+getFriends();
		return s;
	}
}