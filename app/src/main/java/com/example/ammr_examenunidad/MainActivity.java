package com.example.ammr_examenunidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, dni;
    private Button btnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.txtNombre);
        dni = (EditText)findViewById(R.id.txtDNI);
        btnd = (Button)findViewById(R.id.btnenviar);

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Declaramos variables que obtendran el nombre y dni ingresados
                String nomb = nombre.getText().toString();
                String DNI = dni.getText().toString();


                // Enviaremos los 2 parametros ingresados en 2 variables al otro activity
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("nombre", nomb);
                intent.putExtra("dni", DNI);
                startActivity(intent);
            }
        });



    }
}
