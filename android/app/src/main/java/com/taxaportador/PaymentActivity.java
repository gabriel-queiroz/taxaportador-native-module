package com.taxaportador;


import android.util.Log;

import java.math.BigDecimal;

import br.com.phoebus.android.payments.api.ApplicationInfo;
import br.com.phoebus.android.payments.api.Credentials;
import br.com.phoebus.android.payments.api.ErrorData;
import br.com.phoebus.android.payments.api.PaymentClient;
import br.com.phoebus.android.payments.api.PaymentRequest;



public class PaymentActivity  implements PaymentClient.PaymentCallback {

    private PaymentClient paymentClient = new PaymentClient();

    public void doExecute() {

      Log.e("entrou na funçãooooo", "bem vindo gabriel");

        try {

        PaymentRequest request = new PaymentRequest();
        request.setValue(new BigDecimal(50));
        request.setAppTransactionId("123456");
        ApplicationInfo appInfo = new ApplicationInfo();
        appInfo.setCredentials(new Credentials());
        appInfo.setSoftwareVersion("1.0.0.0");
        request.setAppInfo(appInfo);


            paymentClient.startPayment(request, this);

        } catch (Exception e) {
            Log.e("deu erro ", e.getMessage());
        }


    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(ErrorData errorData) {

    }
}
