package LifeExpectancy;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java app for making a map to display life expectancy around the world Created by dank on 10/17/15.
 */
public class LifeExpectancy extends PApplet {
    /**
     * The Map.
     */

    UnfoldingMap           map;
    /**
     * The Life exp map.
     */

    HashMap<String, Float> lifeExpMap;
    /**
     * The Life exp by country.
     */

    Map<String, Float>     lifeExpByCountry;
    /**
     * The Countries.
     */

    List<Feature>          countries;
    /**
     * The Country markers.
     */

    List<Marker>           countryMarkers;

    public void setup() {
        // Sets the size of the application
        size(800, 600, OPENGL);
        // Sets the size of the map and type of map.
        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);

        // Loads a Comma Separated Values file with data about the life expectancies of countries around the world
        lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBank.csv");
        println("Loaded " + lifeExpMap.size() + " data entries");

        // Load country polygons and adds them as markers
        countries = GeoJSONReader.loadData(this, "countries.geo.json");
        countryMarkers = MapUtils.createSimpleMarkers(countries);
        map.addMarkers(countryMarkers);

        // Country markers are shaded according to life expectancy (only once)
        shadeCountries();
    }

    private void shadeCountries() {
        for (Marker marker : countryMarkers) {
            String countryId = marker.getId();
            if (lifeExpMap.containsKey(countryId)) {
                float lifeExp = lifeExpMap.get(countryId);
                int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
                marker.setColor(color(255 - colorLevel, 100, colorLevel));
            }
            else {
                marker.setColor(color(150, 150, 150));

            }
        }
    }

    private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
        Map<String, Float> lifeExpMap = new HashMap<String, Float>();
        String[]           rows       = loadStrings(fileName);

        for (String row : rows) {
            String[] columns = row.split(",");
            if (columns.length == 6 && !columns[5].equals("..")) {
                float value = Float.parseFloat(columns[5]);
                lifeExpMap.put(columns[4], value);
            }
        }
        return lifeExpMap;
    }

    public void draw() {
        map.draw();
    }
}
