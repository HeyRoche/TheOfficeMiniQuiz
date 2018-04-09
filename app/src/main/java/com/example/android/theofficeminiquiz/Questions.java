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

import android.widget.Toast;

public class Questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int correctAnswer = 0;
    RadioButton selectionThreeRadio;
    RadioButton selectionOneQuestion5;
    RadioButton selectionTwoQuestion6;
    CheckBox selectionTwoCheckBox2;
    CheckBox selectionThreeCheckBox;
    CheckBox selectionThreeCheckBox2;
    RadioButton selectionOneQuestion8;
    CheckBox selectionTwoCheckBox;
    RadioButton selectionTwoQuestion9;
    RadioButton selectionThreeQuestion10;
    EditText car;
    EditText yourName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Spinner spinner = findViewById(R.id.andySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.andyQuestion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        generalQuestions();
    }
    //Method used to call viewIDs
    public void generalQuestions() {

        EditText yourName = findViewById(R.id.user_name);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        selectionThreeRadio = (findViewById(R.id.radio_2005));

        selectionOneQuestion5 = findViewById(R.id.radio_Scranton);

        selectionTwoQuestion6 = findViewById(R.id.radio_candles);

        selectionTwoCheckBox2 =  findViewById(R.id.scranton_strangler);

        selectionThreeCheckBox2 =  findViewById(R.id.hr);

        selectionOneQuestion8 =  findViewById(R.id.true_school);

        selectionTwoCheckBox =  findViewById(R.id.Toby);

        selectionThreeCheckBox = findViewById(R.id.Roy);

        selectionTwoQuestion9 =  findViewById(R.id.Stanley_selection);

        selectionThreeQuestion10 = findViewById(R.id.scrantones);

        car = findViewById(R.id.hit_with_car);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }
    //Method called when the Get Score button is selected. Used to calculate answers and provide Toast Message//
    public void displayScore(View view) {

        if (selectionThreeRadio.isChecked()) {
            correctAnswer++;
        }
        if (selectionOneQuestion5.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoQuestion6.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoCheckBox2.isChecked() && selectionThreeCheckBox2.isChecked()) {
            correctAnswer++;
        }
        if (selectionOneQuestion8.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoCheckBox.isChecked() && selectionThreeCheckBox.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoQuestion9.isChecked()) {
            correctAnswer++;
        }
        if (selectionThreeQuestion10.isChecked()) {
            correctAnswer++;
        }
        car = findViewById(R.id.hit_with_car);
        String carResponse = car.getText().toString().toLowerCase();
        if (carResponse.equalsIgnoreCase(getString(R.string.Meredith))) {
            correctAnswer++;
        }
        yourName = findViewById(R.id.user_name);
        String yourNameEntered= yourName.getText().toString();

        if (correctAnswer >= 8) {
            Toast.makeText(this, yourNameEntered + " , Congrats you answered " + correctAnswer + " out of 10 correctly!", Toast.LENGTH_LONG).show();
        }else { Toast.makeText(this, yourNameEntered + ", Seriously, Toby you got "  + correctAnswer + " out of 10 correctly!" +"You should re-watch the series!", Toast.LENGTH_LONG).show();
            }
    }

    /**
     * Method to check answer in spinner.
     *
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                correctAnswer++;
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    //Method to reset the score
    public void resetScore(View view) {
        correctAnswer = 0;

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







