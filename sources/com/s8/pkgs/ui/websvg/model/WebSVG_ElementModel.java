package com.s8.pkgs.ui.websvg.model;

import com.s8.api.annotations.S8Field;
import com.s8.api.annotations.S8ObjectType;
import com.s8.api.flow.repository.objects.RepoS8Object;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.io.svg.styles.SVG_FillColor;
import com.s8.pkgs.io.svg.styles.SVG_StrokeColor;
import com.s8.pkgs.io.svg.styles.SVG_StrokeSolidity;
import com.s8.pkgs.io.svg.styles.SVG_StrokeThickness;
import com.s8.pkgs.ui.websvg.WebSVG_Element;
import com.s8.pkgs.ui.websvg.model.shapes.WebSVG_ShapeModel;


@S8ObjectType(name = "com.s8.pkgs.ui.websvg.model.WebSVG_ModelElement", sub = {
		WebSVG_ShapeModel.class,
		WebSVG_GroupModel.class
})
public abstract class WebSVG_ElementModel extends RepoS8Object {


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

	
	@S8Field(name = "isBoundingBoxRelevant")
	public boolean isBoundingBoxRelevant = false;
	
	/** S8 constructor  */
	public WebSVG_ElementModel() { super(); }
	
	
	public void setBoundingBoxRelevant(boolean state) {
		this.isBoundingBoxRelevant = state;
	}
	
	
	
	protected void applyProperties(WebSVG_Element element) {
		element.setBoundingBoxRelevant(isBoundingBoxRelevant);
	}
	
	

	/**
	 * 
	 * @param front
	 * @return
	 */
	public abstract WebSVG_Element createWeb(S8WebFront front);
	
	
	
}
