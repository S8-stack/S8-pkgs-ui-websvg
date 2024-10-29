package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.maths.SVG_Vector;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Line;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;

/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_LineModel extends WebSVG_ShapeModel {
	

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
	public static WebSVG_LineModel create(SVG_Stroke stroke,
			double x0, double y0, double x1, double y1, boolean isBoundingBoxUpdating) {
		WebSVG_LineModel circle = new WebSVG_LineModel();
		circle.setStroke(stroke);
		circle.setCoordinates(x0, y0, x1, y1);
		circle.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return circle;
	}
	
	public static WebSVG_LineModel create(SVG_Stroke stroke,
			SVG_Vector p0, SVG_Vector p1, boolean isBoundingBoxUpdating) {
		return create(stroke, p0.getX(), p0.getY(), p1.getX(), p1.getY(), isBoundingBoxUpdating);
	}
	


	public static WebSVG_LineModel create(double x0, double y0, double x1, double y1) {
		WebSVG_LineModel line = new WebSVG_LineModel();
		line.setCoordinates(x0, y0, x1, y1);
		return line;
	}
	
	
	public @S8Field(name = "x0") double x0;
	
	public @S8Field(name = "y0") double y0;
	
	public @S8Field(name = "x1") double x1;
	
	public @S8Field(name = "y1") double y1;
	
	
	
	/** S8 constructor */
	public WebSVG_LineModel() { super(); }
	
	
	
	/**
	 * 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	public void setCoordinates(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		
	}
	
	/**
	 * 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	public void setCoordinates(SVG_Vector p0, SVG_Vector p1) {
		this.x0 = p0.getX();
		this.y0 = p0.getY();
		this.x1 = p1.getX();
		this.y1 = p1.getY();
	}
	
	

	/**
	 * following order: {x0, y0, x1, y1}
	 * @param coordinates
	 */
	public void setCoordinates(double[] coordinates) {
		this.x0 = coordinates[0];
		this.y0 = coordinates[1];
		this.x1 = coordinates[2];
		this.y1 = coordinates[3];
	}
	

	@Override
	public WebSVG_Shape createWeb(S8WebFront front) {
		WebSVG_Line line = new WebSVG_Line(front);
		line.setCoordinates(x0, y0, x1, y1);
		
		
		applyStyle(line);
		applyProperties(line);
		
		return null;
	}

	
}
