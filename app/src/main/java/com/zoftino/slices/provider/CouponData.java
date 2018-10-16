package com.zoftino.slices.provider;

import com.zoftino.slices.R;

import java.util.ArrayList;
import java.util.List;

public class CouponData {

    public static List<String> getDeals(){
        List<String> cList = new ArrayList<String>();
        cList.add("laptops 20% off");
        cList.add("watches 50% off");
        cList.add("mobiles 30% off");
        cList.add("tv 80% off");

        return cList;
    }

    public static List<Integer> getIcons(){
        List<Integer> icons = new ArrayList<Integer>();
        icons.add(R.drawable.laptop);
        icons.add(R.drawable.watch);
        icons.add(R.drawable.phone);
        icons.add(R.drawable.tv);

        return icons;
    }
}
