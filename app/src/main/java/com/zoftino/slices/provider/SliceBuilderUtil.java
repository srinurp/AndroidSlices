package com.zoftino.slices.provider;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;

import com.zoftino.slices.CouponActivity;
import com.zoftino.slices.R;

import java.util.concurrent.ThreadLocalRandom;

import androidx.slice.Slice;
import androidx.slice.builders.GridRowBuilder;
import androidx.slice.builders.ListBuilder;

import static androidx.core.graphics.drawable.IconCompat.createWithResource;

public class SliceBuilderUtil {

    public static boolean delay = true;

    public static Slice getDefaultSlice(Uri sliceUri, Context context){
        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .setAccentColor(Color.GREEN)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitle("Coupons")
                                .setSubtitle("latest coupons best stores")
                                .setPrimaryAction(
                                        SliceActionUtil.
                                                createDefaultActivityAction(context))
                )
                .build();
    }

    public static Slice getCouponSliceWithToggle(Uri sliceUri, Context context){

        return new ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitle("Coupons cashback")
                                .setSubtitle("Enable cashback offers")
                                .setPrimaryAction(SliceActionUtil.createCashbackToggleActivityAction(context))
                )
                .build();
    }

    public static Slice getCouponSliceWithMultipleRows(Uri sliceUri, Context context){

        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitleItem(System.currentTimeMillis())
                                .setTitle("Coupons")
                                .setSubtitle("Best offers from top stores")
                                .setPrimaryAction(SliceActionUtil.createDefaultActivityAction(context))
                                .addEndItem(createWithResource(context, R.drawable.offer),
                                        ListBuilder.ICON_IMAGE)
                )
                .addRow(
                new ListBuilder.RowBuilder()
                        .setTitleItem(createWithResource(context, R.drawable.phone),
                                ListBuilder.ICON_IMAGE)
                        .setTitle("Mobile")
                        .setSubtitle("Huge discounts on mobiles")
                        .setPrimaryAction(SliceActionUtil.createCouponAction(context))
                        .addEndItem(System.currentTimeMillis())
                )
                .build();
    }

    public static Slice getDealsSliceWithHeader(Uri sliceUri, Context context){

        ListBuilder listBuilder = new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .setAccentColor(0xff0F9F58)
                .setHeader(
                        new ListBuilder.HeaderBuilder()
                                .setTitle("Deals")
                                .setSubtitle("Best deals")
                                .setSummary("View latest deals from top stores in all categories.")
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context)));

        int i =0;
        for(String deal : CouponData.getDeals()){
            listBuilder.addRow(
                    new ListBuilder.RowBuilder()
                            .setTitle(deal)
                            .setTitleItem(createWithResource(context, CouponData.getIcons().get(i)),
                                    ListBuilder.ICON_IMAGE)
                            .setPrimaryAction(SliceActionUtil.createCouponAction(context))
            );
            i++;
        }

        return listBuilder.build();

    }

    public static Slice getCouponSliceWithRange(Uri sliceUri, Context context){

        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitleItem(System.currentTimeMillis())
                                .setTitle("Watches")
                                .setSubtitle("Get upto 90% off on branded watches, limited")
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context))
                                .addEndItem(createWithResource(context, R.drawable.watch),
                                        ListBuilder.ICON_IMAGE)
                )
                .addRange(new ListBuilder.RangeBuilder()
                                .setContentDescription("offers taken and total offers")
                                .setTitle("Limited Number")
                                .setSubtitle("Grab it before gone!")
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context))
                                .setMax(40)
                                .setValue(20))

                .build();
    }
    public static Slice getCouponSliceWithInputRange(Uri sliceUri, Context context){
        PendingIntent pi = PendingIntent.getActivity(
                context, 0, new Intent(context, CouponActivity.class), 0);

        return new ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader(
                        new ListBuilder.HeaderBuilder()
                                .setTitle("Discount Range")
                                .setSubtitle("View offers in the discount ragne you selcted")
                                .setSummary("View offers in the discount ragne you selcted")
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context)))
                .addInputRange(new ListBuilder.InputRangeBuilder()
                        .setContentDescription("Select discount")
                        .setTitle("Select Discount")
                        .setSubtitle("View offers for the selected discount")
                        .setInputAction(pi)
                        .setPrimaryAction(SliceActionUtil.createCouponAction(context))
                        .setMax(90)
                        .setMin(10)
                        .setValue(40))

                .build();
    }

    public static Slice getCouponSliceWithGridRow(Uri sliceUri, Context context){

        PendingIntent pi = PendingIntent.getActivity(
                context, 0, new Intent(context, CouponActivity.class), 0);


        GridRowBuilder gridRowBuilder = new GridRowBuilder();
        gridRowBuilder.addCell(new GridRowBuilder.CellBuilder()
                                        .addImage(createWithResource(context,R.drawable.laptop),
                                                ListBuilder.ICON_IMAGE)
                                        .addText("laptop offers")
                                        .setContentIntent(pi))
                        .addCell(new GridRowBuilder.CellBuilder()
                                        .addImage(createWithResource(context,R.drawable.phone),
                                                            ListBuilder.ICON_IMAGE)
                                        .addText("mobile offers")
                                        .setContentIntent(pi))
                         .addCell(new GridRowBuilder.CellBuilder()
                                        .addImage(createWithResource(context,R.drawable.watch),
                                                            ListBuilder.ICON_IMAGE)
                                        .addText("watch offers")
                                        .setContentIntent(pi))
                         .addCell(new GridRowBuilder.CellBuilder()
                                        .addImage(createWithResource(context,R.drawable.tv),
                                                            ListBuilder.ICON_IMAGE)
                                        .addText("tv offers")
                                        .setContentIntent(pi));

        return new ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader(
                        new ListBuilder.HeaderBuilder()
                                .setTitle("Coupons")
                                .setSubtitle("View all coupon categories")
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context)))
                .addGridRow(gridRowBuilder)
                .build();
    }


    public static Slice getCouponsDynamicSlice(Uri sliceUri, Context context){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .setAccentColor(0xff0F9F58)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitle("Fashion offer")
                                .setSubtitle(CouponData.getDeals().get(randomNum))
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context)))
                .build();
    }

    public static Slice getCouponsDelayContentSlice(Uri sliceUri, Context context){
        String subTit;
        if(delay){
            subTit = null;
        }else{
            subTit = "Upto 40% off on everything";
        }
        return new ListBuilder(context, sliceUri, ListBuilder.ICON_IMAGE)
                .setAccentColor(0xff0F9F58)
                .addRow(
                        new ListBuilder.RowBuilder()
                                .setTitle("Latest coupon offers")
                                .setSubtitle(subTit, true)
                                .setPrimaryAction(SliceActionUtil.createCouponAction(context)))
                .build();
    }
}
