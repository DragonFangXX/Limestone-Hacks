package com.example.android.limestonehackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showBinaryDrop(View view){
        ImageView binaryImg = (ImageView)findViewById(R.id.binaryImg);
        TextView binaryInstruction = (TextView) findViewById(R.id.bin_how_to_play);
        Button binBtn = (Button)findViewById(R.id.bin_button);

        if (binaryImg.getVisibility() == View.VISIBLE){
            binaryImg.setVisibility(View.GONE);
            binaryInstruction.setVisibility(View.GONE);
            binBtn.setVisibility(View.GONE);
        }
        else {
            binaryImg.setVisibility(View.VISIBLE);
            binaryInstruction.setVisibility(View.VISIBLE);
            binBtn.setVisibility(View.VISIBLE);
        }
    }

    public void openBinarySearch(View view){
        Intent intent = new Intent(this, BinarySearchActivity.class);
        startActivity(intent);
    }

    public void openRecursion(View view){
        Intent intent = new Intent(this, HanoiActivity.class);
        startActivity(intent);
    }

    public void openExtraHelp(View view){
        Intent intent = new Intent(this, ExtraHelpActivity.class);
        startActivity(intent);
    }
}
