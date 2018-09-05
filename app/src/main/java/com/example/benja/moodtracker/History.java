package com.example.benja.moodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Retrieving the different TextViews that will display depending on the != moods
        TextView moodView4 = findViewById(R.id.moodView4);
        TextView moodView3 = findViewById(R.id.moodView3);
        TextView moodView2 = findViewById(R.id.moodView2);
        TextView moodView1 = findViewById(R.id.moodView1);
        TextView moodView0 = findViewById(R.id.moodView0);

        //Making the TextViews disappear
        moodView4.setVisibility(View.INVISIBLE);
        moodView3.setVisibility(View.INVISIBLE);
        moodView2.setVisibility(View.INVISIBLE);
        moodView1.setVisibility(View.INVISIBLE);
        moodView0.setVisibility(View.INVISIBLE);

        //Receiving the mood a.k.a the emoji chosen
        Intent intent = getIntent();
        int mood = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        //Distinguishing which mood has been selected

        if (mood == 4) {
            moodView4.setVisibility(View.VISIBLE);
        }
        else if (mood == 3) {
            moodView3.setVisibility(View.VISIBLE);
        }
        else if (mood == 2) {
            moodView2.setVisibility(View.VISIBLE);
        }
        else if (mood == 1) {
            moodView1.setVisibility(View.VISIBLE);
        }
        else if (mood == 0) {
            moodView0.setVisibility(View.VISIBLE);
        }

    }
}
