package com.example.android.theofficeminiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton();
    }

    public void nextButton() {
        Button buttonPlay = (Button) findViewById(R.id.buttonStart);
        buttonPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(MainActivity.this, Questions.class));
                startActivity(intent);
            }
        });
    }
}