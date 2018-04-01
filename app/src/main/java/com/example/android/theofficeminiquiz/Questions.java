package com.example.android.theofficeminiquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Spinner spinner = findViewById(R.id.andySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.andyQuestion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    //calcScore beings once user has entered all answers, total is then added and displayed on the screen.
    public void calcScore(View view) {

        RadioButton selectionOneRadio = (RadioButton) findViewById(R.id.radio_2010);
        boolean qOneRadio1 = selectionOneRadio.isChecked();

        RadioButton selectionTwoRadio = (RadioButton) findViewById(R.id.radio_2003);
        boolean qOneRadio2 = selectionTwoRadio.isChecked();

        RadioButton selectionThreeRadio = findViewById(R.id.radio_2005);
        boolean qOneRadio3 = selectionThreeRadio.isChecked();

        RadioButton selectionOneQuestion5 = (RadioButton) findViewById(R.id.radio_Scranton);
        boolean qFiveRadio1 = selectionOneQuestion5.isChecked();

        RadioButton selectionTwoQuestion5 = (RadioButton) findViewById(R.id.radio_Jacksonville);
        boolean qFiveRadio2 = selectionTwoQuestion5.isChecked();

        RadioButton selectionThreeQuestion5 = (RadioButton) findViewById(R.id.radio_New_York);
        boolean qFiveRadio3 = selectionThreeQuestion5.isChecked();

        RadioButton selectionOneQuestion6 = (RadioButton) findViewById(R.id.radio_books);
        boolean qSixRadio1 = selectionOneQuestion6.isChecked();

        RadioButton selectionTwoQuestion6 = (RadioButton) findViewById(R.id.radio_candles);
        boolean qSixRadio2 = selectionTwoQuestion6.isChecked();

        RadioButton selectionThreeQuestion6 = (RadioButton) findViewById(R.id.radio_beer);
        boolean qSixRadio3 = selectionThreeQuestion6.isChecked();

        CheckBox selectionOneCheckBox2 = (CheckBox) findViewById(R.id.mike_favorite);
        boolean qSevenCheckbox1 = selectionOneCheckBox2.isChecked();

        CheckBox selectionTwoCheckBox2 = (CheckBox) findViewById(R.id.scranton_strangler);
        boolean qSevenCheckbox2 = selectionTwoCheckBox2.isChecked();

        CheckBox selectionThreeCheckBox2 = (CheckBox) findViewById(R.id.hr);
        boolean qSevenCheckbox3 = selectionThreeCheckBox2.isChecked();

        RadioButton selectionOneQuestion8 = (RadioButton) findViewById(R.id.true_school);
        boolean qEightRadio1 = selectionOneQuestion8.isChecked();

        RadioButton selectionTwoQuestion8 = (RadioButton) findViewById(R.id.false_school);
        boolean qEightRadio2 = selectionTwoQuestion8.isChecked();

        CheckBox selectionOneCheckBox = (CheckBox) findViewById(R.id.Jim);
        boolean qTwoCheckbox1 = selectionOneCheckBox.isChecked();

        CheckBox selectionTwoCheckBox = (CheckBox) findViewById(R.id.Toby);
        boolean qTwoCheckbox2 = selectionTwoCheckBox.isChecked();

        CheckBox selectionThreeCheckBox = (CheckBox) findViewById(R.id.Roy);
        boolean qTwoCheckbox3 = selectionThreeCheckBox.isChecked();


        //calculate total score
        int questionCalc = questionCheck(qOneRadio1, qOneRadio2, qOneRadio3) + showTakePlace(qFiveRadio1, qFiveRadio2, qFiveRadio3) + janSell(qSixRadio1, qSixRadio2, qSixRadio3) + tobyKnownFor(qSevenCheckbox2, qSevenCheckbox3);
        questionCalc = questionCalc + questionCheck2(qTwoCheckbox2, qTwoCheckbox3) + goToSchool(qEightRadio1, qEightRadio2);
        questionCalc = questionCalc + editTextResponse();
        score = score + questionCalc;
        displayScore(score);


    }


    //Method to determine how many points to award when spinner answer is chosen.


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        //String text = adapterView.getItemAtPosition(i).toString();


        switch (i) {

            case 0:
                break;
            case 1:
                score = 0;

                break;
            case 2:
                score = 0;
                score = score + 5;

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


   //The methods below are used to determine the points awarded for correct and incorrect answers.
    public int questionCheck(boolean qOneRadio1, boolean qOneRadio2, boolean qOneRadio3) {
        int radioScore = 0;

        if (qOneRadio3) {

            radioScore = radioScore + 5;

        }

        if (qOneRadio2) {

            radioScore = 0;


        }

        if (qOneRadio1) {

            radioScore = 0;

        }

        return radioScore;
    }

    public int questionCheck2(boolean qTwoCheckbox2, boolean qTwoCheckbox3) {

        int wedScore = 0;

        if (qTwoCheckbox2 && qTwoCheckbox3) {

            wedScore = wedScore + 5;


        } else {

            wedScore = 0;


        }

        return wedScore;
    }


    public int editTextResponse() {

        int carScore = 0;

        EditText car = findViewById(R.id.hit_with_car);
        String carResponse = car.getText().toString().toLowerCase();


        if (carResponse.compareTo(getString(R.string.meredith)) == 0) {
            carScore = carScore + 5;

        } else {
            carScore = 0;

        }

        return carScore;
    }

    public int showTakePlace(boolean qFiveRadio1, boolean qFiveRadio2, boolean qFiveRadio3) {
        int radioScore2 = 0;

        if (qFiveRadio1) {

            radioScore2 = radioScore2 + 5;

        } else {
            radioScore2 = 0;
        }

        return radioScore2;
    }


    public int janSell(boolean qSixRadio1, boolean qSixRadio2, boolean qSixRadio3) {
        int radioScore3 = 0;

        if (qSixRadio2) {

            radioScore3 = radioScore3 + 5;

        } else {
            radioScore3 = 0;
        }

        return radioScore3;
    }

    public int tobyKnownFor(boolean qSevenCheckbox2, boolean qSevenCheckbox3) {

        int tobyScore = 0;

        if (qSevenCheckbox2 && qSevenCheckbox3) {

            tobyScore = tobyScore + 5;


        } else {

            tobyScore = 0;


        }

        return tobyScore;
    }


    public int goToSchool(boolean qEightRadio1, boolean qEightRadio2) {
        int radioScore4 = 0;

        if (qEightRadio1) {

            radioScore4 = radioScore4 + 5;

        } else {
            radioScore4 = 0;
        }

        return radioScore4;
    }

    //Displays users score on the screen.
    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.current_score);
        scoreView.setText(String.valueOf(score));

    }

}


//Still need to reset the score and account for what happens during pause state.
//Still need a toast with final score information.






