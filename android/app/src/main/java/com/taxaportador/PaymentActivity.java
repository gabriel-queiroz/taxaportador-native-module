package com.taxaportador;


import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.react.bridge.ReactContext;

import java.util.LinkedList;
import java.util.List;

import br.com.phoebus.android.payments.api.ErrorData;
import br.com.phoebus.android.payments.api.Payment;
import br.com.phoebus.android.payments.api.PaymentClient;
import br.com.phoebus.android.payments.api.PaymentRequest;
import br.com.phoebus.android.payments.api.PaymentType;
import br.com.phoebus.android.payments.api.client.Client;

public class PaymentActivity  extends AppCompatActivity {

    private PaymentClient paymentClient = new PaymentClient();

    private List<PaymentType> paymentTypes = new LinkedList<PaymentType>();


  private void doBind(ReactContext context) {
    this.paymentClient.bind(context, new Client.OnConnectionCallback() {
      @Override
      public void onConnected()
      {

        Log.e("Erorr","desconectado");
      }

      @Override
      public void onDisconnected(boolean forced) {

        Log.e("Erorr","conectado");
      }
    });
  }

    public void doExecute(ReactContext context) {

      doBind(context);
      this.paymentTypes.add(PaymentType.CREDIT_STORE);

      final PaymentRequest pr;
      try {
        pr = new PaymentRequest()
          .withValue(DataTypeUtils.getFromString("1000"))
          .withAppTransactionId("123456")
          .withPaymentTypes(this.paymentTypes)
          .withApplicationInfo(CredentialsUtils.getMyAppInfo())
          .withShowReceiptView(true);
      } catch (PackageManager.NameNotFoundException e) {
        Log.e("ERROR", e.getMessage());
        return;
      }

        try {

          this.paymentClient.startPayment(pr, new PaymentClient.PaymentCallback<Payment>() {
            @Override
            public void onSuccess(Payment data) {
              Log.e("SUCESS", "Pagamento Realizado!");

            }
            @Override
            public void onError(ErrorData errorData) {
              Log.e("Erorr",  errorData.getResponseMessage());
            }
          });

        } catch (Exception e) {
            Log.e("deu erro ", e.getMessage());
        }


    }

}

