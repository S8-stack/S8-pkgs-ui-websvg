package com.s8.pkgs.ui.websvg.shapes;

import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.websvg.WebSVG_Element;
import com.s8.pkgs.ui.websvg.WebSources;
import com.s8.pkgs.ui.websvg.style.Fill;
import com.s8.pkgs.ui.websvg.style.FillColor;
import com.s8.pkgs.ui.websvg.style.Stroke;
import com.s8.pkgs.ui.websvg.style.StrokeColor;
import com.s8.pkgs.ui.websvg.style.StrokeSolidity;
import com.s8.pkgs.ui.websvg.style.StrokeThickness;

public class WebSVG_Shape extends WebSVG_Element {
	
	
	
	public final static String WEBPATH = WebSources.WEBPATH + "/shapes"; 

	public WebSVG_Shape(S8WebFront branch, String typeName) {
		super(branch, WEBPATH + typeName);
	}
	
	
	
	
	/**
	 * 
	 * @param stroke
	 */
	public void setStroke(Stroke stroke) {
		setStrokeSolidity(stroke.solidity);
		setStrokeThickness(stroke.thickness);
		setStrokeColor(stroke.color);
	}
	
	
	/**
	 * 
	 * @param solidity
	 */
	public void setStrokeSolidity(StrokeSolidity solidity) {
		vertex.outbound().setUInt8Field("strokeSolidity", solidity.code);
	}
	
	
	/**
	 * 
	 * @param color
	 */
	public void setStrokeColor(StrokeColor color) {
		vertex.outbound().setUInt8Field("strokeColor", color.code);
	}
	
	
	/**
	 * Style: 
	 * @param thickness
	 */
	public void setStrokeThickness(StrokeThickness thickness) {
		vertex.outbound().setUInt8Field("strokeThickness", thickness.code);
	}
	
	

	
	/**
	 * 
	 * @param stroke
	 */
	public void setFill(Fill fill) {
		setFillColor(fill.color);
	}
	
	
	
	/**
	 * 
	 * @param color
	 */
	public void setFillColor(FillColor color) {
		vertex.outbound().setUInt8Field("fillColor", color.code);
	}
	
}
