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

    public void setMoodMessage(String moodMessage) {
        this.moodMessage = moodMessage;
    }

    public void setMoodColor(Integer moodColor) {
        this.moodColor = moodColor;
    }

    public Mood(String moodMessage, Integer moodColor) {
        this.moodMessage = moodMessage;
        this.moodColor = moodColor;
    }
}
