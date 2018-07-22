package com.example.adam_yeh.custom.listview.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ListViewVO> dataList = AssetsUtil.getJSONFromAsset(super.getAssets());
        ListViewAdapter adapter = new ListViewAdapter(this, dataList);

        ListView list = (ListView) super.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(adapter);
    }

}
