package com.example.benja.moodtracker;

public class Mood {
    private String moodMessage;
    private Integer moodColor;

    public String getMoodMessage() {
        return moodMessage;
    }

    public Integer getMoodColor() {
        return moodColor;
    }


    Mood(String moodMessage, Integer moodColor) {
        this.moodMessage = moodMessage;
        this.moodColor = moodColor;
    }
}
