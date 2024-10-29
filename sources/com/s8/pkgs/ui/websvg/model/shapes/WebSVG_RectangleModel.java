package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.maths.SVG_Vector;
import com.s8.pkgs.io.svg.styles.SVG_Fill;
import com.s8.pkgs.io.svg.styles.SVG_FillColor;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Rectangle;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;

/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_RectangleModel extends WebSVG_ShapeModel {

	

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
	public static WebSVG_RectangleModel create(SVG_Stroke stroke, SVG_Fill fill,
			double x, double y, double width, double height, 
			boolean isBoundingBoxUpdating) {
		WebSVG_RectangleModel shape = new WebSVG_RectangleModel();
		if(stroke != null) { shape.setStroke(stroke); }
		if(fill != null) { shape.setFill(fill); }
		shape.setTopLeftCorner(x, y);
		shape.setWidth(width);
		shape.setHeight(height);
		shape.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return shape;
	}
	
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
	public static WebSVG_RectangleModel createRound(S8WebFront branch, SVG_Stroke stroke, SVG_FillColor fill,
			double x, double y, double width, double height, double radius,
			boolean isBoundingBoxUpdating) {
		WebSVG_RectangleModel shape = new WebSVG_RectangleModel();
		if(stroke != null) { shape.setStroke(stroke); }
		if(fill != null) { shape.setFillColor(fill); }
		shape.setTopLeftCorner(x, y);
		shape.setWidth(width);
		shape.setHeight(height);
		shape.setRadius(radius);
		shape.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return shape;
	}
	
	
	
	public @S8Field(name = "top-left-corner-x") double xTopLeftCorner;

	public @S8Field(name = "top-left-corner-y") double yTopLeftCorner;

	public @S8Field(name = "width") double width;

	public @S8Field(name = "height") double height;
	
	public @S8Field(name = "corner-radius") double radius = -1;


	
	/** S8 constructor */
	public WebSVG_RectangleModel() { super(); }

	
	/**
	 * 
	 * @param point
	 */
	public void setTopLeftCorner(SVG_Vector point) {
		xTopLeftCorner = point.getX();
		yTopLeftCorner = point.getY();
	}
	

	public void setTopLeftCorner(float x, float y) {
		xTopLeftCorner = x;
		yTopLeftCorner = y;
	}
	
	
	public void setTopLeftCorner(double x, double y) {
		xTopLeftCorner = x;
		yTopLeftCorner = y;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setWidth(float value) {
		this.width = value;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setWidth(double value) {
		this.width = value;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setHeight(float value) {
		this.height = value;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setHeight(double value) {
		this.height = value;
	}
	
	
	/**
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public WebSVG_Shape createWeb(S8WebFront front) {
		WebSVG_Rectangle rectangle = new WebSVG_Rectangle(front);
		rectangle.setTopLeftCorner(xTopLeftCorner, yTopLeftCorner);
		rectangle.setWidth(width);
		rectangle.setHeight(height);
		if(radius > 0) { rectangle.setRadius(radius); }
		
		applyStyle(rectangle);
		applyProperties(rectangle);
		
		return rectangle;
	}
	


}
