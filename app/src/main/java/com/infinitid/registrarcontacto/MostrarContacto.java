package com.infinitid.registrarcontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarContacto extends AppCompatActivity {


    TextView nombre, fecha, telefono, email, descripcion;
    Button btEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contacto);

        nombre = (TextView) findViewById(R.id.tvNombre);
        fecha = (TextView) findViewById(R.id.tvFecha);
        telefono = (TextView) findViewById(R.id.tvTelefono);
        email = (TextView) findViewById(R.id.tvEmail);
        descripcion = (TextView) findViewById(R.id.tvDescripcion);
        btEditar = (Button) findViewById(R.id.btnEditar);

        nombre.setText(getIntent().getStringExtra(getResources().getString(R.string.pnombre)));
        fecha.setText(getIntent().getStringExtra(getResources().getString(R.string.pfecha)));
        telefono.setText(getIntent().getStringExtra(getResources().getString(R.string.ptelefono)));
        email.setText(getIntent().getStringExtra(getResources().getString(R.string.pemail)));
        descripcion.setText(getIntent().getStringExtra(getResources().getString(R.string.pdescripcion)));

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostrarContacto.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), nombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), email.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
}