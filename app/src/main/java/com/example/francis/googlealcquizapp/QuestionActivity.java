package com.example.francis.googlealcquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

public class QuestionActivity extends AppCompatActivity {

    //A field variable that stores the scores
    private static int score = 0;

    //getter method that gets the score variable
    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        //hides the keyboard when the activity launches
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    //This method handles the question number one
    public void submit(View view) {
        //
        CheckBox check0 = findViewById(R.id.checkbox1);
        CheckBox check2 = findViewById(R.id.checkbox3);
        //boolean variable that checks when when the two correct checkboxes are  checked
        boolean check[] = {check2.isChecked(), check0.isChecked()};


        if (check[0] && check[1]) {
            //adds 1 to score(field variable)
            score = score + 1;
            Toast.makeText(this, "You are Correct", Toast.LENGTH_SHORT).show();
            /*this object renders the "Submit" button invalid after the user clicks it so he/she does'nt have to
            manipulate the answer after submitting*/
            Button button = (Button) findViewById(R.id.b_submit);
            button.setEnabled(false);

        } else {
            score = score - 1;
            Toast.makeText(this, "You are Wrong", Toast.LENGTH_SHORT).show();
            /*this object renders the "Submit" button invalid after the user clicks it so he/she does'nt have to
            manipulate the answer after submitting*/
            Button button = (Button) findViewById(R.id.b_submit);
            button.setEnabled(false);
        }

    }

    //This method handles Question 2,
    public void submitQuestion2(View view) {
        EditText editText = (EditText) findViewById(R.id.ed_question_2_answer);
        //This local varible stores the text
        String text = editText.getText().toString();
        //the "if" statement checks the text if it's nt empty or corresponds with the answer
        if (!text.isEmpty() && text.equals("Sundar Pichai") || text.equals("Pichai Sundar")) {
            //adds 1 if the user is correct
            score = score + 1;
            Toast.makeText(this, "You are Correct", Toast.LENGTH_SHORT).show();
            //removes the cursor from the edit field making it not editable
            editText.setCursorVisible(false);
             /*this object renders the "Submit" button invalid after the user clicks it so he/she does'nt have to
            manipulate the answer after submitting*/
            Button button = (Button) findViewById(R.id.b_submit2);
            button.setEnabled(false);

        } else {
            score = score - 1;
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
            //removes the cursor from the edit field making it not editable
            editText.setCursorVisible(false);
        }
         /*this object renders the "Submit" button invalid after the user clicks it so he/she does'nt have to
            manipulate the answer after submitting*/
        Button button = (Button) findViewById(R.id.b_submit2);
        button.setEnabled(false);

    }

    public void answerQuestion3(View view) {
        //Binds the radio buttons
        RadioGroup radioGroup = findViewById(R.id.rd_group1);
        RadioButton radioButton1 = findViewById(R.id.rd_1);

        //an array that stores the index of the radio button
        boolean checkAnswer[] = {radioButton1.isChecked()};
        //this variable store the count as the "for loop" loops
        int counter = 0;

        //loops through the length of the array
        for (int i = 0; i < checkAnswer.length; i++) {


            if (checkAnswer[i]) {

                counter = counter + 1;
            }
        }

        //if the counter gets count of 1
        if (counter == 1) {
            //adds one to score
            score = score + 1;
            Toast.makeText(QuestionActivity.this, "You are correct", Toast.LENGTH_SHORT).show();

            Log.d("check", Arrays.toString(checkAnswer));
        } else {
            //minus 1 from score if it's wrong
            score = score - 1;
            Toast.makeText(QuestionActivity.this, " Wrong answer", Toast.LENGTH_SHORT).show();
            radioGroup.clearCheck();
        }
        Button button = (Button) findViewById(R.id.b_submit3);
        button.setEnabled(false);
    }

    //Handles the Question 4
    public void answerQuestion4(View view) {

        RadioButton radioButton2 = findViewById(R.id.rd_5);


        boolean checkAnswer[] = {radioButton2.isChecked()};

        int counter = 0;

        for (int i = 0; i < checkAnswer.length; i++) {


            if (checkAnswer[i]) {

                counter = counter + 1;
            }
        }
        if (counter == 1) {
            score = score + 1;
            Toast.makeText(QuestionActivity.this, "You are correct", Toast.LENGTH_SHORT).show();
        } else {
            score = score - 1;
            Toast.makeText(QuestionActivity.this, " Wrong answer", Toast.LENGTH_SHORT).show();
        }
        Button button = (Button) findViewById(R.id.b_submit4);
        button.setEnabled(false);
    }

    //This method makes a Toast and displays the score(field variable)
    public void viewScore(View view) {


        Toast.makeText(this, "Your Score is: " + score, Toast.LENGTH_SHORT).show();
    }

    //This Method takes user to LastScore Activity using the view last score button
    public void checkLastScore(View view) {
        Intent intent = new Intent(this, LastScoreActivity.class);
        startActivity(intent);
    }

    //This method makes the submit buttons valid and the checkboxes,editText and radio empty
    public void restartQuiz(View view) {
        //Resets the Score to 0
        score = 0;
        CheckBox check0 = findViewById(R.id.checkbox1);
        check0.setChecked(false);
        CheckBox check1 = findViewById(R.id.checkbox2);
        check1.setChecked(false);
        CheckBox check2 = findViewById(R.id.checkbox3);
        check2.setChecked(false);
        CheckBox check3 = findViewById(R.id.checkbox4);
        check3.setChecked(false);

        Button bt1 = findViewById(R.id.b_submit);
        bt1.setEnabled(true);
        Button bt2 = findViewById(R.id.b_submit2);
        bt2.setEnabled(true);
        Button bt3 = findViewById(R.id.b_submit3);
        bt3.setEnabled(true);
        Button bt4 = findViewById(R.id.b_submit4);
        bt4.setEnabled(true);

        RadioButton rb1 = findViewById(R.id.rd_1);
        rb1.setChecked(false);
        RadioButton rb2 = findViewById(R.id.rd_2);
        rb2.setChecked(false);
        RadioButton rb3 = findViewById(R.id.rd_3);
        rb3.setChecked(false);
        RadioButton rb4 = findViewById(R.id.rd_4);
        rb4.setChecked(false);
        RadioButton rb5 = findViewById(R.id.rd_5);
        rb5.setChecked(false);
        RadioButton rb6 = findViewById(R.id.rd_6);
        rb6.setChecked(false);
        RadioButton rb7 = findViewById(R.id.rd_7);
        rb7.setChecked(false);

        EditText editText = findViewById(R.id.ed_question_2_answer);
        editText.setText(null);
    }
}
