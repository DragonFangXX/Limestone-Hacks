package com.example.android.limestonehackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class BinarySearchActivity extends AppCompatActivity {
    public int n = (int) (Math.round(((Math.random()) * 1000))); //Generates random number between 1-1000
    public int num_guesses = 0; //Counter for # of tries

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);

    }

    public void compare_loop(View view) {
        System.out.println("I'm in'");
        TextView string_progress_message = (TextView) findViewById(R.id.string_progress_message);
        TextView numGuesses = (TextView) findViewById(R.id.num_guesses);
        EditText num_user_input = (EditText) findViewById(R.id.num_user_input);


        int userInput = Integer.parseInt(num_user_input.getText().toString()); // User's initial Guess

        System.out.println("in");
        if (userInput > n) {
            string_progress_message.setText("Too High!");
        } else if (userInput < n) {
            string_progress_message.setText("Too Low!");
        } else {
            string_progress_message.setText("Success!");
        }
        System.out.println("out");
        num_guesses++;
        System.out.println("im out");
        numGuesses.setText(Integer.toString(num_guesses));
        System.out.println("end");
    }
}
