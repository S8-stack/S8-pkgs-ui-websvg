package com.s8.pkgs.ui.websvg.model;

import java.util.List;

import com.s8.api.annotations.S8Field;
import com.s8.api.annotations.S8ObjectType;
import com.s8.api.flow.repository.objects.RepoS8Object;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.websvg.WebSVG_Canvas;
import com.s8.pkgs.ui.websvg.WebSVG_Element;


/**
 * 
 * @author pierreconvert
 *
 */
@S8ObjectType(name = "com.s8.pkgs.ui.websvg.model.WebSVG_CanvasModel")
public class WebSVG_CanvasModel extends RepoS8Object {

	
	public @S8Field(name = "elements") WebSVG_ElementModel[] elements;
	
	
	public @S8Field(name = "viewport-width") double viewportWidth = 1920;
	
	public @S8Field(name = "viewport-height") double viewportHeight = 1080;
	

	
	public @S8Field(name = "margin-top") double marginTop = 10;
	
	public @S8Field(name = "margin-right") double marginRight = 20;
	
	public @S8Field(name = "margin-bottom") double marginBottom = 10;
	
	public @S8Field(name = "margin-left") double marginLeft = 20;
	
	
	/**
	 * 
	 * @param front
	 * @param typeName
	 */
	public WebSVG_CanvasModel() { super(); }
	
	

	/**
	 * 
	 * @param elements
	 */
	public void setElements(List<WebSVG_ElementModel> elements) {
		int n = elements.size();
		WebSVG_ElementModel[] array = new WebSVG_ElementModel[n];
		for(int i = 0; i<n; i++) { array[i] = elements.get(i); }
		this.elements = array;
	}
	
	
	
	
	
	/**
	 * 
	 * @param width
	 */
	public void setViewportDimensions(double width, double height){
		this.viewportWidth = width;
		this.viewportHeight = height;
	}
	
	
	
	/**
	 * 
	 * @param margin
	 */
	public void setViewportMargins(double marginTop, double marginRight, double marginBottom, double marginLeft){
		setViewportMarginTop(marginTop);
		setViewportMarginRight(marginRight);
		setViewportMarginBottom(marginBottom);
		setViewportMarginLeft(marginLeft);
	}
	
	/**
	 * 
	 * @param margin
	 */
	public void setViewportMarginTop(double margin){
		this.marginTop = margin;
	}
	
	
	/**
	 * 
	 * @param margin
	 */
	public void setViewportMarginRight(double margin){
		this.marginRight = margin;
	}
	
	
	
	/**
	 * 
	 * @param margin
	 */
	public void setViewportMarginBottom(double margin){
		this.marginBottom = margin;
	}
	
	
	/**
	 * 
	 * @param margin
	 */
	public void setViewportMarginLeft(double margin){
		this.marginLeft = margin;
	}
	
	


	/**
	 * 
	 * @param front
	 * @return
	 */
	public WebSVG_Canvas createWeb(S8WebFront front) {
		WebSVG_Canvas group = new WebSVG_Canvas(front);
		
		int n = elements.length;
		WebSVG_Element[] array = new WebSVG_Element[n];
		for(int i = 0; i<n; i++) { array[i] = elements[i].createWeb(front); }
		group.setElements(array);
		
		group.setViewport(viewportWidth, viewportHeight, marginTop, marginRight, marginBottom, marginLeft);
		
		return group;
	}
	
	
}
