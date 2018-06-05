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


    //Declares  variables throughout the quiz.
    int correctAnswer = 0;
    RadioButton selectionThreeRadio;
    RadioButton selectionOneQuestion5;
    RadioButton selectionTwoQuestion6;
    CheckBox selectionOneCheckBox2;
    CheckBox selectionTwoCheckBox2;
    CheckBox selectionThreeCheckBox2;
    CheckBox selectionOneCheckBox;
    CheckBox selectionTwoCheckBox;
    CheckBox selectionThreeCheckBox;
    RadioButton selectionOneQuestion8;
    RadioButton selectionTwoQuestion9;
    RadioButton selectionThreeQuestion10;
    EditText car;
    EditText yourName;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    RadioGroup radioGroup6;
    Spinner spinner;

    // Checks the answers during the one create cycle; was previously informed to do this as a best practice for memory use of application.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

         // I learned who to implement a spinner through YouTube videos ( https://www.youtube.com/watch?v=28jA5-mO8K8 and https://www.youtube.com/watch?v=sH_f8mr-2v8&t=306s)
        // as well as https://developer.android.com/guide/topics/ui/controls/spinner
        Spinner spinner = findViewById(R.id.andySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.andyQuestion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        generalQuestions();
    }

    //This method is used to check the answers by referring to the viewIDs. Incorrect checkboxes are included.
    public void generalQuestions() {

        yourName = findViewById(R.id.user_name);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        selectionThreeRadio = findViewById(R.id.radio_2005);

        selectionOneQuestion5 = findViewById(R.id.radio_Scranton);

        selectionTwoQuestion6 = findViewById(R.id.radio_candles);

        selectionOneQuestion8 = findViewById(R.id.true_school);

        selectionTwoQuestion9 = findViewById(R.id.Stanley_selection);

        selectionThreeQuestion10 = findViewById(R.id.scrantones);

        car = findViewById(R.id.hit_with_car);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        radioGroup1 = findViewById(R.id.radioGroup_1_year);

        radioGroup2 = findViewById(R.id.radioGroup_2_location);

        radioGroup3 = findViewById(R.id.radioGroup_3_jan);

        radioGroup4 = findViewById(R.id.radioGroup_4_school);

        radioGroup5 = findViewById(R.id.radioGroup_5_stanley);

        radioGroup6 = findViewById(R.id.radioGroup_6_song);

        spinner = findViewById(R.id.andySpinner);

        yourName = findViewById(R.id.user_name);

        selectionOneCheckBox2 = findViewById(R.id.mike_favorite);

        selectionTwoCheckBox2 = findViewById(R.id.scranton_strangler);

        selectionThreeCheckBox2 = findViewById(R.id.hr);

        selectionOneCheckBox = findViewById(R.id.Jim);

        selectionTwoCheckBox = findViewById(R.id.Toby);

        selectionThreeCheckBox = findViewById(R.id.Roy);

        car = findViewById(R.id.hit_with_car);
    }

    //Method called when the Get Score button is selected. Used to calculate answers and provide Toast Messages.
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
        if (selectionTwoCheckBox2.isChecked() && selectionThreeCheckBox2.isChecked()&& !selectionOneCheckBox2.isChecked()) {
            correctAnswer++;
        }
        if (selectionOneQuestion8.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoCheckBox.isChecked() && selectionThreeCheckBox.isChecked() && !selectionOneCheckBox.isChecked()) {
            correctAnswer++;
        }
        if (selectionTwoQuestion9.isChecked()) {
            correctAnswer++;
        }
        if (selectionThreeQuestion10.isChecked()) {
            correctAnswer++;
        }
        car = findViewById(R.id.hit_with_car);
        String carResponse = car.getText().toString();
        if (carResponse.equalsIgnoreCase(getString(R.string.Meredith))) {
            correctAnswer++;
        }else if(carResponse.equalsIgnoreCase(getString(R.string.Meredith_S))){
            correctAnswer++;
        }

        yourName = findViewById(R.id.user_name);
        String yourNameEntered = yourName.getText().toString();
        if(correctAnswer >10) {
            correctAnswer=10;
            Toast.makeText(this, yourNameEntered  + getString((R.string.congrats_message)) +  correctAnswer  + getString((R.string.correct10)), Toast.LENGTH_LONG).show();
        }else if (correctAnswer >= 8) {
            Toast.makeText(this, yourNameEntered  + getString((R.string.congrats_message)) +  correctAnswer  + getString((R.string.correct10)), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, yourNameEntered  + getString((R.string.tobyWrong)) +  correctAnswer  + getString((R.string.correct10)) + getString((R.string.re_watch)), Toast.LENGTH_LONG).show();
        }
    }

  //Method used to select the answer from the spinner.
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

    //Method to reset the score when "Replay" is selected
    public void resetScore(View view) {
        correctAnswer = 0;

        //All RadioGroup in app are cleared

            radioGroup1.clearCheck();

            radioGroup2.clearCheck();

            radioGroup3.clearCheck();

            radioGroup4.clearCheck();

            radioGroup5.clearCheck();

            radioGroup6.clearCheck();

        //All Checkbox selections are cleared.
            selectionOneCheckBox.setChecked(false);

            selectionTwoCheckBox.setChecked(false);

            selectionThreeCheckBox.setChecked(false);

            selectionOneCheckBox2.setChecked(false);

            selectionTwoCheckBox2.setChecked(false);

            selectionThreeCheckBox2.setChecked(false);

        //Remaining answers are cleared.
        spinner.setAdapter(null);
        yourName.getText().clear();
        car.getText().clear();
    }
}