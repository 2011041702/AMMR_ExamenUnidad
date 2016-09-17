package com.example.ammr_examenunidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    //Declaramos objetos como TextView Button y variables como A,B,C

    private TextView vernombre;
    private CheckBox chk1, chk2;
    private Button comprar,sortear;
    private TextView vertotal,vermayor, generico;
    private int A=800;
    private int B=1600;
    private int S;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        // Con esto obtenemos las variables enviadas del activity anterior y las almacenamos
        // en otras variables locales

        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        String dni = b.getString("dni");

        vernombre = (TextView)findViewById(R.id.txtVerNombre);

        vernombre.setText(nombre);

        chk1 = (CheckBox)findViewById(R.id.chkRefrigeradora);
        chk2 = (CheckBox)findViewById(R.id.chkTV);
        comprar = (Button)findViewById(R.id.btncomprar);
        sortear = (Button)findViewById(R.id.btnsortear);
        vertotal = (TextView)findViewById(R.id.txttotal);
        vermayor = (TextView)findViewById(R.id.txtmascaro);
        generico = (TextView)findViewById(R.id.txtgenerico);
        sortear.setEnabled(false);
        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Aqui empezamos con las condiciones, ya que vamos a trabajar con checkbox

                // Aqui vemos si los 2 checkbox no estan en modo check y si no lo estan, mandamos un mensaje Toast
                if(!chk1.isChecked() && !chk2.isChecked()){
                    Toast.makeText(Main2Activity.this, "Eliga algun producto", Toast.LENGTH_SHORT).show();
                    sortear.setEnabled(false);
                }
                // Si tenemos los 2 checkbox escogidos se sumara y se mostrara el valor mayor de estos 2
                else if (chk1.isChecked() && chk2.isChecked()){
                    S=A+B;
                    vertotal.setText(String.valueOf(S));
                    vermayor.setText(String.valueOf(B));

                    // Con la propiedad Random generaremos un número aleatorio del 1-5
                    Random rnd = new Random();
                    for(int i = 1; i<=1; i++)
                    {
                        int a = rnd.nextInt(5);
                        generico.setText(String.valueOf(a));
                    }

                    sortear.setEnabled(true);
                }
                else if(chk1.isChecked()){
                    S=A;
                    vertotal.setText(String.valueOf(S));
                    vermayor.setText(String.valueOf(S));
                    Random rnd = new Random();
                    for(int i = 1; i<=1; i++)
                    {
                        int a = rnd.nextInt(5);
                        generico.setText(String.valueOf(a));
                    }
                    sortear.setEnabled(true);
                }
                else if(chk2.isChecked()){
                    S=B;
                    vertotal.setText(String.valueOf(S));
                    vermayor.setText(String.valueOf(S));
                    Random rnd = new Random();
                    for(int i = 1; i<=1; i++)
                    {
                        int a = rnd.nextInt(5);
                        generico.setText(String.valueOf(a));
                    }
                    sortear.setEnabled(true);
                }
            }
        });

        sortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obtendremos 2 valores el nombre y el cupo que fue generado  y los enviaremos a otro activity
                String nomb = vernombre.getText().toString();
                String cupon = generico.getText().toString();

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("nombre", nomb);
                intent.putExtra("cupon", cupon);
                startActivity(intent);

            }
        });

    }
}
