package com.gabdullin.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String Tag = "LifeCycle";
    private EditText theCity;
    private CheckBox wind_forse;
    private CheckBox wet;
    private CheckBox pressure;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), TheCityWeather.class);
            setBundle(intent);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLiveCycleStage("onCreate");
        setViews();
    }

    private void setViews(){
        theCity = findViewById(R.id.the_city);
        wind_forse = findViewById(R.id.wind_force);
        wet = findViewById(R.id.wet);
        pressure = findViewById(R.id.pressure);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(listener);

    }

    private void setBundle(Intent intent){
        String theCityName = theCity.getText().toString();
        boolean windForceState = wind_forse.isChecked();
        boolean wetState = wet.isChecked();
        boolean pressureState = pressure.isChecked();

        intent.putExtra(TheCityWeather.EXTRA_CITY, theCityName);
        intent.putExtra(TheCityWeather.EXTRA_WIND_FORCE, windForceState);
        intent.putExtra(TheCityWeather.EXTRA_WET_STATE, wetState);
        intent.putExtra(TheCityWeather.EXTRA_PRESSURE_STATE, pressureState);

    }

    @Override
    protected void onStart(){
        super.onStart();
        showLiveCycleStage("onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showLiveCycleStage("onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLiveCycleStage("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLiveCycleStage("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLiveCycleStage("onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        showLiveCycleStage("onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLiveCycleStage("onDestroy");
    }

    private void showLiveCycleStage (String text){
        makeToast(text);
        makeLogWrite(text);
    }

    private void makeToast (String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    private void makeLogWrite (String text){
        Log.i(Tag, text);
    }
}
