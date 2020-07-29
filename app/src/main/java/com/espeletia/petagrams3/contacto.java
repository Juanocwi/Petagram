package com.espeletia.petagrams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto extends AppCompatActivity {

    //Inicializar variables
    private EditText edC1,edC2,edC3;
    private Button btnC4;
    private String sEmail,sClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        androidx.appcompat.widget.Toolbar  acvd= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acvd);
        setSupportActionBar(acvd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Para enviar un correo
        edC1=findViewById(R.id.edC1);   //Asignacion de variables
        edC2=findViewById(R.id.edC2);
        edC3=findViewById(R.id.edC3);
        btnC4=findViewById(R.id.btnC4);
        //credenciales de envio correo
        sEmail="juanocwi@gmail.com";
        sClave="AntonioJuan13";

        btnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inicializar  propiedades
                Properties propiedades = new Properties();
                propiedades.put("mail.smtp.auth","true");
                propiedades.put("mail.smtp.starttls.enable","true");
                propiedades.put("mail.smtp.host","smtp.gmail.com");
                propiedades.put("mail.smtp.port","587");
                //Inicializar seccion
                Session seccion = Session.getInstance(propiedades, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sClave);
                    }
                });
                try {
                    //Inicializar contenido Mensaje
                    Message mensaje = new MimeMessage(seccion);
                    //Enviar mensaje
                    mensaje.setFrom(new InternetAddress(sEmail));
                    //Recibir mensaje
                    mensaje.setRecipient(Message.RecipientType.TO,new InternetAddress(edC1.getText().toString()));//.parse(edC1.getText().toString()));
                    mensaje.setRecipient(Message.RecipientType.BCC,new InternetAddress(sEmail));

                    //Asunto mensaje
                    mensaje.setSubject(edC2.getText().toString().trim());
                    //Mensaje mensaje
                    mensaje.setText("Enviaste este mensaje a la app Petagram, espera pronto la respuesta. \n"+edC3.getText().toString().trim());
                    //enviar el mensaje
                    new SendMail().execute(mensaje);
                } catch (MessagingException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Algo salio Mal con el mensaje",Toast.LENGTH_SHORT).show();
                }


            }
        });





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
                Intent intent = new Intent(contacto.this,acerca_de.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(contacto.this,contacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class SendMail extends AsyncTask<Message,String,String> {
        //Inicializar dialogo progreso
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Crear y mostrar dialogo de progreso
            progressDialog=ProgressDialog.show(contacto.this,"Espere Por Favor","Enviando el mensaje",true,false);

        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //Cuando sea excitoso
                Transport.send(messages[0]);
                return "Enviado";
            } catch (MessagingException e) {
                //Cuando error
                e.printStackTrace();
                return "Error";
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Crear y mostrar dialogo de progreso
            progressDialog.dismiss();
            if (s.equals("Enviado")){
                AlertDialog.Builder builder =new AlertDialog.Builder(contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color ='#509324'>Enviado</font>"));
                builder.setMessage("Mensaje enviado adecuadamente.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        //Limpiar todos los editText
                        edC1.setText("");
                        edC2.setText("");
                        edC3.setText("");
                    }
                });
                //Mostrar cuadro de alerta
                builder.show();
            } else{
                //cuando error
                Toast.makeText(getApplicationContext(),"Algo salio mal, verifica la direccion de correo",Toast.LENGTH_SHORT).show();
            }
        }

    }
}