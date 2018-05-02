package com.shahzaib.punjaabi.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shahzaib.punjaabi.Data.Numbers;
import com.shahzaib.punjaabi.Data.Phrases;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class PhrasesListAdapter extends BaseAdapter {

    ArrayList<Phrases> phrasesArrayList;

    public PhrasesListAdapter(ArrayList<Phrases> phrasesArrayList)
    {
        this.phrasesArrayList = phrasesArrayList;
    }


    @Override
    public int getCount() {
        return phrasesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null)
        {// convertView is old view for recycle
            Log.i("123456","View is inflated");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_activity_phrases,parent,false);
        }
        else
        {
            Log.i("123456","View is Recycled");
            view = convertView;
        }

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("123456","Item Clicked");
//            }
//        });
        Phrases currentItem = phrasesArrayList.get(position);

        ((TextView)view.findViewById(R.id.phraseInPunjabiTV)).setText(currentItem.getPhraseInPunjabi());
        ((TextView)view.findViewById(R.id.phraseInEnglishTV)).setText(currentItem.getPhraseInEnglish());
        return view;
    }
}