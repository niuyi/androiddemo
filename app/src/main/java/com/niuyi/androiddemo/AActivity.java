package com.niuyi.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        Log.i("APP_LOG", "onCreate: " + widthPixels);
    }

    public void gotoB(View view){
        Intent in = new Intent();
        in.setClass(this, BActivity.class);
        startActivity(in);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("APP_LOG", "AActivity:onSaveInstanceState");
        outState.putBoolean("TEST", true);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("APP_LOG", "AActivity:onRestoreInstanceState");
    }
}
