package com.example.examen_ii;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import Clases.AdminSQLiteOpenHelper;






public class Clientes_act extends AppCompatActivity {

    private EditText idCodigo, idNombre, idSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

    idCodigo = (EditText) findViewById(R.id.edit_codigo);
    idNombre = (EditText) findViewById(R.id.edit_nombre);
    idSueldo = (EditText) findViewById(R.id.edit_sueldo);

}

    public void agregarClientes(View v){
        AdminSQLiteOpenHelper asoh = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase bd = asoh.getWritableDatabase();


        if(idCodigo.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Debe llenar los campos. ", Toast.LENGTH_SHORT).show();
        }
        else {
            ContentValues registro = new ContentValues();

            registro.put("codigo",idCodigo.getText().toString());
            registro.put("nombre",idNombre.getText().toString());
            registro.put("sueldo",idSueldo.getText().toString());


            bd.insert("clientes",null,registro);
            bd.close();

            Toast.makeText(this,"Has guardado un cliente!",Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarClientes(View v) {

        AdminSQLiteOpenHelper asoh = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = asoh.getWritableDatabase();


        if (idCodigo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe llenar codigo! ", Toast.LENGTH_SHORT).show();
        }
        else{
            bd.delete("clientes","codigo="+idCodigo.getText().toString(),null);
            bd.close();

            Toast.makeText(this,"Cliente eliminado!",Toast.LENGTH_LONG).show();

        }
    }

    public void actualizarClientes(View v)
    {

        AdminSQLiteOpenHelper asoh = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = asoh.getWritableDatabase();


        if (idCodigo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe llenar codigo! ", Toast.LENGTH_SHORT).show();
        }
        else{

            ContentValues registro = new ContentValues();

            registro.put("codigo",idCodigo.getText().toString());
            registro.put("nombre",idNombre.getText().toString());
            registro.put("sueldo",idSueldo.getText().toString());

            bd.update("clientes", registro,"codigo="+idCodigo.getText().toString(),null);

            Toast.makeText(this,"Cliente actualizado!",Toast.LENGTH_LONG).show();

        }
    }

    public void mostrarClientes(View v)
    {
        AdminSQLiteOpenHelper asoh = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase bd = asoh.getWritableDatabase();


        if(idCodigo.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Debe llenar codigo! ", Toast.LENGTH_SHORT).show();
        }
        else {

            Cursor fila = bd.rawQuery("SELECT nombre, sueldo FROM clientes WHERE codigo=" + idCodigo.getText().toString(), null);

            if (fila.moveToFirst())
            {
                idNombre.setText(fila.getString(0));
                idSueldo.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this,"No hay campos en la tabla!",Toast.LENGTH_LONG).show();
            }
        }
    }
}

