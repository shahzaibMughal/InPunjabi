package com.shahzaib.punjaabi.Data;

public class Colors {
    String colorInEnglish, colorInPunjabi;
    int colorPicture, audio;

    public Colors(String colorInEnglish, String colorInPunjabi, int colorPicture, int audio)
    {
        this.colorInEnglish = colorInEnglish;
        this.colorInPunjabi = colorInPunjabi;
        this.colorPicture = colorPicture;
        this.audio = audio;
    }


    public String getColorInEnglish() {
        return colorInEnglish;
    }

    public String getColorInPunjabi() {
        return colorInPunjabi;
    }

    public int getColorPicture() {
        return colorPicture;
    }

    public int getAudio() {
        return audio;
    }
}
