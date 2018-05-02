package com.shahzaib.punjaabi.Data;

public class Phrases {

    String phraseInEnglish, phraseInPunjabi;
    int audio;

    public Phrases(String phraseInEnglish, String phraseInPunjabi,int audio)
    {
        this.phraseInEnglish = phraseInEnglish;
        this.phraseInPunjabi = phraseInPunjabi;
        this.audio = audio;
    }

    public String getPhraseInEnglish() {
        return phraseInEnglish;
    }

    public String getPhraseInPunjabi() {
        return phraseInPunjabi;
    }

    public int getAudio() {
        return audio;
    }
}
