package com.infinitid.registrarcontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiedtNombre;
    private DatePicker dpFecha;
    private TextInputEditText tiedtTelefono;
    private TextInputEditText tiedtEmail;
    private TextInputEditText tiedtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBoton = (Button)findViewById(R.id.btnSiguiente);
        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), tiedtNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), String.valueOf(dpFecha.getDayOfMonth()+"/"+(dpFecha.getMonth()+1)+"/"+dpFecha.getYear()));
                intent.putExtra(getResources().getString(R.string.ptelefono), tiedtTelefono.getText().toString())
                intent.putExtra(getResources().getString(R.string.pemail), tiedtEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tiedtDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}