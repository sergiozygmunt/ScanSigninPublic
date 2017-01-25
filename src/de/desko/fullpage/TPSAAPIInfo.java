/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.desko.fullpage;

public class TPSAAPIInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public TPSAAPIInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(TPSAAPIInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        PageScanApiJNI.delete_TPSAAPIInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCompileDate(String value) {
    PageScanApiJNI.TPSAAPIInfo_CompileDate_set(swigCPtr, this, value);
  }

  public String getCompileDate() {
    return PageScanApiJNI.TPSAAPIInfo_CompileDate_get(swigCPtr, this);
  }

  public void setCompileTime(String value) {
    PageScanApiJNI.TPSAAPIInfo_CompileTime_set(swigCPtr, this, value);
  }

  public String getCompileTime() {
    return PageScanApiJNI.TPSAAPIInfo_CompileTime_get(swigCPtr, this);
  }

  public void setVersion(int value) {
    PageScanApiJNI.TPSAAPIInfo_Version_set(swigCPtr, this, value);
  }

  public int getVersion() {
    return PageScanApiJNI.TPSAAPIInfo_Version_get(swigCPtr, this);
  }

  public void setNumber(int value) {
    PageScanApiJNI.TPSAAPIInfo_Number_set(swigCPtr, this, value);
  }

  public int getNumber() {
    return PageScanApiJNI.TPSAAPIInfo_Number_get(swigCPtr, this);
  }

  public TPSAAPIInfo() {
    this(PageScanApiJNI.new_TPSAAPIInfo(), true);
  }

}