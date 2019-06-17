package com.taxaportador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.facebook.react.HeadlessJsTaskService;

public class PaymentBroadcastReceiver  extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
      Intent serviceIntent = new Intent(context, MyTaskService.class);
      context.startService(serviceIntent);
      HeadlessJsTaskService.acquireWakeLockNow(context);
    }
}
