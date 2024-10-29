package com.s8.pkgs.ui.websvg.model.shapes;

import java.util.List;

import com.s8.api.annotations.S8Field;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.styles.SVG_FillColor;
import com.s8.pkgs.io.svg.styles.SVG_Stroke;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Path;
import com.s8.pkgs.ui.websvg.shapes.WebSVG_Shape;
import com.s8.pkgs.ui.websvg.shapes.path.WebSVG_PathElement;

/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_PathModel extends WebSVG_ShapeModel {



	/**
	 * 
	 * @param branch
	 * @param stroke
	 * @param fill
	 * @param isBoundingBoxUpdating
	 * @param elements
	 * @return
	 */
	public static WebSVG_PathModel create(SVG_Stroke stroke, SVG_FillColor fill,
			boolean isBoundingBoxUpdating,
			WebSVG_PathElement... elements) {
		WebSVG_PathModel shape = new WebSVG_PathModel();
		if(stroke != null) { shape.setStroke(stroke); }
		if(fill != null) { shape.setFillColor(fill); }
		shape.setBoundingBoxRelevant(isBoundingBoxUpdating);
		shape.setElements(elements);
		return shape;
	}


	public @S8Field(name = "elements") WebSVG_PathElement[] elements;


	/** S8 constructor */
	public WebSVG_PathModel() { super(); }


	/**
	 * 
	 * @param point
	 */
	public void setElements(WebSVG_PathElement... elements) {
		this.elements = elements;
	}


	/**
	 * 
	 * @param point
	 */
	public void setElements(List<WebSVG_PathElement> elements) {
		int n = elements.size();
		WebSVG_PathElement[] array = new WebSVG_PathElement[n];
		for(int i = 0; i<n; i++) { array[i] = elements.get(i); }
		this.elements = array;
	}

	

	@Override
	public WebSVG_Shape createWeb(S8WebFront front) {
		WebSVG_Path polygon = new WebSVG_Path(front);
		polygon.setElements(elements);
		
		applyStyle(polygon);
		applyProperties(polygon);
		return polygon;
	}


}
