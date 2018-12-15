package com.gabdullin.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TheCityWeather extends AppCompatActivity {

    private TextView theCity;
    private TextView windForce;
    private TextView wet;
    private TextView pressure;

    public static final String EXTRA_CITY = "city";
    public static final String EXTRA_WIND_FORCE = "wind_force";
    public static final String EXTRA_WET_STATE = "wet";
    public static final String EXTRA_PRESSURE_STATE = "pressure";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thecityweather);

        setView();

        Intent intent = getIntent();
        setState(intent);


    }

    private void setView() {
        theCity = findViewById(R.id.in_the_city);
        windForce = findViewById(R.id.wind_force);
        pressure = findViewById(R.id.pressure);
        wet = findViewById(R.id.wet);
    }

    private void setState(Intent intent) {
        theCity.setText(intent.getStringExtra(EXTRA_CITY));
        windForce.setVisibility(intent.getBooleanExtra(EXTRA_WIND_FORCE, false) ? View.VISIBLE : View.GONE);
        wet.setVisibility(intent.getBooleanExtra(EXTRA_WET_STATE, false) ? View.VISIBLE : View.GONE);
        pressure.setVisibility(intent.getBooleanExtra(EXTRA_PRESSURE_STATE, false) ? View.VISIBLE : View.GONE);
    }

}
