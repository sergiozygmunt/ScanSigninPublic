package sample.custom.wrapper;
import de.desko.fullpage.PageScanApi;


public enum RecognitionResult {
	NO_ERR, NO_DOC, BAD_MRZ, ROTATION, GOOD, TOO_MANY_REJECTIONS, BAD_LAYOUT, UNKNOWN;

	static RecognitionResult fromResult(int result)
	{
		if (result == PageScanApi.getRrNoErr()) return NO_ERR;
		else if (result == PageScanApi.getRrNoDoc()) return NO_DOC;
		else if (result == PageScanApi.getRrDocWithoutMrz()) return BAD_MRZ;
		else if (result == PageScanApi.getRrDocRotation()) return ROTATION;
		else if (result == PageScanApi.getRrGoodRecognition()) return GOOD;
		else if (result == PageScanApi.getRrToManyRejections()) return TOO_MANY_REJECTIONS;
		else if (result == PageScanApi.getRrDocLayoutNotOK()) return BAD_LAYOUT;
		else if (result == PageScanApi.getRrUnknownError()) return UNKNOWN;
		return UNKNOWN;
	}
}
