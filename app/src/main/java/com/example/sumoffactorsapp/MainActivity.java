package com.example.sumoffactorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Sum of Factors App created for AUCSC 220.
 * Date: Thursday, October 21st, 2021
 *
 * This class contains an activity that gets the user's input and sends it to the next
 * activity. The number the user can enter in is restricted to only 5 digits (less than 100 000),
 * and must be greater than 0.
 *
 * @author anjola
 */
public class MainActivity extends AppCompatActivity {

  EditText userInput;
  Button calculateButton;
  int userInputInt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    userInput = (EditText) findViewById(R.id.userInput);
    calculateButton = (Button) findViewById(R.id.calculateButton);
    Intent outputIntent = new Intent(this, OutputActivity.class);

    calculateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        try {
          userInputInt = Integer.parseInt(userInput.getText().toString());
          if (userInputInt == 0) {
            userInput.getText().clear();
            userInput.setHint("Not a number greater than 0.");
            userInput.setHintTextColor(getResources().getColor(R.color.red));
            return;
          }
        } // try
        catch (NumberFormatException e) {
          userInput.setHint("Not a number. Try again.");
          userInput.setHintTextColor(getResources().getColor(R.color.red));
          return;
        } // catch

        outputIntent.putExtra("User's input as an integer", userInputInt);
        startActivity(outputIntent);

      } // onClick
    });

  } //onCreate


} // MainActivity