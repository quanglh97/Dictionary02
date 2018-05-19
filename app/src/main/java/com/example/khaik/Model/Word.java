package com.example.khaik.Model;

import java.io.Serializable;

/**
 * Created by Admin on 4/20/2018.
 */

public class Word implements Serializable {
    private int mID;
    private String mWord;
    private String mMean;


    public Word(int mID, String mWord, String mMean) {
        this.mID = mID;
        this.mWord = mWord;
        this.mMean = mMean;
    }

    public Word(String mWord, String mMean)
    {
        this.mWord = mWord;
        this.mMean = mMean;
    }

    public Word() {
    }

    public int getmID() {
        return mID;
    }

    public String getmWord() {
        return mWord;
    }

    public String getmMean() {
        return mMean;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    public void setmMean(String mMean) {
        this.mMean = mMean;
    }
}

