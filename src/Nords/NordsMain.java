package Nords;

import processing.core.PApplet;

public class NordsMain extends PApplet {
	/*-------------------------------------------
	nords[0] = X-coordinate
	nords[1] = Y-coordinate
	-------------------------------------------*/
	//private int[] nords = {20,20, 120,20, 120,120};
	private int[] nords = {100,0, 200,80, 120,200, 40,180, 0,60};

	public void setup(){
		size(400,400);
	}

	public void draw() {
		background(255);
		shape(this.nords);

		int[] g = CoordinateCalculation.getCenter(nords);
		println(g);
		pushStyle();
		fill(0);
		point(g[0], g[1]);
		popStyle();
	}

	public void shape(int[] nords) {
		beginShape();
		for(int i = 0; i < nords.length; i+=2) {
			vertex(nords[i], nords[i+1]);
		}
		endShape(CLOSE);
	}

}
