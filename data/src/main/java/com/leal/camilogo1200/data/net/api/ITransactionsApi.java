package com.leal.camilogo1200.data.net.api;

import com.leal.camilogo1200.data.net.dto.TransactionDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ITransactionsApi {
    @GET("/")
    Observable<List<TransactionDTO>> getAllTransactions();

    @GET("/{id}/info")
    Single<TransactionDTO> getTransactionById(@Path("id") String transactionId);
}
