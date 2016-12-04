package com.example.android.limestonehackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class LinkedListActivity extends AppCompatActivity {
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_list);
    }
    ImageView kirbyImg = (ImageView)findViewById(R.id.kirbyImg1);
    ImageView ganonImg = (ImageView)findViewById(R.id.ganonImg1);
    ImageView foxImg = (ImageView)findViewById(R.id.foxImg1);
    
}
