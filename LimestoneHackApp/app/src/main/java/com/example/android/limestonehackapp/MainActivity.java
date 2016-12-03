package com.example.android.limestonehackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showBinaryDrop(View view){
        ImageView binaryImg = (ImageView)findViewById(R.id.binaryImg);
        
    }

    public void openBinarySearch(View view){
        Intent intent = new Intent(this, BinarySearchActivity.class);
        startActivity(intent);
    }

    public void openRecursion(View view){
        Intent intent = new Intent(this, HanoiActivity.class);
        startActivity(intent);
    }
}
