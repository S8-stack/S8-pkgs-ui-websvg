package com.s8.pkgs.ui.websvg.viewer;

import com.s8.api.web.S8WebFront;
import com.s8.api.web.S8WebObject;
import com.s8.pkgs.ui.websvg.WebSVG_Canvas;
import com.s8.pkgs.ui.websvg.WebSources;

public class WebSVG_Viewer extends S8WebObject {
	
	

	/**
	 * 
	 * @param front
	 * @param typeName
	 */
	public WebSVG_Viewer(S8WebFront front) {
		super(front, WebSources.WEBPATH + "/viewer/WebSVG_Viewer");
	}
	
	

	public void setCanvas(WebSVG_Canvas canvas) {
		vertex.outbound().setObjectField("canvas", canvas);
	}
	

}
