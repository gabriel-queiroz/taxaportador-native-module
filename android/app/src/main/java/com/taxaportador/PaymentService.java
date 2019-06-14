package com.taxaportador;


import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.react.ReactActivity;
import java.util.LinkedList;
import java.util.List;

import br.com.phoebus.android.payments.api.ErrorData;
import br.com.phoebus.android.payments.api.Payment;
import br.com.phoebus.android.payments.api.PaymentClient;
import br.com.phoebus.android.payments.api.PaymentRequest;
import br.com.phoebus.android.payments.api.PaymentType;
import br.com.phoebus.android.payments.api.client.Client;

class PaymentService {

    private PaymentClient paymentClient = new PaymentClient();

    private List<PaymentType> paymentTypes = new LinkedList<PaymentType>();

    private Context context;

    PaymentService(Context context){
      this.context = context;
    }

  private void doBind() {
    this.paymentClient.bind(this.context.getApplicationContext(), new Client.OnConnectionCallback() {

      public void onConnected()
      {

        Log.e("Erorr","desconectado");
      }


      public void onDisconnected(boolean forced) {

        Log.e("Erorr","conectado");
      }
    });
  }

    public void doPayment(double value, String transationId, boolean showReceiptView) {

      Log.e("CARREGADO", "foii");

      doBind();
      this.paymentTypes.add(PaymentType.CREDIT_STORE);

      final PaymentRequest pr;
      try {
        pr = new PaymentRequest()
          .withValue(DataTypeUtils.getFromString(Double.toString(value)))
          .withAppTransactionId(transationId)
          .withPaymentTypes(paymentTypes)
          .withApplicationInfo(CredentialsUtils.getMyAppInfo())
          .withShowReceiptView(showReceiptView);
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

