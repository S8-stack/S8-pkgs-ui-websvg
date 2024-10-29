package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.maths.SVG_Vector;
import com.s8.pkgs.io.svg.styles.SVG_Fill;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Polygon;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;


/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_PolygonModel extends WebSVG_ShapeModel {
	

	/**
	 * 
	 * @param branch
	 * @param color
	 * @param solidity
	 * @param thickness
	 * @param xc
	 * @param yc
	 * @param r
	 * @return
	 */
	public static WebSVG_PolygonModel create(S8WebFront branch, SVG_Stroke stroke, SVG_Fill fill,
			double[] coordinates, boolean isBoundingBoxUpdating) {
		WebSVG_PolygonModel polyline = new WebSVG_PolygonModel();
		polyline.setStroke(stroke);
		polyline.setCoordinates(coordinates);
		polyline.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return polyline;
	}
	
	
	/**
	 * 
	 * @param branch
	 * @param coordinates
	 * @return
	 */
	public static WebSVG_PolygonModel create(S8WebFront branch, double[] coordinates) {
		WebSVG_PolygonModel line = new WebSVG_PolygonModel();
		line.setCoordinates(coordinates);
		return line;
	}
	
	/**
	 * following order: {x0, y0, x1, y1, ... , x[n-1], y[n-1]}
	 */
	public @S8Field(name = "coordinates") double[] coordinates;
	
	
	
	/** S8 constructor */
	public WebSVG_PolygonModel() { super(); }
	

	/**
	 * following order: {x0, y0, x1, y1, ... , x[n-1], y[n-1]}
	 * @param coordinates
	 */
	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
	
	/**
	 * following order: {x0, y0, x1, y1, ... , x[n-1], y[n-1]}
	 * @param coordinates
	 */
	public void setCoordinates(SVG_Vector[] points) {
		int nPoints = points.length;
		double[] coordinates = new double[2*nPoints];
		for(int i = 0; i<nPoints; i++) {
			SVG_Vector point = points[i];
			coordinates[2*i + 0] = point.getX();
			coordinates[2*i + 1] = point.getY();
		}
		this.coordinates = coordinates;
	}

	
	@Override
	public WebSVG_Shape createWeb(S8WebFront front) {
		WebSVG_Polygon polygon = new WebSVG_Polygon(front);
		polygon.setCoordinates(coordinates);
		
		applyStyle(polygon);
		applyProperties(polygon);
		return polygon;
	}
}
