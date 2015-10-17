package creatingGuis;
import processing.core.PApplet;
/**
 * Created by dank on 10/17/15.
 */
public class MyDisplay extends PApplet{
    public void setup() {
        size(400, 400);
        background(200, 200, 200);
    }

    public void draw() {
        int faceWidth = 390;
        int faceHeight = 390;
        fill(255, 255, 0);
        ellipse(200, 200, faceWidth, faceHeight);
        fill(0, 0, 0);
        ellipse(125, 140, 50, 70);
        ellipse(275, 140, 50, 70);
        noFill  ();
        arc(200, 250, (faceWidth/2), (faceHeight/3), 0, PI);
    }
}
