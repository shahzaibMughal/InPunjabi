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

import com.shahzaib.punjaabi.Adapters.FamilyListAdapter;
import com.shahzaib.punjaabi.Data.Family;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class FamilyFragment extends Fragment {

    ListView listView;
    FamilyListAdapter adapter;
    ArrayList<Family> familyArrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_family,container,false);
        listView = view.findViewById(R.id.familyListView);
        addData();// ******* add family Members in arrayList
        adapter = new FamilyListAdapter(familyArrayList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("123456","Item Clicked************");
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getContext(),familyArrayList.get(position).getAudio());
                mediaPlayer.start();
            }
        });

        return view;
    }

    private void addData()
    {
        // ******* add family members in array
        familyArrayList.add(new Family("Father","Abba",R.drawable.family,R.raw.fatherr));
        familyArrayList.add(new Family("Mother","Amma",R.drawable.family,R.raw.mother));
        familyArrayList.add(new Family("Brother","Praa",R.drawable.family,R.raw.brother));
        familyArrayList.add(new Family("Sister","peen",R.drawable.family,R.raw.sister));
        familyArrayList.add(new Family("Son","Puter",R.drawable.family,R.raw.son));
        familyArrayList.add(new Family("Wife","wooti",R.drawable.family,R.raw.wifee));
        familyArrayList.add(new Family("Brother In Law","Sala",R.drawable.family,R.raw.brother_in_law));
        familyArrayList.add(new Family("Father in Law","Saura",R.drawable.family,R.raw.father_in_law));
        familyArrayList.add(new Family("Mother in Law","Sas",R.drawable.family,R.raw.mother_in_law));
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
