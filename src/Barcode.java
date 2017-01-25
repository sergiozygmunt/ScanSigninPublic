import de.desko.fullpage.OnBcrHandler; //imports manufacturer’s SDK
import sample.custom.wrapper.Scanner;

public class Barcode extends OnBcrHandler
{
	public void OnEvent()
	{
		byte[] rawbarcode = null;
		String barcode = "";
		if(Scan.getInit() == false){Scan.init();}
		try{rawbarcode = Scanner.getBarcodeFromDevice();}
		catch(Exception e){System.out.println("Error reading barcode: "+e);} //prints barcode decoding error to screen
		for(int i = 4; i < rawbarcode.length - 2; i++) {barcode += (char) rawbarcode[i];}
		Boolean result = Scan.log(barcode);
		if(result)
		// If the scanned and decoded 2D barcode is in the database, flash green LEDs and sound single beep
		{
			try{Scanner.buzzerGood();}
			catch(Exception e){System.out.println("Error sounding good sound: "+e);}
			try{Scanner.setLedGood();}
			catch(Exception e){System.out.println("Error lighting led");}
			Scanner.setDisplayText(Scan.getName(barcode) + " Logged");
		}
		else
		// If the scanned and decoded 2D barcode is NOT in the database, flash red LEDs and sound multiple beeps
		{
			try{Scanner.buzzerBad();}
			catch(Exception e){System.out.println("Error sounding bad sound: "+e);}
			try{Scanner.setLedBad();}
			catch(Exception e){System.out.println("Error lighting led");}
			Scanner.setDisplayText("Not logged");
		}
	}
}
