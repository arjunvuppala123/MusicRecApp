package com.example.musicrecapp.ui.musiclist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.example.musicrecapp.R;
import com.example.musicrecapp.ui.musiclist.model.Song;
import java.util.ArrayList;
import java.util.List;



public class SongAdapter extends BaseAdapter implements Filterable {

    private final LayoutInflater mLayoutInflater;
    private List<Song> SongList;
    private final List<Song> SongFilterList;
    private SongFilter SongFilter;

    public SongAdapter(Context context, List data){
        SongList = data;
        SongFilterList=data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public SongAdapter(LayoutInflater mLayoutInflater, List songFilterList) {
        this.mLayoutInflater = mLayoutInflater;
        SongFilterList = songFilterList;
    }

    @Override
    public int getCount() {
        return SongList.size();
    }

    @Override
    public Song getItem(int position) {
        return (Song) SongList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View updateView;
        ViewHolder viewHolder;
        if (view == null) {
            updateView = mLayoutInflater.inflate(R.layout.address_listitem, null);
            viewHolder = new ViewHolder();

            viewHolder.tvName = (TextView) updateView.findViewById(R.id.nameTV);
            viewHolder.tvArea = (TextView) updateView.findViewById(R.id.areaTV);
            viewHolder.tvStreet = (TextView) updateView.findViewById(R.id.streetTv);

            updateView.setTag(viewHolder);

        } else {
            updateView = view;
            viewHolder = (ViewHolder) updateView.getTag();
        }

        final Song item = getItem(position);

            viewHolder.tvName.setText(item.getsongName());
            viewHolder.tvArea.setText(item.getartistName());
            viewHolder.tvStreet.setText(String.valueOf(item.getGenre()));


        return updateView;

    }

    @Override
    public Filter getFilter() {
        if (SongFilter == null) {
            SongFilter = new SongFilter();
        }
        return SongFilter;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvArea;
        TextView tvStreet;

    }

    private class SongFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            long genreId= Long.parseLong(constraint.toString());
            FilterResults results = new FilterResults();

            if (genreId > 0) {
                ArrayList<Song> filterList = new ArrayList<>();
                for (int i = 0; i < SongFilterList.size(); i++) {

                    if ( (SongFilterList.get(i).getGenreId() )== genreId) {

                        Song Song = SongFilterList.get(i);
                        filterList.add(Song);
                    }
                }

                results.count = filterList.size();
                results.values = filterList;

            } else {

                results.count = SongFilterList.size();
                results.values = SongFilterList;

            }
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            SongList = (ArrayList<Song>)results.values;
            notifyDataSetChanged();
        }
    }
}

