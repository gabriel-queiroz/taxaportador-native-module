package com.taxaportador;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class SendEvent extends ReactContextBaseJavaModule implements ActivityEventListener {
  private static final String TAG = "AppboyMessaging";
  private static ReactApplicationContext reactContext;
  private String thisApp;


  public SendEvent(ReactApplicationContext reactContext){
    super(reactContext);

    this.reactContext = reactContext;
    Log.d(TAG, String.format("React_context %s", reactContext));
    reactContext.addActivityEventListener(this);

    thisApp = reactContext.getPackageName();
  }

  @Override
  public String getName() {
    return TAG;
  }

  public static void sendEvent(String event, WritableNativeMap params) {
    reactContext
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(event, params);
  }

  @Override
  public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {}

  @Override
  public void onNewIntent(Intent intent){}
}
