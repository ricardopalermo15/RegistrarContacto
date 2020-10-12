package com.infinitid.registrarcontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputEditText nombre, telefono, email, descripcion;
    Button siguiente;
    DatePicker fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.edtNombre);
        fecha = findViewById(R.id.dpFecha);
        telefono = findViewById(R.id.edtTelefono);
        email = findViewById(R.id.edtEmail);
        descripcion = findViewById(R.id.edtDescripcion);
        siguiente =findViewById(R.id.btnSiguiente);

        //Recibo paramatros cuando vuelvo del Activity Mostrar contacto
        nombre.setText(getIntent().getStringExtra(getResources().getString(R.string.pnombre)));
        telefono.setText(getIntent().getStringExtra(getResources().getString(R.string.ptelefono)));
        email.setText(getIntent().getStringExtra(getResources().getString(R.string.pemail)));
        descripcion.setText(getIntent().getStringExtra(getResources().getString(R.string.pdescripcion)));

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nombre.getText().toString().isEmpty()&&!telefono.getText().toString().isEmpty()&&!email.getText().toString().isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MostrarContacto.class);
                    intent.putExtra(getResources().getString(R.string.pnombre), nombre.getText().toString());
                    intent.putExtra(getResources().getString(R.string.pfecha), String.valueOf(fecha.getDayOfMonth()) + '/' + (fecha.getMonth()+1) + '/' + (fecha.getYear()));
                    intent.putExtra(getResources().getString(R.string.ptelefono), telefono.getText().toString());
                    intent.putExtra(getResources().getString(R.string.pemail), email.getText().toString());
                    intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Debe ingresar los datos solicitadoa",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}