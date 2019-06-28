package com.taxaportador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableNativeMap;

public class PaymentBroadcastReceiver  extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
      Log.w("notificationnnn aaa", "aaaaaaaaaaaaaaaaaaaaaa");
    Toast toast = Toast.makeText(context, "entrouu", Toast.LENGTH_SHORT);
    toast.show();

    SendEvent event = new SendEvent(new ReactApplicationContext(context));

    WritableNativeMap map = new WritableNativeMap();
    map.putString("message", "Pagamento aprovado com sucesso");

    SendEvent.sendEvent("onPayment", map);

//      Intent serviceIntent = new Intent(context, MyTaskService.class);
//      context.startService(serviceIntent);
//      HeadlessJsTaskService.acquireWakeLockNow(context);
    }
}
