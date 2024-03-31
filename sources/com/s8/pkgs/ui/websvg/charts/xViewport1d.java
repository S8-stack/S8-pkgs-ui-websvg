package com.s8.pkgs.ui.websvg.charts;


/**
 * 
 */
public class xViewport1d extends Viewport1d {



	public static class Builder extends Viewport1d.Builder {


		@Override
		public xViewport1d build(int nTicks, double lowerBound, double upperBound) {
			return new xViewport1d(min, max, nTicks, lowerBound, upperBound);
		}
	}



	public xViewport1d(double min, double max, int nTicks, double lowerBound, double upperBound) {
		super(min, max, nTicks, lowerBound, upperBound);
	}

	
	public void generateAxis(List<WebSv>) {
		
	}


}
