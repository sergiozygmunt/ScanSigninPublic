/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.desko.fullpage;

public class TPSAScanSettingsEx {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public TPSAScanSettingsEx(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(TPSAScanSettingsEx obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        PageScanApiJNI.delete_TPSAScanSettingsEx(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setScanIRLight(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_ScanIRLight_set(swigCPtr, this, value);
  }

  public long getScanIRLight() {
    return PageScanApiJNI.TPSAScanSettingsEx_ScanIRLight_get(swigCPtr, this);
  }

  public void setScanUvOnlyLight(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_ScanUvOnlyLight_set(swigCPtr, this, value);
  }

  public long getScanUvOnlyLight() {
    return PageScanApiJNI.TPSAScanSettingsEx_ScanUvOnlyLight_get(swigCPtr, this);
  }

  public void setScanUV3Light(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_ScanUV3Light_set(swigCPtr, this, value);
  }

  public long getScanUV3Light() {
    return PageScanApiJNI.TPSAScanSettingsEx_ScanUV3Light_get(swigCPtr, this);
  }

  public void setScanVisibleLight(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_ScanVisibleLight_set(swigCPtr, this, value);
  }

  public long getScanVisibleLight() {
    return PageScanApiJNI.TPSAScanSettingsEx_ScanVisibleLight_get(swigCPtr, this);
  }

  public void setResolution(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_Resolution_set(swigCPtr, this, value);
  }

  public long getResolution() {
    return PageScanApiJNI.TPSAScanSettingsEx_Resolution_get(swigCPtr, this);
  }

  public void setScanFlags(long value) {
    PageScanApiJNI.TPSAScanSettingsEx_ScanFlags_set(swigCPtr, this, value);
  }

  public long getScanFlags() {
    return PageScanApiJNI.TPSAScanSettingsEx_ScanFlags_get(swigCPtr, this);
  }

  public TPSAScanSettingsEx() {
    this(PageScanApiJNI.new_TPSAScanSettingsEx(), true);
  }

}