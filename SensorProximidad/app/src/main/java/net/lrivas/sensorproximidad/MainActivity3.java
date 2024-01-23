package net.lrivas.sensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    Sensor  sensorL;

    Button btnCompartir;

    SensorManager administradorDeSensores;
    SensorEventListener disparadorEventoSensor;
    TextView  lux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        lux = findViewById(R.id.txtlux);
        btnCompartir = findViewById(R.id.idbtn);
        administradorDeSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorL = administradorDeSensores.getDefaultSensor(Sensor.TYPE_LIGHT);


        disparadorEventoSensor = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {




                if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){

                    lux.setText("" +Math.floor(sensorEvent.values[0])+  " LUX");
                }

            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, lux.getText());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });
        iniciarSensor();
    }

    public void iniciarSensor(){
        administradorDeSensores.registerListener(disparadorEventoSensor,sensorL ,SensorManager.SENSOR_DELAY_NORMAL);


    }
    public void detenerSensor(){
        administradorDeSensores.unregisterListener(disparadorEventoSensor);
    }
    @Override
    protected void onPause() {
        detenerSensor();
        super.onPause();
    }
    @Override
    protected void onResume() {
        iniciarSensor();
        super.onResume();
    }
}