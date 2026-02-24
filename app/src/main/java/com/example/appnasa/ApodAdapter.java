package com.example.appnasa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ApodAdapter extends RecyclerView.Adapter<ApodAdapter.ApodViewHolder> {

    private List<Apod> listaApod;

    public ApodAdapter(List<Apod> listaApod) {
        this.listaApod = listaApod;
    }

    @NonNull
    @Override
    public ApodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_apod, parent, false);
        return new ApodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApodViewHolder holder, int position) {
        Apod apodActual = listaApod.get(position);

        holder.txtTitulo.setText(apodActual.getTitulo());
        holder.txtFecha.setText(apodActual.getFecha());

        if (apodActual.getUrlImagen() != null && !apodActual.getUrlImagen().isEmpty()) {
            Picasso.get()
                    .load(apodActual.getUrlImagen())
                    .into(holder.imgEspacio);
        }
    }

    @Override
    public int getItemCount() {
        return listaApod.size();
    }

    public static class ApodViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtFecha;
        ImageView imgEspacio;

        public ApodViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            imgEspacio = itemView.findViewById(R.id.imgEspacio);
        }
    }
}