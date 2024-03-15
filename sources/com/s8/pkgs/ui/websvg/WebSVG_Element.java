package com.s8.pkgs.ui.websvg;

import com.s8.api.web.S8WebFront;
import com.s8.api.web.S8WebObject;

public class WebSVG_Element extends S8WebObject {

	public WebSVG_Element(S8WebFront branch, String typeName) {
		super(branch, typeName);
	}
	
	
	public void isBoundingBoxRelevant(boolean state) {
		vertex.outbound().setBool8Field("isBoundingBoxRelevant", state);
	}
	
	
	/**
	 * 
	 * @param solidity
	 */
	public void setStrokeSolidity(WebSVG_StrokeSolidity solidity) {
		vertex.outbound().setUInt8Field("strokeSolidity", solidity.code);
	}
	
	
	/**
	 * 
	 * @param color
	 */
	public void setStrokeColor(WebSVG_StrokeColor color) {
		vertex.outbound().setUInt8Field("strokeColor", color.code);
	}
	
	
	/**
	 * Style: 
	 * @param thickness
	 */
	public void setStrokeThickness(float thickness) {
		vertex.outbound().setFloat32Field("strokeThickness", thickness);
	}

}
