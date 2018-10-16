package com.zoftino.slices;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zoftino.slices.presenter.SlicesData;

import androidx.appcompat.app.AppCompatActivity;

public class SlicesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slices_list);

        ListView lv = (ListView)findViewById(R.id.slices_lst);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, SlicesData.getCouponAppSlices()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getSlice((String)((TextView) view).getText());
            }
        });
    }

    private void getSlice(String slice){
        String sliceUri = SlicesData.couponAppSlicesUri+SlicesData.getSliceData().get(slice);
        Uri uri = Uri.parse(sliceUri);

        Intent intent = new Intent(getBaseContext(), SlicePresenterActivity.class);
        intent.setData(uri);
        startActivity(intent);
    }
}
