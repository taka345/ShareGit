package informationManager.Sample;

import informationManager.LocalApplet;
import processing.core.PApplet;

public class testPApplet extends LocalApplet {

	public testPApplet(PApplet app_parent) {
		super(app_parent);
	}

	public void setup() {
	    size(300, 200);
	}

	public void draw() {
			background(50);
		    if (mousePressed) {
		      fill(255, 0, 0);
		    } else {
		      fill(0, 255, 0);
		    }
		    ellipse( mouseX, mouseY, 100, 100 );

	}
}
