package com.shahzaib.punjaabi.Fragments;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shahzaib.punjaabi.Adapters.ColorListAdapter;
import com.shahzaib.punjaabi.Data.Colors;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {

    ListView listView;
    ColorListAdapter adapter;
    ArrayList<Colors> colorsArrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_colors,container,false);
        listView = view.findViewById(R.id.colorsListView);
        addData();// ******* add colors in arrayList
        adapter = new ColorListAdapter(colorsArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("123456","Item Clicked************");
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getContext(),colorsArrayList.get(position).getAudio());
                mediaPlayer.start();
            }
        });


        return view;
    }

    private void addData()
    {
        // ******* add colors in array
        colorsArrayList.add(new Colors("Red","Laal",R.drawable.color_red,R.raw.red));
        colorsArrayList.add(new Colors("Green","Hraa",R.drawable.color_green,R.raw.green));
        colorsArrayList.add(new Colors("Yellow","Peela",R.drawable.color_yellow,R.raw.yellow));
        colorsArrayList.add(new Colors("Blue","Nelaa",R.drawable.color_blue,R.raw.blue));
        colorsArrayList.add(new Colors("Black","Kala",R.drawable.color_black,R.raw.black));
        colorsArrayList.add(new Colors("White","Cheta",R.drawable.color_white,R.raw.white));
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(getContext(),R.raw.number_one); // just to prevent null medial player object
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("123456","onPause");
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}