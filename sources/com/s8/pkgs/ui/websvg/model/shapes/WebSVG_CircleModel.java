package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.maths.SVG_Vector;
import com.s8.pkgs.io.svg.styles.SVG_Fill;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Circle;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;

/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_CircleModel extends WebSVG_ShapeModel {

	

	
	/**
	 * 
	 * @param front
	 * @param stroke
	 * @param center
	 * @param r
	 * @param isBoundingBoxUpdating
	 * @return
	 */
	public static WebSVG_CircleModel createCircle(SVG_Stroke stroke,
			SVG_Vector center, double r, boolean isBoundingBoxUpdating) {
		return createCircle(stroke, center.getX(), center.getY(), r, isBoundingBoxUpdating);
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
	public static WebSVG_CircleModel createCircle(SVG_Stroke stroke,
			double xc, double yc, 
			double r,
			boolean isBoundingBoxUpdating) {
		WebSVG_CircleModel circle = new WebSVG_CircleModel();
		circle.setStroke(stroke);
		circle.setCenter(xc, yc);
		circle.setRadius(r);
		circle.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return circle;
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
	public static WebSVG_CircleModel createRound(SVG_Stroke stroke, SVG_Fill fill,
			SVG_Vector center,double r,
			boolean isBoundingBoxUpdating) {
		WebSVG_CircleModel shape = new WebSVG_CircleModel();
		shape.setStroke(stroke);
		shape.setFill(fill);
		shape.setCenter(center);
		shape.setRadius(r);
		shape.setBoundingBoxRelevant(isBoundingBoxUpdating);
		return shape;
	}

	
	
	



	public @S8Field(name = "center-x") double xCenter;

	public @S8Field(name = "center-y") double yCenter;

	public @S8Field(name = "radius") double radius;

	
	/** S8 constructor */
	public WebSVG_CircleModel() { super(); }

	
	/**
	 * 
	 * @param point
	 */
	public void setCenter(SVG_Vector point) {
		this.xCenter = point.getX();
		this.yCenter = point.getY();
	}
	
	
	public void setCenter(double x0, double y0) {
		this.xCenter = x0;
		this.yCenter = y0;
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
		WebSVG_Circle circle = new WebSVG_Circle(front);
		circle.setCenter(xCenter, yCenter);
		circle.setRadius(radius);
		
		applyStyle(circle);
		applyProperties(circle);
		
		return circle;
	}
	




}
