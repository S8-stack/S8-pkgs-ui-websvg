package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.annotations.S8ObjectType;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.maths.SVG_Vector;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Polyline;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;


/**
 * 
 * @author pierreconvert
 *
 */
@S8ObjectType(name = "com.s8.pkgs.ui.websvg.model.shapes.WebSVG_PolylineModel")
public class WebSVG_PolylineModel extends WebSVG_ShapeModel {
	

	/**
	 * 
	 * @param branch
	 * @param stroke
	 * @param coordinates
	 * @param isBoundingBoxUpdating
	 * @return
	 */
	public static WebSVG_PolylineModel create(S8WebFront branch, SVG_Stroke stroke, double[] coordinates, boolean isBoundingBoxUpdating) {
		WebSVG_PolylineModel polyline = new WebSVG_PolylineModel();
		polyline.setStroke(stroke);
		polyline.setCoordinates(coordinates);
		polyline.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return polyline;
	}
	
	/**
	 * 
	 * @param branch
	 * @param stroke
	 * @param coordinates
	 * @param isBoundingBoxUpdating
	 * @return
	 */
	public static WebSVG_PolylineModel create(S8WebFront branch, SVG_Stroke stroke, SVG_Vector[] points, boolean isBoundingBoxUpdating) {
		WebSVG_PolylineModel polyline = new WebSVG_PolylineModel();
		polyline.setStroke(stroke);
		polyline.setCoordinates(points);
		polyline.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return polyline;
	}
	
	
	/**
	 * 
	 * @param branch
	 * @param coordinates
	 * @return
	 */
	public static WebSVG_PolylineModel create(S8WebFront branch, double[] coordinates) {
		WebSVG_PolylineModel line = new WebSVG_PolylineModel();
		line.setCoordinates(coordinates);
		return line;
	}
	
	
	/**
	 * following order: {x0, y0, x1, y1, ... , x[n-1], y[n-1]}
	 */
	public @S8Field(name = "coordinates") double[] coordinates;
	
	
	/** S8 constructor */
	public WebSVG_PolylineModel() { super(); }
	

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
			coordinates[2*i + 0] = (float) point.getX();
			coordinates[2*i + 1] = (float) point.getY();
		}
		this.coordinates = coordinates;
	}

	@Override
	public WebSVG_Shape createWeb(S8WebFront front) {
		WebSVG_Polyline polyline = new WebSVG_Polyline(front);
		polyline.setCoordinates(coordinates);
		
		applyStyle(polyline);
		applyProperties(polyline);
		return polyline;
	}

}
