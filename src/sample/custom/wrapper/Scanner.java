package sample.custom.wrapper;

import de.desko.fullpage.PageScanApi;
import de.desko.fullpage.TPSABuzzerSettings;
import de.desko.fullpage.TPSADeviceInfo;
import de.desko.fullpage.TPSAScanSettings;
import de.desko.fullpage.TPSAStatusLEDSettings;

/**
 * Sample wrapper for package de.desko.fullpage.
 * 
 * @author DESKO
 *
 */
public class Scanner {
	
	/** Helper transforming a bad results into an exception */
	private static void throwResult(int res) throws ScannerException {
		if (res != PageScanApi.getPsaSuccess())	{
			throw new ScannerException("failed with "+res);
		}
	}
	
	/** Connect to device */ 
	public static void connect() throws ScannerException {
		throwResult(PageScanApi.ConnectToDevice());
	}
	
	/** Disconnect from device. */
	public static void disonnect() {
		PageScanApi.DisconnectFromDevice();
	}
	
	/** Get firmware information as string. */
	public static String getFirmware() throws ScannerException {
		TPSADeviceInfo DeviceInfo = new TPSADeviceInfo();
		throwResult(PageScanApi.GetSystemInfo(DeviceInfo));
		
		return "FW Version " +
				DeviceInfo.getVersion() +
				"." +
				DeviceInfo.getNumber() +
				" " +
				DeviceInfo.getCompileDate()+
				" " +
				DeviceInfo.getCompileTime()
				;
	}
	
	/** Get firmware information as string. */
	public static TPSADeviceInfo getDeviceInfo() throws ScannerException {
		TPSADeviceInfo DeviceInfo = new TPSADeviceInfo();
		throwResult(PageScanApi.GetSystemInfo(DeviceInfo));
		
		return DeviceInfo;
	}
	/** Perform a short buzzer beep indicating success. */
	public static void buzzerGood() throws ScannerException
	{
		TPSABuzzerSettings settings = new TPSABuzzerSettings();
		settings.setDuration(1000);
		settings.setEnabled(true);
		settings.setHighTime(100);
		settings.setLowTime(900);
		
		throwResult(PageScanApi.SetBuzzerSettings(settings));
		throwResult(PageScanApi.UseBuzzer());
	}

	/** Perform a sequence of short buzzer beeps indicating failure. */
	public static void buzzerBad() throws ScannerException {
		TPSABuzzerSettings settings = new TPSABuzzerSettings();
		settings.setDuration(1000);
		settings.setEnabled(true);
		settings.setHighTime(100);
		settings.setLowTime(100);
		
		throwResult(PageScanApi.SetBuzzerSettings(settings));
		throwResult(PageScanApi.UseBuzzer());
	}
	
	
	/** Prepare scanning */
	public static void setScanSettings(TPSAScanSettings settings) throws ScannerException {
		  throwResult(PageScanApi.SetScanSettings(settings));	
	}
	
	public static void setLedAttentionOn() throws ScannerException
	{
		TPSAStatusLEDSettings led = new TPSAStatusLEDSettings();
		led.setEnabled(true);
		led.setDuration(1000);
		led.setHighTime(500);
		led.setLowTime(500);
		led.setUsage(PageScanApi.getSluFlashing());
		led.setColor(PageScanApi.getSlcYellow());
		
		throwResult(PageScanApi.SetStatusLEDSettings(false, led));
		
		long[] flags = new long[1];
		PageScanApi.GetSystemInfoFlags(flags);
		if (0 != (flags[0] & PageScanApi.getSupportExternalStatusLed()))
		{
			throwResult(PageScanApi.SetExtStatusLED(PageScanApi.getSlcYellow()));
		}
	}

	public static void setLedGood() throws ScannerException
	{
		TPSAStatusLEDSettings led = new TPSAStatusLEDSettings();
		led.setEnabled(true);
		led.setDuration(1000);
		led.setHighTime(1000);
		led.setLowTime(0);
		led.setUsage(PageScanApi.getSluPermanent());
		led.setColor(PageScanApi.getSlcGreen());
		
		throwResult(PageScanApi.SetStatusLEDSettings(false, led));
		
		long[] flags = new long[1];
		PageScanApi.GetSystemInfoFlags(flags);
		if (0 != (flags[0] & PageScanApi.getSupportExternalStatusLed()))
		{
			throwResult(PageScanApi.SetExtStatusLED(PageScanApi.getSlcGreen()));
		}
	}

	public static void setLedBad() throws ScannerException
	{
		TPSAStatusLEDSettings led = new TPSAStatusLEDSettings();
		led.setEnabled(true);
		led.setDuration(1000);
		led.setHighTime(1000);
		led.setLowTime(0);
		led.setUsage(PageScanApi.getSluPermanent());
		led.setColor(PageScanApi.getSlcRed());
		
		
		throwResult(PageScanApi.SetStatusLEDSettings(false, led));
		
		long[] flags = new long[1];
		PageScanApi.GetSystemInfoFlags(flags);
		if (0 != (flags[0] & PageScanApi.getSupportExternalStatusLed()))
		{
			throwResult(PageScanApi.SetExtStatusLED(PageScanApi.getSlcRed()));
		}
	}

	public static void setLedAttentionOff() throws ScannerException
	{
		TPSAStatusLEDSettings led = new TPSAStatusLEDSettings();
		led.setEnabled(true);
		led.setDuration(1000);
		led.setHighTime(500);
		led.setLowTime(500);
		led.setUsage(PageScanApi.getSluPermanent());
		led.setColor(PageScanApi.getSlcYellow());
		
		throwResult(PageScanApi.SetStatusLEDSettings(false, led));
		
		long[] flags = new long[1];
		PageScanApi.GetSystemInfoFlags(flags);
		if (0 != (flags[0] & PageScanApi.getSupportExternalStatusLed()))
		{
			throwResult(PageScanApi.SetExtStatusLED(PageScanApi.getSlcBlack()));
		}
	}
	
	/** Prepare scanning */
	public static void setScanSettings(boolean scanIr, boolean scanVisible, boolean scanUv, boolean scanUv3, Resolution resolution) throws ScannerException
	{
		  TPSAScanSettings settings = new TPSAScanSettings();
		  settings.setResolution(resolution.ordinal());
		  settings.setScanIRLight(scanIr);
		  settings.setScanVisibleLight(scanVisible);
		  settings.setScanUvOnlyLight(scanUv);
		  settings.setScanUV3Light(scanUv3);
		  
		  setScanSettings(settings);
	}

	/** Get current scan settings. */
	public static TPSAScanSettings getScanSettings() throws ScannerException {
		TPSAScanSettings settings = new TPSAScanSettings();
		throwResult(PageScanApi.GetScanSettings(settings));
		return settings;
		
	}
	
	/** Scan. */
	public static void scan() throws ScannerException {
		throwResult(PageScanApi.Scan());
	}
	
	/** Helper to convert ocr byte array to nice String */
	private static String ocrPostProcess(byte[] result)
	{
		StringBuilder out = new StringBuilder();
		
		// convert line separator '\r' to '\n'
		for (int i = 0; i < result.length; i++) {
			if (result[i] == '\0') break;
			
			if (result[i] == '\r') {
			  out.append('\n'); 
			  if (result[i] == '\n') i++;
			}
			else
				out.append((char)result[i]);
		}
		return out.toString();
	}

	/**
	 * Get OCR with recognition on PC.
	 * @param newScan Set to true if IR was not scanned before.
	 * @return Recognized String
	 * @throws ScannerException
	 * @throws RecognitionException
	 */
	public static String getOcrOnPc(boolean newScan) throws ScannerException
	{
		if (newScan) {
			TPSAScanSettings settings = getScanSettings();
			settings.setScanIRLight(true);
			setScanSettings(settings);
			scan();
			buzzerGood();
		}
		
		int[] OcrResult = new int[1];
		long[] MrzBufferSize = new long[1];
		throwResult(PageScanApi.ReadOcrPc(OcrResult, MrzBufferSize));

		if (RecognitionResult.fromResult(OcrResult[0]) != RecognitionResult.GOOD) {
			return null;
		}
		
		byte[] result = new byte[(int) MrzBufferSize[0]];
		PageScanApi.GetOcrOutput(result, MrzBufferSize[0]);
		
		return ocrPostProcess(result);
	}
	
	/** Get OCR from device. Does not need an explicit previous scan.*/
	public static String getOcrFromDevice() throws ScannerException
	{
		int[] OcrResult = new int[1];
		long[] MrzBufferSize = new long[1];
		throwResult(PageScanApi.ReadOcrDevice(OcrResult, MrzBufferSize));
		byte[] result = new byte[(int) MrzBufferSize[0]];
		PageScanApi.GetOcrOutput(result, MrzBufferSize[0]);
		System.out.println("OcrResult="+OcrResult[0]+" MrzBufferSize="+MrzBufferSize[0]);

		if (RecognitionResult.fromResult(OcrResult[0]) != RecognitionResult.GOOD) {
			return null;
		}
		
		return ocrPostProcess(result);
	}

	/** Get barcode from device */
	public static byte[] getBarcodeFromDevice() throws ScannerException
	{
		boolean BarcodeFound[] = new boolean[1];
		int[] BarcodeLength = new int[1];
		long[] BarcodeBufferSize = new long[1];
		throwResult(PageScanApi.ReadBarcode(BarcodeFound, BarcodeLength, BarcodeBufferSize));

		if (! BarcodeFound[0]) {
			return null;
		}
		
		byte[] result = new byte[(int) BarcodeBufferSize[0]];
		PageScanApi.GetBarcodeOutput(result, BarcodeBufferSize[0]);
		
		for (int i = 0; i < result.length; i++) {
		  if (result[i] == '\r') {
			  result[i] = '\n';
			  if (result[i] == '\n') i++;
		  }
		}
		
		return result;
	}
	
	/** Get magnetic stripe data from device. */
	public static byte[] getMsrFromDevice() throws ScannerException {
		boolean BarcodeFound[] = new boolean[1];
		int[] BarcodeLength = new int[1];
		long[] BarcodeBufferSize = new long[1];
		
		throwResult(PageScanApi.ReadMsr(BarcodeFound, BarcodeLength, BarcodeBufferSize));

		if (! BarcodeFound[0]) {
			return null;
		}
		
		byte[] result = new byte[(int) BarcodeBufferSize[0]];
		PageScanApi.GetMsrOutput(result, BarcodeBufferSize[0]);
		
		for (int i = 0; i < result.length; i++) {
		  if (result[i] == '\r') {
			  result[i] = '\n';
			  if (result[i] == '\n') i++;
		  }
		}
		
		return result;
	}

	/** Get JPEG image as byte array. */
	public static byte[] getJpegImage(Light light, boolean optimize, int JpegQuality) throws ScannerException {
		
		int ImageOptimize = (optimize ? PageScanApi.getIoBest() : PageScanApi.getIoNone());
		
		long[] ImageBufferSize = new long[1];
		throwResult(PageScanApi.PrepareJpegImage(light.ordinal(), ImageOptimize, (short) JpegQuality, ImageBufferSize));
		
		byte[] buffer = new byte[(int) ImageBufferSize[0]];
		throwResult(PageScanApi.GetJpegImage(buffer, ImageBufferSize[0]));
		
		return buffer;
	}


	/** Get BMP image as byte array. */
	public static byte[] getBmpImage(Light light, boolean optimize) throws ScannerException {
		
		int ImageOptimize = (optimize ? PageScanApi.getIoBest() : PageScanApi.getIoNone());
		
		long[] ImageBufferSize = new long[1];
		throwResult(PageScanApi.PrepareBmpImage(light.ordinal(), ImageOptimize, ImageBufferSize));
		
		byte[] buffer = new byte[(int) ImageBufferSize[0]];
		throwResult(PageScanApi.GetBmpImage(buffer, ImageBufferSize[0]));
		
		return buffer;
	}

	/** Get raw image as byte array. */
	public static byte[] getRawImage(Light LightSource, boolean optimize, Dimensions dim) throws ScannerException {
		
		int ImageOptimize = (optimize ? PageScanApi.getIoBest() : PageScanApi.getIoNone());
		
		long[] ImageBufferSize = new long[1];
		int[] BitsPerPixel = new int[1];
		int[] ImageWidth = new int[1];
		int[] ImageHeight = new int[1];
		throwResult(PageScanApi.PrepareRawImage(LightSource.ordinal(), ImageOptimize, ImageWidth, ImageHeight, BitsPerPixel, ImageBufferSize));
		
		long size = ImageBufferSize[0]; 
		dim.width = ImageWidth[0];
		dim.height = ImageHeight[0];
		
		byte[] buffer = new byte[(int) ImageBufferSize[0]];
		throwResult(PageScanApi.GetRawImage(buffer, size));
		
		return buffer;
		
	}

	/** Set display text */
	public static void setDisplayText(String DisplayText) {
		PageScanApi.SetDisplayText(DisplayText);
	}

}
