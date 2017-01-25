import sample.custom.wrapper.Scanner;
import sample.custom.wrapper.ScannerException;
import de.desko.fullpage.OnDevicePlugHandler;
import de.desko.fullpage.PageScanApi;
import de.desko.fullpage.TPSADeviceInfo;

/**
 * Implementation of a OnDevicePlug callback
 * 
 */
public class OnDevice extends OnDevicePlugHandler {

	/**
	 * Function to be executed when the OnDevicePlug event occurs.
	 * Shows status of device in relation to the computer running the programk on the LCD of the device.
	 */
	public void OnEvent(final boolean isPlugged) {
		if (isPlugged) {
			int trys = 5;

			while (!PageScanApi.IsDeviceConnected() && trys > 0) {
				try {
					Scanner.connect();
					TPSADeviceInfo info = Scanner.getDeviceInfo();
					System.out.println("Connected to device ------------");
					System.out.println(String.format("Version:    %08X.%08X",info.getVersion(),info.getNumber()));
					System.out.println(String.format("Date/Time:  %s %s",info.getCompileDate(),info.getCompileTime()));
				} catch (ScannerException e) {
					trys--;
				}
			}

			if (! PageScanApi.IsDeviceConnected() )
				System.out.println("Connect failed!");
		} else {
			Scanner.disonnect();
			System.out.println("Disconnected.");
		}

	}
}
