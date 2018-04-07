package com.example.android.theofficeminiquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int score = 0;
    int correctAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Spinner spinner = findViewById(R.id.andySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.andyQuestion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        /*called so that keyboard doesn't immediately open when app is running.*/
        EditText yourName = findViewById(R.id.user_name);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    /**
     * calculates score for all answers selected or input during quiz.
     */

    public void calcScore(View view) {
        RadioButton selectionThreeRadio = findViewById(R.id.radio_2005);
        boolean qOneRadio3 = selectionThreeRadio.isChecked();

        RadioButton selectionOneQuestion5 = (RadioButton) findViewById(R.id.radio_Scranton);
        boolean qFiveRadio1 = selectionOneQuestion5.isChecked();

        RadioButton selectionTwoQuestion6 = (RadioButton) findViewById(R.id.radio_candles);
        boolean qSixRadio2 = selectionTwoQuestion6.isChecked();

        CheckBox selectionTwoCheckBox2 = (CheckBox) findViewById(R.id.scranton_strangler);
        boolean qSevenCheckbox2 = selectionTwoCheckBox2.isChecked();

        CheckBox selectionThreeCheckBox2 = (CheckBox) findViewById(R.id.hr);
        boolean qSevenCheckbox3 = selectionThreeCheckBox2.isChecked();

        RadioButton selectionOneQuestion8 = (RadioButton) findViewById(R.id.true_school);
        boolean qEightRadio1 = selectionOneQuestion8.isChecked();

        CheckBox selectionTwoCheckBox = (CheckBox) findViewById(R.id.Toby);
        boolean qTwoCheckbox2 = selectionTwoCheckBox.isChecked();

        CheckBox selectionThreeCheckBox = (CheckBox) findViewById(R.id.Roy);
        boolean qTwoCheckbox3 = selectionThreeCheckBox.isChecked();

        RadioButton selectionTwoQuestion9 = (RadioButton) findViewById(R.id.Stanley_selection);
        boolean qNineRadio2 = selectionTwoQuestion9.isChecked();

        RadioButton selectionThreeQuestion10 = (RadioButton) findViewById(R.id.scrantones);
        boolean qTenRadio3 = selectionThreeQuestion10.isChecked();

        //calculate total score
        int questionCalc = questionCheck(qOneRadio3) + showTakePlace(qFiveRadio1) + janSell(qSixRadio2) + tobyKnownFor(qSevenCheckbox2, qSevenCheckbox3);
        questionCalc = questionCalc + questionCheck2(qTwoCheckbox2, qTwoCheckbox3) + goToSchool(qEightRadio1) + stutterQuestion(qNineRadio2) + themeSong(qTenRadio3);
        questionCalc = questionCalc + editTextResponse();
        score = score + questionCalc;
        displayScore(score);

        //Toast message to display at end of quiz.
        Toast.makeText(this, "Congrats you answered " + correctAnswer + " out of 10 correctly!", Toast.LENGTH_LONG).show();
    }

    /**
     * calculats score using, global variable for the spinner adapter.
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                break;
            case 1:
                score = 0;
                break;
            case 2:
                score = 0;
                score = score + 5;
                correctAnswer++;
                break;
            case 3:
                score = 0;
                break;
            case 4:
                score = 0;
                break;
            case 5:
                score = 0;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /**
     * @param qOneRadio3 first radio question, refers to show start.
     *                   calculates score for question.
     *                   The methods below are used to determine the points awarded for correct and incorrect answers.
     */

    public int questionCheck(boolean qOneRadio3) {
        int radioScore = 0;

        if (qOneRadio3) {
            radioScore = radioScore + 5;
            correctAnswer++;
        } else {
            radioScore = 0;
        }
        return radioScore;
    }

    /**
     * first checkbox question, refers to wedding.
     * calculates score for question.
     *
     * @param qTwoCheckbox2 refers to second answer selection.
     * @param qTwoCheckbox3 refers to third answer selection.
     */

    public int questionCheck2(boolean qTwoCheckbox2, boolean qTwoCheckbox3) {
        int wedScore = 0;

        if (qTwoCheckbox2 && qTwoCheckbox3) {
            wedScore = wedScore + 5;
            correctAnswer++;
        } else {
            wedScore = 0;
        }
        return wedScore;
    }

    /**
     * calculates score for question.
     *
     * @return returns score based on selection user provides.
     * The method below checks the editText response provided by the user.
     */

    public int editTextResponse() {
        int carScore = 0;
        EditText car = findViewById(R.id.hit_with_car);
        String carResponse = car.getText().toString().toLowerCase();
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        if (carResponse.compareTo(getString(R.string.Meredith)) == 0) {
            carScore = carScore + 5;
            correctAnswer++;
        }
        if (carResponse.compareTo(getString(R.string.meredith)) == 0) {
            carScore = carScore + 5;
            correctAnswer++;
        } else {
            carScore = 0;
        }
        return carScore;
    }

    /**
     * calculates score for question.
     *
     * @param qFiveRadio1 refers to the second radio question asked.
     * @return returns score based on selection user provides.
     */

    public int showTakePlace(boolean qFiveRadio1) {
        int radioScore2 = 0;

        if (qFiveRadio1) {
            radioScore2 = radioScore2 + 5;
            correctAnswer++;
        } else {
            radioScore2 = 0;
        }
        return radioScore2;
    }

    /**
     * calculates score for question.
     *
     * @param qSixRadio2 refers to the sixth question asked on the quiz, third radio question.
     * @return returns score based on selection user provides.
     */

    public int janSell(boolean qSixRadio2) {
        int radioScore3 = 0;

        if (qSixRadio2) {
            radioScore3 = radioScore3 + 5;
            correctAnswer++;
        } else {
            radioScore3 = 0;
        }
        return radioScore3;
    }

    /**
     * calculates score for question.
     *
     * @param qSevenCheckbox2 second checkbox question on the quiz, refers to scranton strangler.
     * @param qSevenCheckbox3 second checkbox question on the quiz, refers to HR.
     * @return returns score based on selection user provides.
     */

    public int tobyKnownFor(boolean qSevenCheckbox2, boolean qSevenCheckbox3) {
        int tobyScore = 0;

        if (qSevenCheckbox2 && qSevenCheckbox3) {
            tobyScore = tobyScore + 5;
            correctAnswer++;
        } else {
            tobyScore = 0;
        }
        return tobyScore;
    }

    /**
     * calculates score for question.
     *
     * @param qEightRadio1 fourth radio question on quiz, refers to true as an answer selection.
     * @return returns score based on selection user provides.
     */

    public int goToSchool(boolean qEightRadio1) {
        int radioScore4 = 0;

        if (qEightRadio1) {
            radioScore4 = radioScore4 + 5;
            correctAnswer++;
        } else {
            radioScore4 = 0;
        }
        return radioScore4;
    }

    /**
     * calculates score for question.
     *
     * @param qNineRadio2 fifth radio question on quiz, refers to question 9.
     * @return returns score based on selection user provides
     */

    public int stutterQuestion(boolean qNineRadio2) {
        int radioScore4 = 0;

        if (qNineRadio2) {
            radioScore4 = radioScore4 + 5;
            correctAnswer++;
        } else {
            radioScore4 = 0;
        }
        return radioScore4;
    }

    /**
     * calculates score for the question.
     *
     * @param qTenRadio3 sixth and final radio question, refers to question 10.
     * @return returns score based on selection user provides
     */

    public int themeSong(boolean qTenRadio3) {
        int radioScore5 = 0;

        if (qTenRadio3) {
            radioScore5 = radioScore5 + 5;
            correctAnswer++;
        } else {
            radioScore5 = 0;
        }
        return radioScore5;
    }

    /**
     * @param score display final score based on calcScore calculations.
     */

    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.current_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * resets the score and answered selected from the quiz.
     *
     * @param view
     */

    public void resetScore(View view) {
        score = 0;
        displayScore(score);

        RadioGroup radioGroup1 = findViewById(R.id.radioGroup_1_year);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = findViewById(R.id.radioGroup_2_location);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = findViewById(R.id.radioGroup_3_jan);
        radioGroup3.clearCheck();

        RadioGroup radioGroup4 = findViewById(R.id.radioGroup_4_school);
        radioGroup4.clearCheck();

        RadioGroup radioGroup5 = findViewById(R.id.radioGroup_5_stanley);
        radioGroup5.clearCheck();

        RadioGroup radioGroup6 = findViewById(R.id.radioGroup_6_song);
        radioGroup6.clearCheck();

        EditText userName = findViewById(R.id.user_name);
        userName.getText().clear();

        EditText car = findViewById(R.id.hit_with_car);
        car.getText().clear();

        CheckBox selectionOneCheckBox = findViewById(R.id.Jim);
        selectionOneCheckBox.setChecked(false);

        CheckBox selectionTwoCheckBox = findViewById(R.id.Toby);
        selectionTwoCheckBox.setChecked(false);

        CheckBox selectionThreeCheckBox = findViewById(R.id.Roy);
        selectionThreeCheckBox.setChecked(false);

        CheckBox selectionOneCheckBox2 = findViewById(R.id.mike_favorite);
        selectionOneCheckBox2.setChecked(false);

        CheckBox selectionTwoCheckBox2 = findViewById(R.id.scranton_strangler);
        selectionTwoCheckBox2.setChecked(false);

        CheckBox selectionThreeCheckBox2 = findViewById(R.id.hr);
        selectionThreeCheckBox2.setChecked(false);

        Spinner spinner = findViewById(R.id.andySpinner);
        spinner.setAdapter(null);
    }
}








