package UnfoldingMaps;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.Map;

/**
 * Java app for making a map to display life expectancy around the world
 * Created by dank on 10/17/15.
 */
public class LifeExpectancy extends PApplet{
    UnfoldingMap map;

    Map<String, Float> lifeExpByCountry;

    public void setup() {

        lifeExpByCountry = loadLifeExpectancyFromCSV("Data/LifeExpectancyWorldBack.csv");
        // Sets the size of the application
        size(800, 600, OPENGL);
        // Sets the size of the map and type of map.
        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
    }

    private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {

    }
    public void draw() {
        map.draw();
    }
}
