package com.leal.camilogo1200.data.net.api;

import com.leal.camilogo1200.data.net.dto.TransactionDTO;
import com.leal.camilogo1200.data.net.dto.UserDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUsersAPI {
    @GET("/")
    Observable<List<UserDTO>> getAllUsers();

    @GET("/{id}")
    Single<UserDTO> getuserById(@Path("id") String id);

    @GET("/{id}/transactions")
    Observable<List<TransactionDTO>> getTransactionsByUser(@Path("id") String userId);
}
