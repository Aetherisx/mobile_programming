package com.example.sensoruygulamas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sensor1_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AccelerometerSensorActivity.class)));
        findViewById(R.id.sensor2_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CompassSensorActivity.class)));
        findViewById(R.id.sensor3_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GyroscopeSensorActivity.class)));
        findViewById(R.id.sensor4_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HumiditySensorActivity.class)));
        findViewById(R.id.sensor5_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LightSensorActivity.class)));
        findViewById(R.id.sensor6_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MagnetometerSensorActivity.class)));
        findViewById(R.id.sensor7_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PressureSensorActivity.class)));
        findViewById(R.id.sensor8_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProximitySensorActivity.class)));
        findViewById(R.id.sensor9_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ThermometerSensorActivity.class)));
    }
}