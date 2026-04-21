package com.example.sensoruygulamas;

import android.hardware.Sensor; import android.hardware.SensorEvent; import android.hardware.SensorEventListener; import android.hardware.SensorManager; import android.os.Bundle; import android.widget.TextView; import androidx.appcompat.app.AppCompatActivity;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView textView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_proximity_sensor);
        textView = findViewById(R.id.proximity_text_view);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }
    @Override protected void onResume() { super.onResume(); if (sensor != null) sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL); }
    @Override protected void onPause() { super.onPause(); sensorManager.unregisterListener(this); }
    @Override public void onSensorChanged(SensorEvent event) { textView.setText("Proximity: " + event.values[0]); }
    @Override public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}