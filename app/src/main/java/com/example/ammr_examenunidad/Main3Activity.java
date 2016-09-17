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

        // Obtenemos los parametros obtenidos del activity 2 y los almacenamos en variables locales

        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        String cupon = b.getString("cupon");

        ganador = (TextView)findViewById(R.id.txtcupoganador);
        recibido = (TextView)findViewById(R.id.txtcuporecibido);
        estado = (TextView)findViewById(R.id.txtestado);

        // Mostraremos en el objeto recibido el valor cupon que fue recibido del activity anterior
        recibido.setText(cupon);

        //Nuevamente usaremos el metodo Random con este generaremos el cupon que sera el ganador
        Random rnd = new Random();
        for(int i = 1; i<=1; i++)
        {
            int a = rnd.nextInt(5);
            ganador.setText(String.valueOf(a));
        }

        // Ahora que el cupon fue generado y tenemos el cupon que se dio en el activity anterior solo
        // compararemos si son iguales, y si fuese el caso el mensaje del objeto estado sera el siguiente
        if (ganador.getText().equals(cupon)){
            estado.setText("Ganador");
        }else{
            estado.setText("Vuelva a Intentarlo");
        }

    }
}
