package com.example.sumoffactorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Sum of Factors App created for AUCSC 220.
 * Date: Thursday, October 21st, 2021
 *
 * This class contains an activity that calculates and displays the sum of factors of the
 *  * integer that the user inputted.
 *
 * @author anjola
 */
public class OutputActivity extends AppCompatActivity {

    int userInputInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Bundle informationComingIn = getIntent().getExtras();
        userInputInt = informationComingIn.getInt("User's input as an integer");
        calcSumOfFactors();
    } // onCreate

    /**
     * Calculates and displays the sum of all of the integer's factors.
     */
    public void calcSumOfFactors() {
        int sumOfFactors = 0;
        for (int num = 1; num <= userInputInt; num++) {
            if (userInputInt % num == 0) {
                sumOfFactors = sumOfFactors + num;
            } // if
        } // for
        displaySumOfFactors(sumOfFactors);
    } // calcSumOfFactors

    /**
     * Displays the sum of factors of the integer that the user inputted.
     * @param sumFactors - the calculated sum of factors of the integer the user inputted
     */
    public void displaySumOfFactors(int sumFactors) {
        TextView outputForSumOfFactors = (TextView) findViewById(R.id.output);
        String sumFactorsStr = "" + sumFactors;
        outputForSumOfFactors.setText("The sum of factors of " + userInputInt + " is " +
                sumFactorsStr + ".");
    } // displaySumOfFactors

    /**
     * Returns the user to the home page.
     * @param aView - current View
     */
    public void homePage(View aView) {
        Button homeButton = (Button) aView.findViewById(R.id.homeButton);
        Intent toHomePage = new Intent(this, MainActivity.class);
        startActivity(toHomePage);
    } //homePage

} // OutputActivity