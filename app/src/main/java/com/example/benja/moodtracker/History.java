package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class History extends AppCompatActivity {
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ListView listMood = findViewById(R.id.listMood);
        listMood.setAdapter(new MyCustomAdapter(this));


    }

    public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
        private Context context;

        MyCustomAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return pos;
            //return 0 if list items do not have an Id variable.
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                view = inflater.inflate(R.layout.customlayout, null);
            }


            //Handle buttons and add onClickListeners
            ImageButton superHappyButton = view.findViewById(R.id.superHappyComment4);
            ImageButton happyButton = view.findViewById(R.id.happyComment3);
            ImageButton normalButton = view.findViewById(R.id.normalComment2);
            ImageButton disappointedButton = view.findViewById(R.id.disappointedComment1);
            ImageButton sadButton = view.findViewById(R.id.sadComment0);

            SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
            final String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));


            superHappyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
                    //do something
                    notifyDataSetChanged();
                }
            });
            happyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
                    //do something
                    notifyDataSetChanged();

                }
            });
            normalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
                    //do something
                    notifyDataSetChanged();

                }
            });
            disappointedButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
                    //do something
                    notifyDataSetChanged();

                }
            });
            sadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_LONG).show();
                    //do something
                    notifyDataSetChanged();

                }
            });

            //Retrieving the different TextViews that will display depending on the != moods
            TextView moodView4 = view.findViewById(R.id.moodView44);
            TextView moodView3 = view.findViewById(R.id.moodView33);
            TextView moodView2 = view.findViewById(R.id.moodView22);
            TextView moodView1 = view.findViewById(R.id.moodView11);
            TextView moodView0 = view.findViewById(R.id.moodView00);

            moodView0.setVisibility(View.INVISIBLE);
            moodView1.setVisibility(View.INVISIBLE);
            moodView2.setVisibility(View.INVISIBLE);
            moodView3.setVisibility(View.INVISIBLE);
            moodView4.setVisibility(View.INVISIBLE);

            //Retrieving the comment icons which will be displayed if a comment has been input
            @SuppressLint("CutPasteId") ImageButton superHappyComment = view.findViewById(R.id.superHappyComment4);
            @SuppressLint("CutPasteId") ImageButton happyComment = view.findViewById(R.id.happyComment3);
            @SuppressLint("CutPasteId") ImageButton normalComment = view.findViewById(R.id.normalComment2);
            @SuppressLint("CutPasteId") ImageButton disappointedComment = view.findViewById(R.id.disappointedComment1);
            @SuppressLint("CutPasteId") ImageButton sadComment = view.findViewById(R.id.sadComment0);

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


            return view;
        }

    }
}

