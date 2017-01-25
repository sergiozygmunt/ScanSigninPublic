/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.desko.fullpage;

public class TPSABuzzerSettings {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public TPSABuzzerSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(TPSABuzzerSettings obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        PageScanApiJNI.delete_TPSABuzzerSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEnabled(boolean value) {
    PageScanApiJNI.TPSABuzzerSettings_Enabled_set(swigCPtr, this, value);
  }

  public boolean getEnabled() {
    return PageScanApiJNI.TPSABuzzerSettings_Enabled_get(swigCPtr, this);
  }

  public void setDuration(int value) {
    PageScanApiJNI.TPSABuzzerSettings_Duration_set(swigCPtr, this, value);
  }

  public int getDuration() {
    return PageScanApiJNI.TPSABuzzerSettings_Duration_get(swigCPtr, this);
  }

  public void setHighTime(int value) {
    PageScanApiJNI.TPSABuzzerSettings_HighTime_set(swigCPtr, this, value);
  }

  public int getHighTime() {
    return PageScanApiJNI.TPSABuzzerSettings_HighTime_get(swigCPtr, this);
  }

  public void setLowTime(int value) {
    PageScanApiJNI.TPSABuzzerSettings_LowTime_set(swigCPtr, this, value);
  }

  public int getLowTime() {
    return PageScanApiJNI.TPSABuzzerSettings_LowTime_get(swigCPtr, this);
  }

  public TPSABuzzerSettings() {
    this(PageScanApiJNI.new_TPSABuzzerSettings(), true);
  }

}