package com.example.benja.moodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.application.EXTRA_NUMBER";
    int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Retrieving all the different moods or buttons that could be selected
        ImageButton textButton = findViewById(R.id.superHappyTextButton);
        ImageButton superHappyButton = findViewById(R.id.superHappyButton);
        ImageButton happyButton = findViewById(R.id.happyButton);
        ImageButton normalButton = findViewById(R.id.normalButton);
        ImageButton disappointedButton = findViewById(R.id.disappointedButton);
        ImageButton sadButton = findViewById(R.id.sadButton);
        ImageButton historyButton = findViewById(R.id.historyButton);
        final TextView superHappyBorder = findViewById(R.id.superHappyBorder);
        final TextView happyBorder = findViewById(R.id.happyBorder);
        final TextView normalBorder = findViewById(R.id.normalBorder);
        final TextView disappointedBorder = findViewById(R.id.disappointedBorder);
        final TextView sadBorder = findViewById(R.id.sadBorder);

        //Setting the borders invisible (as long as no mood has been selected)
        superHappyBorder.setVisibility(View. INVISIBLE);
        happyBorder.setVisibility(View. INVISIBLE);
        normalBorder.setVisibility(View. INVISIBLE);
        disappointedBorder.setVisibility(View. INVISIBLE);
        sadBorder.setVisibility(View. INVISIBLE);


        //When one clicks on the Add a note button
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You have clicked on the image", Toast.LENGTH_LONG).show();
            }
        });

        //When one clicks on the history button
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyActivityIntent = new Intent(MainActivity.this, History.class);
                //Sending the mood a.k.a the emoji slected
                historyActivityIntent.putExtra(EXTRA_NUMBER, mood);
                MainActivity.this.startActivity(historyActivityIntent);
            }
        });

        //When one clicks on the superHappy emoji
        superHappyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You have clicked on the smiley", Toast.LENGTH_LONG).show();
                mood = 4;
                superHappyBorder.setVisibility(View.VISIBLE);
                happyBorder.setVisibility(View. INVISIBLE);
                normalBorder.setVisibility(View. INVISIBLE);
                disappointedBorder.setVisibility(View. INVISIBLE);
                sadBorder.setVisibility(View. INVISIBLE);

            }
        });

        //When one clicks on the happy emoji
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 3;
                happyBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View. INVISIBLE);
                normalBorder.setVisibility(View. INVISIBLE);
                disappointedBorder.setVisibility(View. INVISIBLE);
                sadBorder.setVisibility(View. INVISIBLE);

            }
        });
        //When one clicks on the normal emoji
        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 2;
                normalBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View. INVISIBLE);
                happyBorder.setVisibility(View. INVISIBLE);
                disappointedBorder.setVisibility(View. INVISIBLE);
                sadBorder.setVisibility(View. INVISIBLE);

            }
        });
        //When one clicks on the disappointed emoji
        disappointedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 1;
                disappointedBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View. INVISIBLE);
                happyBorder.setVisibility(View. INVISIBLE);
                normalBorder.setVisibility(View. INVISIBLE);
                sadBorder.setVisibility(View. INVISIBLE);
            }
        });
        //When one clicks on the sad emoji
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 0;
                sadBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View. INVISIBLE);
                happyBorder.setVisibility(View. INVISIBLE);
                normalBorder.setVisibility(View. INVISIBLE);
                disappointedBorder.setVisibility(View. INVISIBLE);
            }
        });
    }
}
