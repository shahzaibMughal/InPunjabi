package com.shahzaib.punjaabi.Fragments;

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

import com.shahzaib.punjaabi.Adapters.PhrasesListAdapter;
import com.shahzaib.punjaabi.Data.Phrases;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {

    ListView listView;
    PhrasesListAdapter adapter;
    ArrayList<Phrases> phrasesArrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_phrases,container,false);
        listView = view.findViewById(R.id.phrasesListView);
        addData();// ******* add phrases in arrayList
        adapter = new PhrasesListAdapter(phrasesArrayList);
        listView.setAdapter(adapter);
        Log.i("123456","OnCreateView");



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("123456","Item Clicked************");
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getContext(),phrasesArrayList.get(position).getAudio());
                mediaPlayer.start();
            }
        });



        return view;
    }

    private void addData() {
        //**** add phrases in arrayList
        phrasesArrayList.add(new Phrases("Who r u?", "Kon an tu?",R.raw.who_r_u));
        phrasesArrayList.add(new Phrases("How r u?", "Ki hal e?",R.raw.how_r_u));
        phrasesArrayList.add(new Phrases("May i come in?", "aaavan?",R.raw.may_i_come));
        phrasesArrayList.add(new Phrases("Get lost !", "Paaaat ja!",R.raw.get_lost));
        phrasesArrayList.add(new Phrases("Hello!", "Oye",R.raw.hello));
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
