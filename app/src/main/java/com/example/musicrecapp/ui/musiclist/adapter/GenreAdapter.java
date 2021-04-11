package com.example.musicrecapp.ui.musiclist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.musicrecapp.ui.musiclist.model.Genre;
import com.example.musicrecapp.ui.musiclist.musiclistFragment;

import java.util.List;


public class GenreAdapter extends ArrayAdapter<Genre> {

    //private musiclistFragment context;
    private List<Genre> genreList;
    private Context context;

    public GenreAdapter(FragmentActivity context, int textViewResourceId,
                        List<Genre> values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.genreList = values;
    }

    public int getCount(){
        return genreList.size();
    }

    public Genre getItem(int position){
        return genreList.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(context);
        view.setTextColor(Color.BLACK);
        view.setGravity(Gravity.CENTER);
        view.setText(genreList.get(position).getCity());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView view = new TextView(context);
        view.setTextColor(Color.BLACK);
        view.setBackgroundColor(Color.WHITE);
        view.setGravity(Gravity.CENTER);
        view.setText(genreList.get(position).getCity());
        view.setHeight(60);

        return view;
    }
}
