package com.example.android.limestonehackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.media.MediaPlayer;

public class BinarySearchActivity extends AppCompatActivity {
    public int n = (int) (Math.round(((Math.random()) * 1000))); //Generates random number between 1-1000
    public int num_guesses = 0; //Counter for # of tries



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);
    }

    public void check(View view){
        TextView string_progress_message = (TextView) findViewById(R.id.string_progress_message);
        EditText num_user_input = (EditText) findViewById(R.id.num_user_input);
        String textInput = num_user_input.getText().toString();

        if (textInput.isEmpty() || textInput.equals(null)){
            string_progress_message.setText(getString(R.string.invalid));
        }
        else{
            compare_loop(string_progress_message, num_user_input, textInput);
        }
    }

    public void compare_loop(TextView string_progress_message, EditText num_user_input, String textInput) {
        TextView numGuesses = (TextView) findViewById(R.id.num_guesses);
        TextView lastGuess = (TextView) findViewById(R.id.last_guess);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
        int userInput;

        userInput = Integer.parseInt(textInput); // User's initial Guess

        if (userInput > 1000||userInput < 0) {
            string_progress_message.setText(getString(R.string.invalid));
        } else if (userInput < n) {
            string_progress_message.setText(getString(R.string.too_low));
        } else if(userInput > n){
            string_progress_message.setText(getString(R.string.too_high));
        } else {
            string_progress_message.setText(getString(R.string.success));
            mp.start(); //Play glorious victory music
        }

        num_guesses++;

        lastGuess.setText(getString(R.string.last_guess, Integer.toString(userInput)));
        numGuesses.setText(getString(R.string.number_of_guesses, Integer.toString(num_guesses)));
        num_user_input.setText("");
    }

    public void restart(View view){
        finish();
        startActivity(getIntent());
    }
}
