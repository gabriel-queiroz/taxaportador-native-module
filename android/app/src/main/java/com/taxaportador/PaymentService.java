package com.taxaportador;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;

import java.util.LinkedList;
import java.util.List;

import br.com.phoebus.android.payments.api.ErrorData;
import br.com.phoebus.android.payments.api.Payment;
import br.com.phoebus.android.payments.api.PaymentClient;
import br.com.phoebus.android.payments.api.PaymentRequest;
import br.com.phoebus.android.payments.api.PaymentType;
import br.com.phoebus.android.payments.api.client.Client;
import br.com.phoebus.android.payments.api.exception.ClientException;


class PaymentService extends AppCompatActivity {

    private PaymentClient paymentClient = new PaymentClient();

    private List<PaymentType> paymentTypes = new LinkedList<PaymentType>();

    private Context context;

    PaymentService(Context context){
      this.context = context;
    }

  private void doBind(Promise promise) {
    this.paymentClient.bind(this.context.getApplicationContext(), new Client.OnConnectionCallback() {

      public void onConnected()
      {

        Log.e("error1","desconectado");
      }

      public void onDisconnected(boolean forced) {

        Log.e("error2","conectado");
        promise.reject("error", "Errro ao conectar");
      }
    });
  }

    public void doPayment(double value, String transationId, boolean showReceiptView, Promise promise) {

      Log.e("CARREGADO", "foii");

      doBind(promise);
      this.paymentTypes.add(PaymentType.CREDIT);

      final PaymentRequest pr;
      try {
        pr = new PaymentRequest()
          .withValue(DataTypeUtils.getFromString(Double.toString(value)))
          .withAppTransactionId(transationId)
          .withPaymentTypes(paymentTypes)
          .withApplicationInfo(CredentialsUtils.getMyAppInfo())
          .withShowReceiptView(true);
      } catch (Exception e) {
        Log.e("error3", e.getMessage());
        promise.reject("error4", e.getMessage());
        return;
      }

        try {
          this.paymentClient.startPayment(pr, new PaymentClient.PaymentCallback<Payment>() {
            @Override
            public void onSuccess(Payment data) {
              Log.e("SUCESS", "Pagamento Realizado!");
              WritableMap map = Arguments.createMap();
              map.putString("message", "Pagamento aprovado com sucesso");
              promise.resolve(map);

            }
            @Override
            public void onError(ErrorData errorData) {
              Log.e("error5",  errorData.getResponseMessage());
              promise.reject("error8", errorData.getResponseMessage());
            }
          });


        } catch (ClientException e) {
            Log.e("error6", e.getMessage());
            promise.reject("error7", e.getMessage());
        }
    }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }
}

