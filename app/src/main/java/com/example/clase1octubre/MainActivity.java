package com.example.clase1octubre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editNombre, editCarrera;
    Button btnagregar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo=(EditText)findViewById(R.id.InputCodigo);
        editNombre=(EditText) findViewById(R.id.inputnombre);
        editCarrera=(EditText) findViewById((R.id.inputcarrera));
        btnagregar=(Button) findViewById(R.id.btnagregar);
        final baseDatos baseDatos=new baseDatos(getApplicationContext());

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.agregarEstudiante(editCodigo.getText().toString(), editNombre.getText().toString(),
                        editCarrera.getText().toString());
                Toast.makeText(getApplicationContext(), text:"Se agregaron los datos correctamente",
                Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}