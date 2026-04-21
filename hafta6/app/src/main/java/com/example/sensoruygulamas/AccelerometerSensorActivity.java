package com.example.sensoruygulamas;

import android.annotation.SuppressLint;
import android.hardware.Sensor; import android.hardware.SensorEvent; import android.hardware.SensorEventListener; import android.hardware.SensorManager; import android.os.Bundle; import android.widget.TextView; import androidx.appcompat.app.AppCompatActivity;

public class AccelerometerSensorActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_accelerometer_sensor);
        textView = findViewById(R.id.accelerometer_text_view); // XML'deki ID ile ayni olmali
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override protected void onResume() { super.onResume(); if (sensor != null) sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL); }
    @Override protected void onPause() { super.onPause(); sensorManager.unregisterListener(this); }
    @Override public void onSensorChanged(SensorEvent event) { textView.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]); }
    @Override public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}