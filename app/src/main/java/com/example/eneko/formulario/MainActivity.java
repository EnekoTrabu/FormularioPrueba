package com.example.eneko.formulario;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {
private Button btn;
private Button botoncico;
private Button cambiar;
private ImageButton camara;
    private ImageButton email;
    private ImageButton telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btnPagina);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.googel.com");
                Intent i = new Intent (Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });

        botoncico = (Button)findViewById(R.id.btnMapa);
        botoncico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.8245931,-1.6600049"));
                startActivity(i);
            }
        });

        camara = findViewById(R.id.btnCamara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (i.resolveActivity(getPackageManager()) != null) {

                }
                    startActivity(i);
            }
        });

        email = findViewById(R.id.btnEmail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] TO = {"eneko@gmail.com"};
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Semana de la salud");
                i.putExtra(Intent.EXTRA_TEXT, "Información relativa a la semana de la salud");
                i.putExtra(Intent.EXTRA_EMAIL, TO);

                startActivity(i);

            }
        });

        telefono = findViewById(R.id.btnTelefono);
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:948999999"));
                startActivity(i);

            }
        });

        cambiar = findViewById(R.id.btnCambiar);
        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Activity2.class);
                startActivity(i);
            }
        });
    }
}
