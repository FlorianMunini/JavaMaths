package View;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This program demonstrates how to draw XY line chart with XYDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */

public class GraphiqueView extends JFrame {
	private JFrame frame3=null;
	public GraphiqueView() {
		createChartPanel();
	}
	
	private JPanel createChartPanel() {
		
		String chartTitle = "FFT";
		String xAxisLabel = "X";
		String yAxisLabel = "Y";
		
		XYDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,xAxisLabel, yAxisLabel, dataset,PlotOrientation.VERTICAL,false,false,false);
		
		
		customizeChart(chart);
		
		// saves the chart as an image files
		File imageFile = new File("Graphique FFT.png");
		int width = 640;
		int height = 480;
		
		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		return new ChartPanel(chart);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("FFT Sinus");
		
		series1.add(1.0, 3.0);
		series1.add(2.0, 3.0);
		series1.add(3.0, 2.5);
		series1.add(3.5, 2.8);
		series1.add(4.2, 6.0);
		series1.add(10.2, 4.0);
				
		dataset.addSeries(series1);
		return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);

		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(1.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
	public void display() {
		frame3 = new JFrame();
		JPanel chartPanel = createChartPanel();
		frame3.add(chartPanel, BorderLayout.CENTER);
		frame3.setTitle("Graphique de la FFT");
		frame3.setSize(800, 800);
		frame3.setLocation(800, 100);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setVisible(true);

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new GraphiqueView().setVisible(true);
				
			}
				
		});
			}
	public void close() {

		frame3.dispose();
	}

}