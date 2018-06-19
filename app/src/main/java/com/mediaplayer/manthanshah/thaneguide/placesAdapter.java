package com.mediaplayer.manthanshah.thaneguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class placesAdapter extends ArrayAdapter {
    public placesAdapter(Context context, ArrayList<Data> words, int colorResourceId) {
        super(context, 0, words);
    }

    public placesAdapter(Activity context, ArrayList<Data> data) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,  false);
        }

        Data data = (Data) getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nameText);
        nameTextView.setText(data.getmLocationName());

        TextView discriptionTextView = (TextView) listItemView.findViewById(R.id.discriptionText);
        discriptionTextView.setText(data.getmLocationDiscription());

        ImageView icon = listItemView.findViewById(R.id.icon);
        icon.setImageResource(data.getmImageResourceId());

        return listItemView;


    }
}
