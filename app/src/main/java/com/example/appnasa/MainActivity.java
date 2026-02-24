package com.example.appnasa;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewNasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNasa = findViewById(R.id.recyclerViewNasa);
        recyclerViewNasa.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(this, "Iniciando petición a la NASA...", Toast.LENGTH_SHORT).show();
        obtenerDatosDeLaNasa();
    }

    private void obtenerDatosDeLaNasa() {
        NasaApi api = RetrofitClient.getClient().create(NasaApi.class);

        Call<List<Apod>> call = api.obtenerImagenesEspacio("Pt6zHbZbChvU4gNp3WFa3kduvnyCqfZhPQa71KQb", 50);

        call.enqueue(new Callback<List<Apod>>() {
            @Override
            public void onResponse(Call<List<Apod>> call, Response<List<Apod>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Apod> listaImagenes = response.body();

                    ApodAdapter adaptador = new ApodAdapter(listaImagenes);
                    recyclerViewNasa.setAdapter(adaptador);
                } else {
                    Log.e("NASA_ERROR", "Error del servidor: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Apod>> call, Throwable t) {
                Log.e("NASA_FALLO_CRITICO", "Motivo del fallo: " + t.getMessage(), t);
            }
        });
    }
}