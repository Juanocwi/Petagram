package com.espeletia.petagrams3.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.adaptadores.MascotasAdaptador;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class L_M_Fragment extends Fragment {
    private RecyclerView listaMascotas;
    public ArrayList<Mascotas> mascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_l_m,container,false);
        //introducir el linear RecyclerView con las mascotas
        listaMascotas=(RecyclerView) v.findViewById(R.id.rvPantalla);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();
        return v;
    }
    public void inicializaAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    //Base de datos de las mascotas a mostrar en el recyclerview
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(0,"Kaiser","7",R.drawable.ic_m1,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Perla","3",R.drawable.ic_m2,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Gigante","1",R.drawable.ic_m3,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Albo","2",R.drawable.ic_m4,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Galleta","8",R.drawable.ic_m5,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Max","4",R.drawable.ic_m6,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Runner","5",R.drawable.ic_m7,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Sasha","6",R.drawable.ic_m8,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Maximus","8",R.drawable.ic_m9,R.drawable.ic_bone,R.drawable.ic_bone1));

    }
}
