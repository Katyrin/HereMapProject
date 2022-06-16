package com.example.heretest;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.CustomMetadataValue;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCircle;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.Metadata;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.TextFormat;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.gestures.GestureState;
import com.here.sdk.mapviewlite.Camera;
import com.here.sdk.mapviewlite.CameraUpdate;
import com.here.sdk.mapviewlite.MapImage;
import com.here.sdk.mapviewlite.MapImageFactory;
import com.here.sdk.mapviewlite.MapMarker;
import com.here.sdk.mapviewlite.MapMarkerImageStyle;
import com.here.sdk.mapviewlite.MapPolygon;
import com.here.sdk.mapviewlite.MapPolyline;
import com.here.sdk.mapviewlite.MapPolylineStyle;
import com.here.sdk.mapviewlite.MapScene;
import com.here.sdk.mapviewlite.MapViewLite;
import com.here.sdk.mapviewlite.Padding;
import com.here.sdk.mapviewlite.PixelFormat;
import com.here.sdk.routing.Maneuver;
import com.here.sdk.routing.ManeuverAction;
import com.here.sdk.routing.Route;
import com.here.sdk.routing.RoutingEngine;
import com.here.sdk.routing.Section;
import com.here.sdk.routing.Waypoint;
import com.here.sdk.search.Address;
import com.here.sdk.search.AutosuggestEngine;
import com.here.sdk.search.AutosuggestOptions;
import com.here.sdk.search.AutosuggestResult;
import com.here.sdk.search.AutosuggestResultType;
import com.here.sdk.search.GeocodingEngine;
import com.here.sdk.search.GeocodingOptions;
import com.here.sdk.search.GeocodingResult;
import com.here.sdk.search.ReverseGeocodingEngine;
import com.here.sdk.search.ReverseGeocodingOptions;
import com.here.sdk.search.SearchCategory;
import com.here.sdk.search.SearchEngine;
import com.here.sdk.search.SearchOptions;
import com.here.sdk.search.SearchResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class HereMap {

    private static final String LOG_TAG = HereMap.class.getName();

    private final Context context;
    private final MapViewLite mapView;
    private final List<MapMarker> mapMarkerList = new ArrayList<>();
    private final SearchEngine searchEngine;
    private final AutosuggestEngine autosuggestEngine;
    private final GeocodingEngine geocodingEngine;
    private final GeocodingEngine geocodingEngine2;
    private final ReverseGeocodingEngine reverseGeocodingEngine;
    private final Truck truck = new Truck();
    private static double hourDestination;
    private static double hourStart;
    private static double hourDestination25;
    private static double hourStart25;
    private double fixRoutePriceStart;
    private double fixRoutePriceDestination;
    private final Locality25 locality25 = new Locality25();
    private final HoursNSK hoursNSK = new HoursNSK();
    private boolean cityCenterStart;
    private boolean cityCenterDestination;
    private final GeoCoordinates cityCenterGeo = new GeoCoordinates(55.030132, 82.918927);
    private double fixedAmountRoutePrices;
    private double lengthFirstHalf;
    private double lengthSecondHalf;
    static String shareTextRout;
    static String addressStart;
    static String addressDestination;
    private String detailsRout;
    private final List<MapPolyline> mapPolylines = new ArrayList<>();
    private final RoutingEngine routingEngine;
    static GeoCoordinates startGeoCoordinates;
    static GeoCoordinates destinationGeoCoordinates;
    static GeoCoordinates geoCoordinatesPoint;
    private final MapScene mapScene;
    private MapPolygon mapPolygon;
    private final HashSet<Double> hourRoutePointsList = new HashSet<>();
    private boolean notCityStart;
    private boolean notCityDestination;

    HereMap(Context context, MapViewLite mapView) {
        this.context = context;
        this.mapView = mapView;
        Camera camera = mapView.getCamera();
        camera.setTarget(new GeoCoordinates(54.999310, 82.930359));
        camera.setZoomLevel(8);
        mapScene = mapView.getMapScene();

        try {
            searchEngine = new SearchEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of SearchEngine failed: " + e.error.name());
        }

        try {
            autosuggestEngine = new AutosuggestEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of AutosuggestEngine failed: " + e.error.name());
        }

        try {
            geocodingEngine = new GeocodingEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of GeocodingEngine failed: " + e.error.name());
        }
        try {
            geocodingEngine2 = new GeocodingEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of GeocodingEngine failed: " + e.error.name());
        }

        try {
            reverseGeocodingEngine = new ReverseGeocodingEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of ReverseGeocodingEngine failed: " + e.error.name());
        }

        try {
            routingEngine = new RoutingEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of RoutingEngine failed: " + e.error.name());
        }

        setTapGestureHandler();
        setLongPressGestureHandler();
    }

    void onSearchButtonClicked(String s) {
        // Search for "Pizza" and show the results on the map.
        searchExample(s);

        // Search for auto suggestions and log the results to the console.
        autoSuggestExample(s);
    }

    void onGeocodeButtonClicked(String str) {
        // Search for the location that belongs to an address and show it on the map.
        geocodeAnAddress(str);
    }

    void onGeocodeButtonClicked2(String str2) {
        // Search for the location that belongs to an address and show it on the map.
        geocodeAnAddress2(str2);
    }

    private void searchExample(String s) {
        Toast.makeText(context, "Searching in viewport: " + s, Toast.LENGTH_LONG).show();
        searchInViewport(s);
    }

    private void geocodeAnAddress(String s) {
        // Set map to expected location.
        geocodeAddressInViewport(s);
    }

    private void geocodeAnAddress2(String s2) {
        // Set map to expected location.
        geocodeAddressInViewport2(s2);
    }

    private void setTapGestureHandler() {
        mapView.getGestures().setTapListener(this::pickMapMarker);
    }

    private void setLongPressGestureHandler() {
        mapView.getGestures().setLongPressListener((gestureState, touchPoint) -> {
            if (gestureState == GestureState.BEGIN) {
                clearWaypointMapMarker();
                clearMap();
                clearRoute();
                MainActivity.pointDialog.show();
                geoCoordinatesPoint = mapView.getCamera().viewToGeoCoordinates(touchPoint);
            }
        });
    }

    void getAddressForCoordinates(GeoCoordinates geoCoordinates) {
        // By default results are localized in EN_US.
        ReverseGeocodingOptions reverseGeocodingOptions = new ReverseGeocodingOptions(LanguageCode.RU_RU);

        reverseGeocodingEngine.searchAddress(
                geoCoordinates, reverseGeocodingOptions, (searchError, address) -> {
                    if (MainActivity.choicePointBoolean == 0) {
                        startGeoCoordinates = geoCoordinates;
                        assert address != null;
                        searchPointInZones(address.addressText);
                        addressStart = address.addressText;
                        MainActivity.nameAddress.setText(address.addressText);
                    } else if (MainActivity.choicePointBoolean == 1) {
                        destinationGeoCoordinates = geoCoordinates;
                        assert address != null;
                        searchPointInZones2(address.addressText);
                        MainActivity.nameAddress2.setText(address.addressText);
                        addressDestination = address.addressText;
                    }
                    if (searchError != null) {
                        showDialog("Reverse geocoding", "Error: " + searchError);
                    }
//                        showDialog("Reverse geocoded address:", address.addressText);
                });
    }

    private void pickMapMarker(final Point2D point2D) {
        float radiusInPixel = 2;
        mapView.pickMapItems(point2D, radiusInPixel, pickMapItemsResult -> {
            if (pickMapItemsResult == null) {
                return;
            }

            MapMarker topmostMapMarker = pickMapItemsResult.getTopmostMarker();
            if (topmostMapMarker == null) {
                return;
            }

            Metadata metadata = topmostMapMarker.getMetadata();
            if (metadata != null) {
                CustomMetadataValue customMetadataValue = metadata.getCustomValue("key_search_result");
                if (customMetadataValue != null) {
                    SearchResultMetadata searchResultMetadata = (SearchResultMetadata) customMetadataValue;
                    String title = searchResultMetadata.searchResult.title;
                    String vicinity = searchResultMetadata.searchResult.vicinity;
                    SearchCategory category = searchResultMetadata.searchResult.category;
                    showDialog("Picked Search Result",
                            title + ", " + vicinity + ". Category: " + category.localizedName);
                    return;
                }
            }

            showDialog("Picked Map Marker",
                    "Geographic coordinates: " +
                            topmostMapMarker.getCoordinates().latitude + ", " +
                            topmostMapMarker.getCoordinates().longitude);

//                if (mapMarkerStart!=null){
//                    clearMarker();
//                    startGeoCoordinates = new GeoCoordinates(topmostMapMarker.getCoordinates().latitude, topmostMapMarker.getCoordinates().longitude);
//                    addPoiMapMarkerStart(startGeoCoordinates);
//                }else if (mapMarkerDestination!=null){
//                    clearMarker();
//                    destinationGeoCoordinates = new GeoCoordinates(topmostMapMarker.getCoordinates().latitude, topmostMapMarker.getCoordinates().longitude);
//                    addPoiMapMarkerDestination(destinationGeoCoordinates);
//                }

        });
    }

    private void searchInViewport(String queryString) {
        clearMarker();

        int maxSearchResults = 30;
        SearchOptions searchOptions = new SearchOptions(
                LanguageCode.RU_RU,
                TextFormat.PLAIN,
                maxSearchResults);

        GeoBox viewportGeoBox = mapView.getCamera().getBoundingRect();
        searchEngine.search(queryString, viewportGeoBox, searchOptions, (searchError, list) -> {
            if (searchError != null) {
                showDialog("Search", "Error: " + searchError);
                return;
            }

            assert list != null;
            if (list.isEmpty()) {
                showDialog("Search", "No results found");
            } else {
                showDialog("Search", "Results: " + list.size());
            }

            // Add new marker for each search result on map.
            for (SearchResult searchResult : list) {
                Metadata metadata = new Metadata();
                metadata.setCustomValue("key_search_result", new SearchResultMetadata(searchResult));
                addPoiMapMarker(searchResult.coordinates, metadata);
            }
        });
    }

    private static class SearchResultMetadata implements CustomMetadataValue {

        SearchResult searchResult;

        SearchResultMetadata(SearchResult searchResult) {
            this.searchResult = searchResult;
        }

        @NonNull
        @Override
        public String getTag() {
            return "SearchResult Metadata";
        }
    }

    private final AutosuggestEngine.Callback autosuggestCallback = (searchError, list) -> {
        if (searchError != null) {
            Log.d(LOG_TAG, "Autosuggest Error: " + searchError.name());
            return;
        }

        assert list != null;
        if (list.isEmpty()) {
            Log.d(LOG_TAG, "Autosuggest: No results found");
        } else {
            Log.d(LOG_TAG, "Autosuggest results: " + list.size());
        }

        for (AutosuggestResult autosuggestResult : list) {
            Log.d(LOG_TAG, "Autosuggest result: " + autosuggestResult.title +
                    "Highlighted: " + autosuggestResult.highlightedTitle);
        }
    };

    private void autoSuggestExample(String s) {
        GeoCoordinates centerGeoCoordinates = mapView.getCamera().getTarget();
        int maxSearchResults = 5;
        AutosuggestOptions autosuggestOptions = new AutosuggestOptions(
                LanguageCode.RU_RU,
                TextFormat.PLAIN,
                maxSearchResults,
                new ArrayList<>(Collections.singletonList(
                        AutosuggestResultType.PLACE)));

        // Simulate a user typing a search term.
        autosuggestEngine.suggest("п",
                centerGeoCoordinates,
                autosuggestOptions,
                autosuggestCallback);

        autosuggestEngine.suggest("пи",
                centerGeoCoordinates,
                autosuggestOptions,
                autosuggestCallback);

        autosuggestEngine.suggest("пиц",
                centerGeoCoordinates,
                autosuggestOptions,
                autosuggestCallback);

        autosuggestEngine.suggest(s,
                centerGeoCoordinates,
                autosuggestOptions,
                autosuggestCallback);
    }

    private void geocodeAddressInViewport(String queryString) {
        addressStart = queryString;
        clearMarker();
        GeoCircle geoCircle = new GeoCircle(new GeoCoordinates(54.999310, 82.930359), 50000);
        long maxResultCount = 1;
        GeocodingOptions geocodingOptions = new GeocodingOptions(
                LanguageCode.RU_RU, (int) maxResultCount);
        geocodingEngine.searchLocations(queryString, geoCircle, geocodingOptions, (searchError, list) -> {
            if (searchError != null) {
                showDialog("Geocoding", "Error: " + searchError);
                return;
            }
            assert list != null;
            if (list.isEmpty()) {
                showDialog("Geocoding", "No geocoding results found.");
                return;
            }
            for (GeocodingResult geocodingResult : list) {
                GeoCoordinates geoCoordinates = geocodingResult.coordinates;
                Address address = geocodingResult.address;
                if (address != null) {
                    String locationDetails = address.addressText
                            + ". GeoCoordinates: " + geoCoordinates.latitude
                            + ", " + geoCoordinates.longitude;
                    Log.d(LOG_TAG, "GeocodingResult: " + locationDetails);
                }
                if (list.size() == 1) {
                    addPoiMapMarkerStart(geoCoordinates);
                    //camera.setTarget(new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude));
                    startGeoCoordinates = new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude);
                } else if (list.size() > 1) {
                    addPoiMapMarkerStart(geoCoordinates);
                    //camera.setTarget(new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude));
                    startGeoCoordinates = new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude);

                }
                searchPointInZones(queryString);
            }
            //showDialog("Geocoding result", "Size: " + list.size());
        });
    }

    private void searchPointInZones(String queryString) {
        hourRoutePointsList.clear();
        routHalfFirst();
        hourStart = 0;
        hourStart25 = 0;
        fixRoutePriceStart = 0;
        if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour00, true)) {
            hourStart = 0;
            hourStart25 = 0;
            cityCenterStart = true;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в черте города", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour05l, true) ||
                PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour05r, true)) {
            hourStart = 0.5;
            hourStart25 = 0;
            cityCenterStart = false;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в получасовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour10l, true) ||
                PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour10r, true)) {
            hourStart = 1;
            hourStart25 = 0;
            cityCenterStart = false;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour15l, true) ||
                PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour15r, true)) {
            hourStart = 1.5;
            hourStart25 = 0;
            cityCenterStart = false;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в 1,5 часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour20l, true) ||
                PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour20r, true)) {
            hourStart = 2;
            hourStart25 = 0;
            cityCenterStart = false;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в 2 часовой зоне отдаления ", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour25l, true) ||
                PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.arrHour25r, true)) {
            hourStart25 = 2.5;
            cityCenterStart = false;
            notCityStart = false;
            Toast.makeText(context, "Загрузка по адресу: " + queryString + "\nНаходится в 2,5 часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else {
            hourStart = 0;
            hourStart25 = 0;
            cityCenterStart = false;
            notCityStart = true;
        }
        for (Map.Entry<ArrayList<GeoCoordinates>, Integer> entry : locality25.setFixKmArr().entrySet()) {
            if (PolyUtil.containsLocation(startGeoCoordinates, entry.getKey(), true)) {
                fixRoutePriceStart = entry.getValue();
                //Toast.makeText(context, entry.getValue().toString(), Toast.LENGTH_LONG).show();
                routHalfFirst();
                if (destinationGeoCoordinates != null && startGeoCoordinates != null) {
                    invisibleAddRoute();
                }
                return;
            }
        }
        routHalfFirst();
        if (destinationGeoCoordinates != null && startGeoCoordinates != null) {
            invisibleAddRoute();
        }
    }

    private void geocodeAddressInViewport2(String queryString2) {
        addressDestination = queryString2;
        clearMarker();
        GeoCircle geoCircle = new GeoCircle(new GeoCoordinates(54.999310, 82.930359), 50000);
        long maxResultCount = 1;
        GeocodingOptions geocodingOptions = new GeocodingOptions(
                LanguageCode.RU_RU, (int) maxResultCount);
        geocodingEngine2.searchLocations(queryString2, geoCircle, geocodingOptions, (searchError, list) -> {
            if (searchError != null) {
                showDialog("Geocoding", "Error: " + searchError);
                return;
            }
            assert list != null;
            if (list.isEmpty()) {
                showDialog("Geocoding", "No geocoding results found.");
                return;
            }
            for (GeocodingResult geocodingResult : list) {
                GeoCoordinates geoCoordinates = geocodingResult.coordinates;
                Address address = geocodingResult.address;
                if (address != null) {
                    String locationDetails = address.addressText
                            + ". GeoCoordinates: " + geoCoordinates.latitude
                            + ", " + geoCoordinates.longitude;
                    Log.d(LOG_TAG, "GeocodingResult: " + locationDetails);
//                        addPoiMapMarkerDestination(geoCoordinates);
//                        //camera.setTarget(new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude));
//                        destinationGeoCoordinates = new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude);
                }
                if (list.size() == 1) {
                    addPoiMapMarkerDestination(geoCoordinates);
                    //camera.setTarget(new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude));
                    destinationGeoCoordinates = new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude);
                } else if (list.size() > 1) {
                    addPoiMapMarkerDestination(geoCoordinates);
                    //camera.setTarget(new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude));
                    destinationGeoCoordinates = new GeoCoordinates(geoCoordinates.latitude, geoCoordinates.longitude);

                }
                searchPointInZones2(queryString2);
            }
            //showDialog("Geocoding result", "Size: " + list.size());
        });
    }

    private void searchPointInZones2(String queryString2) {
        hourRoutePointsList.clear();
        routHalfSecond();
        hourDestination = 0;
        hourDestination25 = 0;
        fixRoutePriceDestination = 0;
        if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour00, true)) {
            hourDestination = 0;
            hourDestination25 = 0;
            cityCenterDestination = true;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в черте города", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour05l, true) ||
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour05r, true)) {
            hourDestination = 0.5;
            hourDestination25 = 0;
            cityCenterDestination = false;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в получасовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour10l, true) ||
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour10r, true)) {
            hourDestination = 1;
            hourDestination25 = 0;
            cityCenterDestination = false;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour15l, true) ||
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour15r, true)) {
            hourDestination = 1.5;
            hourDestination25 = 0;
            cityCenterDestination = false;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в 1,5 часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour20l, true) ||
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour20r, true)) {
            hourDestination = 2;
            hourDestination25 = 0;
            cityCenterDestination = false;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в 2 часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else if (PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour25l, true) ||
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.arrHour25r, true)) {
            hourDestination25 = 2.5;
            cityCenterDestination = false;
            notCityDestination = false;
            Toast.makeText(context, "Выгрузка по адресу: " + queryString2 + "\nНаходится в 2,5 часовой зоне отдаления", Toast.LENGTH_LONG).show();
        } else {
            hourDestination = 0;
            hourDestination25 = 0;
            cityCenterDestination = false;
            notCityDestination = true;
        }
        for (Map.Entry<ArrayList<GeoCoordinates>, Integer> entry : locality25.setFixKmArr().entrySet()) {
            assert destinationGeoCoordinates != null;
            if (PolyUtil.containsLocation(destinationGeoCoordinates, entry.getKey(), true)) {
                fixRoutePriceDestination = entry.getValue();
                //Toast.makeText(context, entry.getValue().toString(), Toast.LENGTH_LONG).show();
                routHalfSecond();
                if (destinationGeoCoordinates != null && startGeoCoordinates != null) {
                    invisibleAddRoute();
                }
            }
        }
        routHalfSecond();
        if (destinationGeoCoordinates != null && startGeoCoordinates != null) {
            invisibleAddRoute();
        }
    }

    //Этот код делает логику подсчета стоимости маршрута
    private String routCountPrice(Route route) {
        CameraUpdate cameraUpdate = mapView.getCamera().calculateEnclosingCameraUpdate(
                route.getBoundingBox(),
                new Padding(10, 10, 10, 10));
        mapView.getCamera().updateCamera(cameraUpdate);
        double allHour = hourStart + hourDestination + hourStart25 + hourDestination25;
        double start = hourStart + hourStart25;
        double destination = hourDestination + hourDestination25;
        double lengthInMeters = route.getLengthInMeters();
        double kmAB = Math.ceil(lengthInMeters / 5000) * 10;
        fixedAmountRoutePrices = fixRoutePriceStart + fixRoutePriceDestination;
        if (PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.allHours(), true) &&
                PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.allHours(), true)) {
            //если нет фиксированого километража нигде или нет фикс.км на старте + финиш не в городе и наоборот
            if (fixedAmountRoutePrices == 0 || (fixRoutePriceStart != 0 && !cityCenterDestination) ||
                    (fixRoutePriceDestination != 0 && !cityCenterStart)) {
                fixedAmountRoutePrices = route.getLengthInMeters();
                fixedAmountRoutePrices = Math.ceil(fixedAmountRoutePrices / 5000) * 10;
                //если старт или финиш находятся в 2.5ч
                if (hourStart25 != 0 && hourDestination25 != 0 && Truck.km25 != 0) {
                    if (hourRoutePointsList.contains(0.0)) {
                        //Toast.makeText(context, "Это 1.1 version (менее 2 т и обе точки в зоне 2.5)", Toast.LENGTH_LONG).show();
                        return truck.count25Str(allHour, lengthFirstHalf) +
                                truck.count25SecondStr(allHour, lengthSecondHalf) + "\nИтого: " +
                                (truck.count25(allHour, lengthFirstHalf) +
                                        truck.count25Second(allHour, lengthSecondHalf)) + " рублей";
                    } else {
                        //Toast.makeText(context, "Это 1.2 version (менее 2 т и обе точки в зоне 2.5)", Toast.LENGTH_LONG).show();
                        return truck.count25Str(allHour, (lengthFirstHalf + lengthSecondHalf) / 2) +
                                truck.count25SecondStr(allHour, fixedAmountRoutePrices / 2) +
                                "\nИтого: " + (truck.count25(allHour, (lengthFirstHalf + lengthSecondHalf) / 2)
                                + truck.count25Second(allHour, fixedAmountRoutePrices / 2)) + " рублей";
                    }
                } else if (hourStart25 != 0 && hourDestination25 == 0 && Truck.km25 != 0) {
                    if (cityCenterDestination) {
                        //Toast.makeText(context, "Это 2.1 version (менее 2 т и загрузка в зоне 2.5 выгрузка в городе)", Toast.LENGTH_LONG).show();
                        return truck.count25Str(allHour, fixedAmountRoutePrices) + "\nИтого: " +
                                truck.count25(allHour, fixedAmountRoutePrices) + " рублей";
                    } else {
                        if (hourRoutePointsList.contains(0.0)) {
                            //Toast.makeText(context, "Это 2.2 version (менее 2 т и загрузка в зоне 2.5)", Toast.LENGTH_LONG).show();
                            return (truck.count25Str(allHour, lengthFirstHalf) +
                                    truck.countSecondStr(hourDestination)) +
                                    "\nИтого: " + (truck.count25(allHour, lengthFirstHalf) +
                                    truck.countSecond(hourDestination)) + " рублей";
                        } else {
                            //Toast.makeText(context, "Это 2.3 version (менее 2 т и загрузка в зоне 2.5)", Toast.LENGTH_LONG).show();
                            return (truck.count25Str(allHour, lengthFirstHalf) +
                                    truck.countSecondStr(hourDestination / 2)) +
                                    "\nИтого: " + (truck.count25(allHour, lengthFirstHalf) +
                                    truck.countSecond(hourDestination / 2)) + " рублей";
                        }
                    }
                } else if (hourStart25 == 0 && hourDestination25 != 0 && Truck.km25 != 0) {
                    if (cityCenterStart) {
                        //Toast.makeText(context, "Это 3.1 version (менее 2 т и выгрузка в зоне 2.5 загрузка в городе)", Toast.LENGTH_LONG).show();
                        return truck.count25Str(allHour, fixedAmountRoutePrices) + "\nИтого: " +
                                truck.count25(allHour, fixedAmountRoutePrices) + " рублей";
                    } else {
                        if (hourRoutePointsList.contains(0.0)) {
                            //Toast.makeText(context, "Это 3.2 version (менее 2 т и выгрузка в зоне 2.5)", Toast.LENGTH_LONG).show();
                            return (truck.countStr(hourStart) +
                                    truck.count25SecondStr(allHour, lengthSecondHalf)) + "\nИтого: " +
                                    (truck.count(hourStart) +
                                            truck.count25Second(allHour, lengthSecondHalf)) + " рублей";
                        } else {
                            //Toast.makeText(context, "Это 3.3 version (менее 2 т и выгрузка в зоне 2.5)", Toast.LENGTH_LONG).show();
                            return (truck.countStr(hourStart / 2) +
                                    truck.count25SecondStr(allHour, lengthSecondHalf)) + "\nИтого: " +
                                    (truck.count(hourStart / 2) +
                                            truck.count25Second(allHour, lengthSecondHalf)) + " рублей";
                        }
                    }
                } else {
                    if (hourRoutePointsList.contains(0.0)) {
                        //Toast.makeText(context, "Это 4.1 version (более 2т и просто почасовка обязательно центр)", Toast.LENGTH_LONG).show();
                        return truck.countStr(allHour) + "\nИтого: " +
                                truck.count(allHour) + " рублей";
                    } else {
                        if (start > destination) {
                            //Toast.makeText(context, "Это 4.2 version (более 2т и просто почасовка обязательно центр)", Toast.LENGTH_LONG).show();
                            return truck.countStr((start + destination / 2)) + "\nИтого: " +
                                    truck.count((start + destination / 2)) + " рублей";
                        } else {
                            //Toast.makeText(context, "Это 4.3 version (более 2т и просто почасовка обязательно центр)", Toast.LENGTH_LONG).show();
                            return truck.countStr((start / 2 + destination)) + "\nИтого: " +
                                    truck.count((start / 2 + destination)) + " рублей";
                        }
                    }
                }
            } else {
                if (hourStart25 != 0 && hourDestination25 == 0) {
                    //Toast.makeText(context, "Это 5 version (менее 2 т и загрузка в зоне 2.5 выгрузка в городе FIX)", Toast.LENGTH_LONG).show();
                    return truck.count25Str(allHour, fixedAmountRoutePrices) + "\nИтого: " +
                            truck.count25(allHour, fixedAmountRoutePrices) + " рублей";
                } else {
                    //Toast.makeText(context, "Это 6 version (менее 2 т и выгрузка в зоне 2.5 загрузка в городе FIX)", Toast.LENGTH_LONG).show();
                    return truck.count25Str(allHour, fixedAmountRoutePrices) + "\nИтого: " +
                            truck.count25(allHour, fixedAmountRoutePrices) + " рублей";
                }
            }
        } else if (lengthSecondHalf < 300.0 && lengthFirstHalf < 300.0) {
            if (fixedAmountRoutePrices == 0)
                fixedAmountRoutePrices = kmAB;
            if (((hourDestination25 != 0 && Truck.km25 != 0) || (hourStart25 != 0 && Truck.km25 != 0))
                    && (hourStart + hourDestination) == 0) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 7.1 version (менее 2 т и обе точки в зоне 2.5 или до 150км через город)", Toast.LENGTH_LONG).show();
                    return truck.count25Str(allHour, lengthFirstHalf) +
                            truck.count25SecondStr(allHour, lengthSecondHalf) + "\nИтого: " +
                            (truck.count25(allHour, lengthFirstHalf) + truck.count25Second(allHour, lengthSecondHalf))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 7.2 version (менее 2 т и обе точки в зоне 2.5 или до 150км)", Toast.LENGTH_LONG).show();
                    return truck.count25Str(allHour, (lengthFirstHalf + lengthSecondHalf) / 2) +
                            truck.count25SecondStr(allHour, fixedAmountRoutePrices / 2) +
                            "\nИтого: " + (truck.count25(allHour, (lengthFirstHalf + lengthSecondHalf) / 2)
                            + truck.count25Second(allHour, fixedAmountRoutePrices / 2)) + " рублей";
                }
            } else if ((hourDestination25 != 0 && Truck.km25 == 0) || (hourDestination != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 8.1 version (все загрузка 150км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr(lengthFirstHalf) +
                            truck.countSecondStr((hourDestination + hourDestination25)) + "\nИтого: " +
                            (truck.count150Km(lengthFirstHalf) + truck.countSecond((hourDestination + hourDestination25)))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 8.2 version (все загрузка 150км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr(lengthFirstHalf) +
                            truck.countSecondStr((hourDestination + hourDestination25) / 2) +
                            "\nИтого: " + (truck.count150Km(lengthFirstHalf) +
                            truck.countSecond((hourDestination + hourDestination25) / 2)) + " рублей";
                }
            } else if ((hourStart25 != 0 && Truck.km25 == 0) || (hourStart != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 9.1 version (все выгрузка 150км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr(lengthSecondHalf) + truck.countSecondStr((hourStart + hourStart25)) +
                            "\nИтого: " + (truck.count150Km(lengthSecondHalf) + truck.countSecond((hourStart + hourStart25)))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 9.2 version (все выгрузка 150км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr(lengthSecondHalf) +
                            truck.countSecondStr((hourStart + hourStart25) / 2) +
                            "\nИтого: " + (truck.count150Km(lengthSecondHalf) +
                            truck.countSecond((hourStart + hourStart25) / 2)) + " рублей";
                }
            } else {
                if (hourRoutePointsList.contains(2.0)) {
                    //Toast.makeText(context, "Это 10.1 version (Все от 75до 150км с центром города)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr(fixedAmountRoutePrices) + "\nИтого: " +
                            truck.count150Km(fixedAmountRoutePrices) + " рублей";
                } else {
                    //Toast.makeText(context, "Это 10.2 version (Все точки от 75до 150км)", Toast.LENGTH_LONG).show();
                    return truck.count150KmStr((lengthFirstHalf + lengthSecondHalf) / 2)
                            + truck.count150KmSecondStr(kmAB / 2) +
                            "\nИтого: " + (truck.count150Km((lengthFirstHalf + lengthSecondHalf) / 2)
                            + truck.count150KmSecond(kmAB / 2)) + " рублей";
                }
            }
        } else if (lengthSecondHalf < 400.0 && lengthFirstHalf < 400.0 && lengthFirstHalf >= 300.0 || lengthSecondHalf < 400.0 && lengthFirstHalf < 400.0) {
            if (fixedAmountRoutePrices == 0)
                fixedAmountRoutePrices = kmAB;
            if (((hourDestination25 != 0 && Truck.km25 != 0) || (hourStart25 != 0 && Truck.km25 != 0))
                    && (hourStart + hourDestination) == 0) {
                if (hourRoutePointsList.contains(0.0)) {
                    if (hourStart25 != 0) {
                        //Toast.makeText(context, "Это 11.1 version (менее 2 т и загрузка в зоне 2.5 или до 200км через город)", Toast.LENGTH_LONG).show();
                        return truck.count150KmStr(lengthFirstHalf) + truck.count200KmStr(lengthSecondHalf) +
                                "\nИтого: " + (truck.count150Km(lengthFirstHalf) + truck.count200Km(lengthSecondHalf))
                                + " рублей";
                    } else {
                        //Toast.makeText(context, "Это 11.2 version (менее 2 т и выгрузка в зоне 2.5 или до 200км через город)", Toast.LENGTH_LONG).show();
                        return truck.count200KmStr(lengthFirstHalf) + truck.count150KmStr(lengthSecondHalf) +
                                "\nИтого: " + (truck.count200Km(lengthFirstHalf) + truck.count150Km(lengthSecondHalf))
                                + " рублей";
                    }
                } else {
                    //Toast.makeText(context, "Это 11.3 version (менее 2 т и обе точки в зоне 2.5 или до 200км)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr((lengthFirstHalf + lengthSecondHalf) / 2) +
                            truck.count200KmStr(fixedAmountRoutePrices / 2) + "\nИтого: " +
                            (truck.count200Km((lengthFirstHalf + lengthSecondHalf) / 2)
                                    + truck.count200Km(fixedAmountRoutePrices / 2)) + " рублей";
                }
            } else if ((hourDestination25 != 0 && Truck.km25 == 0) || (hourDestination != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 12.1 version (все загрузка 200км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr(lengthFirstHalf) + truck.countSecondStr((hourDestination + hourDestination25))
                            + "\nИтого: " + (truck.count200Km(lengthFirstHalf) +
                            truck.countSecond((hourDestination + hourDestination25))) + " рублей";
                } else {
                    //Toast.makeText(context, "Это 12.2 version (все загрузка 200км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr(lengthFirstHalf) +
                            truck.countSecondStr((hourDestination + hourDestination25) / 2) + "\nИтого: " +
                            (truck.count200Km(lengthFirstHalf) +
                                    truck.countSecond((hourDestination + hourDestination25) / 2)) + " рублей";
                }
            } else if ((hourStart25 != 0 && Truck.km25 == 0) || (hourStart != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 13.1 version (все выгрузка 200км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr(lengthSecondHalf) + truck.countSecondStr((hourStart + hourStart25)) +
                            "\nИтого: " + (truck.count200Km(lengthSecondHalf) + truck.countSecond((hourStart + hourStart25)))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 13.2 version (все выгрузка 200км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr(lengthSecondHalf) +
                            truck.countSecondStr((hourStart + hourStart25) / 2) + "\nИтого: " +
                            (truck.count200Km(lengthSecondHalf) + truck.countSecond((hourStart + hourStart25) / 2))
                            + " рублей";
                }
            } else {
                if (hourRoutePointsList.contains(2.0)) {
                    //Toast.makeText(context, "Это 14.1 version (Все от 150до 200км через город)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr(fixedAmountRoutePrices) +
                            "\nИтого: " + truck.count200Km(fixedAmountRoutePrices) + " рублей";
                } else {
                    //Toast.makeText(context, "Это 14.2 version (Все от 150до 200км без заезда в город)", Toast.LENGTH_LONG).show();
                    return truck.count200KmStr((lengthFirstHalf + lengthSecondHalf) / 2) +
                            truck.count150KmSecondStr(kmAB / 2) + "\nИтого: " +
                            (truck.count200Km((lengthFirstHalf + lengthSecondHalf) / 2) +
                                    truck.count150KmSecond(kmAB / 2)) + " рублей";
                }
            }
        } else {
            if (fixedAmountRoutePrices == 0)
                fixedAmountRoutePrices = kmAB;
            if (((hourDestination25 != 0 && Truck.km25 != 0) || (hourStart25 != 0 && Truck.km25 != 0))
                    && (hourStart + hourDestination) == 0) {
                if (hourRoutePointsList.contains(0.0)) {
                    if (hourStart25 != 0) {
                        //Toast.makeText(context, "Это 15.1 version (менее 2 т и загрузка в зоне 2.5 или более 200км через город)", Toast.LENGTH_LONG).show();
                        return truck.count150KmStr(lengthFirstHalf) + truck.countAllKmStr(lengthSecondHalf) +
                                "\nИтого: " + (truck.count150Km(lengthFirstHalf) + truck.countAllKm(lengthSecondHalf))
                                + " рублей";
                    } else {
                        //Toast.makeText(context, "Это 15.2 version (менее 2 т и разгрузка в зоне 2.5 или более 200км через город)", Toast.LENGTH_LONG).show();
                        return truck.countAllKmStr(lengthFirstHalf) + truck.count150KmStr(lengthSecondHalf) +
                                "\nИтого: " + (truck.countAllKm(lengthFirstHalf) + truck.count150Km(lengthSecondHalf))
                                + " рублей";
                    }
                } else {
                    //Toast.makeText(context, "Это 15.3 version (менее 2 т и обе точки в зоне 2.5 или более 200км)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr((lengthFirstHalf + lengthSecondHalf) / 2) +
                            truck.countAllKmStr(kmAB / 2) + "\nИтого: " +
                            (truck.countAllKm((lengthFirstHalf + lengthSecondHalf) / 2) +
                                    truck.countAllKm(kmAB / 2)) + " рублей";
                }
            } else if ((hourDestination25 != 0 && Truck.km25 == 0) || (hourDestination != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 16.1 version (все загрузка более 200км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr(lengthFirstHalf) +
                            truck.countSecondStr((hourDestination + hourDestination25)) + "\nИтого: " +
                            (truck.countAllKm(lengthFirstHalf) + truck.countSecond((hourDestination + hourDestination25)))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 16.2 version (все загрузка более 200км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr(lengthFirstHalf) +
                            truck.countSecondStr((hourDestination + hourDestination25) / 2) +
                            "\nИтого: " + (truck.countAllKm(lengthFirstHalf) +
                            truck.countSecond((hourDestination + hourDestination25) / 2)) + " рублей";
                }
            } else if ((hourStart25 != 0 && Truck.km25 == 0) || (hourStart != 0)) {
                if (hourRoutePointsList.contains(0.0)) {
                    //Toast.makeText(context, "Это 17.1 version (все выгрузка более 200км через город + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr(lengthSecondHalf) + truck.countSecondStr((hourStart + hourStart25)) +
                            "\nИтого: " + (truck.countAllKm(lengthSecondHalf) + truck.countSecond((hourStart + hourStart25)))
                            + " рублей";
                } else {
                    //Toast.makeText(context, "Это 17.2 version (все выгрузка более 200км + отдаленка)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr(lengthSecondHalf) +
                            truck.countSecondStr((hourStart + hourStart25) / 2) + "\nИтого: " +
                            (truck.countAllKm(lengthSecondHalf) + truck.countSecond((hourStart + hourStart25) / 2))
                            + " рублей";
                }
            } else {
                if (hourRoutePointsList.contains(2.0)) {
                    //Toast.makeText(context, "Это 18.1 version (Все от 200км через город)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr(lengthFirstHalf + lengthSecondHalf) + "\nИтого: " +
                            truck.countAllKm(lengthFirstHalf + lengthSecondHalf) + " рублей";
                } else {
                    //Toast.makeText(context, "Это 18.2 version (Все от 200км без заезда в город)", Toast.LENGTH_LONG).show();
                    return truck.countAllKmStr((lengthFirstHalf + lengthSecondHalf) / 2) +
                            truck.count150KmSecondStr(kmAB / 2) + "\nИтого: " +
                            (truck.countAllKm((lengthFirstHalf + lengthSecondHalf) / 2) +
                                    truck.count150KmSecond(kmAB / 2)) + " рублей";
                }
            }
        }
    }

    void addPoiMapMarkerStart(GeoCoordinates geoCoordinates) {
        MapMarker mapMarkerStart = createPoiMapMarker(geoCoordinates);
        mapView.getMapScene().addMapMarker(mapMarkerStart);
        mapMarkerList.add(mapMarkerStart);
    }

    void addPoiMapMarkerDestination(GeoCoordinates geoCoordinates) {
        MapMarker mapMarkerDestination = createPoiMapMarker(geoCoordinates);
        mapView.getMapScene().addMapMarker(mapMarkerDestination);
        mapMarkerList.add(mapMarkerDestination);
    }

    private void addPoiMapMarker(GeoCoordinates geoCoordinates, Metadata metadata) {
        MapMarker mapMarker = createPoiMapMarker(geoCoordinates);
        mapMarker.setMetadata(metadata);
        mapView.getMapScene().addMapMarker(mapMarker);
        mapMarkerList.add(mapMarker);
    }

    private MapMarker createPoiMapMarker(GeoCoordinates geoCoordinates) {
        MapImage mapImage = MapImageFactory.fromResource(context.getResources(), R.drawable.poi);
        MapMarker mapMarker = new MapMarker(geoCoordinates);
        MapMarkerImageStyle mapMarkerImageStyle = new MapMarkerImageStyle();
        mapMarkerImageStyle.setAnchorPoint(new Anchor2D(0.5F, 1));
        mapMarker.addImage(mapImage, mapMarkerImageStyle);
        return mapMarker;
    }

    void clearMarker() {
        for (MapMarker mapMarker : mapMarkerList) {
            mapView.getMapScene().removeMapMarker(mapMarker);
        }
        mapMarkerList.clear();
        //функции Routing
        clearWaypointMapMarker();
        clearRoute();
    }


    private void showDialog(String title, String message) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    //here plus class Routing************************************************************************
    //private final List<MapMarker> mapMarkerList = new ArrayList<>();
    void invisibleAddRoute() {
        hourRoutePointsList.clear();

        Waypoint startWaypoint = new Waypoint(startGeoCoordinates);
        Waypoint destinationWaypoint = new Waypoint(destinationGeoCoordinates);
        List<Waypoint> waypoints =
                new ArrayList<>(Arrays.asList(startWaypoint, destinationWaypoint));
        if (Truck.km25 != 0) {
            routingEngine.calculateRoute(
                    waypoints,
                    new RoutingEngine.CarOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route route = routes.get(0);
                            try {
                                searchArrayPointInRoute(new GeoPolyline(route.getPolyline()));
                            } catch (InstantiationErrorException e) {
                                e.printStackTrace();
                            }
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        } else {
            routingEngine.calculateRoute(
                    waypoints,
                    new RoutingEngine.TruckOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route route = routes.get(0);
                            try {
                                searchArrayPointInRoute(new GeoPolyline(route.getPolyline()));
                            } catch (InstantiationErrorException e) {
                                e.printStackTrace();
                            }
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        }


    }

    //Этот код строит логику маршрута
    void addRoute() {
        clearMarker();
        clearWaypointMapMarker();
        clearRoute();

        fixedAmountRoutePrices = fixRoutePriceStart + fixRoutePriceDestination;
        // Когда финиш и старт не в городе и Когда старт или финиш в зоне 25 и Когда фиксированый общий километраж равен 0 и Когда не более 2т
        // или Когда фиксированный общий километраж не равен 0 и Когда старт и финиш в зоне 25 и Когда не более 2т
        if (((!cityCenterDestination && !cityCenterStart && (hourStart25 != 0 || hourDestination25 != 0) && Truck.km25 != 0) ||
                (fixedAmountRoutePrices != 0 && hourStart25 != 0 && hourDestination25 != 0 && Truck.km25 != 0))
                && hourRoutePointsList.contains(0.0)) {
            if (hourStart25 != 0 && hourDestination25 == 0) {
                //Toast.makeText(context, "Это 1 вариант", Toast.LENGTH_LONG).show();
                routHalfFirst();
                addWaypoints();
            } else if (hourStart25 == 0) {
                //Toast.makeText(context, "Это 2 вариант", Toast.LENGTH_LONG).show();
                routHalfSecond();
                addWaypoints();
            } else {
                //Toast.makeText(context, "Это 3 вариант", Toast.LENGTH_LONG).show();
                routHalfFirst();
                routHalfSecond();
                fixedAmountRoutePrices = lengthFirstHalf + lengthSecondHalf;
                addWaypoints();
            }
        } else if ((notCityStart || notCityDestination) && !cityCenterDestination && !cityCenterStart
                && hourRoutePointsList.contains(0.0)) {
            if (notCityStart && !notCityDestination) {
                //Toast.makeText(context, "Это 4 вариант", Toast.LENGTH_LONG).show();
                routHalfFirst();
                addWaypoints();
            } else if (!notCityStart) {
                //Toast.makeText(context, "Это 5 вариант", Toast.LENGTH_LONG).show();
                routHalfSecond();
                addWaypoints();
            } else {
                //Toast.makeText(context, "Это 6 вариант", Toast.LENGTH_LONG).show();
                routHalfFirst();
                routHalfSecond();
                fixedAmountRoutePrices = lengthFirstHalf + lengthSecondHalf;
                addWaypoints();
            }
        } else if (!PolyUtil.containsLocation(startGeoCoordinates, hoursNSK.allHours(), true) &&
                !PolyUtil.containsLocation(destinationGeoCoordinates, hoursNSK.allHours(), true)
                && hourRoutePointsList.contains(2.0)) {
            //Toast.makeText(context, "Это 7 вариант", Toast.LENGTH_LONG).show();
            routHalfFirst();
            routHalfSecond();
            fixedAmountRoutePrices = lengthFirstHalf + lengthSecondHalf;
            addWaypoints();
        } else {
            //Toast.makeText(context, "Это 8 вариант", Toast.LENGTH_LONG).show();
            Waypoint startWaypoint = new Waypoint(startGeoCoordinates);
            Waypoint destinationWaypoint = new Waypoint(destinationGeoCoordinates);
            List<Waypoint> waypoints =
                    new ArrayList<>(Arrays.asList(startWaypoint, destinationWaypoint));
            if (Truck.km25 != 0) {
                routingEngine.calculateRoute(
                        waypoints,
                        new RoutingEngine.CarOptions(),
                        (routingError, routes) -> {
                            if (routingError == null) {
                                assert routes != null;
                                Route route = routes.get(0);
                                showRouteDetails(route);
                                showRouteOnMap(route);
                            } else {
                                showDialog("Error while calculating a route:", routingError.toString());
                            }
                        });
            } else {
                routingEngine.calculateRoute(
                        waypoints,
                        new RoutingEngine.TruckOptions(),
                        (routingError, routes) -> {
                            if (routingError == null) {
                                assert routes != null;
                                Route route = routes.get(0);
                                showRouteDetails(route);
                                showRouteOnMap(route);
                            } else {
                                showDialog("Error while calculating a route:", routingError.toString());
                            }
                        });
            }

        }
    }

    private void showRouteDetails(Route route) {
        long estimatedTravelTimeInSeconds = route.getDurationInSeconds();
        int lengthInMeters = route.getLengthInMeters();

        String routeDetails = "Travel Time: " + formatTime(estimatedTravelTimeInSeconds)
                + "\nLength: " + formatLength(lengthInMeters)
                + "\n\nМинимальный заказ по автомобилю " + MainActivity.carName +
                MainActivity.withApparel + " составит:" + routCountPrice(route);
        MainActivity.textRout.setText(routeDetails);
        MainActivity.dialog.show();
        shareTextRout = routCountPrice(route);
    }

    private String formatTime(long sec) {
        long hours = sec / 3600;
        long minutes = (sec % 3600) / 60;

        return String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
    }

    private String formatLength(int meters) {
        int kilometers = meters / 1000;
        int remainingMeters = meters % 1000;

        return String.format(Locale.getDefault(), "%02d.%02d km", kilometers, remainingMeters);
    }

    private void showRouteOnMap(Route route) {
        // Show route as polyline.
        GeoPolyline routeGeoPolyline;
        try {
            routeGeoPolyline = new GeoPolyline(route.getPolyline());
        } catch (InstantiationErrorException e) {
            // It should never happen that the route shape contains less than two vertices.
            return;
        }
        MapPolylineStyle mapPolylineStyle = new MapPolylineStyle();
        mapPolylineStyle.setColor(0x00908AA0, PixelFormat.RGBA_8888);
        mapPolylineStyle.setWidth(10);
        MapPolyline routeMapPolyline = new MapPolyline(routeGeoPolyline, mapPolylineStyle);
        mapView.getMapScene().addMapPolyline(routeMapPolyline);
        mapPolylines.add(routeMapPolyline);

        // Draw a circle to indicate starting point and destination.
        addCircleMapMarker(startGeoCoordinates, R.drawable.green_dot1);
        addCircleMapMarker(destinationGeoCoordinates, R.drawable.green_dot2);

        // Log maneuver instructions per route leg.
        List<Section> sections = route.getSections();
        for (Section section : sections) {
            logManeuverInstructions(section);
        }
    }

    private void logManeuverInstructions(Section section) {
        Log.d(LOG_TAG, "Log maneuver instructions per route leg:");
        List<Maneuver> maneuverInstructions = section.getManeuvers();
        for (Maneuver maneuverInstruction : maneuverInstructions) {
            ManeuverAction maneuverAction = maneuverInstruction.getAction();
            GeoCoordinates maneuverLocation = maneuverInstruction.getCoordinates();
            String maneuverInfo = maneuverInstruction.getText()
                    + ", Action: " + maneuverAction.name()
                    + ", Location: " + maneuverLocation;
            Log.d(LOG_TAG, maneuverInfo);
        }
    }

    void addWaypoints() {
        if (startGeoCoordinates == null || destinationGeoCoordinates == null) {
            showDialog("Error", "Please add a route first.");
            return;
        }

        clearWaypointMapMarker();
        clearRoute();
        Waypoint waypointCentr = new Waypoint(cityCenterGeo);
        List<Waypoint> waypointsPlusCenter = new ArrayList<>(Arrays.asList(new Waypoint(startGeoCoordinates),
                waypointCentr, new Waypoint(destinationGeoCoordinates)));
        if (Truck.km25 != 0) {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.CarOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route route = routes.get(0);
                            showRouteDetails(route);
                            showRouteOnMap(route);

                            // Draw a circle to indicate the location of the waypoints.
                            addCircleMapMarker(waypointCentr.coordinates, R.drawable.red_dot);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        } else {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.TruckOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route route = routes.get(0);
                            showRouteDetails(route);
                            showRouteOnMap(route);

                            // Draw a circle to indicate the location of the waypoints.
                            addCircleMapMarker(waypointCentr.coordinates, R.drawable.red_dot);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        }

    }

    private void routHalfFirst() {
        if (startGeoCoordinates == null) {
            showDialog("Error", "Please add a route first.");
            return;
        }
        Waypoint waypointCentr = new Waypoint(cityCenterGeo);
        List<Waypoint> waypointsPlusCenter = new ArrayList<>(Arrays.asList(new Waypoint(startGeoCoordinates),
                waypointCentr));
        if (Truck.km25 != 0) {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.CarOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route routeFir = routes.get(0);
                            showFirstHalf(routeFir);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        } else {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.TruckOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route routeFir = routes.get(0);
                            showFirstHalf(routeFir);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        }

    }

    private void showFirstHalf(Route routeFir) {
        double lengthInMeters = routeFir.getLengthInMeters();
        if (fixRoutePriceStart != 0) {
            lengthFirstHalf = fixRoutePriceStart;
        } else {
            lengthFirstHalf = Math.ceil(lengthInMeters / 5000) * 10;
        }

    }

    private void routHalfSecond() {
        if (destinationGeoCoordinates == null) {
            showDialog("Error", "Please add a route first.");
            return;
        }
        Waypoint waypointCentr = new Waypoint(cityCenterGeo);
        List<Waypoint> waypointsPlusCenter = new ArrayList<>(Arrays.asList(new Waypoint(destinationGeoCoordinates),
                waypointCentr));
        if (Truck.km25 != 0) {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.CarOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route routeSec = routes.get(0);
                            showSecondHalf(routeSec);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        } else {
            routingEngine.calculateRoute(
                    waypointsPlusCenter,
                    new RoutingEngine.TruckOptions(),
                    (routingError, routes) -> {
                        if (routingError == null) {
                            assert routes != null;
                            Route routeSec = routes.get(0);
                            showSecondHalf(routeSec);
                        } else {
                            showDialog("Error while calculating a route:", routingError.toString());
                        }
                    });
        }

    }

    private void showSecondHalf(Route routeSec) {
        double lengthInMeters = routeSec.getLengthInMeters();
        if (fixRoutePriceDestination != 0) {
            lengthSecondHalf = fixRoutePriceDestination;
        } else {
            lengthSecondHalf = Math.ceil(lengthInMeters / 5000) * 10;
        }
    }

    void clearMap() {
        clearWaypointMapMarker();
        clearRoute();
    }

    private void clearWaypointMapMarker() {
        for (MapMarker mapMarker : mapMarkerList) {
            mapView.getMapScene().removeMapMarker(mapMarker);
        }
        mapMarkerList.clear();
    }

    private void clearRoute() {
        for (MapPolyline mapPolyline : mapPolylines) {
            mapView.getMapScene().removeMapPolyline(mapPolyline);
        }
        mapPolylines.clear();
    }

    private void addCircleMapMarker(GeoCoordinates geoCoordinates, int resourceId) {
        MapImage mapImage = MapImageFactory.fromResource(context.getResources(), resourceId);
        MapMarker mapMarker = new MapMarker(geoCoordinates);
        mapMarker.addImage(mapImage, new MapMarkerImageStyle());
        mapView.getMapScene().addMapMarker(mapMarker);
        mapMarkerList.add(mapMarker);
    }

    //Polygones***************************************************************************************

    void showMapPolygon() {
        clearMapP();

        mapScene.addMapPolygon(hoursNSK.hour00());
        mapScene.addMapPolygon(hoursNSK.hour05l());
        mapScene.addMapPolygon(hoursNSK.hour05r());
        mapScene.addMapPolygon(hoursNSK.hour10l());
        mapScene.addMapPolygon(hoursNSK.hour10r());
        mapScene.addMapPolygon(hoursNSK.hour15l());
        mapScene.addMapPolygon(hoursNSK.hour15r());
        mapScene.addMapPolygon(hoursNSK.hour20l());
        mapScene.addMapPolygon(hoursNSK.hour20r());
        mapScene.addMapPolygon(hoursNSK.hour25l());
        mapScene.addMapPolygon(hoursNSK.hour25r());

        for (MapPolygon p : locality25.arrayMapPolygon()) {
            mapScene.addMapPolygon(p);
        }
    }

    private void clearMapP() {
        if (mapPolygon != null) {
            mapScene.removeMapPolygon(mapPolygon);
        }
    }

    private void searchArrayPointInRoute(GeoPolyline gp) {
        hourRoutePointsList.clear();
        for (GeoCoordinates gc : gp.vertices) {
            if (PolyUtil.containsLocation(gc, hoursNSK.allHours(), true)) {
                if (PolyUtil.containsLocation(gc, hoursNSK.arrHour00, true)) {
                    hourRoutePointsList.add(0.0);
                } else if (PolyUtil.containsLocation(gc, hoursNSK.arrHour05l, true) ||
                        PolyUtil.containsLocation(gc, hoursNSK.arrHour05r, true)) {
                    hourRoutePointsList.add(0.5);
                } else if (PolyUtil.containsLocation(gc, hoursNSK.arrHour10l, true) ||
                        PolyUtil.containsLocation(gc, hoursNSK.arrHour10r, true)) {
                    hourRoutePointsList.add(1.0);
                } else if (PolyUtil.containsLocation(gc, hoursNSK.arrHour15l, true) ||
                        PolyUtil.containsLocation(gc, hoursNSK.arrHour15r, true)) {
                    hourRoutePointsList.add(1.5);
                } else if (PolyUtil.containsLocation(gc, hoursNSK.arrHour20l, true) ||
                        PolyUtil.containsLocation(gc, hoursNSK.arrHour20r, true)) {
                    hourRoutePointsList.add(2.0);
                } else if (PolyUtil.containsLocation(gc, hoursNSK.arrHour25l, true) ||
                        PolyUtil.containsLocation(gc, hoursNSK.arrHour25r, true)) {
                    hourRoutePointsList.add(2.5);
                } else {
                    hourRoutePointsList.add(3.0);
                }
            }
        }
        //Toast.makeText(context, hourRoutePointsList.toString(), Toast.LENGTH_LONG).show();
    }
}
