package com.example.android.htmlquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Pull answers from xml based on ID and assign boolean variable for scoring.

    public void submitQuiz (View view) {
        RadioButton oneA = findViewById(R.id.oneA);
        boolean answerOne = oneA.isChecked();
        RadioButton twoD = findViewById(R.id.twoD);
        boolean answerTwo = twoD.isChecked();
        EditText threeA = findViewById(R.id.userThree);
        String responseThree = threeA.getText().toString();
        String threeTest = "<h1>";
        boolean answerThree = responseThree.toLowerCase().contains(threeTest.toLowerCase());
        RadioButton fourA = findViewById(R.id.fourA);
        boolean answerFour = fourA.isChecked();
        CheckBox fiveA = findViewById(R.id.fiveA);
        boolean answerFiveA = fiveA.isChecked();
        CheckBox fiveB = findViewById(R.id.fiveB);
        boolean answerFiveB = fiveB.isChecked();
        CheckBox fiveC = findViewById(R.id.fiveC);
        boolean answerFiveC = fiveC.isChecked();
        CheckBox fiveD = findViewById(R.id.fiveD);
        boolean answerFiveD = fiveD.isChecked();

        int score = calculateScore(answerOne, answerTwo, answerThree, answerFour,answerFiveA, answerFiveB, answerFiveC, answerFiveD);
        // Show score as a toast

        if (score == 0)
        {
            Toast.makeText(this, "Try again! You scored 0 out of 5!", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(this, "Way to go! You scored " + score + " out of 5!", Toast.LENGTH_SHORT).show();

    }



    //calculate the score based on user answers
    private int calculateScore(boolean answerOne, boolean answerTwo, boolean answerThree, boolean answerFour, boolean answerFiveA, boolean answerFiveB, boolean answerFiveC, boolean answerFiveD){
        int totalScore = 0;

        if (answerOne){
            totalScore = totalScore + 1;

        }

        if (answerTwo){
            totalScore = totalScore + 1;

        }

        if (answerThree){
            totalScore = totalScore + 1;

        }

        if (answerFour){
            totalScore = totalScore + 1;

        }

        //If both A and D are checked, but not B and C.
        if (answerFiveA && answerFiveD && !answerFiveB && !answerFiveC) {
            totalScore = totalScore + 1;

        }

        return totalScore;

    }



}