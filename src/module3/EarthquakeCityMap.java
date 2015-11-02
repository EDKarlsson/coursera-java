package module3;

//Java utilities libraries

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * EarthquakeCityMap An application with an interactive map displaying earthquake data. Author: UC San Diego Intermediate Software
 * Development MOOC team
 *
 * @author Dan Karlsson: October 17, 2015
 */
public class EarthquakeCityMap extends PApplet {

    /**
     * The Threshold moderate. The constant THRESHOLD_MODERATE. Less than this threshold is a light earthquake
     */
    public static final  float   THRESHOLD_MODERATE = 5;
    /**
     * The Threshold light. The constant THRESHOLD_LIGHT. Less than this threshold is a minor earthquake
     */
    public static final  float   THRESHOLD_LIGHT    = 4;
    // You can ignore this.  It's to keep eclipse from generating a warning.
    private static final long    serialVersionUID   = 1L;
    // IF YOU ARE WORKING OFFLINE, change the value of this variable to true
    private static final boolean offline            = false;
    /**
     * This is where to find the local tiles, for working without an Internet connection
     */

    public static        String  mbTilesString      = "blankLight-1-3.mbtiles";
    private final        boolean DEBUG              = true;
    // The map
    private UnfoldingMap map;
    //feed with magnitude 2.5+ Earthquakes
    private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
    private PointFeature feature;

    private float magnitude;
    private int yellow = color(255, 255, 0);
    private int red    = color(200, 0, 0);
    private int blue   = color(0, 102, 255);
    private int white  = color(255, 255, 255);
    private int grey   = color(50, 50, 50);
    private int black  = color(0, 0, 0);

    public void setup() {
        size(950, 600, OPENGL);

        if (offline) {
            map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
            earthquakesURL = "2.5_week.atom";    // Same feed, saved Aug 7, 2015, for working offline
        }
        else {
            map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
            // IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
            //earthquakesURL = "2.5_week.atom";
        }

        map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);

        // The List you will populate with new SimplePointMarkers
        List<Marker> markers = new ArrayList<Marker>();

        //Use provided parser to collect properties for each earthquake
        //PointFeatures have a getLocation method
        List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);

        // These print statements show you (1) all of the relevant properties
        // in the features, and (2) how to get one property and use it
        if (DEBUG) {
            if (earthquakes.size() > 0) {
                PointFeature f = earthquakes.get(0);
                System.out.println(f.getProperties());
                Object magObj = f.getProperty("magnitude");
                float mag = Float.parseFloat(magObj.toString());
                println("Magnitude : " + mag);
                // PointFeatures also have a getLocation method
                // System.out.println(createMarker(f));
            }
        }

        // Here is an example of how to use Processing's color method to generate
        // an int that represents the color yellow.

        //TODO: Add code here as appropriate
        for (PointFeature quake : earthquakes) {
            markers.add(createMarker(quake));
        }
        map.addMarkers(markers);
    }

    /**
     * createMarker
     *
     * @param feature
     *         A suggested helper method that takes in an earthquake feature
     *
     * @return returns a SimplePointMarker for that earthquake
     */
    private SimplePointMarker createMarker(PointFeature feature)
    {
        SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
        marker.setRadius(10);
        Object magObject = feature.getProperty("magnitude");
        this.magnitude = Float.parseFloat(magObject.toString());
        if (DEBUG) {
            println("-----------------------------------------------");
        }
        if (this.magnitude > THRESHOLD_MODERATE) {
            if (DEBUG) {
                println("Color : red");
            }
            marker.setColor(this.red);
            marker.setRadius(20);
        }
        else if (this.magnitude > THRESHOLD_LIGHT) {
            marker.setColor(this.yellow);
            marker.setRadius(15);
            if (DEBUG) {
                println("Color : yellow");
            }
        }
        else {
            marker.setColor(this.blue);
            if (DEBUG) {
                println("Color : blue");
            }
        }
        if (DEBUG) {
            println("Marker Magnitude : " + this.magnitude);
            println("Marker Lat: " + marker.getLocation().getLat());
            println("Marker Lon: " + marker.getLocation().getLon());
            println("-----------------------------------------------");
        }
        // PointFeatures also have a getLocation method
        return marker;
    }
    public void draw() {
        background(10);
        map.draw();
        addKey();
    }

    // helper method to draw key in GUI
    // TODO: Implement this method to draw the key
    private void addKey()
    {
        int rectHeight = 300;
        int rectWidth  = 175;
        int rectX      = 20;
        int rectY      = 50;

        // Remember you can use Processing's graphics methods here
        fill(grey);
        rect(rectX, rectY, rectWidth, rectHeight);
        fill(white);
        rect(rectX, rectY, rectWidth, rectHeight);
        fill(red);
        ellipse(50, 80, 30, 30);
        fill(black);
        text("Moderate Magnitude > 4.9", 80, 105);

        fill(yellow);
        ellipse(50, 170, 20, 20);
        fill(black);
        text("Light Magnitude 4.0 - 4.9", 80, 175);

        fill(blue);
        ellipse(50, 230, 10, 10);
        fill(black);

        text("Magnitude < 4.0", 80, 235);
        fill(white);
    }
}
