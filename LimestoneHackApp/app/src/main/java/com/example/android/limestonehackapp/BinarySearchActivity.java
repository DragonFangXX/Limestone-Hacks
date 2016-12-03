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
        TextView string_progress_message = (TextView) findViewById(R.id.string_progress_message);
        TextView numGuesses = (TextView) findViewById(R.id.num_guesses);
        TextView lastGuess = (TextView) findViewById(R.id.last_guess);
        EditText num_user_input = (EditText) findViewById(R.id.num_user_input);


        int userInput = Integer.parseInt(num_user_input.getText().toString()); // User's initial Guess

        if (userInput > 1000) {
            string_progress_message.setText("Invalid!");
        } else if (userInput < n) {
            string_progress_message.setText("Too Low!");
        } else if(userInput > n){
            string_progress_message.setText("Too High!");
        } else {
            string_progress_message.setText("Success!");
        }

        num_guesses++;

        lastGuess.setText(getString(R.string.last_guess, Integer.toString(userInput)));
        numGuesses.setText(getString(R.string.number_of_guesses, Integer.toString(num_guesses)));
        num_user_input.setText("");
    }
}
