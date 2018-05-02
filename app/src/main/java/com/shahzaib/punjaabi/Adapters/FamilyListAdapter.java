package com.shahzaib.punjaabi.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shahzaib.punjaabi.Data.Family;
import com.shahzaib.punjaabi.Data.Numbers;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class FamilyListAdapter extends BaseAdapter {

    ArrayList<Family> familyArrayList;

    public FamilyListAdapter(ArrayList<Family> familyArrayList)
    {
        this.familyArrayList = familyArrayList;
    }


    @Override
    public int getCount() {
        return familyArrayList.size();
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_activity_family,parent,false);
        }
        else
        {
            Log.i("123456","View is Recycled");
            view = convertView;
        }

        Family currentItem = familyArrayList.get(position);

        ((TextView)view.findViewById(R.id.familyMemberInPunjabiTV)).setText(currentItem.getFamilyMemberInPunjabi());
        ((TextView)view.findViewById(R.id.familyMemberInEnglishTV)).setText(currentItem.getFamilyMemberInEnglish());
        ((ImageView)view.findViewById(R.id.familyMemberPicture)).setImageResource(currentItem.getFamilyMemberPicture());

        return view;
    }
}