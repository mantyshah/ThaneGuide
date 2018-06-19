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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.thanelist, container, false);


        final ArrayList<Data> data = new ArrayList<>();

        data.add(new Data("Tikuji Ni Wadi", "Tikuji-Ni-Wadi is an\namusement park.", R.mipmap.tikujiniwadi, 19.238302, 72.966846));
        data.add(new Data("Suraj Water Park", "Suraj Water Park is a\n17-acre water theme park.", R.mipmap.surajwaterpark,19.254311, 72.970526 ));
        data.add(new Data("Viviana Mall", "Biggest Shopping Mall of\nthane city.", R.mipmap.viviana, 19.208714, 72.971719));
        data.add(new Data("Talao Pali","This sizable, popular lake\n with a manmade island.", R.mipmap.talaopali, 19.192613, 72.975212));
        data.add(new Data("Upvan Lake", "Upvan is a lake famous for\nhosting Sanskruti Arts Festival.", R.mipmap.upvanlake,19.221729, 72.956027 ));
        data.add(new Data("Butterfly Garden", "Tranquil, small butterfly farm\nwith guided tours.", R.mipmap.butterflygarden, 19.270376, 72.955367));
        data.add(new Data("Ghodbunder Fort", "Ghodbunder Fort is a\nfort located in Ghodbunder Village.", R.mipmap.ghodbunderfort, 19.296460, 72.888311));

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
