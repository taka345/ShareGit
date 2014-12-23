package informationManager.Sample;

import informationManager.InfomationFrame;
import processing.core.PApplet;

public class InformationManager extends PApplet {
	private InfomationFrame infoFrame;

	public InformationManager() {}

	testPApplet test1;
	testPApplet test2;
	testPApplet test3;

	public void setup()
	{
		size(600,600);
		test1 = new  testPApplet(this);
		test1.setLocation(0, 0);
		test2 = new  testPApplet(this);
		test2.setLocation(100, 100);
		test3 = new  testPApplet(this);
		test3.setLocation(200, 200);

		this.infoFrame = new InfomationFrame(0, 0, 225, 30, true);
		this.infoFrame.setValue("aaa", test1);
		this.infoFrame.setValue("bbb", test2);
		this.infoFrame.setValue("ccc", test3);
		this.infoFrame.setValue("ddd");
		this.infoFrame.setValue("eee");
	}
	public void draw()
	{
		background(120);
		this.infoFrame.draw(this);
	}
	public void mousePressed() {
		infoFrame.push(this.mouseX, this.mouseY);
	}
}

