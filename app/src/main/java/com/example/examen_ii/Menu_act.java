package com.example.examen_ii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    public ViewFlipper vf;
    public int [] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {

            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2200);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }





    public void Info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }


    public void Cliente(View v)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }


    public void Seguridad(View v)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }

    public void Prestamos(View v)
    {
        // Envío el dato

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");

        //INICIO COMENTARIO Se agregan clientes para GIT
        clientes.add("Betzabe");
        clientes.add("Matias");

        //FIN COMENTARIO Se agregan clientes para GIT


        creditos.add("hipotecario");
        creditos.add("automotriz");

        Intent i = new Intent(this, Prestamos_act.class);
        i.putExtra("listaClientes", clientes); // preparo el dato que quiero envíar.
        i.putExtra("listaCreditos", creditos);
        startActivity(i);


    }





}