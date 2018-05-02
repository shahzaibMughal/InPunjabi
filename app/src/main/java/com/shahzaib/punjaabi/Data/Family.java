package com.shahzaib.punjaabi.Data;

public class Family {
    String familyMemberInEnglish, familyMemberInPunjabi;
    int familyMemberPicture, audio;

    public Family(String familyMemberInEnglish, String familyMemberInPunjabi, int familyMemberPicture, int audio)
    {// add family member
        this.familyMemberInEnglish = familyMemberInEnglish;
        this.familyMemberInPunjabi = familyMemberInPunjabi;
        this.familyMemberPicture = familyMemberPicture;
        this.audio = audio;
    }

    public String getFamilyMemberInEnglish() {
        return familyMemberInEnglish;
    }

    public String getFamilyMemberInPunjabi() {
        return familyMemberInPunjabi;
    }

    public int getFamilyMemberPicture() {
        return familyMemberPicture;
    }

    public int getAudio() {
        return audio;
    }
}
