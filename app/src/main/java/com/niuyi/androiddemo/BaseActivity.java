package com.niuyi.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    private String TAG = BaseActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: " + getClass().getCanonicalName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: " + getClass().getCanonicalName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: " + getClass().getCanonicalName());
    }
}
