package com.zoftino.slices.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlicesData {
    private static Map<String, String> sliceUrls;
    public static String couponAppSlicesUri = "content://com.zoftino.slices/";
    private static List list = new ArrayList<String>();

    public static Map<String, String> getSliceData(){

        if(sliceUrls == null){
            sliceUrls = new HashMap<String, String>();

            sliceUrls.put("coupon", "coupon");
            sliceUrls.put("cashback", "cashback");
            sliceUrls.put("multiCoupons", "multiCoupons");
            sliceUrls.put("deals", "deals");
            sliceUrls.put("dealsLimited", "dealsLimited");
            sliceUrls.put("dealsCategories", "dealsCategories");
            sliceUrls.put("dealsrange", "dealsrange");
            sliceUrls.put("couponDynamic", "couponDynamic");
            sliceUrls.put("couponDelay", "couponDelay");


        }
        return sliceUrls;
    }
    public static List getCouponAppSlices(){
        if(list.isEmpty()){
            list.addAll(getSliceData().keySet());
        }
        return list;
    }
    public static String getCouponAppSlicesUri(){
        return couponAppSlicesUri;
    }
}
