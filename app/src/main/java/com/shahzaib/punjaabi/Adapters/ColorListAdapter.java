package com.shahzaib.punjaabi.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shahzaib.punjaabi.Data.Colors;
import com.shahzaib.punjaabi.R;

import java.util.ArrayList;

public class ColorListAdapter  extends BaseAdapter {

    ArrayList<Colors> colorsArrayList;

    public ColorListAdapter(ArrayList<Colors> colorsArrayList)
    {
        this.colorsArrayList = colorsArrayList;
    }


    @Override
    public int getCount() {
        return colorsArrayList.size();
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_activity_colors,parent,false);
        }
        else
        {
            Log.i("123456","View is Recycled");
            view = convertView;
        }

        Colors currentItem = colorsArrayList.get(position);

        ((TextView)view.findViewById(R.id.colorInPunjabiTV)).setText(currentItem.getColorInPunjabi());
        ((TextView)view.findViewById(R.id.colorInEnglishTV)).setText(currentItem.getColorInEnglish());
        ((ImageView)view.findViewById(R.id.colorPicture)).setImageResource(currentItem.getColorPicture());

        return view;
    }
}