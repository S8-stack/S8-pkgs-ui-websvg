package com.s8.pkgs.ui.websvg;

import com.s8.api.web.S8WebFront;
import com.s8.api.web.S8WebFrontObject;

public class WebSVG_Element extends S8WebFrontObject {

	public WebSVG_Element(S8WebFront branch, String typeName) {
		super(branch, typeName);
	}
	
	
	public void isBoundingBoxRelevant(boolean state) {
		vertex.fields().setBool8Field("isBoundingBoxRelevant", state);
	}
	
	
	/**
	 * 
	 * @param solidity
	 */
	public void setStrokeSolidity(WebSVG_StrokeSolidity solidity) {
		vertex.fields().setUInt8Field("strokeSolidity", solidity.code);
	}
	
	
	/**
	 * 
	 * @param color
	 */
	public void setStrokeColor(WebSVG_StrokeColor color) {
		vertex.fields().setUInt8Field("strokeColor", color.code);
	}
	
	
	/**
	 * Style: 
	 * @param thickness
	 */
	public void setStrokeThickness(float thickness) {
		vertex.fields().setFloat32Field("strokeThickness", thickness);
	}

}
