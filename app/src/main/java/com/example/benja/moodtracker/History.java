package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    public static final String PREF_KEY_COMMENT0 = "PREFERENCE_KEY_COMMENT0";
    public static final String PREF_KEY_COMMENT1 = "PREFERENCE_KEY_COMMENT1";
    public static final String PREF_KEY_COMMENT2 = "PREFERENCE_KEY_COMMENT2";
    public static final String PREF_KEY_COMMENT3 = "PREFERENCE_KEY_COMMENT3";
    public static final String PREF_KEY_COMMENT4 = "PREFERENCE_KEY_COMMENT4";
    public static final String PREF_KEY_COMMENT5 = "PREFERENCE_KEY_COMMENT5";
    public static final String PREF_KEY_COMMENT6 = "PREFERENCE_KEY_COMMENT6";

    public static final String PREF_KEY_COLOR0 = "PREFERENCE_KEY_COLOR0";
    public static final String PREF_KEY_COLOR1 = "PREFERENCE_KEY_COLOR1";
    public static final String PREF_KEY_COLOR2 = "PREFERENCE_KEY_COLOR2";
    public static final String PREF_KEY_COLOR3 = "PREFERENCE_KEY_COLOR3";
    public static final String PREF_KEY_COLOR4 = "PREFERENCE_KEY_COLOR4";
    public static final String PREF_KEY_COLOR5 = "PREFERENCE_KEY_COLOR5";
    public static final String PREF_KEY_COLOR6 = "PREFERENCE_KEY_COLOR6";
    public static final String PREF_KEY_MOOD = "PREFERENCE_KEY_MOOD";
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    final ArrayList<String> listOfComments = new ArrayList<>();
    public List<Integer> listOfMoods = new ArrayList<>();


    private ArrayList<Mood> moodsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);

        int cpt = mPreferences.getInt("counter", 0);

        if (cpt == 0) {

            //Extracting colors from SP
            int mood = (mPreferences.getInt(PREF_KEY_MOOD, 2)); //If no mood selected --> normal emoji chosen
            String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));
            int checking0;
            int checking1 = (mPreferences.getInt(PREF_KEY_COLOR1, 5)); //default value of 5 gets treated in History activity
            int checking2 = (mPreferences.getInt(PREF_KEY_COLOR2, 5));
            int checking3 = (mPreferences.getInt(PREF_KEY_COLOR3, 5));
            int checking4 = (mPreferences.getInt(PREF_KEY_COLOR4, 5));
            int checking5 = (mPreferences.getInt(PREF_KEY_COLOR5, 5));
            int checking6 = (mPreferences.getInt(PREF_KEY_COLOR6, 5));

            //extracting comments from SP
            String checkingComments0;
            String checkingComments1 = (mPreferences.getString(PREF_KEY_COMMENT1, "")); //default value "" to not display empty strings (gets treated in History activity)
            String checkingComments2 = (mPreferences.getString(PREF_KEY_COMMENT2, ""));
            String checkingComments3 = (mPreferences.getString(PREF_KEY_COMMENT3, ""));
            String checkingComments4 = (mPreferences.getString(PREF_KEY_COMMENT4, ""));
            String checkingComments5 = (mPreferences.getString(PREF_KEY_COMMENT5, ""));
            String checkingComments6 = (mPreferences.getString(PREF_KEY_COMMENT6, ""));

            //Setting comments in correct order with new comment
            checkingComments0 = checkingComments1;
            checkingComments1 = checkingComments2;
            checkingComments2 = checkingComments3;
            checkingComments3 = checkingComments4;
            checkingComments4 = checkingComments5;
            checkingComments5 = checkingComments6;
            checkingComments6 = comment;

            //Adding new order containing new comment into empty Arraylist
            listOfComments.add(checkingComments0);
            listOfComments.add(checkingComments1);
            listOfComments.add(checkingComments2);
            listOfComments.add(checkingComments3);
            listOfComments.add(checkingComments4);
            listOfComments.add(checkingComments5);
            listOfComments.add(checkingComments6);

            //Saving this list to SP
            for (int j = 0; j < listOfComments.size(); j++) {
                mPreferences.edit().putString("PREFERENCE_KEY_COMMENT" + j, listOfComments.get(j)).apply();
            }

            //Setting colors in correct order with new color
            checking0 = checking1;
            checking1 = checking2;
            checking2 = checking3;
            checking3 = checking4;
            checking4 = checking5;
            checking5 = checking6;
            checking6 = mood;

            //Adding new order containing new color into empty Arraylist
            listOfMoods.add(checking0);
            listOfMoods.add(checking1);
            listOfMoods.add(checking2);
            listOfMoods.add(checking3);
            listOfMoods.add(checking4);
            listOfMoods.add(checking5);
            listOfMoods.add(checking6);

            //Saving this list to SP
            for (int j = 0; j < listOfMoods.size(); j++) {
                mPreferences.edit().putInt("PREFERENCE_KEY_COLOR" + j, listOfMoods.get(j)).apply();
            }

            mPreferences.edit().putInt("PREFERENCE_KEY_COLOR", 2).apply();
            mPreferences.edit().putString("PREFERENCE_KEY_COMMENT", "").apply();

            mPreferences.edit().putInt("counter", 1).apply();
        }
        if (cpt == 2) {
            int mood = (mPreferences.getInt(PREF_KEY_MOOD, 2)); //If no mood selected --> normal emoji chosen
            String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));
            int checking0 = (mPreferences.getInt(PREF_KEY_COLOR0, 5));
            int checking1 = (mPreferences.getInt(PREF_KEY_COLOR1, 5)); //default value of 5 gets treated in History activity
            int checking2 = (mPreferences.getInt(PREF_KEY_COLOR2, 5));
            int checking3 = (mPreferences.getInt(PREF_KEY_COLOR3, 5));
            int checking4 = (mPreferences.getInt(PREF_KEY_COLOR4, 5));
            int checking5 = (mPreferences.getInt(PREF_KEY_COLOR5, 5));
            int checking6 = mood;

            //extracting comments from SP
            String checkingComments0 = (mPreferences.getString(PREF_KEY_COMMENT0, ""));
            String checkingComments1 = (mPreferences.getString(PREF_KEY_COMMENT1, "")); //default value "" to not display empty strings (gets treated in History activity)
            String checkingComments2 = (mPreferences.getString(PREF_KEY_COMMENT2, ""));
            String checkingComments3 = (mPreferences.getString(PREF_KEY_COMMENT3, ""));
            String checkingComments4 = (mPreferences.getString(PREF_KEY_COMMENT4, ""));
            String checkingComments5 = (mPreferences.getString(PREF_KEY_COMMENT5, ""));
            String checkingComments6 = comment;

            listOfComments.add(checkingComments0);
            listOfComments.add(checkingComments1);
            listOfComments.add(checkingComments2);
            listOfComments.add(checkingComments3);
            listOfComments.add(checkingComments4);
            listOfComments.add(checkingComments5);
            listOfComments.add(checkingComments6);

            //Saving this list to SP
            for (int j = 0; j < listOfComments.size(); j++) {
                mPreferences.edit().putString("PREFERENCE_KEY_COMMENT" + j, listOfComments.get(j)).apply();
            }

            listOfMoods.add(checking0);
            listOfMoods.add(checking1);
            listOfMoods.add(checking2);
            listOfMoods.add(checking3);
            listOfMoods.add(checking4);
            listOfMoods.add(checking5);
            listOfMoods.add(checking6);

            //Saving this list to SP
            for (int j = 0; j < listOfMoods.size(); j++) {
                mPreferences.edit().putInt("PREFERENCE_KEY_COLOR" + j, listOfMoods.get(j)).apply();
            }


        }

        //Retrieving the comments from SP
        String comment0 = (mPreferences.getString(PREF_KEY_COMMENT0, ""));
        String comment1 = (mPreferences.getString(PREF_KEY_COMMENT1, ""));
        String comment2 = (mPreferences.getString(PREF_KEY_COMMENT2, ""));
        String comment3 = (mPreferences.getString(PREF_KEY_COMMENT3, ""));
        String comment4 = (mPreferences.getString(PREF_KEY_COMMENT4, ""));
        String comment5 = (mPreferences.getString(PREF_KEY_COMMENT5, ""));
        String comment6 = (mPreferences.getString(PREF_KEY_COMMENT6, ""));

        //Retrieving the colors from SP
        int color0 = (mPreferences.getInt(PREF_KEY_COLOR0, 5));
        int color1 = (mPreferences.getInt(PREF_KEY_COLOR1, 5));
        int color2 = (mPreferences.getInt(PREF_KEY_COLOR2, 5));
        int color3 = (mPreferences.getInt(PREF_KEY_COLOR3, 5));
        int color4 = (mPreferences.getInt(PREF_KEY_COLOR4, 5));
        int color5 = (mPreferences.getInt(PREF_KEY_COLOR5, 5));
        int color6 = (mPreferences.getInt(PREF_KEY_COLOR6, 5));

        //Adding all that in an array
        moodsList.add(new Mood(comment6, color6));
        moodsList.add(new Mood(comment5, color5));
        moodsList.add(new Mood(comment4, color4));
        moodsList.add(new Mood(comment3, color3));
        moodsList.add(new Mood(comment2, color2));
        moodsList.add(new Mood(comment1, color1));
        moodsList.add(new Mood(comment0, color0));


        ListView listMood = findViewById(R.id.listViewMood);
        listMood.setAdapter(new MyCustomAdapter(History.this, moodsList));
    }

    //Creating custom ListView
    public class MyCustomAdapter extends ArrayAdapter {
        private Context context;
        private ArrayList<Mood> moodsList;


        MyCustomAdapter(Context context, ArrayList<Mood> moodsList) {
            super(context, R.layout.customlayout, moodsList);
            this.context = context;
            this.moodsList = moodsList;


        }

        @SuppressLint("InflateParams")
        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {

            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (inflater != null) {
                    view = inflater.inflate(R.layout.customlayout, null);
                }
            }
            Mood mood = moodsList.get(position);
            final String moodMessage = mood.getMoodMessage();
            Integer moodColor = mood.getMoodColor();

            //Retrieving textView and imageButton from the custom layout file
            assert view != null;
            TextView moodTextView = view.findViewById(R.id.moodTextView);
            ImageButton moodImageButton = view.findViewById(R.id.moodImageButton);


            //Giving the imageButton an image to display
            moodImageButton.setImageResource(R.drawable.ic_comment_black_48px);


            //Displaying the days through he listview
            String datesList[] = {"Today", "Yesterday", "2 days ago", "3 days ago", "4 days ago", "5 days ago", "6 days ago"};
            moodTextView.setText(datesList[position]);

            //Defining the width and color for every mood possible
            ViewGroup.LayoutParams params = moodTextView.getLayoutParams();
            if (moodColor == 0) {
                moodColor = R.color.banana_yellow;
                params.width = 1100;
            } else if (moodColor == 1) {
                moodColor = R.color.light_sage;
                params.width = 880;
            } else if (moodColor == 2) {
                moodColor = R.color.cornflower_blue_65;
                params.width = 660;
            } else if (moodColor == 3) {
                moodColor = R.color.warm_grey;
                params.width = 440;
            } else if (moodColor == 4) {
                moodColor = R.color.faded_red;
                params.width = 220;
            }
            moodTextView.setLayoutParams(params);

            //If a mood has been selected display it
            if (moodColor != 5) {
                moodTextView.setBackgroundColor(ContextCompat.getColor(History.this, moodColor));
            } else {
                moodTextView.setVisibility(View.INVISIBLE);
            }


            //If not message is input the comment button is set invisible
            if (moodMessage.equals("")) {
                moodImageButton.setVisibility(View.INVISIBLE);
            }


            //When one taps on the comment button a toast shall appear with the correct comment of the day
            moodImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(History.this, moodMessage, Toast.LENGTH_LONG).show();
                }
            });


            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return true;
    }
}



