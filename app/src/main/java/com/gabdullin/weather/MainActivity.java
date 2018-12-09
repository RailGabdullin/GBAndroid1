package com.gabdullin.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String Tag = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLiveCycleStage("onCreate");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TheCityWeather.class);
                startActivity(intent);
            }
        });


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
