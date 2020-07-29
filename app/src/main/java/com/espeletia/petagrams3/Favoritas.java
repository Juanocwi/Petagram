package com.espeletia.petagrams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {
    ArrayList<Mascotas> favoritas;

    private RecyclerView listaFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        androidx.appcompat.widget.Toolbar  acvf= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acvf);
        setSupportActionBar(acvf);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaFavoritas = (RecyclerView) findViewById(R.id.rvFav);

        LinearLayoutManager llmf = new LinearLayoutManager(this);
        llmf.setOrientation(LinearLayoutManager.VERTICAL);

        listaFavoritas.setLayoutManager(llmf);
        inicializarListaFavoritas();
        inicializarAdaptador();

    }
    // menu opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acercade:
                Intent intent = new Intent(Favoritas.this,acerca_de.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(Favoritas.this,contacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void inicializarAdaptador(){
        FavoritasAdaptador adaptador =new FavoritasAdaptador(favoritas);
        listaFavoritas.setAdapter(adaptador);

    }

    public void inicializarListaFavoritas(){
        favoritas = new ArrayList<Mascotas>();

        favoritas.add(new Mascotas(1,"Gigante","1",R.drawable.ic_m3,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Albo","2",R.drawable.ic_m4,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Galleta","8",R.drawable.ic_m5,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Max","4",R.drawable.ic_m6,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Runner","5",R.drawable.ic_m7,R.drawable.ic_bone1,R.drawable.ic_bone1));

    }
}