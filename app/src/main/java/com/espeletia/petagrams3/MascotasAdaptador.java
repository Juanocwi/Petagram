package com.espeletia.petagrams3;

import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter <MascotasAdaptador.MascotasViewHolder> {

    private ArrayList<Mascotas> mascotas;//private MascotasViewHolder.ViewHolderClick mlistener;

    public MascotasAdaptador(ArrayList<Mascotas> mascotas){
        this.mascotas=mascotas;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Darle vida al CardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) { //Asociar cada Elemento de la lista con los views
        Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.ivFoto.setImageResource(mascota.getIvFoto());
        mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());
        mascotasViewHolder.ivTLike.setImageResource(mascota.getIvTLikes());
        mascotasViewHolder.tvNombre.setText(mascota.getTvNombre());
        mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());

    }

    @Override
    public int getItemCount() {     //Cantidad de Mascotas
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{//implements View.OnClickListener
        private ImageView ivFoto, ivLike, ivTLike;
        private TextView  tvNombre,tvLikes;
        //public ViewHolderClick mlistener;

        public MascotasViewHolder(@NonNull View itemView) {//,ViewHolderClick listener
            super(itemView);
            ivFoto      = (ImageView) itemView.findViewById(R.id.ivFoto);
            ivLike      = (ImageView) itemView.findViewById(R.id.ivLike);
            ivTLike     = (ImageView) itemView.findViewById(R.id.ivTLike);
            tvNombre    = (TextView)  itemView.findViewById(R.id.tvNombre);
            tvLikes     = (TextView)  itemView.findViewById(R.id.tvLikes);

//            ivFoto.setOnClickListener((View.OnClickListener) this);
//            ivLike.setOnClickListener((View.OnClickListener) this);

        }

//        @Override
//        public void onClick(View v) {
//            if (v instanceof ImageView) {
//                mlistener.onLike((ImageView) v);
//            } else {
//                mlistener.onDislike((ImageView) v);
//            }
//        }
//        public static interface ViewHolderClick {
//            public void onLike(ImageView caller);
//            public void onDislike(ImageView dcaller);
//        }
    }



}
