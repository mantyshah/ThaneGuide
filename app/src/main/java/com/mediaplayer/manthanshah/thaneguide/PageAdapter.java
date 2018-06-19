package com.mediaplayer.manthanshah.thaneguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public Fragment getItem(int position) {

        if (position == 0)
        {
            return new ResturantFragment();
        }

        else if(position == 1)
        {
            return new ResidentialFragment();
        }
        else if (position == 2)
        {
            return new AttractionsFragment();
        }
        else
        {
            return new PublicPlacesFragment();
        }
    }

    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 1) {
            return mContext.getString(R.string.category_hotels);
        } else if (position == 2) {
            return mContext.getString(R.string.category_attractions);
        } else {
            return mContext.getString(R.string.category_gardens);
        }
    }
}
