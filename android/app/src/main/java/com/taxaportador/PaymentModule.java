package com.taxaportador;


import android.content.Context;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import java.util.HashMap;
import java.util.Map;


public class PaymentModule extends ReactContextBaseJavaModule {

  private Context context;

  public PaymentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }
    @Override
    public String getName() {
        return "Payment";
    }
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        constants.put("GABRIEL", "AAAAA");
        return constants;
    }
    @ReactMethod
    public void startPayment(double value, String transactionId, boolean showReceiptView, Promise promise) {

        try{
          PaymentService payment = new PaymentService(this.getReactApplicationContext());
          payment.doPayment(value, transactionId, showReceiptView, promise);

        }
        catch(Exception e){
          promise.reject("error", e.getMessage());
        }
    }

}
