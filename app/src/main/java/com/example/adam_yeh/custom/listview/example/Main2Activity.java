package com.example.adam_yeh.custom.listview.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = super.getIntent();
        String position = i.getExtras().getString("position");

        TextView tv = super.findViewById(R.id.show);
        tv.setText(position);
    }

}
