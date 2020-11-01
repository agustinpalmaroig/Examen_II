package com.example.examen_ii;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Clases.creditos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 = (Spinner)findViewById(R.id.spnCliente);
        spin2 = (Spinner)findViewById(R.id.spnPrestamo);
        text = (TextView)findViewById(R.id.textView5);



        // Recibir el dato.
        // <----
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void CalcularPrestamo (View v)
    {
        String cliente = spin1.getSelectedItem().toString();  // almaceno selección del spinner.
        String creditos = spin2.getSelectedItem().toString();

        creditos credito = new creditos();  // Construir mi objeto.


        int resultHipotecario =  credito.getHipotecario();
        int resultAutomotriz =  credito.getAutomotriz();

        // Inteligencia Axel.

        if(cliente.equals("Axel") && creditos.equals("hipotecario"))
        {
            int resultado = (750000 + resultHipotecario);


            text.setText("El precio del plan es: " + resultado);
        }

        if(cliente.equals("Axel") && creditos.equals("automotriz"))
        {
            int resultado = (750000 + resultAutomotriz);
            text.setText("La deuda total es: " + resultado);
        }


        // Inteligencia Roxana.

        if(cliente.equals("Roxana") && creditos.equals("hipotecario"))
        {
            int resultado = (900000 + resultHipotecario);


            text.setText("La deuda total es: " + resultado);
        }

        if(cliente.equals("Roxana") && creditos.equals("automotriz"))
        {
            int resultado = (900000 + resultAutomotriz);
            text.setText("La deuda total es: " + resultado);
        }



    }


    public void CalcularDeudas(View v)
    {
        String cliente = spin1.getSelectedItem().toString();  // almaceno selección del spinner.
        String creditos = spin2.getSelectedItem().toString();

        creditos credito = new creditos();  // Construir mi objeto.


        int resultHipotecario =  credito.getHipotecario();
        int resultAutomotriz =  credito.getAutomotriz();

        // Inteligencia Axel.

        if(cliente.equals("Axel") && creditos.equals("hipotecario"))
        {
            int resultado = (750000 + resultHipotecario)/12;


            text.setText("El precio del plan es: " + resultado);
        }

        if(cliente.equals("Axel") && creditos.equals("automotriz"))
        {
            int resultado = (750000 + resultAutomotriz)/8;
            text.setText("La deuda total es: " + resultado);
        }

        // Inteligencia para Roxana.

        if(cliente.equals("Roxana") && creditos.equals("hipotecario"))
        {
            int resultado = (900000 + resultHipotecario)/12;


            text.setText("La deuda total es: " + resultado);
        }

        if(cliente.equals("Roxana") && creditos.equals("automotriz"))
        {
            int resultado = (900000 + resultAutomotriz)/8;
            text.setText("La deuda total es: " + resultado);
        }

    }


}