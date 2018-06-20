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
public class ResturantFragment extends Fragment {


    public ResturantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thanelist, container, false);

        final ArrayList<Data> data = new ArrayList<>();
        data.add(new Data("Veggies", "Pure veg restaurant\nspecialised in south indian food.", R.mipmap.veggies,19.204632, 72.977165 ));
        data.add(new Data("Mahesh Lunch Home", "Non veg restaurant\nspecialised in sea food.", R.mipmap.mahesh, 19.208077, 72.963779 ));
        data.add(new Data("Utsav", "Pure veg restaurant\nspecialisedin italian foods.", R.mipmap.utsav,19.194644, 72.966578));
        data.add(new Data("Prasant Corner", "Pure veg restaurant\nspecialised in Indian street foods.", R.mipmap.prashantcorner,19.193363, 72.967380 ));
        data.add(new Data("Veg Sizzels", "Pure veg restaurant\nspecialised in sizzlers", R.mipmap.vegsizzels,19.225708, 72.970307 ));
        data.add(new Data("Kath N Ghat" , "Non veg restaurant\nspecialised in maharashtrian cuisine", R.mipmap.kathnghat, 19.196858, 72.962963));

        placesAdapter placesAdapter = new placesAdapter(getActivity(), data, R.color.category_resturant);

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
