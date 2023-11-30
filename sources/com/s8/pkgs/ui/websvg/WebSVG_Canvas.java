package com.s8.pkgs.ui.websvg;

import java.util.List;

import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.carbide.HTML_NeNode;


/**
 * 
 * @author pierreconvert
 *
 */
public class WebSVG_Canvas extends HTML_NeNode {

	
	/**
	 * 
	 * @param branch
	 * @param typeName
	 */
	public WebSVG_Canvas(S8WebFront branch) {
		super(branch, WebSVG.WEBPATH + "/WebSVG_Canvas");
	}
	
	
	/**
	 * 
	 * @param elements
	 */
	public void addElement(WebSVG_Element element) {
		vertex.fields().addObjToList("elements", element);
	}


	public void setElements(List<WebSVG_Element> elements) {
		vertex.fields().setObjectListField("elements", elements);
	}
	

}
