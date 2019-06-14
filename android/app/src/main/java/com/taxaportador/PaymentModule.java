package com.taxaportador;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

import java.util.HashMap;
import java.util.Map;

import br.com.phoebus.android.payments.api.PaymentType;


public class PaymentModule extends ReactContextBaseJavaModule {
    public PaymentModule(ReactApplicationContext reactContext) {
        super(reactContext);
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
    public void startPayment(double value, String transactionId, boolean showReceiptView) {
        PaymentService payment = new PaymentService(this.getReactApplicationContext());
        payment.doPayment(value, transactionId, showReceiptView);
    }
}