package com.espeletia.petagrams3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private ImageButton bottonF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar  acv= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acv);
        setSupportActionBar(acv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        findViewById(R.id.bottonF).setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Favoritas.class);
                startActivity(intent);
            }
        });

        listaMascotas=(RecyclerView) findViewById(R.id.rvPantalla);
///
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();


        findViewById(R.id.floatingActionButton).setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
            }
        });

    }

    public void inicializaAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

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