package com.s8.pkgs.ui.websvg.model;

import java.util.List;

import com.s8.api.annotations.S8Field;
import com.s8.api.annotations.S8ObjectType;
import com.s8.api.web.S8WebFront;
import com.s8.pkgs.ui.websvg.WebSVG_Element;
import com.s8.pkgs.ui.websvg.WebSVG_Group;


/**
 * 
 * @author pierreconvert
 *
 */
@S8ObjectType(name = "com.s8.pkgs.ui.websvg.model.WebSVG_GroupModel")
public class WebSVG_GroupModel extends WebSVG_ElementModel {
	
	
	public static WebSVG_GroupModel create(List<WebSVG_ElementModel> elements, boolean isClickable) {
		WebSVG_GroupModel groupModel = new WebSVG_GroupModel();
		groupModel.setElements(elements);
		groupModel.setBoundingBoxRelevant(true);
		groupModel.setClickable(isClickable);
		return groupModel;
	}

	
	public @S8Field(name = "elements") WebSVG_ElementModel[] elements;
	

	public @S8Field(name = "clickable") boolean isClickable;
	
	/**
	 * S8 constructor
	 */
	public WebSVG_GroupModel() { super(); }
	
	

	public void setElements(List<WebSVG_ElementModel> elements) {
		int n = elements.size();
		WebSVG_ElementModel[] array = new WebSVG_ElementModel[n];
		for(int i = 0; i<n; i++) { array[i] = elements.get(i); }
		this.elements = array;
	}
	
	
	public void setClickable(boolean isClickable) {
		this.isClickable = isClickable;
	}



	@Override
	public WebSVG_Element createWeb(S8WebFront front) {
		WebSVG_Group group = new WebSVG_Group(front);
		
		int n = elements.length;
		WebSVG_Element[] array = new WebSVG_Element[n];
		for(int i = 0; i<n; i++) { array[i] = elements[i].createWeb(front); }
		group.setElements(array);
		
		group.setClickable(isClickable);
		
		return group;
	}
	

}
