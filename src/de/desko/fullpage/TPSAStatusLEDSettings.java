/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.desko.fullpage;

public class TPSAStatusLEDSettings {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public TPSAStatusLEDSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(TPSAStatusLEDSettings obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        PageScanApiJNI.delete_TPSAStatusLEDSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEnabled(boolean value) {
    PageScanApiJNI.TPSAStatusLEDSettings_Enabled_set(swigCPtr, this, value);
  }

  public boolean getEnabled() {
    return PageScanApiJNI.TPSAStatusLEDSettings_Enabled_get(swigCPtr, this);
  }

  public void setColor(char value) {
    PageScanApiJNI.TPSAStatusLEDSettings_Color_set(swigCPtr, this, value);
  }

  public char getColor() {
    return PageScanApiJNI.TPSAStatusLEDSettings_Color_get(swigCPtr, this);
  }

  public void setUsage(char value) {
    PageScanApiJNI.TPSAStatusLEDSettings_Usage_set(swigCPtr, this, value);
  }

  public char getUsage() {
    return PageScanApiJNI.TPSAStatusLEDSettings_Usage_get(swigCPtr, this);
  }

  public void setDuration(long value) {
    PageScanApiJNI.TPSAStatusLEDSettings_Duration_set(swigCPtr, this, value);
  }

  public long getDuration() {
    return PageScanApiJNI.TPSAStatusLEDSettings_Duration_get(swigCPtr, this);
  }

  public void setHighTime(long value) {
    PageScanApiJNI.TPSAStatusLEDSettings_HighTime_set(swigCPtr, this, value);
  }

  public long getHighTime() {
    return PageScanApiJNI.TPSAStatusLEDSettings_HighTime_get(swigCPtr, this);
  }

  public void setLowTime(long value) {
    PageScanApiJNI.TPSAStatusLEDSettings_LowTime_set(swigCPtr, this, value);
  }

  public long getLowTime() {
    return PageScanApiJNI.TPSAStatusLEDSettings_LowTime_get(swigCPtr, this);
  }

  public TPSAStatusLEDSettings() {
    this(PageScanApiJNI.new_TPSAStatusLEDSettings(), true);
  }

}
