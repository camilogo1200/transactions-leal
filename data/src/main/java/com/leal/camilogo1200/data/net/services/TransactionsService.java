package com.leal.camilogo1200.data.net.services;

import com.leal.camilogo1200.data.net.RetrofitServiceBuilder;
import com.leal.camilogo1200.data.net.api.ITransactionsApi;
import com.leal.camilogo1200.data.net.interfaces.RetrofitBuilder;
import com.leal.camilogo1200.data.net.services.interfaces.ITransactionsService;

public class TransactionsService implements ITransactionsService {

    private static TransactionsService instance = null;
    private static String urlBase = "https://mobiletest.leal.co/transactions";
    private static RetrofitBuilder retrofitBuilder = RetrofitServiceBuilder.newBuilder();

    public static TransactionsService getInstance() {
        synchronized (TransactionsService.class) {
            if (instance == null) {
                instance = new TransactionsService();
            }
            return instance;
        }
    }

    private TransactionsService() {
        retrofitBuilder.setBaseUrl(urlBase)
                .addScalarsConverterFactory(true)
                .enableGsonConverterFactory(true)
                .enableGzipCompression(true)
                .enableLoggingInterceptor(true)
                .enableStethoInterceptor(true);
    }

    public ITransactionsApi getApi() {
        return retrofitBuilder.create(ITransactionsApi.class);
    }
}
