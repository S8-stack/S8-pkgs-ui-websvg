package com.s8.pkgs.ui.websvg.charts;


/**
 * 
 */
public class BoundingBox1d {
	
	
	public static BoundingBox1d create(double[] values) {
		BoundingBox1d boundingBox1f = new BoundingBox1d();
		boundingBox1f.update(values);
		return boundingBox1f;
	}

	public double min, max;

	private boolean isInitialized = false;


	public BoundingBox1d(){
		super();
	}

	/**
	 * 
	 * @param vertex
	 */
	public void update(double value){
		if(!isInitialized){
			min = value;
			max = value;
			isInitialized = true;
		}
		else{
			min = Math.min(min, value); 
			max = Math.max(max, value);
		}
	}
	
	/**
	 * 
	 * @param vertex
	 */
	public void update(double[] values){
		int n = values.length;
		for(int i = 0; i < n; i++) { update(values[i]); }
	}

	/**
	 * 
	 * @return
	 */
	public double getCenter(){
		return 0.5 * (min + max);
	}





	/**
	 * 
	 * @return 
	 */
	public double getRadius(){
		return 0.5 * (max - min);
	}
	
	

	public double getMin(){
		return min;
	}

	public double getMax(){
		return max;
	}
	
}
