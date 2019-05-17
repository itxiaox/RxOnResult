package com.itxiaox.rxonresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


    }

    public void back(View view) {

        Intent intent = new Intent();
        intent.putExtra("test","test");
        setResult(1,intent);
        finish();
    }
}
