package com.zoftino.slices.provider;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.zoftino.slices.CouponActivity;
import com.zoftino.slices.MainActivity;
import com.zoftino.slices.R;

import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;

public class SliceActionUtil {
    public static SliceAction createDefaultActivityAction(Context context) {
        return SliceAction.create(
                PendingIntent.getActivity(
                        context, 0, new Intent(context, MainActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.cashback),
                ListBuilder.ICON_IMAGE,
                "Coupon App Main"
        );
    }
    public static SliceAction createCashbackToggleActivityAction(Context context) {
        Intent i = new Intent(context, CouponActivity.class);
        i.putExtra("cashback", true);
        return SliceAction.createToggle(
                PendingIntent.getActivity(
                        context, 0, i, 0
                ),
                "Coupon app cashback option", false
        );
    }
    public static SliceAction createCouponAction(Context context) {
        Intent i = new Intent(context, CouponActivity.class);
        i.putExtra("coupon", true);
        return SliceAction.create(
                PendingIntent.getActivity(
                        context, 0, i, 0
                ),
                IconCompat.createWithResource(context, R.drawable.offer),
                ListBuilder.ICON_IMAGE,
                "Coupons from top stores"
        );
    }
    public static SliceAction createCatLevelCouponActivityAction(Context context) {
        return SliceAction.create(
                PendingIntent.getActivity(
                        context, 0, new Intent(context, MainActivity.class), 0
                ),
                IconCompat.createWithResource(context, R.drawable.loyalty),
                ListBuilder.ICON_IMAGE,
                "Catlevel Coupons"
        );
    }
}
