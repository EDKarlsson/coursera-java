package creatingGuis;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * Created by dank on 10/17/15.
 * Application for demonstrating how the PApplet class works with loading images
 * and dynamically changing display values within the application.
 *
 */
public class DisplayImage extends PApplet{
    PImage img;

    public void setup() {
        // Add setup for my MyPApplet
        size(400, 400);         // Set Canvas Size
        background(255);        // set canvas color
        stroke(0);              // Set pen color
        img = loadImage("https://scontent-lga3-1.xx.fbcdn.net/hphotos-xtp1/v/t1" + "" +
                ".0-9/12108306_10206696228218582_2860135778004971364_n.jpg?oh=3e92088519f418b9734b96935adffac7&oe=56BEDBEA");
        img.resize(0, height);          // Resize loaded image to full height of canvas
        image(img, 0, 0);
    }

    public void draw() {
        // Add drawing code for DisplayImage
        int[] color = sunColorSec(second());        // Calculate color code for sun
        fill(color[0], color[1], color[2]);         // Set sun color
        ellipse(width / 4, height / 5, width / 4, height / 5);  // Draw Sun
    }

    public int[] sunColorSec(float seconds) {
        int[] rgb = new int[3];
        // Scale the brightness of the yellow based on the seconds. 0 seconds
        // is black. 30 seconds i bright yellow.
        float diffFrom30 = Math.abs(30 - seconds);

        float ratio = diffFrom30/30;
        rgb[0] = (int) (255 * ratio);
        rgb[1] = (int) (255 * ratio);
        rgb[2] = 0;

        // System.out.println("R" + rgb[0] + " G" + rgb[1] + " B" + rgb[2]);
        return rgb;
    }

    public static void main(String[] args) {

    }
}
