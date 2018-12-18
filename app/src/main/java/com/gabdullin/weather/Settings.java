package com.gabdullin.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Settings extends Fragment {

    private EditText theCity;
    private CheckBox wind_force;
    private CheckBox wet;
    private CheckBox pressure;
    private CheckBox theme;

//    public static Settings create(){
//        Settings settings = new Settings();
//
//        return settings;
//    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getContext(), TheCityWeather.class);
            setBundle(intent);
            TheCityWeather.create(intent);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.settings, container, false);

        View layout = inflater.inflate(R.layout.settings, container, false);

        theCity = layout.findViewById(R.id.the_city);
        wind_force = layout.findViewById(R.id.wind_force);
        wet = layout.findViewById(R.id.wet);
        pressure = layout.findViewById(R.id.pressure);
        theme = layout.findViewById(R.id.theme);

        Button button = layout.findViewById(R.id.button);
        button.setOnClickListener(listener);

        return layout;

    }

    private void setBundle(Intent intent) {
        String theCityName = theCity.getText().toString();
        boolean windForceState = wind_force.isChecked();
        boolean wetState = wet.isChecked();
        boolean pressureState = pressure.isChecked();

        intent.putExtra(TheCityWeather.EXTRA_CITY, theCityName);
        intent.putExtra(TheCityWeather.EXTRA_WIND_FORCE, windForceState);
        intent.putExtra(TheCityWeather.EXTRA_WET_STATE, wetState);
        intent.putExtra(TheCityWeather.EXTRA_PRESSURE_STATE, pressureState);
        intent.putExtra(TheCityWeather.EXTRA_THEME, theme.isChecked());

    }

}
