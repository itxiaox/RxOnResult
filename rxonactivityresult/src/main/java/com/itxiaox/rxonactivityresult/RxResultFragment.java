package com.itxiaox.rxonactivityresult;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;



/**
 * Created by jack on 2017/12/27.
 */

public class RxResultFragment extends Fragment {
    private Map<Integer, RxOnResult.Callback> mCallbacks = new HashMap<>();

    public RxResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public void startForResult(Intent intent, RxOnResult.Callback callback) {
        int requestCode = generateRequestCode();
        mCallbacks.put(requestCode, callback);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //callback方式的处理
        RxOnResult.Callback callback = mCallbacks.remove(requestCode);
        if (callback != null) {
            callback.onActivityResult(resultCode, data);
        }
    }

    private int generateRequestCode(){
        Random random = new Random();
        for (;;){
            int code = random.nextInt(65536);
            if (!mCallbacks.containsKey(code)){
                return code;
            }
        }
    }

}