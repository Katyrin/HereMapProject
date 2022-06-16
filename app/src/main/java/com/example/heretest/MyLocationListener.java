package com.example.heretest;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

class MyLocationListener implements LocationListener {

    double longitudeMyLoc;
    double latitudeMyLoc;

    @Override
    public void onLocationChanged(Location loc) {
        longitudeMyLoc = loc.getLongitude();
        latitudeMyLoc = loc.getLatitude();

        String longitude = "Longitude: " + loc.getLongitude();
        Log.v(TAG, longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.v(TAG, latitude);

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider,
                                int status, Bundle extras) {
        // TODO Auto-generated method stub
    }
}
