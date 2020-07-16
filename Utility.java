import java.io.IOException;

public class Utility 
{
    public static void cls() throws IOException, InterruptedException 
	{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		for(int i=0;i<5;i++)
			System.out.println();
    }
	
	public static void getEnter()throws IOException,InterruptedException
	{
		try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}
}