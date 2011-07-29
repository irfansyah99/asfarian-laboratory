package com.example.gpssample;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class GPSSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Inisiasi LocationManager dan LocationListener
        LocationManager myLocationManager = 
        	(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener myLocationListener = new MyLocationListener();
        myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 
        		0, 0, myLocationListener);
   }

    /**
     * MyLocationListener
     */
    public class MyLocationListener implements LocationListener{
    	// Dipanggil saat ada perubahan lokasi geografis pengguna
		@Override
		public void onLocationChanged(Location location) {
			// Mendapatkan nilai latitude dari lokasi terbaru
			double latitude = location.getLatitude();
			
			// Mendapatkan nilai longitude dari lokasi terbaru
			double longitude = location.getLongitude();
			
			// Menampilkan lokasi terbaru menggunakan Toast
			String message = "Lokasi saat ini :\n" +
							 "Latitude  = " + latitude + "\n" +
							 "Longitude = " + longitude;
			Toast.makeText(getApplicationContext(), 
						   message, Toast.LENGTH_LONG).show();
		}

    	// Dipanggil saat provider dinon-aktifkan oleh pengguna
		@Override
		public void onProviderDisabled(String provider) {
			String message = "GPS disabled";
			Toast.makeText(getApplicationContext(), 
						   message, Toast.LENGTH_LONG).show();			
		}

		// dipanggil saat provider diaktifkan oleh pengguna
		@Override
		public void onProviderEnabled(String provider) {
			String message = "GPS enabled";
			Toast.makeText(getApplicationContext(), 
						   message, Toast.LENGTH_LONG).show();						
		}
		
		// dipanggil saat ada perubahan status pada provider
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub	
		}
    }
}

