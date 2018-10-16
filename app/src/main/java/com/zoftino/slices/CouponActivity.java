package com.zoftino.slices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CouponActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_layout);

        Intent i = getIntent();


        if (i != null) {

            if (i.getBooleanExtra("cashback", false)) {
                Toast.makeText(this, "cashback is enabled", Toast.LENGTH_LONG).show();
            }

            if (i.getBooleanExtra("android.app.slice.extra.TOGGLE_STATE", false))
                Toast.makeText(this, "Toggle slice action toggle state is: "
                                + i.getBooleanExtra("android.app.slice.extra.TOGGLE_STATE", false),
                        Toast.LENGTH_LONG).show();

            if (i.getIntExtra("android.app.slice.extra.RANGE_VALUE", 0) != 0)
                Toast.makeText(this, "selected discount is: "
                                + i.getIntExtra("android.app.slice.extra.RANGE_VALUE", 0),
                        Toast.LENGTH_LONG).show();

        }
    }
}
