package com.mediaplayer.manthanshah.thaneguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicPlacesFragment extends Fragment {


    public PublicPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thanelist, container, false);
        final ArrayList<Data> data = new ArrayList<>();

        data.add(new Data("Aaji-Aajoba Park", "Garden for elder people.", R.mipmap.aajiaajobapark, 19.193453, 72.973871));
        data.add(new Data("TMC Garden", "Garden for children's\nand adults.", R.mipmap.tmcgarden,19.246502, 72.966592 ));
        data.add(new Data("Ramdasrao Garden", "Garden for childrens.", R.mipmap.ramdasraogarden, 19.214579, 72.963126));
        data.add(new Data("Upvan Garden", "Garden based near\nupvan lake.", R.mipmap.upvangarden, 19.225499, 72.955817));

        placesAdapter placesAdapter = new placesAdapter(getActivity(), data);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Data data1 = data.get(position);

                String url = "http://maps.google.com/maps?daddr="+data1.getMLatitude()+","+data1.getMLongitude()+"&mode=driving";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        listView.setAdapter(placesAdapter);
        return rootView;
    }

}
