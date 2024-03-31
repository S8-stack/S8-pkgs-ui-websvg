package com.s8.pkgs.ui.websvg.charts;


/**
 * 
 */
public class Viewport1d {
	
	
	public static abstract class Builder {
	
		protected double min, max;

		protected boolean isInitialized = false;
		
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
		
		public abstract Viewport1d build(int nTicks, double lowerBound, double upperBound);
	}
	
	
	public final double min;
	
	public final double max;
	
	public final int nTicks;
	
	public final double lowerBound;
	
	public final double upperBound;

	public final double scalingFactor;
	
	public Viewport1d(double min, double max, int nTicks, double lowerBound, double upperBound) {
		super();
		this.min = min;
		this.max = max;
		this.nTicks = nTicks;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		
		
		scalingFactor = (upperBound - lowerBound) / (max - min);	
	}
	
	
	
	public double transform(double value) {
		return scalingFactor * (value - min) + lowerBound;
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
