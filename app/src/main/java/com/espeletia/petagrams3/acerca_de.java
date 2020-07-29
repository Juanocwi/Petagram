package com.espeletia.petagrams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class acerca_de extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        androidx.appcompat.widget.Toolbar  acvd= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acvd);
        setSupportActionBar(acvd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                Intent intent = new Intent(acerca_de.this,acerca_de.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(acerca_de.this,contacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}