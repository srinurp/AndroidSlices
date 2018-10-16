package com.zoftino.slices;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.zoftino.slices.provider.SliceBuilderUtil;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sliceProvider(View view){
        //used to show dynamic slice
        dynamicSliceUpdate();

        //used to show delay content
        delaySliceContent();

        Intent intent = new Intent(getBaseContext(), SlicesListActivity.class);
        startActivity(intent);
    }

    public void dynamicSliceUpdate() {
        new Thread(new Runnable() {
            public void run() {
                //dynamic slice url
                String sliceUri = "content://com.zoftino.slices/couponDynamic";
                Uri uri = Uri.parse(sliceUri);

                int i = 0;
                while(i <= 5) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { }

                    getContentResolver().notifyChange(uri, null);
                    i++;
                }
            }
        }).start();
    }

    public void delaySliceContent(){
        new Thread(new Runnable() {
            public void run() {
                //dynamic slice url
                String sliceUri = "content://com.zoftino.slices/couponDelay";
                Uri uri = Uri.parse(sliceUri);

                try {
                    Thread.sleep(5000);

                    SliceBuilderUtil.delay = false;
                    getContentResolver().notifyChange(uri, null);

                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
