package com.shahzaib.punjaabi.Data;

public class Numbers {

    String numberInEnglish, numberInPunjabi;
    int numberPicture, audio;

    public Numbers(String numberInEnglish, String numberInPunjabi, int numberPicture, int audio)
    {
        this.numberInEnglish = numberInEnglish;
        this.numberInPunjabi = numberInPunjabi;
        this.numberPicture = numberPicture;
        this.audio = audio;
    }

    public String getNumberInEnglish() {
        return numberInEnglish;
    }

    public String getNumberInPunjabi() {
        return numberInPunjabi;
    }

    public int getNumberPicture() {
        return numberPicture;
    }

    public int getAudio() {
        return audio;
    }
}
