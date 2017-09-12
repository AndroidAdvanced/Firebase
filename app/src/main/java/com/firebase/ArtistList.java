package com.firebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rupal on 9/12/2017.
 */

public class ArtistList extends ArrayAdapter<Artist> {

    public Activity activity;
    public List<Artist> artistList;

    public ArtistList(Activity context, List<Artist> artistList) {
        super(context, R.layout.list_layout, artistList);

        this.activity = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View view = inflater.inflate(R.layout.list_layout, null, true);


        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtGenre = (TextView) view.findViewById(R.id.txtGenre);

        Artist artist = artistList.get(position);


        txtName.setText("" + artist.getArtistName());
        txtGenre.setText("" + artist.getArtistGenre());

        return view;
    }
}
