package com.s8.pkgs.ui.websvg.style;

/**
 * 
 * @author pierreconvert
 *
 */
public class Stroke {
	
	
	public static Stroke create(StrokeSolidity solidity, StrokeThickness thickness, StrokeColor color) {
		return new Stroke(solidity, thickness, color);
	}
	

	
	/**
	 * 
	 */
	public final StrokeSolidity solidity;
	
	
	/**
	 * 
	 */
	public final StrokeThickness thickness;
	
	
	/**
	 * 
	 */
	public final StrokeColor color;


	
	/**
	 * 
	 * @param solidity
	 * @param thickness
	 * @param color
	 */
	public Stroke(StrokeSolidity solidity, StrokeThickness thickness, StrokeColor color) {
		super();
		this.solidity = solidity;
		this.thickness = thickness;
		this.color = color;
	}
	
	
	
}
