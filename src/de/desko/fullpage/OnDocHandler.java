/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.desko.fullpage;

public class OnDocHandler {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public OnDocHandler(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(OnDocHandler obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        PageScanApiJNI.delete_OnDocHandler(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    PageScanApiJNI.OnDocHandler_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    PageScanApiJNI.OnDocHandler_change_ownership(this, swigCPtr, true);
  }

  public void OnEvent() {
    if (getClass() == OnDocHandler.class) PageScanApiJNI.OnDocHandler_OnEvent(swigCPtr, this); else PageScanApiJNI.OnDocHandler_OnEventSwigExplicitOnDocHandler(swigCPtr, this);
  }

  public OnDocHandler() {
    this(PageScanApiJNI.new_OnDocHandler(), true);
    PageScanApiJNI.OnDocHandler_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}