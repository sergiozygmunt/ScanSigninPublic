import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Scan
{
	static FileWriter write;
	static Scanner read;
	
	static FileWriter inoutwrite;
	static Scanner inoutread;
	
	static boolean close = false;
	static boolean init = false;
	
	public static void init()
	{
		init = true;
		try{write = new FileWriter("log.csv", true);}
		catch(Exception e){System.out.println("Error loading log: "+e);init=false;}
	}
	
	public static boolean getInit() {return init;}
	
	public static boolean log(String input)
	{
		String[] inout = getInOut(input);
		if(getName(input) != null)
		{
			try{write.write("\n"+new java.util.Date()+","+getName(input)+","+inout[0]);}
			catch(Exception e){System.out.println("Error writing to file: 1-"+e);}
			// Removed "Left" and "Came" from csv
			//System.out.print("\n"+input+" - "+getName(input)+" - "+inout[0]);
			System.out.println("\n"+input+" - "+getName(input)+" - "+inout[0]);
			/*if(inout[0].equals("Left"))
			{
				if((Integer.parseInt((new SimpleDateFormat("MM")).format(new java.util.Date())) - Integer.parseInt(inout[2])) < 10)
				{
					try{write.write(","+(Integer.parseInt((new SimpleDateFormat("HH")).format(new java.util.Date())) - Integer.parseInt(inout[1]))+":0"+(Integer.parseInt((new SimpleDateFormat("MM")).format(new java.util.Date())) - Integer.parseInt(inout[2])));}
					catch(Exception e){System.out.println("Error writing hours: "+e);}
					System.out.print(" - " + (Integer.parseInt((new SimpleDateFormat("HH")).format(new java.util.Date())) - Integer.parseInt(inout[1]))+":0"+(Integer.parseInt((new SimpleDateFormat("MM")).format(new java.util.Date())) - Integer.parseInt(inout[2])));
				}
				else
				{
					try{write.write(","+(Integer.parseInt((new SimpleDateFormat("HH")).format(new java.util.Date())) - Integer.parseInt(inout[1]))+":"+(Integer.parseInt((new SimpleDateFormat("MM")).format(new java.util.Date())) - Integer.parseInt(inout[2])));}
					catch(Exception e){System.out.println("Error writing hours: "+e);}
					System.out.print(" - " + (Integer.parseInt((new SimpleDateFormat("HH")).format(new java.util.Date())) - Integer.parseInt(inout[1]))+":"+(Integer.parseInt((new SimpleDateFormat("MM")).format(new java.util.Date())) - Integer.parseInt(inout[2])));
				}
			}*/
			try{write.flush();}
			catch(Exception e){System.out.println("Error writing to file: 2-"+e);}
			return true;
		}
		else
		{
			System.out.print(input+"\n - Not Found");
			return false;
		}
	}
	
	public static String getName(String input)
	{
		try{read = new Scanner(new File("users.csv"));}
		catch(Exception e){System.out.println("Error loading users: "+e);}
		while(read.hasNextLine())
		{
			String inraw = read.nextLine();
			String[] in = inraw.split(",");
			if(in[0].equals(input))
			{
				return in[1];
			}
		}
		return null;
	}
	
	public static String[] getInOut(String input)
	{
		try{inoutread = new Scanner(new File("scanner_temp.csv"));}
		catch(Exception e){System.out.println("Error reading the temp file: "+e);}
		String[] found = new String[3];
		found[0] = "Came";
		String temp = "";
		String[] in = new String[3];
		while(inoutread.hasNextLine())
		{
			String inraw = inoutread.nextLine();
			in = inraw.split(",");
			if(in[0].equals(input))
			{
				found[0] = "Left";
			}
			else{temp += inraw;}
		}
		try{inoutwrite = new FileWriter("scanner_temp.csv");}
		catch(Exception e){System.out.println("Error creating the temp file: "+e);}
		// Removed "Left" and "Came" from csv
		/*if(found[0].equals("Came")){temp += "\n"+input+","+(new SimpleDateFormat("HH")).format(new java.util.Date())+","+(new SimpleDateFormat("MM")).format(new java.util.Date());}
		else
		{
			found[1] = in[1];
			found[2] = in[2];
		}*/
		try{inoutwrite.write(temp);}
		catch(Exception e){System.out.println("Error writing the temp file: 1-"+e);}
		try{inoutwrite.flush();}
		catch(Exception e){System.out.println("Error writing the temp file: 2-"+e);}
		return found;
	}
}