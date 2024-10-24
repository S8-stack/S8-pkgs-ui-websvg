package com.s8.pkgs.ui.websvg;

import java.util.List;

import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.carbide.HTML_S8WebNode;


/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_Canvas extends HTML_S8WebNode {

	
	/**
	 * 
	 * @param front
	 * @param typeName
	 */
	public WebSVG_Canvas(S8WebFront front) {
		super(front, WebSources.WEBPATH + "/WebSVG_Canvas");
	}
	
	

	public void setElements(List<WebSVG_Element> elements) {
		vertex.outbound().setObjectListField("elements", elements);
	}
	
	public void setElements(WebSVG_Element... elements) {
		vertex.outbound().setObjectListField("elements", elements);
	}
	

}
