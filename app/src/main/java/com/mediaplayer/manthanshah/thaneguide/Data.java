package com.mediaplayer.manthanshah.thaneguide;

public class Data {



    private String mLocationName;

    private String mLocationDiscription;

    private int mImageResourceId;

    private double mLatitude;

    private double mLongitude;

    public Data(String mLocationName, String mLocationDiscription, int mImageResourceId, Double mlatitude , Double mlongitude) {
        this.mLocationName = mLocationName;
        this.mLocationDiscription = mLocationDiscription;
        this.mImageResourceId = mImageResourceId;
        this.mLatitude = mlatitude;
        this.mLongitude = mlongitude;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public String getmLocationDiscription() {
        return mLocationDiscription;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public double getMLatitude() {
        return mLatitude;
    }

    public double getMLongitude() {
        return mLongitude;
    }
}
