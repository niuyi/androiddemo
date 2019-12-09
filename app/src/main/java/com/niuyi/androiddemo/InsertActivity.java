package com.niuyi.androiddemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.niu.lib.MyAnnotation;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.niuyi.androiddemo.DBHelper.COLUMNS_NAME;
import static com.niuyi.androiddemo.DBHelper.TABLE_NAME;

@MyAnnotation(name="new_name")
public class InsertActivity extends BaseActivity
{

    private static final String TAG = InsertActivity.class.getCanonicalName() + "_LOG";
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        ButterKnife.bind(this);

        DBHelper mDBHelper = new DBHelper(this);
        SQLiteDatabase mDB = mDBHelper.getWritableDatabase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_clean)
    public void cleanDB(){
        int count = mDB.delete(TABLE_NAME, null, null);
        Toast.makeText(this, "delete done : " + count, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_insert)
    public void insert(){

        Log.i(TAG, "start insert3");

        new Thread(){
            @Override
            public void run() {
                super.run();

                long started = SystemClock.uptimeMillis();

                mDB.beginTransaction();

                try{
                    ContentValues values = new ContentValues();

                    for(int i = 0 ; i < 100000 ; i++){
                        values.put(COLUMNS_NAME, "name: " + i);
                        mDB.insert(TABLE_NAME, null, values);
                        values.clear();
                    }

                    mDB.setTransactionSuccessful();
                }finally {
                    mDB.endTransaction();
                }

                try{

                    for(int i = 0 ; i < 100000 ; i++){
                        ContentValues values = new ContentValues();
                        values.put(COLUMNS_NAME, "name: " + i);
                        mDB.insert(TABLE_NAME, null, values);
                    }

                    mDB.setTransactionSuccessful();
                }finally {
                    mDB.endTransaction();
                }

                long timeInMethod = SystemClock.uptimeMillis() - started;

                Log.i(TAG, "insert cost: " + timeInMethod);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InsertActivity.this, "insert done" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        }.start();


    }
}
