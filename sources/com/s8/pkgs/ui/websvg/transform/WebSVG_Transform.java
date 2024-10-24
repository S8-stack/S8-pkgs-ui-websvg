package com.s8.pkgs.ui.websvg.transform;


/**
 * 
 */
public class WebSVG_Transform {
	
	
	public static WebSVG_Transform rotateTranslate(double angleDeg, double dx, double dy) {
		double angle = angleDeg * Math.PI / 180.0, cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);
		return new WebSVG_Transform(cosAngle, sinAngle, -sinAngle, cosAngle, dx, dy);
	}
	
	public static WebSVG_Transform translate(double dx, double dy) {
		return new WebSVG_Transform(1.0, 0.0, 0.0, 1.0, dx, dy);
	}

	/**
	 * vector eX, coefficient 0 (row: 0, column: 0)
	 */
	public final double c0;

	/**
	 * vector eX, coefficient 1 (row: 1, column: 0)
	 */
	public final double c1;

	/**
	 * vector eY, coefficient 0 (row: 0, column: 1)
	 */
	public final double c2;

	/**
	 * vector eY, coefficient 1 (row: 1, column: 1)
	 */
	public final double c3;
	
	/**
	 * vector eX translation
	 */
	public final double xTranslation;

	/**
	 * vector eX translation
	 */
	public final double yTranslation;

	
	/**
	 * 
	 * @param dx
	 * @param dy
	 * @param angle [deg]
	 */
	public WebSVG_Transform(double c0, double c1, double c2, double c3, double dx, double dy){
		

		this.c0 = c0;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		
		this.xTranslation = dx;
		this.yTranslation = dy;
		
	}

	


	/**
	 * boosted version
	 * @param right
	 * @return
	 */
	public WebSVG_Vector transformPosition(WebSVG_Vector position){
		return new WebSVG_Vector(
				c0 * position.x + c2 * position.y + xTranslation,
				c1 * position.x + c3 * position.y + yTranslation);
	}
	
	/**
	 * boosted version
	 * @param right
	 * @return
	 */
	public WebSVG_Vector transformPosition(double x, double y){
		return new WebSVG_Vector(
				c0 * x + c2 * y + xTranslation,
				c1 * x + c3 * y + yTranslation);
	}
	
	/**
	 * boosted version
	 * @param right
	 * @return
	 */
	public WebSVG_Vector transformVector(WebSVG_Vector vector){
		return new WebSVG_Vector(
				c0 * vector.x + c2 * vector.y,
				c1 * vector.x + c3 * vector.y);
	}
	
	/**
	 * boosted version
	 * @param right
	 * @return
	 */
	public WebSVG_Vector transformVector(double dx, double dy){
		return new WebSVG_Vector(
				c0 * dx + c2 * dy, 
				c1 * dx + c3 * dy);
	}


}
