/**
 * 
 */
/**
 * 
 */
module com.s8.pkgs.ui.websvg {
	
	exports com.s8.pkgs.ui.websvg;
	
	
	
	exports com.s8.pkgs.ui.websvg.model;
	exports com.s8.pkgs.ui.websvg.model.shapes;
	
	exports com.s8.pkgs.ui.websvg.shapes;
	exports com.s8.pkgs.ui.websvg.shapes.path;
	
	exports com.s8.pkgs.ui.websvg.transform;
	

	exports com.s8.pkgs.ui.websvg.viewer;
	
	requires transitive com.s8.api;
	
	requires transitive com.s8.pkgs.io.svg;
	requires transitive com.s8.pkgs.ui.carbide;
	requires transitive com.s8.build;
	
}