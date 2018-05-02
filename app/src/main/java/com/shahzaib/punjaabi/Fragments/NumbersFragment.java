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

import com.shahzaib.punjaabi.Adapters.NumbersListAdapter;
import com.shahzaib.punjaabi.Data.Numbers;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    ListView listView;
    NumbersListAdapter adapter;
    ArrayList<Numbers> numbersArrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("123456","onCreateView is called");
        View view = inflater.inflate(R.layout.activity_numbers,container,false);
        listView = view.findViewById(R.id.numberListView);
        addData();// ******* add numbers in arrayList
        adapter = new NumbersListAdapter(numbersArrayList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("123456","Item Clicked************");
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getContext(),numbersArrayList.get(position).getAudio());
                mediaPlayer.start();
            }
        });

        return view;
    }


    private void addData()
    {
        // ******* add numbers in array
        numbersArrayList.add(new Numbers("One","ak",R.drawable.number_one,R.raw.number_one));
        numbersArrayList.add(new Numbers("Two","doo",R.drawable.number_two,R.raw.number_two));
        numbersArrayList.add(new Numbers("Three","ten",R.drawable.number_three,R.raw.number__three));
        numbersArrayList.add(new Numbers("Four","char",R.drawable.number_four,R.raw.number_four));
        numbersArrayList.add(new Numbers("Five","panj",R.drawable.number_five,R.raw.number__five));
        numbersArrayList.add(new Numbers("Six","chy",R.drawable.nubmer_six,R.raw.number_six));
        numbersArrayList.add(new Numbers("Seven","sat",R.drawable.number_seven,R.raw.number_seven));
        numbersArrayList.add(new Numbers("Eight","ath",R.drawable.number_eight,R.raw.number_eight));
        numbersArrayList.add(new Numbers("Nine","nao",R.drawable.number_nine,R.raw.number_nine));
        numbersArrayList.add(new Numbers("Ten","das",R.drawable.number__ten,R.raw.number_ten));
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