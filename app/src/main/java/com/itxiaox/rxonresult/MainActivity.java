package com.itxiaox.rxonresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.itxiaox.rxonactivityresult.RxOnResult;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RxOnResult rxOnResult = new RxOnResult(this);
        Intent intent = new Intent(this,TwoActivity.class);
        rxOnResult.startForResult(intent, new RxOnResult.Callback() {
            @Override
            public void onActivityResult(int resultCode, Intent data) {
                Log.i(TAG, "onActivityResult: resultCode = "+resultCode+";"+data.getStringExtra("test"));
            }
        });

    }

    public void go(View view){
        Intent intent = new Intent(this,TwoActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: resultCode = "+requestCode+";"+data.getStringExtra("test"));
    }
}
