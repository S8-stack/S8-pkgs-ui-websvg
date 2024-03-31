package com.s8.pkgs.ui.websvg.charts;

import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.websvg.WebSVG_Canvas;
import com.s8.pkgs.ui.websvg.style.Stroke;
import com.s8.pkgs.ui.websvg.style.StrokeColor;
import com.s8.pkgs.ui.websvg.style.StrokeSolidity;
import com.s8.pkgs.ui.websvg.style.StrokeThickness;

public class WebSVG_Chart {
	
	
	public static class Props {
		
		public int xNbTicks = 5;
		
		public int yNbTicks = 4;
		
		
		public Stroke axisStroke = Stroke.create(StrokeSolidity.SOLID, StrokeThickness.THREE_QUARTERS, StrokeColor.LIGHT_GREY2);
		
		public Stroke tickStroke = Stroke.create(StrokeSolidity.SOLID, StrokeThickness.THREE_QUARTERS, StrokeColor.LIGHT_GREY2);
		
		public Stroke curveStroke = Stroke.create(StrokeSolidity.SOLID, StrokeThickness.ONE_AND_A_HALF, StrokeColor.BLUE);
		
		
	}
	
	
	
	public static WebSVG_Canvas create(S8WebFront front, double[] xCoordinates, double[] yCoordinates, Props props) {
		BoundingBox1d xBoundingBox = BoundingBox1d.create(xCoordinates);
		BoundingBox1d yBoundingBox = BoundingBox1d.create(yCoordinates);
	
		double xMin = xBoundingBox.getMin(), xMax = xBoundingBox.getMax();
		
		
		
		
		WebSVG_Canvas canvas = new WebSVG_Canvas(front);
		
		
		
		
		return canvas;
	}
	
	
}
