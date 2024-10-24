package com.s8.pkgs.ui.websvg.shapes;

import java.util.List;

import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.styles.Fill;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.path.WebSVG_PathElement;

/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_Path extends WebSVG_Shape {

	

	/**
	 * 
	 * @param branch
	 * @param stroke
	 * @param fill
	 * @param isBoundingBoxUpdating
	 * @param elements
	 * @return
	 */
	public static WebSVG_Path create(S8WebFront branch, SVG_Stroke stroke, Fill fill,
			boolean isBoundingBoxUpdating,
			WebSVG_PathElement... elements) {
		WebSVG_Path shape = new WebSVG_Path(branch);
		if(stroke != null) { shape.setStroke(stroke); }
		if(fill != null) { shape.setFill(fill); }
		shape.isBoundingBoxRelevant(isBoundingBoxUpdating);
		shape.setElements(elements);
		return shape;
	}


	public WebSVG_Path(S8WebFront branch) {
		super(branch, "/WebSVG_Path");
	}
	
	
	/**
	 * 
	 * @param point
	 */
	public void setElements(WebSVG_PathElement... elements) {
		vertex.outbound().setExplicitSerializableArrayField("elements", elements);
	}
	
	
	/**
	 * 
	 * @param point
	 */
	public void setElements(List<WebSVG_PathElement> elements) {
		vertex.outbound().setExplicitSerializableArrayField("elements", elements);
	}



}
