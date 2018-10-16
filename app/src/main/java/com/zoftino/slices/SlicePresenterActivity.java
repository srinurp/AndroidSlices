package com.zoftino.slices;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.slice.SliceViewManager;
import androidx.slice.widget.SliceLiveData;
import androidx.slice.widget.SliceView;

public class SlicePresenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slice_presenter);

        SliceViewManager sliceViewManager = SliceViewManager.getInstance(this);

        SliceView sliceView = findViewById(R.id.slice);
        sliceView.setSlice(sliceViewManager.bindSlice(getIntent().getData()));


        SliceView svSmall = findViewById(R.id.slice_icon);
        svSmall.setSlice(sliceViewManager.bindSlice(getIntent().getData()));
        svSmall.setMode(SliceView.MODE_SHORTCUT);

        //listen and update slice changes
        LiveData liveData = SliceLiveData.fromUri(this, getIntent().getData());
        liveData.observe(this, sliceView);

    }
}
