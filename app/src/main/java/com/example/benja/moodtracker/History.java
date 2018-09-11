package com.example.benja.moodtracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class History extends AppCompatActivity {
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Receiving the comments written in this activity
        SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
        final String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));

        //Retrieving the comment icons which will be displayed if a comment has been input
        ImageButton superHappyComment = findViewById(R.id.superHappyComment);
        ImageButton happyComment = findViewById(R.id.happyComment);
        ImageButton normalComment = findViewById(R.id.normalComment);
        ImageButton disappointedComment = findViewById(R.id.disappointedComment);
        ImageButton sadComment = findViewById(R.id.sadComment);

        //Making the comment icons invisible till a particular mood has been chosen and a comment has been input
        superHappyComment.setVisibility(View.INVISIBLE);
        happyComment.setVisibility(View.INVISIBLE);
        normalComment.setVisibility(View.INVISIBLE);
        disappointedComment.setVisibility(View.INVISIBLE);
        sadComment.setVisibility(View.INVISIBLE);

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
        int mood = intent.getIntExtra(MainActivity.EXTRA_MOOD, 2);

        //Distinguishing which mood has been selected
        if (mood == 0) {
            moodView4.setVisibility(View.VISIBLE);
            if (!(comment.equals(""))) {
                superHappyComment.setVisibility(View.VISIBLE);
                happyComment.setVisibility(View.INVISIBLE);
                normalComment.setVisibility(View.INVISIBLE);
                disappointedComment.setVisibility(View.INVISIBLE);
                sadComment.setVisibility(View.INVISIBLE);
            }
        } else if (mood == 1) {
            moodView3.setVisibility(View.VISIBLE);
            if (!(comment.equals(""))) {
                superHappyComment.setVisibility(View.INVISIBLE);
                happyComment.setVisibility(View.VISIBLE);
                normalComment.setVisibility(View.INVISIBLE);
                disappointedComment.setVisibility(View.INVISIBLE);
                sadComment.setVisibility(View.INVISIBLE);
            }
        } else if (mood == 2) {
            moodView2.setVisibility(View.VISIBLE);
            if (!(comment.equals(""))) {
                superHappyComment.setVisibility(View.INVISIBLE);
                happyComment.setVisibility(View.INVISIBLE);
                normalComment.setVisibility(View.VISIBLE);
                disappointedComment.setVisibility(View.INVISIBLE);
                sadComment.setVisibility(View.INVISIBLE);
            }
        } else if (mood == 3) {
            moodView1.setVisibility(View.VISIBLE);
            if (!(comment.equals(""))) {
                superHappyComment.setVisibility(View.INVISIBLE);
                happyComment.setVisibility(View.INVISIBLE);
                normalComment.setVisibility(View.INVISIBLE);
                disappointedComment.setVisibility(View.VISIBLE);
                sadComment.setVisibility(View.INVISIBLE);
            }
        } else if (mood == 4) {
            moodView0.setVisibility(View.VISIBLE);
            if (!(comment.equals(""))) {
                superHappyComment.setVisibility(View.INVISIBLE);
                happyComment.setVisibility(View.INVISIBLE);
                normalComment.setVisibility(View.INVISIBLE);
                disappointedComment.setVisibility(View.INVISIBLE);
                sadComment.setVisibility(View.VISIBLE);
            }
        }

        superHappyComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
            }
        });

        happyComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();

            }
        });

        normalComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
            }
        });

        disappointedComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
            }
        });

        sadComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
            }
        });


        ListView listMood = findViewById(R.id.listMood);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}

