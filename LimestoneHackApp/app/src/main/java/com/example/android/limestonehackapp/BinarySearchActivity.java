package com.example.android.limestonehackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;

public class BinarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);
    }
    TextView string_progress_message = (TextView)findViewById(R.id.string_progress_message);
    EditText num_user_input = (EditText)findViewById(R.id.num_user_input);
    int num_guesses =0; //Counter for # of tries
    int cmp = 2; // sentinel valuet
    int userInput = Integer.parseInt(num_user_input.getText().toString()); // User's initial Guess
    int n = (int) (Math.round(((Math.random())*1000))); //Generates random number between 1-1000

    public void compare_loop {
        while (cmp != 0) {
            if (userInput > n) {

                cmp = 1; //User input is greater than generated number
                string_progress_message.setText("Too High!");
            } else if (userInput < n) {
                cmp = -1; // User input is smaller than generated number
                string_progress_message.setText("Too Low!");
            } else {
                cmp = 0; //User input is equal to the generated number
                string_progress_message.setText("Success!");
            }
            userInput = Integer.parseInt(num_user_input.getText().toString());
            System.out.println(num_guesses);
            num_guesses++;
        }
    }
}
