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
public class ResidentialFragment extends Fragment {


    public ResidentialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thanelist, container, false);


        final ArrayList<Data> data = new ArrayList<>();

        data.add(new Data("The Byke Suraj Plaza", "Relaxed rooms in an\nupscale property.", R.mipmap.thebyke, 19.263124, 72.968874));
        data.add(new Data("Hotel Satkar Residency", "Relaxed hotel offering a\nrooftop pool & a hot tub.", R.mipmap.hotelsatkarresidency, 19.206020, 72.965788));
        data.add(new Data("Ginger Hotel", "Down-to-earth rooms\nin a straightforward hotel.", R.mipmap.gingerhotel, 19.207501, 72.977434));
        data.add(new Data("Tip Top Plaza", "Relaxed option offering informal rooms.", R.mipmap.tiptopplaza, 19.185668, 72.959619));
        data.add(new Data("Fortune Park Lake City", "Relaxed rooms in an\nupscale property.", R.mipmap.fortuneparklakecity, 19.209763, 72.972603));

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
