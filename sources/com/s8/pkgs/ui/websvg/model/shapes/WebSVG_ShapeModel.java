package com.s8.pkgs.ui.websvg.model.shapes;

import com.s8.api.annotations.S8Field;
import com.s8.api.annotations.S8ObjectType;
import com.s8.pkgs.io.svg.styles.SVG_Fill;
import com.s8.pkgs.io.svg.styles.SVG_FillColor;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.io.svg.styles.SVG_StrokeColor;
import com.s8.pkgs.io.svg.styles.SVG_StrokeSolidity;
import com.s8.pkgs.io.svg.styles.SVG_StrokeThickness;
import com.s8.pkgs.ui.websvg.model.WebSVG_ElementModel;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;


/**
 * 
 */
@S8ObjectType(name = "com.s8.pkgs.ui.websvg.model.shapes.WebSVG_ShapeModel", sub = {
		WebSVG_CircleModel.class,
		WebSVG_LineModel.class,
		WebSVG_PathModel.class,
		WebSVG_PolygonModel.class,
		WebSVG_PolylineModel.class,
		WebSVG_RectangleModel.class
})
public abstract class WebSVG_ShapeModel extends WebSVG_ElementModel {
	
	
	/**
	 * 
	 * @param solidity
	 */
	@S8Field(name = "stroke-solidity")
	public SVG_StrokeSolidity strokeSolidity = SVG_StrokeSolidity.SOLID;
	
	
	@S8Field(name = "stroke-color")
	public SVG_StrokeColor strokeColor = SVG_StrokeColor.BLACK;
	
	
	@S8Field(name = "stroke-thickness")
	public SVG_StrokeThickness strokeThickness = SVG_StrokeThickness.ONE;
	

	@S8Field(name = "fill-color")
	public SVG_FillColor fillColor = SVG_FillColor.NONE;

	
	/** S8 constructor */
	public WebSVG_ShapeModel() { super(); }
	
	
	
	
	/**
	 * 
	 * @param stroke
	 */
	public void setStroke(SVG_Stroke stroke) {
		setStrokeSolidity(stroke.solidity);
		setStrokeThickness(stroke.thickness);
		setStrokeColor(stroke.color);
	}
	
	
	/**
	 * Define Stroke
	 * @param solidity
	 * @param thickness
	 * @param color
	 */
	public void setStroke(SVG_StrokeSolidity solidity, SVG_StrokeThickness thickness, SVG_StrokeColor color) {
		setStrokeSolidity(solidity);
		setStrokeThickness(thickness);
		setStrokeColor(color);
	}
	
	
	/**
	 * 
	 * @param solidity
	 */
	public void setStrokeSolidity(SVG_StrokeSolidity solidity) {
		this.strokeSolidity = solidity;
	}
	
	
	/**
	 * 
	 * @param color
	 */
	public void setStrokeColor(SVG_StrokeColor color) {
		this.strokeColor = color;
	}
	
	
	/**
	 * Style: 
	 * @param thickness
	 */
	public void setStrokeThickness(SVG_StrokeThickness thickness) {
		this.strokeThickness = thickness;
	}
	
	

	public void setFill(SVG_Fill fill) {
		setFillColor(fill.color);
	}


	
	/**
	 * 
	 * @param stroke
	 */
	public void setFillColor(SVG_FillColor color) {
		this.fillColor = color;
	}
	
	
	
	protected void applyStyle(WebSVG_Shape shape) {
		shape.setStroke(strokeSolidity, strokeThickness, strokeColor);
		shape.setFillColor(fillColor);
	}
	
}
