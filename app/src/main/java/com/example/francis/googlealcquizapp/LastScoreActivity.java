package com.example.francis.googlealcquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class LastScoreActivity extends AppCompatActivity  {


    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_score);

        score = QuestionActivity.getScore();



        TextView textView = (TextView) findViewById(R.id.tv_last_score);
        textView.setText(Integer.toString(score));
    }







}
