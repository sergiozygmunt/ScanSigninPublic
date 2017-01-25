import de.desko.fullpage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Run 
{
	static {System.loadLibrary("PageScanApiJavaWrapper");}
	public static Barcode barcode = new Barcode();
	public static OnDevice device = new OnDevice();
	public static void main(String[] args)
	{
		try
		{
			PageScanApi.SetupOnBcrHandler(barcode);
			PageScanApi.SetupOnDevicePlugHandler(device);
		}
		catch(Exception e){System.out.println("Error starting scanner: "+e);}
		while(true)
		{
			try{Scan.log(new BufferedReader(new InputStreamReader(System.in)).readLine());}
			catch(IOException e){System.out.println("Error taking input from keyboard: "+e);}
		}
	}
}