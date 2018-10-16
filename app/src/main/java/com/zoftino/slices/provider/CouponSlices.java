package com.zoftino.slices.provider;

import android.content.Context;
import android.net.Uri;

import androidx.slice.Slice;
import androidx.slice.SliceProvider;

public class CouponSlices extends SliceProvider {
    /**
     * Instantiate any required objects. Return true if the provider was successfully created,
     * false otherwise.
     */
    @Override
    public boolean onCreateSliceProvider() {
        return true;
    }


    /**
     * Construct the Slice and bind data if available.
     */
    public Slice onBindSlice(Uri sliceUri) {
        Context context = getContext();
        if (context == null ) {
            return null;
        }
        if ("/coupon".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getDefaultSlice(sliceUri, getContext());
        }else if ("/cashback".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponSliceWithToggle(sliceUri, getContext());
        }else if ("/multiCoupons".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponSliceWithMultipleRows(sliceUri, getContext());
        }else if ("/deals".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getDealsSliceWithHeader(sliceUri, getContext());
        }else if ("/dealsLimited".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponSliceWithRange(sliceUri, getContext());
        }else if ("/dealsrange".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponSliceWithInputRange(sliceUri, getContext());
        }else if ("/dealsCategories".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponSliceWithGridRow(sliceUri, getContext());
        }else if ("/couponDynamic".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponsDynamicSlice(sliceUri, getContext());
        }else if ("/couponDelay".equals(sliceUri.getPath())) {
            return SliceBuilderUtil.getCouponsDelayContentSlice(sliceUri, getContext());
        }else {
            return SliceBuilderUtil.getDefaultSlice(sliceUri, getContext());
        }

    }


    /**
     * Slice has been pinned to external process. Subscribe to data source if necessary.
     */
    @Override
    public void onSlicePinned(Uri sliceUri) {
        // When data is received, call context.contentResolver.notifyChange(sliceUri, null) to

    }

    /**
     * Unsubscribe from data source if necessary.
     */
    @Override
    public void onSliceUnpinned(Uri sliceUri) {
        // Remove any observers if necessary to avoid memory leaks.
    }




}
