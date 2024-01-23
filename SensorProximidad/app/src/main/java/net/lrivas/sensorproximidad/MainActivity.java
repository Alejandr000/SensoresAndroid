package net.lrivas.sensorproximidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Sensor miSensor, sensorL;

    ConstraintLayout ltest, ptest;
    SensorManager administradorDeSensores;
    SensorEventListener disparadorEventoSensor;
    TextView lblValor, lux;
    Button btnValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ltest = findViewById(R.id.idlight);
        ptest = findViewById(R.id.idproxi);


        ltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(getApplicationContext(), MainActivity3.class);
                ActivityOptions options = ActivityOptions.makeClipRevealAnimation(ltest, 10 , 10, 10, 10);
                startActivity(ints, options.toBundle());
            }


        });

        ptest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(getApplicationContext(), MainActivity2.class);
                ActivityOptions options = ActivityOptions.makeClipRevealAnimation(ptest, 10 , 10, 10, 10);
                startActivity(ints, options.toBundle());
            }


        });





    }



}