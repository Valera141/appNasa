package com.example.appnasa;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {

    @GET("planetary/apod")
    Call<List<Apod>> obtenerImagenesEspacio(
            @Query("api_key") String apiKey,
            @Query("count") int cantidad
    );
}