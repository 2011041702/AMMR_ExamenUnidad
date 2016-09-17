package com.example.ammr_examenunidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    private TextView ganador, recibido, estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        String cupon = b.getString("cupon");

        ganador = (TextView)findViewById(R.id.txtcupoganador);
        recibido = (TextView)findViewById(R.id.txtcuporecibido);
        estado = (TextView)findViewById(R.id.txtestado);

        recibido.setText(cupon);


        Random rnd = new Random();
        for(int i = 1; i<=1; i++)
        {
            int a = rnd.nextInt(5);
            ganador.setText(String.valueOf(a));
        }

        if (ganador.getText().equals(cupon)){
            estado.setText("Ganador");
        }else{
            estado.setText("Vuelva a Intentarlo");
        }

    }
}
