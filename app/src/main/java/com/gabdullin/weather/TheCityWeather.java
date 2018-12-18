package com.gabdullin.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TheCityWeather extends Fragment {

    private TextView theCity;
    private View windForce;
    private View wet;
    private View pressure;

    public static final String EXTRA_THEME = "theme";
    public static final String EXTRA_CITY = "city";
    public static final String EXTRA_WIND_FORCE = "wind_force";
    public static final String EXTRA_WET_STATE = "wet";
    public static final String EXTRA_PRESSURE_STATE = "pressure";


    public static TheCityWeather create(Intent intent) {
        TheCityWeather theCityWeather = new TheCityWeather();

        theCityWeather.setState(intent);

        return theCityWeather;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.the_city_weather, container, false);
        setView(layout);
        return layout;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        boolean isDarkTheme = intent.getBooleanExtra(EXTRA_THEME, false);
//        if (isDarkTheme) {
//            setTheme(R.style.DarkTheme);
//        }
//        setContentView(R.layout.the_city_weather);
//
//        setView();
//        setState(intent);
//
//
//    }

    private void setView(View layout) {
        theCity = layout.findViewById(R.id.in_the_city);
        windForce = layout.findViewById(R.id.wind_force);
        pressure = layout.findViewById(R.id.pressure);
        wet = layout.findViewById(R.id.wet);
    }

    private void setState(Intent intent) {
        theCity.setText(intent.getStringExtra(EXTRA_CITY));
        windForce.setVisibility(intent.getBooleanExtra(EXTRA_WIND_FORCE, false) ? View.VISIBLE : View.GONE);
        wet.setVisibility(intent.getBooleanExtra(EXTRA_WET_STATE, false) ? View.VISIBLE : View.GONE);
        pressure.setVisibility(intent.getBooleanExtra(EXTRA_PRESSURE_STATE, false) ? View.VISIBLE : View.GONE);
    }

}
