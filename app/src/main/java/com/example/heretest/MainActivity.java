package com.example.heretest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.mapviewlite.MapSceneConfig;
import com.here.sdk.mapviewlite.MapStyle;
import com.here.sdk.mapviewlite.MapViewLite;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private PermissionsRequestor permissionsRequestor;
    private MapViewLite mapView;
    private HereMap hereMap;
    static EditText nameAddress;
    private String addressStr;
    static EditText nameAddress2;
    private String addressStr2;
    private Truck truck = new Truck();
    private AdView adView;
    private static final String AD_UNIT_ID = "ca-app-pub-3678485328369090/8334203630";
    static Dialog dialog;
    static TextView textRout;
    static String carName;
    private Dialog dialog2;
    private TextView textViewTime;
    private TextView textViewAdditions;
    static String textViewTimeStr;
    static String textViewAdditionsStr;
    static Dialog pointDialog;
    static int choicePointBoolean;
    public static final int NIGHT = 1;
    public static final int COLD = 2;
    public static final int APPAREL = 3;
    static String withApparel = "";
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameAddress = findViewById(R.id.editText);
        Button searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(v -> {
            addressStr = String.valueOf(nameAddress.getText());
            geocodeAnAddressButtonClicked(findViewById(R.id.searchBtn), addressStr);
        });
        nameAddress2 = findViewById(R.id.editText2);
        Button searchBtn2 = findViewById(R.id.searchBtn2);
        searchBtn2.setOnClickListener(v -> {
            addressStr2 = String.valueOf(nameAddress2.getText());
            geocodeAnAddressButtonClicked2(findViewById(R.id.searchBtn2), addressStr2);
        });

        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        handleAndroidPermissions();
        carName = "Газель тент (до 1,6м)";
        setTitle(carName);
        truck.onClickGazelleTent();

        nameAddress.setOnEditorActionListener((v, actionId, event) -> {
            // TODO Auto-generated method stub
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //Call your method here
                addressStr = String.valueOf(nameAddress.getText());
                geocodeAnAddressButtonClicked(findViewById(R.id.searchBtn), addressStr);
                if (getCurrentFocus() != null) {
                    getSystemService(Context.INPUT_METHOD_SERVICE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return true;
            }
            return false;
        });

        nameAddress2.setOnEditorActionListener((v, actionId, event) -> {
            // TODO Auto-generated method stub
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //Call your method here
                addressStr2 = String.valueOf(nameAddress2.getText());
                geocodeAnAddressButtonClicked2(findViewById(R.id.searchBtn2), addressStr2);
                if (getCurrentFocus() != null) {
                    getSystemService(Context.INPUT_METHOD_SERVICE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return true;
            }
            return false;
        });
        //Avertising
        MobileAds.initialize(this, initializationStatus -> {
        });
        FrameLayout adContainerView = findViewById(R.id.ad_view_container);

        adView = new AdView(this);
        adView.setAdUnitId(AD_UNIT_ID);
        adContainerView.addView(adView);
        loadBanner();

        // Оформление заявок
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.rout_dialog_layout);
        Button shareBtn = dialog.findViewById(R.id.shareBtn);
        textRout = dialog.findViewById(R.id.textView);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialog2.show();
                captureScreen();
            }
        });
        dialog2 = new Dialog(MainActivity.this);
        dialog2.setContentView(R.layout.rout_dialog_layout2);
        Button shareBtn2 = dialog2.findViewById(R.id.shareBtn2);
        textViewTime = dialog2.findViewById(R.id.textViewTime2);
        textViewAdditions = dialog2.findViewById(R.id.textViewAdditions);
        shareBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTimeStr = String.valueOf(textViewTime.getText());
                textViewAdditionsStr = String.valueOf(textViewAdditions.getText());
                if (textViewTimeStr.equals(new String(""))) {
                    Toast.makeText(getApplicationContext(), "Введи время погрузки", Toast.LENGTH_SHORT).show();
                } else {
                    textViewTimeStr = String.valueOf(textViewTime.getText());
                    textViewAdditionsStr = String.valueOf(textViewAdditions.getText());
                    String shareText = textViewTimeStr + " нужен автомобиль: " + carName + "\nАдрес погрузки: " + HereMap.addressStart +
                            "\nАдрес выгрузки: " + HereMap.addressDestination + HereMap.shareTextRout + "\n" + textViewAdditionsStr;

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(url));
                    sendIntent.setPackage("org.telegram.messenger");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    sendIntent.setType("image/png");
                    startActivity(Intent.createChooser(sendIntent, "Share with Friends"));

                    dialog2.cancel();
                    textViewTime.setText(null);
                    textViewAdditions.setText(null);
                }
            }
        });
        // long tap - choice points dialog
        pointDialog = new Dialog(MainActivity.this);
        pointDialog.setContentView(R.layout.choice_point);
        Button startBtn = pointDialog.findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePointBoolean = 0;
                pointDialog.cancel();
                hereMap.addPoiMapMarkerStart(HereMap.geoCoordinatesPoint);
                hereMap.getAddressForCoordinates(HereMap.geoCoordinatesPoint);
            }
        });
        Button destinationBtn = pointDialog.findViewById(R.id.destinationBtn);
        destinationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePointBoolean = 1;
                pointDialog.cancel();
                hereMap.addPoiMapMarkerDestination(HereMap.geoCoordinatesPoint);
                hereMap.getAddressForCoordinates(HereMap.geoCoordinatesPoint);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trucks, menu);

        MenuItem night = menu.add(0,NIGHT,0,"Ночной тариф");
        night.setCheckable(true);
        MenuItem cold = menu.add(0,COLD,0,"Морозный тариф");
        cold.setCheckable(true);
        MenuItem apparel = menu.add(0,APPAREL,0,"Аппарель");
        apparel.setCheckable(true);
        return true;
    }

    private void handleAndroidPermissions() {
        permissionsRequestor = new PermissionsRequestor(this);
        permissionsRequestor.request(new PermissionsRequestor.ResultListener(){

            @Override
            public void permissionsGranted() {
                loadMapScene();
            }

            @Override
            public void permissionsDenied() {
                Log.e(TAG, "Permissions denied by user.");
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsRequestor.onRequestPermissionsResult(requestCode, grantResults);
    }

private void loadMapScene() {
    // Load a scene from the SDK to render the map with a map style.
    MapSceneConfig mapSceneConfig = new MapSceneConfig();
    mapSceneConfig.mainLanguageCode = LanguageCode.RU_RU;
    mapSceneConfig.fallbackLanguageCode = LanguageCode.RU_RU;

    mapView.getMapScene().loadScene(MapStyle.NORMAL_DAY, mapSceneConfig, errorCode -> {
        if (errorCode == null) {
            hereMap = new HereMap(MainActivity.this, mapView);
            hereMap.showMapPolygon();
        } else {
            Log.d(TAG, "onLoadScene failed: " + errorCode.toString());
        }
    });
}

    public void searchExampleButtonClicked(View view, String s) {
        hereMap.onSearchButtonClicked(s);
    }

    public void geocodeAnAddressButtonClicked(View view, String s) {
        hereMap.onGeocodeButtonClicked(s);
    }
    public void geocodeAnAddressButtonClicked2(View view, String s2) {
        hereMap.onGeocodeButtonClicked2(s2);
    }

    //нижние три функции относятся к классу RoutingExample
    public void addRouteButtonClicked(View view) {
           if (HereMap.startGeoCoordinates == null && HereMap.destinationGeoCoordinates == null) {
               Toast.makeText(getApplicationContext(), "Введите адрес погрузки и адрес выгрузки чтобы построить маршрут", Toast.LENGTH_SHORT).show();
               return;
           }
           if (HereMap.startGeoCoordinates == null) {
               Toast.makeText(getApplicationContext(), "Введите адрес погрузки чтобы построить маршрут", Toast.LENGTH_SHORT).show();
               return;
           }
           if (HereMap.destinationGeoCoordinates == null) {
               Toast.makeText(getApplicationContext(), "Введите адрес выгрузки чтобы построить маршрут", Toast.LENGTH_SHORT).show();
           } else {
               hereMap.addRoute();
           }


    }

    public void addWaypointsButtonClicked(View view) {
        hereMap.addWaypoints();
    }

    public void clearMapButtonClicked(View view) {
        nameAddress.setText(null);
        nameAddress2.setText(null);
        HereMap.startGeoCoordinates = null;
        HereMap.destinationGeoCoordinates = null;
        hereMap.clearMarker();
        hereMap.clearMap();
    }

    @Override
    protected void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        if (adView != null) {
            adView.resume();
        }
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
        mapView.onDestroy();
    }

//menu**********************************************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==R.id.gazelle_tent){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleTent();
        }else if (id==R.id.gazelle_thermos){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleThermos();
        }else if (id==R.id.gazelle_height){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleHeight();
        }else if (id==R.id.gazelle_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleBoard();
        }else if (id==R.id.gazelle_farmer){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleFarmer();
        }else if (id==R.id.gazelle_ref){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleRef();
        }else if (id==R.id.gazelle_pyramid){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazellePyramid();
        }else if (id==R.id.gazelle_towing){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleTrowing();
        }
        else if (id==R.id.gazelle_long_original){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongOriginal();
        }else if (id==R.id.gazelle_long_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongBoard();
        }else if (id==R.id.gazelle_long_farmer){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongFarmer();
        }else if (id==R.id.gazelle_long_ref){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongRef();
        }else if (id==R.id.gazelle_long_pyramid){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongPyramid();
        }else if (id==R.id.gazelle_long_height){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongHaight();
        }else if (id==R.id.gazelle_long_long){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickGazelleLongLong();
        }
        else if (id==R.id.ton_2_original){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Original();
        }else if (id==R.id.ton_2_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Board();
        }else if (id==R.id.ton_2_farmer){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Farmer();
        }else if (id==R.id.ton_2_ref){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Ref();
        }else if (id==R.id.ton_2_pyramid){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Pyramid();
        }else if (id==R.id.ton_2_height){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Haight();
        }else if (id==R.id.ton_2_long){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon2Long();
        }
        else if (id==R.id.ton_3_original_mini){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3OriginalMini();
        }else if (id==R.id.ton_3_original_maxi){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3OriginalMaxi();
        }else if (id==R.id.ton_3_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3Board();
        }else if (id==R.id.ton_3_farmer){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3Farmer();
        }else if (id==R.id.ton_3_ref){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3Ref();
        }else if (id==R.id.ton_3_multi_ref){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3MultiRef();
        }else if (id==R.id.ton_3_pyramid){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3Pyramid();
        }else if (id==R.id.ton_3_long){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon3Long();
        }
        else if (id==R.id.ton_5_mini){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5Mini();
        }else if (id==R.id.ton_5_medium){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5Medium();
        }else if (id==R.id.ton_5_maxi){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5Maxi();
        }else if (id==R.id.ton_5_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5Board();
        }else if (id==R.id.ton_5_ref_mini){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5RefMini();
        }else if (id==R.id.ton_5_ref_maxi){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon5RefMaxi();
        }
        else if (id==R.id.ton_7_min){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon7Min();
        }else if (id==R.id.ton_7_max){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon7Max();
        }else if (id==R.id.ton_7_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon7Board();
        }else if (id==R.id.ton_7_ref_min){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon7RefMin();
        }else if (id==R.id.ton_7_ref_max){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon7RefMax();
        }
        else if (id==R.id.ton_10_min){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon10Min();
        }else if (id==R.id.ton_10_max){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon10Max();
        }else if (id==R.id.ton_10_board){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon10Board();
        }else if (id==R.id.ton_10_ref_min){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon10RefMin();
        }else if (id==R.id.ton_10_ref_max){
            carName = item.getTitle().toString();
            setTitle(carName);
            truck.onClickTon10RefMax();
        }

        if (id==NIGHT){
            item.setChecked(!item.isChecked());
            if (item.isChecked()){
                Truck.nightPrice = 100;
            }
            else{
                Truck.nightPrice = 0;
            }
        }
        if (id==COLD) {
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                Truck.coldPrice = 100;
                Truck.coldKm25 = 2;
                Truck.coldKm = 2;
            } else {
                Truck.coldPrice = 0;
                Truck.coldKm25 = 0;
                Truck.coldKm = 0;
            }
        }
        if (id==APPAREL) {
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                Truck.apparelPrice = 100;
                Truck.apparelKm25 = 2;
                Truck.apparelKm = 2;
                withApparel = " с АППАРЕЛЬЮ";
            } else {
                Truck.apparelPrice = 0;
                Truck.apparelKm25 = 0;
                Truck.apparelKm = 0;
                withApparel="";
            }
        }
        if (HereMap.destinationGeoCoordinates!=null && HereMap.startGeoCoordinates!=null){
            hereMap.invisibleAddRoute();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadBanner() {
        List<String> testDevices = new ArrayList<>();
        testDevices.add(AdRequest.DEVICE_ID_EMULATOR);
        RequestConfiguration requestConfiguration
                = new RequestConfiguration.Builder()
                .setTestDeviceIds(testDevices)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);
        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);
        adView.loadAd(new AdRequest.Builder().build());
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    private void captureScreen() {
        MapViewLite.CaptureScreenshotCallback mcs = bitmap -> {
            Context context = getApplicationContext();
            url = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "screenshot", null);
        };
        mapView.captureScreenshot( mcs);
    }
}
