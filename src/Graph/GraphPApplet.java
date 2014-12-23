package Graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import processing.core.PApplet;

public class GraphPApplet extends PApplet{
	DefaultPieDataset data;
	JFreeChart chart;
	ChartPanel cpanel;

	public void setPieData() {
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		data = new DefaultPieDataset();


		chart = ChartFactory.createPieChart("PieChartTest", data, true, false, false);
		chart.setBackgroundPaint(Color.PINK);

		cpanel = new ChartPanel(null);
	    cpanel.setChart(chart);
	}

	public void setup() {
		size(400,400);
		setPieData();

		cpanel.setPreferredSize(new Dimension(400, 400));
	    this.add(cpanel, BorderLayout.CENTER);
	}

	public void draw() {
		background(200);
		data.setValue("アサヒ", 37);
		data.setValue("キリン", 36);
		data.setValue("サントリー", 13);
		data.setValue("サッポロ", 12);
		data.setValue("その他", 2);
	}
}

